package ui;
//private String name;
//private String carnum;
//private String phone;
//private String location ;

import java.util.Scanner;


import service.CarRentService;
import vo.CarRent;

public class CarRentUI {
	Scanner keyin = new Scanner(System.in);
	CarRentService service = new CarRentService();
	// 생성자
	public CarRentUI(){
		String choice;

		while (true) {
			menu();

			choice = keyin.next();
			switch(choice) {
			case "1" :create(); break;
			case "2" : retrieve() ; break;
			case "3" : retrieveAll();break;
			case "0":
				System.out.println("###프로그램을 종료####");
				return;
			}
		}
	}// 생성자가 끝난 다음에 생성해야한다 // 메소드 끼리는 같은 레벨에 잇어야한다






	private void create() {
		System.out.println("\n<<회원가입>>");

		String  name, carnum,check,phone,location;

		System.out.println("## 예약자 성함입력:  ");
		name = keyin.next();


		System.out.println("## 예약하려는 차번호 입력:  ");
		carnum = keyin.next();

		System.out.println("## 예약자 전화번호입력:  ");
		phone = keyin.next();
		System.out.print("# 예약자 위치 입력: ");
		location = keyin.next();


		System.out.print("# 예약하시겠습니까?(y/n): ");
		check = keyin.next();

		if (!(check.equals("y") || check.equals("Y"))) {
			System.out.println("##예약이 중단되었습니다##");
			return;
		}
		CarRent carrent = new CarRent(name,carnum,phone,location);
		service.insert(carrent);
		System.out.println("## 예약이 완료되었습니다 ##");

	}
	private void retrieve() {
		System.out.println("\n<<예약정보조회>>");
		String phone;
		System.out.print("# 전화번호: ");
		phone = keyin.next();
		CarRent carrent = service.selectOne(phone);
		if (carrent ==null) {
			System.out.println("## 입력한신 분의 예약정보가 없습니다 ##");
			return;
		}

		carrent.output();
		System.out.println();


	}

	private void retrieveAll() {
		int count = service.getCount();
		if(count == 0) {
			System.out.println("가입한 회원이 한명도 없습니다");
			return;
		}
		CarRent [] list = service.selectAll();

		for(int i =0 ; i<count;++i) {
			CarRent carrent = list[i];
			carrent.output();
		}
	}





	private void menu() {
		System.out.println("=========[예약하십니까]============");
		System.out.println("1)예약");
		System.out.println("2)조회");
		System.out.println("3)전체출력");
		System.out.println("0)종료");
	}





}
