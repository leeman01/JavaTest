package com.kdigital.spring6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.spring6.entity.FriendEntity;
// Integer는 테이블에서의 PrimaryKey이다
public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {
	
}
