package com.kdigital.jpa06;

import java.util.Arrays;
import java.util.List;

import com.kdigital.jpa05.util.MyManager;
import com.kdigital.jpa06.entity.Question;
import com.kdigital.jpa06.entity.Survey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class SurveyMain {

	public static void main(String[] args) {
		makeQuestion();
		makeSurvey();

	}
	private static void makeQuestion() {
		EntityManager manager = MyManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			manager.persist(new Question("Q1","질문-1"));
			manager.persist(new Question("Q2","질문-2"));
			manager.persist(new Question("Q3","질문-3"));
			manager.persist(new Question("Q4","질문-4"));
			manager.persist(new Question("Q5","질문-5"));
			manager.persist(new Question("Q6","질문-6"));
		
			tx.commit();
			System.out.println("저장완료");
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
		
	}
	private static void makeSurvey() {
		EntityManager manager = MyManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			Question q1 = manager.find(Question.class, "Q1");
			Question q2 = manager.find(Question.class, "Q2");
			Question q3 = manager.find(Question.class, "Q3");
			Question q4 = manager.find(Question.class, "Q4");
			List<Question> qlist = Arrays.asList(q1,q2,q3,q4);
			Survey survey = new Survey("설문","설문지 제목",qlist);
			manager.persist(survey);
			tx.commit();
			System.out.println("저장완료");
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
	}
}
