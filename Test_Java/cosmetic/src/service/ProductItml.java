package service;

import java.util.Scanner;

import vo.Foundation;
import vo.Lipstick;
import vo.Product;

public class ProductItml implements CosmeticServiceI {
	int count=0;
	Product [] list = new Product[10];
	Scanner keyin = new Scanner(System.in);
	String [] lipstick1 =  {"립밤","립글로스","틴트"};
	String [] lipstick2 = {"빨강","분홍","오렌지"};
	String [] texture1 = {"크림","스틱"};
	@Override
	public boolean insert(Product product) {
		String b= product.getProductno();
		if(count ==list.length) 
			return false;
		for (int i=0 ; i<count ; ++i) {
			if (list[i].getProductno().equals(b)) {
				System.out.println("이미 있는 상품번호입니다");
				return false;
			}
		}
		list[count++]=product;
		return true; // 삽입 구문	
	}

	@Override
	public boolean update(Product product) {
		String b= product.getProductno();
		String a = product.getName();
		int d = product.getPrice();
		int c= product.getPrice();
		
		for (int i=0; i<count;++i) {
			if (b.equals(list[i].getProductno())) {
				System.out.println(list[i].toString());
				}
			
			if ((list[i] instanceof Lipstick) &&(list[i].getProductno().equals(b)) ) {
				
				System.out.println(">상품명 : ");
				String name = keyin.next();
				System.out.println("> 상품가격 : ");
				int price = keyin.nextInt();
				System.out.println("립스터 타입:(1. 립밤 /2. 립글로스 3.틴트): ");
				int type = keyin.nextInt();
				String type1 =  lipstick1[type-1];
				System.out.println(">립스터 색상: (1. 빨강 2. 분홍 3. 오렌지");
				int color = keyin.nextInt();
				String color1 = lipstick2[color-1];
				Lipstick lip = new Lipstick(b, name, price,type1,color1);
				list[i] = lip;
				System.out.println("정보가 수정되었습니다");
				return true;
				
			
			}else if((list[i] instanceof Foundation) && (list[i].getProductno().equals(b))) {
				System.out.println(">상품명 : ");
				String name1 = keyin.next();
				System.out.println("> 상품가격 : ");
				int price1 = keyin.nextInt();
				System.out.println("파운데이션 제형: (1. 크림 2.스틱)");
				int type2 = keyin.nextInt();
				String texture = texture1[type2-1];
				Foundation found = new Foundation(b,name1,price1,texture);
				list[i] = found;
				System.out.println("정보가 수정되었습니다");
				return true;
			}			
		}
		System.out.println("해당 상품은 없는 정보입니다");
		return false;
	}
	@Override
	public boolean delete(String prodcutno) {
		
		for(int i=0 ; i<count;++i) {
			if (list[i].getProductno().equals(prodcutno)) {
				for(int j=i ; j <count-1;++j) { //뒤의 데이터를 앞으로 가져오기
					list[j] = list[i];
				}
				-- count;
				return true;
			}
		}
		return false;
	}
		
	

	@Override
	public Product selectOne(String productno) {
		for (int i=0;i<count;++i) {
			if (list[i].getProductno().equals(productno)) {
				return list[i];
			}
		}
		return null;
	}

	@Override
	public Product[] SelectAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

}
