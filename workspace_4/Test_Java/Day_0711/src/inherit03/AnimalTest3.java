package inherit03;
// 다형성
// 상속
public class AnimalTest3 {

	public static void main(String[] args) {
		// Animal animal = new Animal();  // 객체생성할수 없다는 오류발생 , 이 클래스는 상속만을 위해서 만듦
		Animal animal;
		animal = new Dog();
		System.out.println(animal instanceof Dog); // 형제객체가 아닌 다른것을 사용하면 안됨
		process(animal);
		System.out.println("=====================");
		
		
		animal = new Bird();
		process(animal);
		System.out.println("=====================");
		
		
		animal = new Cat();
		process(animal);
		System.out.println("=====================");
		
	}
	// 쓸 예정
	public static void process(Animal animal) {
		// 부모의 추상 메소드가 아닌 경우에는 다형성을 처리하기 어렵다
		if (animal instanceof Cat) {
			animal.setType("고양이");
		}else if (animal instanceof Bird) {
			animal.setType("참새");
		}else if (animal instanceof Dog) {
			animal.setType("강아지");
		}
		animal.output();
		//  cry 메소드는 추상메소드라서 다형성 처리가된다
		animal.cry();
	}
}
