package com.example.demo.controller;
import com.example.demo.repository.CommercialInvoiceViewRepository;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.InvoiceForm;
import com.example.demo.entity.CommercialInvoiceView;
import com.example.demo.service.InvoiceService;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
public class InvoiceController {
	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private CommercialInvoiceViewRepository commercialInvoiceViewRepository;
    
    @GetMapping("/export/CI_form")
    public String showInvoiceForm(Model model,@RequestParam(name="exportId") Long exportId) {
        // 데이터베이스 VIEW에서 초기 데이터를 가져옴
        CommercialInvoiceView commercialInvoice = commercialInvoiceViewRepository.findById("INV-2024-001").orElse(null);
        if (commercialInvoice != null) {
            model.addAttribute("commercialInvoice", commercialInvoice);
            logger.info("Initial data loaded for invoice_no={}: {}", "INV-2024-001", commercialInvoice);
        } else {
            logger.warn("No initial invoice data found for invoice_no={}", "INV-2024-001");
        }
        model.addAttribute("exportId",exportId);
        // 빈 폼 객체를 추가해줌 (폼 필드에 대한 초기화)
        model.addAttribute("invoiceForm", new InvoiceForm());
        return "export/CI_form";
    }
    @PostMapping("/generateInvoice")
    	public String generateInvoice(@ModelAttribute("invoiceForm") InvoiceForm form, Model model
    			,@RequestParam(name="exportId") Long exportId) throws IOException, InvalidFormatException {	
        // 폼 데이터를 Map에 저장 (HTML 폼에서 입력받은 데이터만)
        Map<String, String> invoiceData = new HashMap<>();
        invoiceData.put("{LCno}", form.getLCno());
        invoiceData.put("{LCdate}", form.getLCdate());
        invoiceData.put("{References}", form.getReferences());
        invoiceData.put("{shippingMarks}", form.getShippingMarks());
     
        logger.info("Form data received: LCno={}, LCdate={}, References={}, ShippingMarks={}",
                form.getLCno(), form.getLCdate(), form.getReferences(), form.getShippingMarks());
        
        // 데이터베이스 VIEW에서 조회해야 하는 데이터 추가
        CommercialInvoiceView commercialInvoice = commercialInvoiceViewRepository.findById("INV-2024-001").orElse(null);
        byte[] signatureImageBytes = null; // 이미지 데이터를 위한 변수 선언
        
        if (commercialInvoice != null) {
            invoiceData.put("{shipperName}", commercialInvoice.getShipperName());
            invoiceData.put("{shipperAddress}", commercialInvoice.getShipperAddress());
            invoiceData.put("{invoiceNo}", commercialInvoice.getInvoiceNo()); 
            invoiceData.put("{consigneeName}", commercialInvoice.getConsigneeName());
            invoiceData.put("{consigneeAddress}", commercialInvoice.getConsigneeAddress());
            invoiceData.put("{expectedShippingDate}", commercialInvoice.getExpectedShippingDate().toString());
            invoiceData.put("{loadingPort}", commercialInvoice.getLoadingPort());
            invoiceData.put("{buyerCountry}", commercialInvoice.getBuyerCountry());
            invoiceData.put("{unloadingPort}", commercialInvoice.getUnloadingPort());
            invoiceData.put("{paymentMethod}", commercialInvoice.getPaymentMethod());
            invoiceData.put("{incoterm}", commercialInvoice.getIncoterm());
            invoiceData.put("{invoiceDate}", commercialInvoice.getInvoiceDate().toString());
            invoiceData.put("{productDescription}", commercialInvoice.getProductDescription());
            invoiceData.put("{productQuantity}", String.valueOf(commercialInvoice.getProductQuantity()));
            invoiceData.put("{unitPrice}", String.valueOf(commercialInvoice.getUnitPrice()));
            invoiceData.put("{totalAmount}", String.valueOf(commercialInvoice.getTotalAmount()));
         // 이미지 데이터를 BLOB에서 가져오기
            signatureImageBytes = commercialInvoice.getshipperSignature(); // 이 부분에서 BLOB 데이터를 가져옴
            if (signatureImageBytes == null) {
                logger.warn("No signature image found for invoice_no={}", commercialInvoice.getInvoiceNo());
            }
        } else {
            logger.warn("No invoice found for invoice_no={}", "INV-2024-001");
        }

        // 모델에 데이터 추가
        model.addAttribute("commercialInvoice", commercialInvoice);

        try {
            // InvoiceService를 사용하여 Word 문서 생성
            logger.info("Generating invoice document with data: {}", invoiceData);
            String filePath = "/template/output_invoice.docx"; // 파일 경로 지정
            invoiceService.generateInvoice(invoiceData, filePath, signatureImageBytes); // 이미지 데이터도 전달
        } catch (Exception e) {
            logger.error("Error while generating invoice: ", e);
            return "error";  // 오류가 발생한 경우 에러 페이지로 이동
        }
        
        model.addAttribute("exportId",exportId);

        return "export/invoice_generated"; // 문서 생성 후의 결과 페이지로 이동
    

   
}
}

