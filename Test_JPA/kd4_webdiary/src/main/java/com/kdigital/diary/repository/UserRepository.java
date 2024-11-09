package com.kdigital.diary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.diary.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
