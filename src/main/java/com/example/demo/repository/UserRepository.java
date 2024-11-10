package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AuthUserEntity;


public interface UserRepository extends JpaRepository<AuthUserEntity, String> {

}
