package inherit03;
// 다형성
// 상속
public class AnimalTest2 {

	public static void main(String[] args) {
		// Animal animal = new Animal();  // 객체생성할수 없다는 오류발생 , 이 클래스는 상속만을 위해서 만듦
		Animal animal;
		animal = new Dog();
		animal.setType("개의종류");
		animal.output();
		animal.cry();  // 동적바인딩: 부모의 메소드가 추상 이면 자동으로 자식의 메소드를 찾아가는 것 => 다형성
		System.out.println("===========================");
		
		animal = new Bird();
		animal.setType("새의 종류");
		animal.output();
		animal.cry();  // 동적바인딩: 부모의 메소드가 추상 이면 자동으로 자식의 메소드를 찾아가는 것 => 다형성
		System.out.println("===========================");
		
		animal = new Cat();
		animal.setType("고양이의 종류");
		animal.output();
		animal.cry();  // 동적바인딩: 부모의 메소드가 추상 이면 자동으로 자식의 메소드를 찾아가는 것 => 다형성
		
		
	}
	
}
