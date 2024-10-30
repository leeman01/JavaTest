package com.kdigital.jpa02;

import java.time.LocalDate;

import com.kdigital.jpa02.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberInsert {

	public static void main(String[] args) {
		
		//1 Factory 생성
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");

		//2
		EntityManager manager = factory.createEntityManager();
		//3
		EntityTransaction tx = manager.getTransaction();	
		
		//4
		try {
			tx.begin();
			for (int i=2;i<=10;++i) {
				Member member = new Member("0"+i+"@naver.com","김일"+i,25+i,LocalDate.now());
				manager.persist(member);
			}
			tx.commit();
			System.out.println("저장완료");
		}catch(Exception e) {
			tx.rollback();
			System.out.println("저장실패");
		}finally {
			manager.close();
		}
		factory.close();

	}

}