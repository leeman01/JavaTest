package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
// @RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    // @Value("${user.board.pageLimit}")
    // private int pageLimit; // 한 페이지에 보여줄 글의 개수
    
    // 상품 등록 페이지로 이동
    @GetMapping("/product/prodInsert")
    public String showInsertPage() {
        return "product/prodInsert";
    }

    // 상품 등록 처리
    @PostMapping("/product/insert")
    public String submitProduct(@ModelAttribute ProductDTO productDTO) {

        productService.saveProduct(productDTO); // 상품 정보 저장
        return "redirect:/product/promotion"; // prodMain.html로 리다이렉트
    }

    @GetMapping("/product/promotion")
    public String showPromotionPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "sortOrder", defaultValue = "latest") String sortOrder,
            Model model) {
        Page<ProductDTO> productPage;

        // 정렬 옵션에 따른 정렬 방식 선택
        if ("views".equals(sortOrder)) {
            productPage = productService.getProductsByViews(page); // 조회순으로 정렬
        } else {
            productPage = productService.getProductsByPage(page); // 최신순으로 정렬 (기본값)
        }

        model.addAttribute("products", productPage.getContent());  // 현재 페이지의 상품 목록
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());  // 전체 페이지 수
        model.addAttribute("sortOrder", sortOrder);  // 현재 정렬 옵션

        return "product/prodMain";  // prodMain.html로 이동
    }

    // 파일 저장 로직
    private String saveFile(MultipartFile file) {
        // 파일을 서버에 저장하고 경로를 반환하는 로직
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename(); // 유니크한 파일명 생성
        Path path = Paths.get("uploads/" + fileName);
        try {
            Files.copy(file.getInputStream(), path, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/uploads/" + fileName; // 이미지 경로 반환
    }

    // 이미지를 화면에 출력하기 위해 다운로드
    /* 전달받은 게시글 번호에 파일을 다운로드
    * 
    */
    @GetMapping("/product/download")
    public String download(
            @RequestParam(name = "id") Long id, HttpServletResponse response) {
        System.out.println(id);
        ProductDTO productDTO = productService.selectOne(id);
        String savedFileName = productDTO.getSavedFileName(); // 저장된 파일명 가져오기

        try {
            String tempName = URLEncoder.encode(productDTO.getOriginalFileName(), StandardCharsets.UTF_8.toString());
            response.setHeader("Content-Disposition", "attachment;filename=" + tempName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String fullPath = uploadPath + "/" + savedFileName; // 전체 경로 설정

        System.out.println("저장 경로: " + fullPath);
        FileInputStream filein = null;
        ServletOutputStream fileout = null;

        try {
            filein = new FileInputStream(fullPath);
            fileout = response.getOutputStream();

            FileCopyUtils.copy(filein, fileout);

            fileout.close();
            filein.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // prodDetail.html로 이동
    @GetMapping("/product/detail/{id}")
    public String showProductDetail(@PathVariable("id") Long id, Model model) {
        productService.updateViewCount(id); // 조회수 업데이트
        ProductDTO product = productService.selectOne(id);
        model.addAttribute("product", product);
        return "product/prodDetail";
    }

// --------------------------------------------------------------------------------------
    @GetMapping("/mypage/mymarketing/detail/{productId}")
    public String showMarketingDetail(@PathVariable("productId") Long productId, Model model) {

        // 조회수 증가 함수 호출
        // productService.updateViewCount(productId);

        // 상품 정보 가져오기
        ProductDTO product = productService.selectOne(productId);

        // 숙제 3) productId에해당하는 전체 조회수를 리스트로 반환하는 문장이 필요 (반환되는 데이터 값으로 그래프 그림)
        // 반환된 리스트를 model에 저장한다.
        // productService.updateViewCount(productId);

        List<Map<String, Object>> totalViewList = productService.getTotalViewsByProductId(productId);

        // 주차별 누적 조회수 가져오기
        // Map<String, Integer> weeklyViewCounts =
        // productService.getWeeklyViewCounts(productId);

        // 모델에 데이터 추가하기
        // 조회수 리스트를 모델에 추가 (교수님께서 리스트로 하라고 하셨는데 이렇게 하는거 맞는지 모름 주의)
        model.addAttribute("product", product);
        // model.addAttribute("weeklyViewCounts", weeklyViewCounts);
        model.addAttribute("totalViewList", totalViewList);

        // 상세 페이지로 이동
        return "mypage/mymarketingDetail";
    }
    // --------------------------------------------------------------------------------------

    // 수정 페이지로 이동
    @GetMapping("/product/edit/{id}")
    public String showEditPage(@PathVariable("id") Long id, Model model) {
        ProductDTO product = productService.selectOne(id);
        model.addAttribute("product", product);
        return "product/prodEdit"; // 수정할 수 있는 페이지
    }

    // 수정 처리
    @PostMapping("/product/update")
    public String updateProduct(@ModelAttribute ProductDTO productDTO) {
        System.out.println("이미지 첨부 ============> " + productDTO.getProductImageFile().getOriginalFilename());
        productService.updateProduct(productDTO); // 기존 saveProduct 재활용
        return "redirect:/product/promotion"; // 수정 후 리스트 페이지로 이동
    }

    // 삭제 처리
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id); // 삭제 로직을 서비스에 추가
        return "redirect:/mypage/mymarketing/list"; // 삭제 후 리스트 페이지로 이동
    }

    @GetMapping("/product/promotion/views")
    public String showProductsByViews(Model model) {
        List<ProductDTO> products = productService.getProductsByTotalViews();
        model.addAttribute("products", products);
        return "product/prodMain";
    }

}