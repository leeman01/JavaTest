package com.kdigital.entity.service; // 현재클래스가 패키지안에 포함되어있는지 정보
import java.util.ArrayList;
import java.util.List;

import com.kdigital.entity.Fitness;
import com.kdigital.entity.util.MyManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
public class FitnessServiceImpl implements FitnessService {

	@Override
	public boolean insert(Fitness fitness) {
		EntityManager manager = MyManager.getManager() ;
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			manager.persist(fitness);
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public Fitness selectOne(int id) {
		EntityManager manager = MyManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		Fitness fitness = null ;
		try {
			tx.begin();
			fitness = manager.find(Fitness.class, id);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return fitness;
	}

	@Override
	public boolean update(Fitness fitness) {
		EntityManager manager = MyManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			Fitness fitness1 = manager.find(Fitness.class, fitness.getId());
			if (fitness1 == null)
				return false;
			fitness1.setHeight(fitness.getHeight());
			fitness1.setWeight(fitness.getWeight());
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		EntityManager manager = MyManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			Fitness fitness = manager.find(Fitness.class, id);
			if (fitness==null)
				return false;
			manager.remove(fitness);
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return true;
	}
	// JPQL(JAVA Persistence Query Language)을 사용해야 다양한 쿼리문을 실행할 수 있다
	@Override
	public List<Fitness> selectAll() {
	    EntityManager manager = MyManager.getManager();
	    EntityTransaction tx = manager.getTransaction();
	    List<Fitness> list = new ArrayList<>(); // 결과를 저장할 리스트 선언
	    try {
	        tx.begin();
	        String query = "select f from Fitness f";
	        TypedQuery<Fitness> tq = manager.createQuery(query, Fitness.class);
	        list = tq.getResultList(); // 조회 결과를 리스트에 저장
	        tx.commit();
	    } catch(Exception e) {
	        if (tx.isActive()) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        manager.close();
	    }
	    return list; // 조회된 리스트를 반환
	}

}


