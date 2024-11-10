package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.ProductViewEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductViewRepository;
import com.example.demo.utils.FileService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductViewRepository productViewRepository;

    // 업로드된 파일이 저장될 디렉토리 경로를 읽어옴
    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    // 상품 저장
    public void saveProduct(ProductDTO productDTO) {

        log.info("저장 경로: " + uploadPath);

        // 첨부파일 처리
        String originalFileName = null;
        String savedFileName = null;

        // 파일 첨부 여부 확인 (파일이 존재하면)
        if (!productDTO.getProductImageFile().isEmpty()) {
            savedFileName = FileService.saveFile(productDTO.getProductImageFile(), uploadPath);
            originalFileName = productDTO.getProductImageFile().getOriginalFilename();

            productDTO.setOriginalFileName(originalFileName);
            productDTO.setSavedFileName(savedFileName);
        }

        // 1) Entity로 변환
        ProductEntity productEntity = Stream.of(productDTO) // DTO 객체를 Stream으로 변환
                .map(dto -> new ProductEntity(
                        dto.getId(),
                        dto.getProductName(),
                        dto.getProductDescription(),
                        dto.getProductPrice(),
                        LocalDateTime.now(), // 현재 시간을 설정
                        // dto.getProductImageFile(),
                        dto.getOriginalFileName(),
                        dto.getSavedFileName(),
                        dto.getCompanyName(),
                        dto.getFoundedYear(),
                        dto.getBusinessType(),
                        dto.getCountry(),
                        // dto.getLastViewedDate()
                        LocalDate.now() // 기본값 = 마지막 조회 날짜 설정 (이게 맞는지 모름 주의)
                        ))
                .findFirst() // 변환된 첫 번째(유일한) Entity를 가져옴
                .orElse(null);

        productRepository.save(productEntity); // 데이터베이스에 저장
// --------------------------------------------------------------------------------------
        // 숙제 1) product_views 테이블에 레코드 추가 ==> 
        if (productEntity != null) {
            // 처음 저장될 때는 조회수 = 0 이므로 기본값은 0이어야 함
            ProductViewEntity productViewEntity = new ProductViewEntity(productEntity.getId(), 0);
            productViewRepository.save(productViewEntity); // product_views에 레코드 저장하기
        }

        log.info("상품 저장 및 product_view 테이블에 레코드 추가됨!");
    }

    // --------------------------------------------------------------------------------------
    // 모든 상품 가져오기
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();

        return productEntities.stream() // Entity 리스트를 스트림으로 변환
                .map(entity -> new ProductDTO(
                        entity.getId(),
                        entity.getProductName(),
                        entity.getProductDescription(),
                        entity.getProductPrice(),
                        entity.getProductDate(), // LocalDateTime을 문자열로 변환
                        entity.getOriginalFileName(), // 이미지 경로
                        entity.getSavedFileName(),
                        entity.getDailyViews(),
                        entity.getTotalViews(),
                        entity.getCompanyName(),
                        entity.getFoundedYear(),
                        entity.getBusinessType(),
                        entity.getCountry(),
                        entity.getLastViewedDate()))
                .collect(Collectors.toList()); // 리스트로 수집
    }

    public ProductDTO selectOne(Long id) {
        Optional<ProductEntity> temp = productRepository.findById(id);
        ProductDTO productDTO = null;

        if (temp.isPresent()) {
            ProductEntity productEntity = temp.get();


            productDTO = new ProductDTO(
                    productEntity.getId(),
                    productEntity.getProductName(),
                    productEntity.getProductDescription(),
                    productEntity.getProductPrice(),
                    productEntity.getProductDate(),
                    productEntity.getOriginalFileName(),
                    productEntity.getSavedFileName(),
                    productEntity.getDailyViews(), // 일일 조회수
                    productEntity.getTotalViews(), // 누적 조회수
                    productEntity.getCompanyName(),
                    productEntity.getFoundedYear(),
                    productEntity.getBusinessType(),
                    productEntity.getCountry(),
                    productEntity.getLastViewedDate());
        }

        return productDTO;
    }

    /**
     * 조회수 업데이트
     * 
     * @param id : 업데이트하는 상품의 번호
     */
    @Transactional
    public void updateViewCount(Long id) {
        // ProductEntity 에서 조회수 증가 처리
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품을 찾을 수 없습니다."));

        // 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();

        // 조회수가 없는 경우 기본값 0으로 처리(주의)
        if (productEntity.getDailyViews() == 0) {
            productEntity.setDailyViews(0);
        }
        if (productEntity.getTotalViews() == 0) {
            productEntity.setTotalViews(0);
        }

        // 마지막 조회 날짜가 null이거나 마지막 조회 날짜와 현재 날짜가 다르면 일일 조회수 초기화
        if (productEntity.getLastViewedDate() == null || !productEntity.getLastViewedDate().isEqual(currentDate)) {
            productEntity.setDailyViews(0); // 일일 조회수 초기화
        }

        // 조회수 증가
        productEntity.setDailyViews(productEntity.getDailyViews() + 1); // 일일 조회수 증가
        productEntity.setTotalViews(productEntity.getTotalViews() + 1); // 누적 조회수 증가
        productEntity.setLastViewedDate(currentDate); // 마지막 조회 날짜 갱신
        // --------------------------------------------------------------------------------------
        // 전체 조회수를 날짜 별로 업데이트 (테이블명: product_view)
        // 숙제 2) Entity 만들 것

        // product_view 테이블에 조회수를 업데이트하는 기록을 추가 (맞게 한건지 모르겠음 주의)
        ProductViewEntity productViewEntity = new ProductViewEntity(productEntity.getId(),
                productEntity.getTotalViews());

        productViewRepository.save(productViewEntity);

        // ProductEntity 업데이트
        productRepository.save(productEntity);
    }

    // --------------------------------------------------------------------------------------
    // 페이징
    public Page<ProductDTO> getProductsByPage(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id")); // 페이지 번호와 한 페이지의 크기 설정
        Page<ProductEntity> productPage = productRepository.findAll(pageable);

        return productPage.map(product -> new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getProductDate(),
                product.getOriginalFileName(),
                product.getSavedFileName(),
                product.getDailyViews(),
                product.getTotalViews(),
                product.getCompanyName(),
                product.getFoundedYear(),
                product.getBusinessType(),
                product.getCountry(),
                product.getLastViewedDate()));
    }

    public Page<ProductEntity> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    /**
     * 홍보플랫폼 수정
     */
    @Transactional
    public void updateProduct(ProductDTO productDTO) {
        System.out.println("=================================수정 처리");
        // 기존 상품 데이터를 가져옴
        ProductEntity existingProduct = productRepository.findById(productDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품을 찾을 수 없습니다."));

        // 조회수를 그대로 유지하기 위해 기존 조회수를 가져옴
        int currentDailyViews = existingProduct.getDailyViews(); // 기존 일일 조회수
        int currentTotalViews = existingProduct.getTotalViews(); // 기존 누적 조회수
        System.out.println("============기존 이미지: " + existingProduct.getOriginalFileName());

        // 나머지 데이터를 업데이트
        existingProduct.setProductName(productDTO.getProductName());
        existingProduct.setProductDescription(productDTO.getProductDescription());
        existingProduct.setProductPrice(productDTO.getProductPrice());
        existingProduct.setCompanyName(productDTO.getCompanyName());
        existingProduct.setFoundedYear(productDTO.getFoundedYear());
        existingProduct.setBusinessType(productDTO.getBusinessType());
        existingProduct.setCountry(productDTO.getCountry());

        // 첨부파일이 있을 경우 처리
        if (!productDTO.getProductImageFile().isEmpty()) {
            String originalFilename = productDTO.getProductImageFile().getOriginalFilename();
            String savedFileName = FileService.saveFile(productDTO.getProductImageFile(), uploadPath);
            existingProduct.setOriginalFileName(originalFilename);
            existingProduct.setSavedFileName(savedFileName);
        }

        // 조회수는 그대로 유지
        existingProduct.setDailyViews(currentDailyViews); // 기존 일일 조회수 유지
        existingProduct.setTotalViews(currentTotalViews); // 기존 누적 조회수 유지

        // 마지막으로 수정한 날짜만 업데이트
        existingProduct.setProductDate(LocalDateTime.now());
    }

    public List<ProductDTO> getProductsByTotalViews() {
        List<ProductEntity> productEntities = productRepository.findAllByOrderByTotalViewsDesc();

        return productEntities.stream()
                .map(entity -> new ProductDTO(
                        entity.getId(),
                        entity.getProductName(),
                        entity.getProductDescription(),
                        entity.getProductPrice(),
                        entity.getProductDate(),
                        entity.getOriginalFileName(),
                        entity.getSavedFileName(),
                        entity.getDailyViews(),
                        entity.getTotalViews(),
                        entity.getCompanyName(),
                        entity.getFoundedYear(),
                        entity.getBusinessType(),
                        entity.getCountry(),
                        entity.getLastViewedDate()))
                .collect(Collectors.toList());
    }

    public Page<ProductDTO> getProductsByViews(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "totalViews")); // 조회수 기준으로 정렬
        Page<ProductEntity> productPage = productRepository.findAll(pageable);

        return productPage.map(product -> new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getProductDate(),
                product.getOriginalFileName(),
                product.getSavedFileName(),
                product.getDailyViews(),
                product.getTotalViews(),
                product.getCompanyName(),
                product.getFoundedYear(),
                product.getBusinessType(),
                product.getCountry(),
                product.getLastViewedDate()));
    }

    // 페이징 처리
    public Page<ProductDTO> getProductsByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")); // 페이지 번호와 한 페이지의 크기 설정
        Page<ProductEntity> productPage = productRepository.findAll(pageable); // 페이징된 결과 가져오기

        return productPage.map(product -> new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getProductDate(),
                product.getOriginalFileName(),
                product.getSavedFileName(),
                product.getDailyViews(),
                product.getTotalViews(),
                product.getCompanyName(),
                product.getFoundedYear(),
                product.getBusinessType(),
                product.getCountry(),
                product.getLastViewedDate()));
    }

    // --------------------------------------------------------------------------------------
    /**
     * 특정 상품에 대한 주차별 조회수 리스트 반환 (그래프 그리는 데이터)
     */

    public List<Map<String, Object>> getTotalViewsByProductId(Long productId) {
        List<Object[]> results = productViewRepository.findTotalViewsByProductIdGroupedByDate(productId);

        List<Map<String, Object>> viewsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("yearweek", result[0]); // 주차
            map.put("week_range", result[1]); // 주차 범위 (예: "2024년 10월 21일 ~ 10월 27일")
            map.put("total_views_sum", result[2]); // 주차별 조회수 합계
            viewsList.add(map);
        }

        return viewsList;
    }

    // public List<Integer> getTotalViewsByProductId(Long productId) {
    // // product_view 테이블에서 특정 productId에 대한 모든 조회수를 가져오기
    // // List<ProductViewEntity> viewRecords =
    // productViewRepository.findByProductIdOrderByViewedAtAsc(productId);
    // List<Object[]> totalViews =
    // productViewRepository.findTotalViewsByProductIdGroupedByDate(productId);

    // System.out.println("그래프 그리는 데이터 : " + totalViews);

    // // 주차별 조회수 리스트로 변환 (원하는 대로 가공할 수 있음)
    // List<Integer> totalViewsList = viewRecords.stream()
    // .map(ProductViewEntity::getTotalViews)
    // .collect(Collectors.toList());

    // return totalViewsList;
    // }
    // --------------------------------------------------------------------------------------
    // 주차별 누적 조회수를 계산하여 반환하는 메서드 (그래프 그릭 위한 코드 - v02)
    // public Map<String, Integer> getWeeklyViewCounts(Long productId) {
    // // 오늘 날짜
    // LocalDate today = LocalDate.now();

    // // 두 달 전 날짜
    // LocalDate twoMonthsAgo = today.minusMonths(2);

    // // 주차별 누적 조회수를 저장할 Map (key: 주차, value: 조회수)
    // Map<String, Integer> weeklyViewCounts = new LinkedHashMap<>();

    // // 조회수 기록을 가져옴 (두 달 내의 조회수)
    // // List<ProductViewEntity> viewRecords =
    // productViewRepository.findViewsByProductIdAndDateRange(productId,
    // twoMonthsAgo, today);

    // // 주차별로 그룹화하여 조회수 계산
    // for (ProductViewEntity view : viewRecords) {
    // // 해당 날짜가 속한 주 계산
    // WeekFields weekFields = WeekFields.of(Locale.getDefault());
    // String weekLabel = view.getViewedAt().getYear() + "년 " +
    // view.getViewedAt().get(weekFields.weekOfMonth()) + "주차";

    // // 주차별 조회수 증가
    // weeklyViewCounts.put(weekLabel, weeklyViewCounts.getOrDefault(weekLabel, 0) +
    // 1);
    // }

    // return weeklyViewCounts;
    // }
    // --------------------------------------------------------------------------------------
    @Transactional
    public void deleteProduct(Long id) {
        // product_view 테이블에서 해당 product_id와 연결된 데이터 먼저 삭제
        productViewRepository.deleteByProductId(id);

        // product 테이블에서 데이터 삭제
        productRepository.deleteById(id);
    }

}
