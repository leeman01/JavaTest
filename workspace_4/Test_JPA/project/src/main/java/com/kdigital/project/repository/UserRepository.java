package com.kdigital.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.project.Entity.AuthUserEntity;

public interface UserRepository extends JpaRepository<AuthUserEntity, Integer> {

}
