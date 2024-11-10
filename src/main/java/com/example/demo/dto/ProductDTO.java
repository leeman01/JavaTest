package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductDTO {


    private Long id;
    private String productName;
    private String productDescription;
    private String productPrice;
    private LocalDateTime productDate;
    private MultipartFile productImageFile; // 파일 업로드를 위한 필드 추가
    private String originalFileName; // 다운로드시
    private String savedFileName; // 다운로드시
    // 조회수 관련 필드 추가
    private int dailyViews; // 일일 조회수
    private int totalViews; // 누적 조회수
    // 추가된 필드들
    private String companyName;
    private Integer foundedYear;
    private String businessType;
    private String country;
    private LocalDate lastViewedDate;

    // public ProductDTO(Long id, String productName, String productDescription, String productPrice,
    //         LocalDateTime productDate, String originalFileName, String savedFileName) {
    //     super();
    //     this.id = id;
    //     this.productName = productName;
    //     this.productDescription = productDescription;
    //     this.productPrice = productPrice;
    //     this.productDate = productDate;
    //     this.originalFileName = originalFileName;
    //     this.savedFileName = savedFileName;
    // }

    // 새로운 생성자 추가
    public ProductDTO(Long id, String productName, String productDescription, String productPrice, LocalDateTime productDate, String originalFileName, String savedFileName, int dailyViews, int totalViews, String companyName, Integer foundedYear, String businessType, String country, LocalDate lastViewedDate) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productDate = productDate;
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.dailyViews = dailyViews;
        this.totalViews = totalViews;
        this.companyName = companyName;
        this.foundedYear = foundedYear;
        this.businessType = businessType;
        this.country = country;
        this.lastViewedDate = lastViewedDate;
    }
}