package friend;

import java.util.Scanner;
// 오버로딩 생성자를 넣어서 일부 수정햇으므로 실행하지 마시오!
public class FriendUI {
	// Have -A 관계
	Scanner keyin = 	new Scanner(System.in);
	FriendVO friend = new FriendVO(); // null로 초기화
	
	// 생성자
	public FriendUI(){
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
	}
	/*
	 * 삭제 버튼
	 */
	private void delete() {
		String phone , check;
		String a= friend.getName();
		String b= friend.getPhone();
		int c = friend.getAge();
		int age;
		System.out.println("삭제할 이름을 입력하시오: ");
		String name = keyin.next();
		if (name ==null) {
			System.out.println("## 저장된 정보가 없습니다##");
			return;
		}
		friend.output();
		
	
		System.out.print(" 정말로 삭제할까요?(y/n): ");
		check  =keyin.next();
		
		if (!(check.equals("y") || check.equals("Y"))) {
			System.out.println("삭제작업이 취소되었습니다.\n");
			return;
		}
		friend.setName(null); //NullPoiterExceprtion 이 발생할 수 있다
		friend.setPhone(null);
		friend.setAge(0);
		
		System.out.println("## 삭제완료 ##");
		
	}
	/*
	 * 저장된 전화번호부와 나이를 수정
	 */
	private void update() {
		String phone , check;
		int age;
		String name = friend.getName();
		if (name ==null) {
			System.out.println("## 저장된 정보가 없습니다##");
			return;
		}
		friend.output();
		
		System.out.print("전화번호: ");
		phone =keyin.next();
		System.out.print("나이: ");
		age = keyin.nextInt();
		
		System.out.print(" 정말로 수정할까요? (y/n)");
		check  =keyin.next();
		
		if (!(check.equals("y") || check.equals("Y"))) {
			System.out.println("수정 작업이 취소되었습니다.\n");
			return;
		}
		friend.setPhone(phone);
		friend.setAge(age);
		System.out.println("## 수정완료");
				
	}
	/*
	 * 저장된 전화번호부의 데이터를 출력
	 */
	private void retrieve() {
		String name = friend.getName();
		if (name ==null) {
			System.out.println("## 저장된 정보가 없습니다##");
			return;
		}
		friend.output();
		
		
	}
	/**
	 * 한사람의 정보를 입력받아 대입하는 메소드
	 */
	private void create() {
		// 지역변수 선언
		String name,phone ;
		int age;
		
		System.out.print("이름: ");
		name = keyin.next();
		System.out.print("전화번호: ");
		phone =keyin.next();
		System.out.print("나이: ");
		age = keyin.nextInt();
		// 기존 값을 변경하는 과정이라 이해하자
//		friend.setName(name);
//		friend.setPhone(phone);
//		friend.setAge(age);
		friend = new FriendVO(name,phone,age); // 새롭게 생성된 @ 200번지라면~
		System.out.println("## 저장완료\n");
	}
	/**
	 * 메뉴를 화면에 출력
	 */
	private void menu() {
		System.out.println("=====[전화번호부]=====");
		System.out.println("          1)  저 장");
		System.out.println("          2)  조회");
		System.out.println("          3) 수정");
		System.out.println("          4)  삭  제");
		System.out.println("          0) 종료");
		System.out.println("========================");
		System.out.print("선택하시오:  ");
		
	}

}
