package com.kdigital.test2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class Fitnessdto {
	
	private String name;
	private String gender ;
	private double height;
	private double weight;
	private double bmi;
	private String bmiResult;
	private double stdweight;
	public Fitnessdto(String name, String gender, double height, double weight) {
		super();
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		calcStdWeight();
		calcBMI();
		calcBmiResult();
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
			bmiResult = "고도비만";
		}else if(bmi >=30 && bmi<=34.9) {
			bmiResult = "중도비만";
		}else if(bmi>=25 && bmi<=29.9) {
			bmiResult = "경도비만";
		}else if(bmi>=23 && bmi<=24.9) {
			bmiResult = "과체중";
		}else if (bmi>=18.5 && bmi <=22.9) {
			bmiResult = "정상";
		}else if(bmi>0 && bmi <18.5) {
			bmiResult = "저체중";
		}else if (bmi ==0) {
			bmiResult="성별을 제대로 입력해주세요";
		}
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

	   public double getStdWeight() {
	      return stdweight;
	   }


}
