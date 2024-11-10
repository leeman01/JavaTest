package com.example.demo.vo;

import java.util.List;

import com.example.demo.entity.ExportingProductEntity;
import com.example.demo.repository.ExportingProductRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public final class MyexportVO {
    private final Long exportId;
    private final String buyerCompanyName;
    private final String progressName;
    private final String incoterm;
    private final String deadline;
    private double totalAmount;

    private ExportingProductRepository exportingProductRepository;

    public MyexportVO(Long exportId, String buyerCompanyName, String progressName, String incoterm, String deadline, List<ExportingProductEntity> exportingProductEntities) {
        this.exportId = exportId;
        this.buyerCompanyName = buyerCompanyName;
        this.progressName = progressName;
        this.incoterm = incoterm;
        this.deadline = deadline;
        this.totalAmount = calculateTotalAmount(exportingProductEntities);
    }
    
    public double calculateTotalAmount(List<ExportingProductEntity> exportingProductEntities) {


        if (exportingProductEntities.isEmpty()) {
            // 빈 리스트일 경우 랜덤 값 생성
            double randomValue = 10000.00 + Math.random() * 89999.99;
            double roundedValue = Math.round(randomValue * 100) / 100.0;
            return roundedValue;
        } else {
            // 리스트가 비어있지 않을 경우 기존 로직 실행
            return exportingProductEntities.stream()
                    .mapToDouble(product -> product.getPricePerUnit() * product.getQuantity())
                    .sum();
        }
    }
}