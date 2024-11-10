package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExportingExportEntity;
import com.example.demo.entity.ExportingProductEntity;

@Repository
public interface ExportingProductRepository extends JpaRepository<ExportingProductEntity,Long>{

    List<ExportingProductEntity> findByexportId(ExportingExportEntity exportingExportEntity);
}