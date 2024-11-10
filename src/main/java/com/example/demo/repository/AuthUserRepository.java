package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AuthUserEntity;

public interface AuthUserRepository extends JpaRepository<AuthUserEntity, String> {

}
