package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AuthUserEntity;
import com.example.demo.entity.ExportingExportEntity;
@Repository
public interface ExportingRepository extends JpaRepository<ExportingExportEntity, Long> {

	List<ExportingExportEntity> findByuserId(Optional<AuthUserEntity> user);

	List<ExportingExportEntity> findByuserId(AuthUserEntity userEntity);





	Page<ExportingExportEntity> findByBuyerCompanyNameContains(String searchWord, PageRequest of);

	Page<ExportingExportEntity> findByBuyerEmailContains(String searchWord, PageRequest of);

	Page<ExportingExportEntity> findByBuyerCompanyNameContainsAndUserId(AuthUserEntity user, String searchWord, PageRequest of);

	Page<ExportingExportEntity> findByBuyerEmailContainsAndUserId(AuthUserEntity user, String searchWord, PageRequest of);

	Page<ExportingExportEntity> findAllByUserId(AuthUserEntity user, PageRequest of);


	Page<ExportingExportEntity> findByBuyerEmailContainsAndUserId(int userId, String searchWord, PageRequest of);

	Page<ExportingExportEntity> findByBuyerCompanyNameContainsAndUserId(int userId, String searchWord, PageRequest of);

	Page<ExportingExportEntity> findAllByUserId(int userId, PageRequest of);

	Page<ExportingExportEntity> findByBuyerCompanyNameContainsAndUserId(String searchWord, int userId, PageRequest of);

	Page<ExportingExportEntity> findByBuyerEmailContainsAndUserId(String searchWord, int userId, PageRequest of);

	Page<ExportingExportEntity> findByBuyerCompanyNameContainsAndUserId(String searchWord, AuthUserEntity userEntity,
			PageRequest of);

	Page<ExportingExportEntity> findByBuyerEmailContainsAndUserId(String searchWord, AuthUserEntity userEntity,
			PageRequest of);
	





}
