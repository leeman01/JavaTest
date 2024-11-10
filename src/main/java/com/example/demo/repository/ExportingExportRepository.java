package com.example.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AuthUserEntity;
import com.example.demo.entity.ExportingExportEntity;

@Repository
public interface ExportingExportRepository extends JpaRepository<ExportingExportEntity, Long> {

    List<ExportingExportEntity> findByuserId(Optional<AuthUserEntity> user);
}