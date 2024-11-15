package com.example.demo.controller;

import org.springframework.http.MediaType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.InvoiceForm;
import com.example.demo.entity.CommercialInvoiceView;
import com.example.demo.repository.CommercialInvoiceViewRepository;
import com.example.demo.service.InvoiceService;

import org.springframework.ui.Model;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/export")
public class ExportController {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommercialInvoiceViewRepository commercialInvoiceViewRepository;
    
    @GetMapping("/intro")
    public String getServiceIntro() {
        return "export/serviceIntro";
    }

    @GetMapping("/start")
    public String getStart() {
        return "export/start";
    }

    @PostMapping("/cargoInfo")
    public String cargoInfo() {
        return "export/cargoInfo";
    }

    @GetMapping("/EXP_DECLARE")
    public String getEXP_DECLARE() {
        return "export/EXP_DECLARE";
    }

    @GetMapping("/Declare_success")
    public String getDeclare_success() {
        return "export/Declare_success";
    }

    @GetMapping("/invoice/{invoiceNo}/signature")
    @ResponseBody
    public ResponseEntity<byte[]> getSignatureImage(@PathVariable("invoiceNo") String invoiceNo) {
        // invoiceNo로 데이터베이스에서 CommercialInvoiceView 객체를 찾습니다.
        CommercialInvoiceView commercialInvoice = commercialInvoiceViewRepository.findById(invoiceNo).orElse(null);
        if (commercialInvoice == null || commercialInvoice.getshipperSignature() == null) {
            return ResponseEntity.notFound().build(); // 데이터가 없으면 404 반환
        }

        // 이미지 데이터 가져오기 (필드명이 `shipperSignature`인 경우)
        byte[] imageBytes = commercialInvoice.getshipperSignature();

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG); // 이미지 타입에 맞게 설정 (예: PNG, JPEG 등)

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/downloadInvoice")
    public ResponseEntity<InputStreamResource> downloadInvoice() {
        try {
            // 임시 경로에 있는 파일 경로 사용
            String tempDir = System.getProperty("java.io.tmpdir");
            String outputFilePath = tempDir + "output_invoice.docx";
            logger.info("Attempting to download file from: {}", outputFilePath); // 로그 추가
            FileSystemResource fileResource = new FileSystemResource(outputFilePath);

            // 파일이 존재하지 않으면 오류 반환
            if (!fileResource.exists() || !fileResource.isFile()) {
                logger.error("Output file not found at: {}", outputFilePath);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // 파일 읽기
            InputStreamResource resource = new InputStreamResource(fileResource.getInputStream());

            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=output_invoice.docx");

            // 파일 반환
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(fileResource.contentLength())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (IOException e) {
            logger.error("Error while downloading invoice: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 클라이언트에서 받은 데이터를 받아서 외부 API로 다시 요청
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/declare")
    @ResponseBody
    public ResponseEntity<String> handleDeclaration(@RequestBody String requestPayload) {
        String externalApiUrl = "https://testcbtapi.utradehub.or.kr/api/export/declaration.do";

        // 헤더 설정 (API-KEY 포함)
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("API-KEY", "c6d9a09b-cb7e-4644-8aff-db7245e8cec2-917da2fd-c3cb-3621-0000-01928e2e84fc");
        headers.add("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(requestPayload, headers);

        // 외부 API로 POST 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(
                externalApiUrl,
                HttpMethod.POST,
                entity,
                String.class);

        // 외부 API의 응답을 클라이언트에 반환
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
