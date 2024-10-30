package objectinherit;

import java.util.Objects;

class Friend{ // 이름 나이 output overloading 생성자 4개만 만듦
	String name;
	int age;
	public Friend(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void output() {
		System.out.println(name + "," + age + " 살");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "/" + age;
	}
	@Override
	public boolean equals(Object obj) { // obj => f3, f1 => this
		// this의 name과 obj의 name이 같고 this의 age와 obj age가 같아야함
		if (obj == this) return true;
		if (obj==null) return false;
		Friend temp = (Friend)obj; // 자식으로 변경해야함  ==> 하향캐스팅(부모를 자식으로) objec(부모) => Friend
		
		if ((temp.age == this.age)  &&  (temp.name.equals(this.name)))
			return true;
		else
			return false;
	}

}
public class FriendTest {

	public static void main(String[] args) {
		
		Friend f1 = new Friend("손오공",30);
		f1.output();
		// 전달인자가 객체면 그 객체의 toString()을 호출한다.
		// 오버라이드 되어있지 않으면 순수 object로 부터 상속받은 toString()을 호출
		System.out.println(f1);  // f1은 참조변수이므로 출력하면 주소가 출력된다
		
		Friend f2 = new Friend("저팔계",25);
		System.out.println(f2);
		
		Friend f3 = new Friend("손오공",30);
		System.out.println(f3);
		
		Friend f4= null;
		// 주소를 비교하는 것이므로 둘다 false값이 나온다
		System.out.println(f1 == f2);
		System.out.println(f1 == f3);
		// 이렇게해도 내용을 비교하는것이 아닌 주소를 비교하므로 false값이 나옴
		// 내용을 비교해서 같은 데이터라고 true 값을출려하려면 overriding 해야함
		System.out.println(f1.equals(f3));
		System.out.println(f1.equals(f4));
		
		System.out.println("====================================");
		String addr = "서울시";
		System.out.println(addr.getClass()); // 어느 클래스를 사용하는지 알려준다
		System.out.println(f1.getClass());
	// 멤버변수를 문자열로 변환하여 반환해주는 메소드

	}
}
