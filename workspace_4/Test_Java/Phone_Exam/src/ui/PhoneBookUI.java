package ui;

import java.util.Scanner;

import fitness.VO.Fitness;
import service.PhoneBookService;
import vo.PhoneBook;

public abstract class PhoneBookUI implements PhoneBookService {
	Scanner keyin = new Scanner(System.in);
	PhoneBook [] list = new PhoneBook[100];
	PhoneBook book =new PhoneBook();
	int cnt=0;
	public PhoneBookUI(){
		String check;
		
//		String phoneNumber,name,relation;
		while (true) {
			menu();
			System.out.println("번호를 입력해주세요");
			check = keyin.next();
			switch(check) {
			case "1" :create(); break;
			case "2" : retrieve() ; break;
			case "3" : retrieveAll();break;
			case "4" : update() : break;
			case "0":
				System.out.println("###프로그램을 종료####");
				return;
			}
		}
	}// 생성자가 끝난 다음에 생성해야한다 // 메소드 끼리는 같은 레벨에 잇어야한다
	
	
	

	private void menu() {
		System.out.println("=====[전자 책 관리]=====");
		System.out.println("          1)  저 장");
		System.out.println("          2)  조회");
		System.out.println("          3) 수정");
		System.out.println("          4)  삭  제");
		System.out.println("          5) 전체조회");
		System.out.println("          0) 종료");
		System.out.println("========================");
		System.out.print("선택하시오:  ");
		
	}

}
