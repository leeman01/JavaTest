package com.kdigital.jpa05.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
// singleton pattern , DTO Pattern
public class MyManager {

		private static EntityManagerFactory factory;
		
		private MyManager() {} // 외부에서 이 클래스를 생성하지 못하도록 막는 용도
		// 스태틱블럭: private인 static 변수를 초기화
		static{
			factory = Persistence.createEntityManagerFactory("jpastudy");
		}
		public static EntityManager getManager() {
			return factory.createEntityManager();
		}
		public static void close() {
			factory.close();
		}
		
}
