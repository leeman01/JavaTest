package com.kdigital.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.project.Entity.ManagingDocumentParentEntity;

public interface ManagingDocumentRepository extends JpaRepository<ManagingDocumentParentEntity, Long> {

}
