package myenum;

public class FruitTest_02 {

	public static void main(String[] args) {
		Fruit1  apple =Fruit1.사과; // enum
		String english = apple.getFruit();
		
		System.out.println(apple);
		// name() : Fruit 데이터의 값을 가져오는 메소드
		System.out.println(apple.name() +":" + english) ;
		
		Fruit1 [] fary =Fruit1.values();  // enum 안에 선언된 각각의 데이터를 배열로 반환
		System.out.println(fary.length);
		for (Fruit1 f:fary)
			System.out.println(f);
		
		System.out.println("========================");
		Fruit1 ftemp = Fruit1.바나나;
		switch(ftemp) {
		case 바나나: System.out.println("바나나는 노래"); ; break;
		case 사과 : System.out.println("사과는 빨개"); ; break;
		case 딸기 : System.out.println("딸기는 비싸"); break;
		default :	
		}
		System.out.println("========================");
		// valueofString(0 : 데이터와 매칭되는 Enum타입을 반환
		Fruit1 ftmp = Fruit1.valueOf("딸기");
		System.out.println(ftmp);
		
		System.out.println("========================");
		String ftmp1 =ftmp.name();  // 문자열로 변환 name , tostring 모두 문자열로 반환한다 <= 모두 enum에서 상속받아 사용됨
		System.out.println(ftmp1);
		String ftmp2 = ftmp.toString();
		System.out.println(ftmp2);
		
		
		System.out.println("========================");
		System.out.println(ftmp1.equals(ftmp2)); // 둘다 문자열이므로 true
		
		System.out.println("========================");
		Fruit1 ftmp3 =Fruit1.사과;
		int ord = ftmp3.ordinal(); // index값을 반환하는 메소드
		System.out.println(ord);
	}

}
