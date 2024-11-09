package inherit03;
// 부모가 추상클래스면 자식도 추상클래스가 된다
// 객체 생성이 가능한 클래스 (concreate class)가 되려면 상속받은  추상메소드를  반드시 ! 오버라이딩 해야한다 !!!!!!!!!!!!!!
public class Cat extends Animal {

	@Override
	public void cry() {
		System.out.println("야옹~~~~~~~");
		
	}
}
