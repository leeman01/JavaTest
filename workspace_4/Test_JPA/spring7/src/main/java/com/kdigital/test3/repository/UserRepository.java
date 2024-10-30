package com.kdigital.test3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.test3.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,  String > {

}
