package com.kdigital.entity.service; // 현재클래스가 패키지안에 포함되어있는지 정보
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.kdigital.exam.entity.CashBook;
import com.kdigital.exam_util.MyManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
public class CashbookServiceImpl implements CashbookService {

	@Override
	public boolean insert(CashBook cashbook) {
		EntityManager manager = MyManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			manager.persist(cashbook);
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
	public List<CashBook> selectData(String date) { 
	    List<CashBook> list = new ArrayList<>();
	    EntityManager manager = MyManager.getManager();
	    EntityTransaction tx = manager.getTransaction();
	    String query = "SELECT c FROM CashBook c WHERE FUNCTION('DATE_FORMAT', c.today, '%Y-%m') = :date";
	        
	    try {
	        tx.begin();
	        TypedQuery<CashBook> tq = manager.createQuery(query, CashBook.class);
	        tq.setParameter("date", date);
	        list = tq.getResultList();
	        tx.commit();
	        
	    } catch (Exception e) {
	        tx.rollback();
	        e.printStackTrace();
	        
	    } finally {
	        manager.close();
	    }
	    return list;
	}




	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CashBook> selectAll() {
		  EntityManager manager = MyManager.getManager();
		  EntityTransaction tx = manager.getTransaction();
		  List<CashBook> list = new ArrayList<>(); 
		  try {
			  tx.begin();
			
			  String query = "select f from CashBook f";
			  TypedQuery<CashBook> tq = manager.createQuery(query, CashBook.class);
			  list = tq.getResultList(); 
			  tx.commit();
			 
			
		  }catch(Exception e) {
			  tx.rollback();
			  e.printStackTrace();
		  }finally {
			  manager.close();
		  }
		return list;
	}


	@Override
	public List<CashBook> statistics(String date) {
	    List<CashBook> list = new ArrayList<>();
	    EntityManager manager = MyManager.getManager();
	    EntityTransaction tx = manager.getTransaction();
	    String query = "select itemType ,sum(amount) amount  "
	    		+ "From TotalAmount c"
	    		+ "where date_format(today,'%Y-%m')=: date "
	    		+ "group by itemType";
	    	
	        
	    try {
	        tx.begin();
	        TypedQuery<CashBook> tq = manager.createQuery(query, CashBook.class);
	        tq.setParameter("date", date);
	        list = tq.getResultList();
	        tx.commit();
	        
	    } catch (Exception e) {
	        tx.rollback();
	        e.printStackTrace();
	        
	    } finally {
	        manager.close();
	    }
	    return list;
	}

	

}


