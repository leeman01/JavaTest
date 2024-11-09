package com.kdigital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// 아이디어(PK) , 이름, 키 , 성별 , 몸무게 , 표준체중, BMI ,BMI 결과 
@Entity
@Table( name = "fitness")
public class Fitness {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // identity는 동일한 값을 생성하지 않겟다는 의미
	private Integer id; // entity는 무조건 객체자료형으로 사용해야한다
	private String name;
	private String gender;
	private double height;
	private double weight;
	@Column(name="std_weight")
	private double stdweight;
	@Column(name="bmi_result")
	private String bmiResult1;
	private double bmi;
	
	
	// 생성자
		public Fitness() { }
		// id는 데이터베이스에서 auto_increment로 해서 받을 필요가 없기에 삭제처리햣다
	public Fitness(String name, String gender, double height, double weight) {
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		
		calcStdWeight();
		calcBMI();
	}
	
	
	
	public double getStdweight() {
		return stdweight;
	}

	public double getBmi() {
		return bmi;
	}

	public String getBmiResult() {
		
		return bmiResult1;
	}
	// 일반 메소드로 stdWeight , bmi ,bmiResult 처리하도록 함
	// 계산되어 나오는 결과이므로 
	private void calcStdWeight() {
		double key = height/100;
		if (gender.equals("남")) { // 기본자료형만 ==으로 비교
			stdweight =key*key*22;
		}else {
			stdweight = key*key*21;
		}
		
	}
	// 오버로딩을 배운후 진행해보자/  ************
	private void calcBMI() {
		double key = height/100;
		bmi = weight / (key*key);
		calcBmiResult();
	}
	
	
	private void calcBmiResult() {
		
		double key = height/100;
		bmi = weight / (key*key);
		
		if (bmi>=35) {
			bmiResult1 = "고도비만";
		}else if(bmi >=30 && bmi<=34.9) {
			bmiResult1 = "중도비만";
		}else if(bmi>=25 && bmi<=29.9) {
			bmiResult1 = "경도비만";
		}else if(bmi>=23 && bmi<=24.9) {
			bmiResult1 = "과체중";
		}else if (bmi>=18.5 && bmi <=22.9) {
			bmiResult1 = "정상";
		}else if(bmi>0 && bmi <18.5) {
			bmiResult1 = "저체중";
		}else if (bmi ==0) {
			bmiResult1="성별을 제대로 입력해주세요";
		}
	}
	public String toString() {
		return String.format(
		"%2d %s %s %.2fcm %.2fkg 표준체중: %.2f BMI: %.2f %s%n",
				id,name,gender,height,weight,stdweight,bmi,bmiResult1);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
		calcStdWeight();
		calcBMI();
	}
	public double getWeight() {
		return weight;
		
	}
	public void setWeight(double weight) {
		this.weight = weight;
		calcStdWeight();
		calcBMI();
	}
	
}
