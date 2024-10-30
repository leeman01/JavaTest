package com.kdigital.agxtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.agxtest.entity.GuestbookEntity;

public interface GuestbookRepository extends JpaRepository<GuestbookEntity,Long> {
	// 2개 이상의 조건으로 삭제할 때
	void deleteBySeqAndPwd(Long seq, String pwd);

}
