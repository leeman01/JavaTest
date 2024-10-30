package com.kdigital.jpa01;

import java.time.LocalDateTime;

import com.kdigital.jpa01.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserInsert {

	public static void main(String[] args) {
		// 1 단계 : Persistence.xml의 설정정보를 읽어 factory 객체 설정
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
		// 2단계 : 위에서 생성한 factory를 이용해 실제로 접속할 수 있는 객체 생성
		EntityManager manager =factory.createEntityManager();		
		// 3단계 : 트랜잭션을 시작하기위한 객체생성
		EntityTransaction tx = manager.getTransaction();
		// 4단계 : 트랜잭션을 시작하고 entity 객체를 생성하여 저장한다
		try {
			tx.begin();
			// 5단계 : DB에 저장할 데이터를 가지고 있는 entity객체를 생성한다
			User user = new User("mim@naver.com","김길동",LocalDateTime.now());
			// 6단계 : 실제 데이터를 insert하는 메소드를 진행
			manager.persist(user);  // 객체를 저장하는 메소드
			// 7단계: commit을 해야 실제 저장된다
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
		factory.close();	
		
	}

}
