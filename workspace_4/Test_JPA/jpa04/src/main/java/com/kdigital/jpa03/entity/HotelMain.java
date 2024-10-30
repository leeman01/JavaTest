package com.kdigital.jpa03.entity;

import java.time.LocalDate;

import com.kdigital.entity.util.MyManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class HotelMain {

	public static void main(String[] args) {
			Hotel hotel = new Hotel("h02","유미콘호텔",LocalDate.of(1985,5,20),Grade.s1);
			insert(hotel);

	}
	private static void insert(Hotel hotel) {
		EntityManager manager =MyManager.getManager() ;
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			manager.persist(hotel);
			System.out.println("저장완료");
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
	}
}
