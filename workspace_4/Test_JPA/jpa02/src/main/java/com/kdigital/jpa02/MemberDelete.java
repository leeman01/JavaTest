package com.kdigital.jpa02;

import com.kdigital.jpa02.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberDelete {

	public static void main(String[] args) {
		// 1 factory
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
		// 2 manager
		EntityManager manager = factory.createEntityManager();
		// 3 transaction
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			// 삭제하고자하는 데이터 find 부터 해야한다
			Member member = manager.find(Member.class,"02@naver.com");
			if (member==null) {
				System.out.println("그런 정보는 없음");
			
			}else{
				 manager.remove(member);
				 System.out.println("삭제완료");
			}
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
		factory.close();
	}
	

}
