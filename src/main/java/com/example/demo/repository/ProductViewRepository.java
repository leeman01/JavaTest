package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ProductViewEntity;

import jakarta.transaction.Transactional;

public interface ProductViewRepository extends JpaRepository<ProductViewEntity, Long> {
    List<ProductViewEntity> findByProductIdOrderByViewedAtAsc(Long productId);

    // 날짜 범위 내에서 특정 productId의 조회수를 가져오는 쿼리
    // @Query("SELECT pv FROM ProductViewEntity pv WHERE pv.productId = :productId AND pv.viewedAt BETWEEN :startDate AND :endDate")
    // @Query(value = "SELECT DATE(viewed_at) AS viewDate, max(total_views) AS totalViewsSum " +
    //         "FROM product_view " +
    //             "WHERE product_id = :product_id " +
    //             "GROUP BY viewDate " +
    //             "ORDER BY viewDate", 
    //         nativeQuery = true)

    // List<Object[]> findViewsByProductIdAndDateRange(@Param("product_id") Long productId,
    //         @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    // @Query(value = "SELECT DATE(viewed_at) AS viewDate, max(total_views) AS totalViewsSum " +
    //     "FROM product_view " +
    //     "WHERE product_id = :productId " + 
    //     "GROUP BY viewDate " +
    //     "ORDER BY viewDate", 
    //     nativeQuery = true
    // )
    // List<Object[]> findViewsByProductIdAndDateRange(@Param("productId") Long productId);

    @Query(value = "SELECT YEARWEEK(viewed_at, 1) AS yearweek, " +
                    "CONCAT(DATE_FORMAT(MIN(DATE_ADD(viewed_at, INTERVAL -WEEKDAY(viewed_at) DAY)), '%Y년 %m/%d'), ' ~ ', " +
                    "DATE_FORMAT(MAX(DATE_ADD(viewed_at, INTERVAL 6 - WEEKDAY(viewed_at) DAY)), '%m/%d')) AS week_range, " +
                    "COUNT(*) AS total_views " +
                    "FROM product_view " +
                    "WHERE product_id = :productId " +
                    "GROUP BY yearweek " +
                    "ORDER BY yearweek", 
                nativeQuery = true
    )
    List<Object[]> findTotalViewsByProductIdGroupedByDate(@Param("productId") Long productId);
    //List<Object[]> findViewsByProductIdAndDateRange(@Param("productId") Long productId);
    

    // 특정 상품과 관련된 조회수 기록 모두 삭제
    @Modifying
    @Transactional
    @Query("DELETE FROM ProductViewEntity p WHERE p.productId = :productId")
    void deleteByProductId(@Param("productId") Long productId);

    // @Query(value = "SELECT product_id, DATE(viewed_at) AS view_date, MAX(total_views) AS total_views_sum " +
    //             "FROM product_view " +
    //             "WHERE product_id = :productId " +
    //             "GROUP BY view_date", 
    //     nativeQuery = true)
    // List<Object[]> findTotalViewsByProductIdGroupedByDate(@Param("productId") Long productId);

}