package com.example.demo.repository;

import com.example.demo.entity.CommercialInvoiceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialInvoiceViewRepository extends JpaRepository<CommercialInvoiceView, String> {
    // 필요하다면 여기에 커스텀 쿼리 메서드를 추가할 수 있습니다.
}
