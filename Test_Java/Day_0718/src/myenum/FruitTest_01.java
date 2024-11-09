package myenum;

public class FruitTest_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit1 f = Fruit1.딸기;  // enum 타입  static final 상수타입
		System.out.println(f.getFruit());
		System.out.println(f);
		System.out.println("===========================");
		//Reflection을 이용하면 6라인처럼 변수명을 조회할수 있다
		String f2 = fruit3.STRABERRY;
		System.out.println(f2); // 변수명 조회는 지금 안됨
		
		
	}

}
