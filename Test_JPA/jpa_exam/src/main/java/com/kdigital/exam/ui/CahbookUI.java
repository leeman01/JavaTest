package com.kdigital.exam.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


import com.kdigital.entity.service.CashbookService;
import com.kdigital.entity.service.CashbookServiceImpl;
import com.kdigital.exam.entity.CashBook;
import com.kdigital.exam.entity.ItemType;

import jakarta.persistence.Column;



public class CahbookUI {
	// Have -A 관계
	Scanner keyin = 	new Scanner(System.in);
	CashbookServiceImpl service = new CashbookServiceImpl();

	public CahbookUI(){
		int number,amount;
		String  detail,note,choice;
		LocalDate today;
		ItemType itemtype;
	
		while (true) {
			menu();
			System.out.println("메뉴를 선택하시오: ");
			choice = keyin.next();
			switch(choice) {
			case "1" : create() ; break;
			case "2" : retrieve() ; break;
			case "3" : delete() ;break;
			case "4" :  statistics() ; break;
			case "5" : retrieveAll() ; break;
			case "0":
				System.out.println("###프로그램을 종료####");
				return;
			}
		}
	}// 생성자가 끝난 다음에 생성해야한다 // 메소드 끼리는 같은 레벨에 잇어야한다



	private void statistics() {
		System.out.println("월별 지출조회");
		String date = makeDate();
		List<CashBook> list =service.statistics(date);
		if (list.size()==0) {
			System.out.println("## 조회된 날짜의 데이터가 없음");
			return;
		}
		int total=0;
		for (CashBook book :list) {
			total += book.getAmount();
		}
		for (CashBook book:list) {
			System.out.println(book);
			System.out.printf("비율 : %.2f%% %n",(book.getAmount()/(double) total*100));
		}
		System.out.printf("총 지출합계 : %,d원 %n",total);
		System.out.println();
		
	}



	/*
	 * 회원가입
	 */
	private void create() {
		String check,detail,note ;
		int amount;
		ItemType tar = null;
		System.out.println("지출내역입력>>");
		System.out.println("1.식비 2.문화예술 3.미용 4. 교통비 5. 경조사비 6.금융 7.기타");
		System.out.println("항목번호>>: ");
		check = keyin.next();
		switch(check) {
		case "1" : tar = ItemType.식비 ; break;
		case "2" : tar = ItemType.문화예술; break;
		case "3" : tar = ItemType.미용; break;
		case "4" : tar = ItemType.교통;break;
		case "5" : tar = ItemType.경조사; break;
		case "6" : tar = ItemType.금융; break;
		case "7" : tar = ItemType.기타; break;
		}
		keyin.nextLine();
		System.out.println("자세한 내역>>:                                  ");
		detail =keyin.nextLine();
		
		System.out.println("자세한 금액>>:                                  ");
		amount=keyin.nextInt();
		keyin.nextLine();
		System.out.println("메모할 내역>>:                                  ");
		note=keyin.nextLine();
		
		CashBook cashbook = new CashBook(tar,detail,amount,note);
		if (service.insert(cashbook)) {
			System.out.println("저장성공");
		}else {
			System.out.println("저장실패");
		}
		
	}
	private void retrieve() {
		System.out.println("월별 지출조회");
		String date = makeDate();
		List<CashBook> list =service.selectData(date);
		if (list.size()==0) {
			System.out.println("## 조회된 날짜의 데이터가 없음");
			return;
		}
		System.out.println("## 조회된 데이터의 개수:"+list.size());
		list.forEach((i) -> System.out.println(i));
	}
	/*
	 * 여기서 부터는 수정을 하자 키와 몸무게만 수정이 가능하다
	 * id 키 몸무게를 입력받는다, 아이디가 있는 사람만 수정 가능 ,없으면 수정불가능
	 */
	private void update() {
		int id;
		double height ,weight;
		String check;
		System.out.print("# 아이디: ");
		id = keyin.nextInt();
		
		
		System.out.print("# 키(cm): ");
		height = keyin.nextDouble();
		
		System.out.print("# 몸무게(kg): ");
		weight = keyin.nextDouble();
		System.out.println("수정하시겠습니가?");
		check = keyin.next();
		
		if (!(check.equals("y") || check.equals("Y"))) {
			System.out.println("## 삭제가 취소되었습니다 ##");
			return;
		}
		
		
		
	
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
	
		
		System.out.print("# 삭제하십니까?: ");
		check = keyin.next();
		if (!(check.equals("y") || check.equals("Y"))) {
			System.out.println("## 삭제가 취소되었습니다 ##");
			return;
		}
		boolean result =service.delete(id);
		if (result) {
			System.out.println("## 삭제가 완료되었습니다 ##");
		}else {
			System.out.println("## 삭제가 실패했습니다 ##");
		}
		
		
	}
	/*
	 *  전체회원 조회
	 */
	private void retrieveAll() {
	List <CashBook> list = service.selectAll();
			
			if(list.size() == 0) {
				System.out.println("가입한 회원이 한명도 없습니다");
				return;
			}
			System.out.println("전체회원 수: " + list.size());
			
			for(int i =0 ; i<list.size();++i) {
				CashBook cashbook = list.get(i);
				System.out.println(cashbook);
		}
		
		
		
	}
	private String makeDate() {
		String year,month;
		
		System.out.print("## 년도를 4자리로 입력 : ");
		year = keyin.next();
		try {
			if(year.length()!=4) 
				throw new Exception("## 데이터가 잘못 입력되었습니다");
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		
		System.out.print("## 월을 2자리로 입력: ");
		month = keyin.next();
		try {
			if(month.length() !=2) 
				throw new Exception("## 데이터가 잘못 입력되었습니다");
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
			String date =year+"-"+month;
			return date;
	}
	/**
	 * 메뉴를 화면에 출력
	 */
	private void menu() {
		System.out.println("=====[돈 관리]=========");
		System.out.println("          1)  지출내역입력");
		System.out.println("          2)  지출내역조회");
		System.out.println("          3) 내역삭제");
		System.out.println("          4)  지출 통계보기");
		System.out.println("         5) 전체조회 ");
		System.out.println("          0) 기타");
		System.out.println("========================");
		System.out.print("선택하시오:  ");
		
	}
}
