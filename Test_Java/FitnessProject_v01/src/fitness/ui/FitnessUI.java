package fitness.ui;

import java.util.Scanner;

import fitness.VO.Fitness;

/*
 * 삭제
 * 1) 탈퇴할 회원여부 파악
 * 2) id를 물어봐서 같은 데이터가 있을 때만 탈퇴
 * 3) 탈퇴 여부를 확인 (check 변수 필요)
 */

public class FitnessUI {
	// Have -A 관계
	Scanner keyin = 	new Scanner(System.in);
	Fitness fitness = null;
			// null로 초기화 , 피트니스와는 다른 패키지안에 있기 때문에 무조건 import 해야한다 , cntrl +shift+o
	
	// 생성자
	public FitnessUI(){
		String choice;
		
		while (true) {
			menu();
			
			choice = keyin.next();
			switch(choice) {
			case "1" :create(); break;
			case "2" : retrieve() ; break;
			case "3" : update() ; break;
			case"4":  delete() ; break;
			case "0":
				System.out.println("###프로그램을 종료####");
				return;
			}
		}
	}// 생성자가 끝난 다음에 생성해야한다 // 메소드 끼리는 같은 레벨에 잇어야한다
	
	/*
	 * 회원가입
	 */
	private void create() {
		System.out.println("\n<<회원가입>>");
		
		String  name, gender,check;
		double height,weight;
		int id;
		
		if (fitness!=null) {
			System.out.println("## 내부 사정으로 가입이 불가능합니다##");
			return;
		}
		
		System.out.print("# 아이디: ");
		id = keyin.nextInt();
		
		System.out.print("# 이름: ");
		name = keyin.next();
		
		System.out.print("# 성별(남/여): ");
		gender = keyin.next();
		
		System.out.print("# 키(cm): ");
		height = keyin.nextDouble();
		
		System.out.print("# 몸무게(kg): ");
		weight = keyin.nextDouble();
		
		System.out.print("# 등록하시겠습니까?: ");
		check = keyin.next();
		
		if (!(check.equals("y") || check.equals("Y"))) {
			System.out.println("##가입이 중단되었습니다##");
		}
		fitness = new Fitness(id,name,gender,height,weight);
		System.out.println("가입이 완료되었습니다");
	}
	private void retrieve() {
		System.out.println("\n<<정보조회>>");
		int id;
		if (fitness == null) {
			System.out.println("##조회할 정보가 없습니다.\n");
			return;
		}
		System.out.print("# 아이디: ");
		id = keyin.nextInt();
		if (id != fitness.getId()) {
			System.out.println("##조회할 정보가 없습니다.\n");
			return;
		}
		
		fitness.output();
		System.out.println();
		
		
	}
	/*
	 * 여기서 부터는 수정을 하자 키와 몸무게만 수정이 가능하다
	 * id 키 몸무게를 입력받는다, 아이디가 있는 사람만 수정 가능 ,없으면 수정불가능
	 */
	private void update() {
		int id;
		double height ,weight;
		System.out.print("# 아이디: ");
		id = keyin.nextInt();
		if (!(id == fitness.getId())) {
			System.out.println("존재하지 않는아이디 입니다");
			return;
		}
		
		System.out.print("# 키(cm): ");
		height = keyin.nextDouble();
		
		System.out.print("# 몸무게(kg): ");
		weight = keyin.nextDouble();
		
		fitness.setHeight(height);
		fitness.setWeight(weight);
		
		fitness.output();
	
	}
	private void delete() {
		int id;
		String name;
		String gender;
		String check;
		double height;
		double weight;
		double stdweight;
		double bmi;
		System.out.print("# 아이디: ");
		id = keyin.nextInt();
		System.out.print("# 이름: ");
		name = keyin.next();
		if (!(id == fitness.getId()|| name == fitness.getName())) {
			System.out.println("## 일치하는 정보가 없습니다 ## ");
			return;
		}
		System.out.print("# 삭제하십니까?: ");
		check = keyin.next();
		if (!(check.equals("y") || check.equals("Y"))) {
			System.out.println("## 삭제가 취소되었습니다 ##");
			return;
		}
		fitness = null;
		System.out.println("## 삭제가 완료되었습니다 ##");
		
	}
	/**
	 * 메뉴를 화면에 출력
	 */
	private void menu() {
		System.out.println("=====[휘트니스 회원관리]=====");
		System.out.println("          1)  저 장");
		System.out.println("          2)  조회");
		System.out.println("          3) 수정");
		System.out.println("          4)  삭  제");
		System.out.println("          0) 종료");
		System.out.println("========================");
		System.out.print("선택하시오:  ");
		
	}
}
