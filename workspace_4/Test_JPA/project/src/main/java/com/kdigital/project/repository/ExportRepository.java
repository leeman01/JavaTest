package com.kdigital.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.project.Entity.ExportingExportEntity;

public interface ExportRepository extends JpaRepository<ExportingExportEntity, Long> {

}
