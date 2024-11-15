package com.example.demo.controller;

import java.io.IOException;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.LoginUserDetails;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ExportingExportEntity;
import com.example.demo.repository.ExportingRepository;
import com.example.demo.service.MypageService;
import com.example.demo.service.ProductService;
import com.example.demo.utils.ReceiveCehck;
import com.example.demo.vo.MyexportDetailVO;
import com.example.demo.vo.MyexportVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
    final ProductService productService;
    @Autowired
    private final MypageService mypageService;
    private final ExportingRepository rep;
    @GetMapping("/intro")
    public String mypageIntro() {
        return "mypage/mypageIntro.html";
    }

    @GetMapping("/mymarketing/list")
    public String mymarketingList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        // 한 페이지에 9개씩 페이징 처리
        Page<ProductDTO> productPage = productService.getProductsByPage(page, 9); // 9개의 상품만 조회

        model.addAttribute("products", productPage.getContent()); // 현재 페이지의 상품 목록
        model.addAttribute("currentPage", page); // 현재 페이지 번호
        model.addAttribute("totalPages", productPage.getTotalPages()); // 전체 페이지 수
        return "mypage/mymarketingList.html";
    }
    
    
    @GetMapping("/myexport/detail/return")
    public String index3(Model model) {
    	MyexportDetailVO myexportDetailVO = new MyexportDetailVO();
    	Optional<ExportingExportEntity> entity = rep.findById((long) 1);
    	ExportingExportEntity export = entity.get();
    	myexportDetailVO.setBuyerCompanyName("GOSINARA");
    	myexportDetailVO.setBuyerEmail("leeman01@naver.com");
    	myexportDetailVO.setIncoterm("FOB");
    	myexportDetailVO.setExpDclrNo("020-15-14-01234567");
    	myexportDetailVO.setAcptDt("2024-10-18");
    	myexportDetailVO.setLoadDtyTmIm("2024-10-31");
    	myexportDetailVO.setLoadDtyTmIm("Yes");
    	myexportDetailVO.setBlNo("123456789");
    	myexportDetailVO.setShpmCmplYn("NO");
    	myexportDetailVO.setShpmCmplYn("MASK-7012");
    	myexportDetailVO.setTkofDt("2024-10-31");
    	myexportDetailVO.setCsclPckGcnt("3600");
    	myexportDetailVO.setCsclPckUt("CT");
    	myexportDetailVO.setCsclPckGcnt("1000");
    	myexportDetailVO.setShpmWght("3000");
    	myexportDetailVO.setShpmPckUt("CT");
    	myexportDetailVO.setShpmPckGcnt("1000");
    	myexportDetailVO.setProcess(0);
    	myexportDetailVO.setProcessName("선적전");
    	model.addAttribute("myexportDetail",myexportDetailVO);
    	return "mypage/myexportDetail";
    	
    }

    @GetMapping("/myexport/list")
    public String myexportList(
    		@AuthenticationPrincipal LoginUserDetails loginUser,
        Model model
    ){
    	String userId =  loginUser.getUsername();
        List<MyexportVO> myexportList = mypageService.getMyexportList(userId);
        model.addAttribute("myexportList", myexportList);
        return "mypage/myexportList.html";
    }

    @GetMapping("/myexport/detail")
    public String myexportDetail(
        @RequestParam(value="exportId") Long exportId,
        Model model
    ){
        MyexportDetailVO myexportDetailVO = mypageService.getMyexportDetail(exportId);
        model.addAttribute("exportId",exportId);
        model.addAttribute("myexportDetail",myexportDetailVO);
        String userName="leerexman01@gmail.com";
		String password ="lumm srte xkut ajum";
		Date endDate = Date.valueOf(LocalDate.now());
		LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(5);
		java.util.Date startDate = Date.from(fiveMinutesAgo.atZone(ZoneId.systemDefault()).toInstant()); // 5분 전으로 설정
	    ReceiveCehck a= new ReceiveCehck();
	    a.setSaveDirectory(uploadPath);
	    if (myexportDetailVO.getProcess()==0 && myexportDetailVO.getIncoterm().equals("DDP")) {
	    	String fileName = a.receiveMailAttachedFile(userName, password, startDate, endDate,exportId);
		    model.addAttribute("file",fileName);
	    	
	    }
	
        return "mypage/myexportDetail.html";
    }
    
    
    @GetMapping("/myexport/download")
    public ResponseEntity<InputStreamResource> downloadFile(
            @RequestParam(value = "fileName") String fileName
    ) {
        try {
            // 파일 경로 설정
            String outputFilePath = uploadPath + "/" + fileName;
            FileSystemResource fileResource = new FileSystemResource(outputFilePath);
            
            // 파일이 존재하지 않으면 오류 반환
            if (!fileResource.exists() || !fileResource.isFile()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // 파일 읽기
            InputStreamResource resource = new InputStreamResource(fileResource.getInputStream());

            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

            // 파일 반환
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(fileResource.contentLength())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (IOException e) {
            log.error("Error while downloading file: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
    
    
    
    
    
    
    
    
}