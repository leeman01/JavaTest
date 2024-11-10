package com.example.demo.entity;

import java.time.LocalDateTime;

import groovy.transform.ToString;
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

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name="product_view")
public class ProductViewEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long viewId;

    @Column(name="product_id")
    private Long productId;

    // @Column(name="viewed_at", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Column(name="viewed_at")
    private LocalDateTime viewedAt = LocalDateTime.now();

    // @Column(name="total_views", nullable= false)
    @Column(name="total_views")
    private int totalViews;

    // 생성자
    public ProductViewEntity(Long productId, int totalViews) {
        this.productId = productId;
        this.totalViews = totalViews;
    }
}
