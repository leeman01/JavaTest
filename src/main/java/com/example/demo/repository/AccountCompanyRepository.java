package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AccountCompanyEntity;
import com.example.demo.entity.AuthUserEntity;

public interface AccountCompanyRepository extends JpaRepository<AccountCompanyEntity, Long> {

	AccountCompanyEntity findByuserId(AuthUserEntity userEntity);

}
