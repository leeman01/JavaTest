package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String productName;
    private String productDescription;
    private String productPrice;

    @CreationTimestamp
    private LocalDateTime productDate;

    // @Lob
    // private String productImage; // 단일 이미지로 처리
    // @Column(name = "product_image_file")
    // private MultipartFile productImageFile;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "saved_file_name")
    private String savedFileName;

    @Column(name = "last_viewed_date")
    private LocalDate lastViewedDate; // 마지막 조회 날짜

    // 조회수 필드
    private int dailyViews = 0; // 일일 조회수
    private int totalViews = 0; // 누적 조회수

    // 회사 정보 관련 필드 추가
    private String companyName;

    // 기존 varchar 형태였던 설립연도를 int로 변경
    @Column(name = "founded_year")
    private Integer foundedYear;

    @Column(name = "business_type")
    private String businessType;
    private String country;

    // 필요한 생성자 추가
    public ProductEntity(Long id, String productName, String productDescription, String productPrice, LocalDateTime productDate, String originalFileName, String savedFileName, String companyName, Integer foundedYear, String businessType, String country, LocalDate lastViewedDate) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productDate = productDate;
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.companyName = companyName;
        this.foundedYear = foundedYear;
        this.businessType = businessType;
        this.country = country;
        this.lastViewedDate = lastViewedDate;
    }
}