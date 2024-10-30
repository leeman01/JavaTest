package ui;

import java.util.Scanner;

import service.ProductItml;
import vo.Foundation;
import vo.Lipstick;
import vo.Product;

public class CosmeticUI {
	 ProductItml service =new ProductItml();
	 Scanner keyin = new Scanner(System.in);
	 String [] lipstick1 =  {"립밤","립글로스","틴트"};
	 String [] lipstick2 = {"빨강","분홍","오렌지"};
	 String [] texture1 = {"크림","스틱"};
	// 생성자 만들기
	 
	
		
	public CosmeticUI() {
		Scanner keyin = 	new Scanner(System.in);
		Product product = new Product();
		String choice;
		while (true) {
			menu();
			choice = keyin.next();
			switch (choice) {
			case "1" : create() ; break;
			case "2" : redate() ; break;
			case "3" : delete() ; break;
			case "4": select() ; break;
			case "5" : retrieve() ; break;
			case "0" : 
				System.out.println("프로그램을 종료합니다");
				return;
			}
			
		}
	
	}
	private void delete() {
		System.out.println(">조회할 번호를 입력하시오: ");
		String productno = keyin.next();
		Product a =service.selectOne(productno);
		if (service.delete(productno)== true){
			System.out.println("성공적으로 삭제가 되었습니다");
		}
		System.out.println("해당정보는 없는 정보로 다시한번 시도해주실 바랍니다");
		return;
		
	}
	private void select() {
		System.out.println(">조회할 번호를 입력하시오: ");
		String productno = keyin.next();
		Product a =service.selectOne(productno);
		if (service.selectOne(productno) == null){
			System.out.println("해당정보는 없습니다");
//			return;
		}
		System.out.println(a.toString());
		
	}
	private void redate() {
		String productno,choice;
		String name=null;
		int type,color,texture;
		int price=0;
		System.out.println("<<상품수정>>");
	
		System.out.println(">수정할 상품번호: ");
		productno = keyin.next();
		Product product = new Product(productno,name,price);
		service.update(product);
		return;
	}

	private void retrieve() {
		Product [] list =service.SelectAll(); 
		int a =service.getCount();
		if (a==0) {
			System.out.println("제품정보가 없습니다");
			return;
		}	
		for (int i=0;i<a;++i) {
			System.out.println(list[i].toString());
		}
		
	}
	private void create() {
		String productno,choice,name;
		String name1=null;
		int type,color,texture,price;
		int price1=0;
		System.out.println("<<상품등록>>");
		System.out.println("1.립스틱 2. 파운데이션 : ");
		choice = keyin.next();
		System.out.println(">상품번호: ");
		productno = keyin.next();
		Product product = new Product(productno,name1,price1);
		
		System.out.println(">상품명: ");
		name = keyin.next();
		System.out.println("상품가격: ");
		
		price = keyin.nextInt();
		if (choice.equals("1")) {
			System.out.println("> 립스틱 타입: (1. 립밤 2. 립글로스 3.틴트");
			type = keyin.nextInt();
			String type1 = lipstick1[type-1];
			System.out.println("> 립스틱 색상 : (1. 빨강 2. 분홍 3. 오렌지");
			color = keyin.nextInt();
			String color1 = lipstick2[color-1];
			
			Lipstick lip = new Lipstick(productno,name,price,type1,color1);
			boolean output =service.insert(lip);
			if (output == true) {
				System.out.println("저장이 성공적으로 완료됨");
			}else if(output ==false) {
				System.out.println("저장이 완료되지 않앗습니다 죄송합니다");
				return;
			}
			
		} else if(choice.equals("2")){
			System.out.println("> 파운데이션 제형 : (1. 크림 2. 스틱 ");
			texture = keyin.nextInt();
			String texture2 = texture1[texture-1]; 
			Foundation foundation = new Foundation(productno,name,price,texture2);
			boolean output =service.insert(foundation);
			if (output == true) {
				System.out.println("저장이 성공적으로 완료됨");
			}else if(output ==false) {
				System.out.println("저장이 완료되지 않앗습니다 죄송합니다");
				return;
			}
			
		}
	
	}
	private void menu() {
		System.out.println("===[화장품 관리]===");
		System.out.println("1.상품등록");
		System.out.println("2.상품 수정");
		System.out.println("3.상품 삭제");
		System.out.println("4.상품 조회");
		System.out.println("5.전체 상품 조회");
		System.out.println("0.종료");
		System.out.println("선택하시오: ");
	}
	
}
