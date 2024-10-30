package fitnessManager;

import java.util.Scanner;

public class FitnessTest {
	static Scanner keyin = new Scanner(System.in); // static을 붙이기전까지 non-static이엇다
	public static void main(String[] args) {
		
		FitnessVO fitness =null;
		String choice;
		
		while(true) {
			menu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : fitness=input(fitness); break; 
			case "2" : output(fitness); break;
			case "0" : 
				System.out.println("종료");
				System.exit(0);
			default:
				System.out.println("메뉴를 다시 선택하길 바람");
			
			
			}
		}
		

	}
	public static void menu() {
		System.out.println("==============[Fitness 회원관리]=========");
		System.out.println("       1) 입력: ");
		System.out.println("       2) 출력: ");
		System.out.println("       0) 종료: ");
		System.out.println("------------------------------");
		System.out.print("선택>");
	}
	
	public static FitnessVO input(FitnessVO fitness) {
		fitness = new FitnessVO();
		String name,gender;
		double height ,weight;
		
		System.out.print("**이름**: ");
		name = keyin.next();
		
		System.out.print("**성별**: ");
		gender = keyin.next();
		
		System.out.print("**키**: ");
		height = keyin.nextDouble();
		
		System.out.print("**몸무게**: ");
		weight = keyin.nextDouble();
		
		
		fitness.setName(name);
		fitness.setGender(gender);
		fitness.setHeight(height);
		fitness.setWeight(weight);
		System.out.println("회원 가입 완료");
		return fitness;
//		System.out.println("이름: "+ fitness.getName());
//		System.out.println("성별: "+ fitness.getGender());
//		System.out.println("키: "+ fitness.getHeight());
//		System.out.println("몸무게: "+ fitness.getWeight());
	}
	public static void output(FitnessVO fitness) {
		if ((fitness == null)) {
			System.out.println("등록한 회원이 없습니다");
			return;
		}
		System.out.println("이름: "+ fitness.getName());
		System.out.println("성별: "+ fitness.getGender());
		System.out.println("키: "+ fitness.getHeight());
		System.out.println("몸무게: "+ fitness.getWeight());
		
	}

}
