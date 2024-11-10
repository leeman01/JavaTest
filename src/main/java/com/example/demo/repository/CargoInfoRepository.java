package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ExportingCargoEntity;
import com.example.demo.entity.ExportingExportEntity;

public interface CargoInfoRepository extends JpaRepository<ExportingCargoEntity, Long> {

	ExportingCargoEntity findByExportId(ExportingExportEntity export);

}
