package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // 페이징 처리 메서드
    Page<ProductEntity> findAll(Pageable pageable);

    @Query("SELECT p FROM ProductEntity p ORDER BY p.totalViews DESC")
    List<ProductEntity> findAllByOrderByTotalViewsDesc();
}
