package inherit03;

public class AnimalTest {

	public static void main(String[] args) {
		// Animal animal = new Animal();  // 객체생성할수 없다는 오류발생 , 이 클래스는 상속만을 위해서 만듦
		Dog dog = new Dog();
		dog.setType("포유류");
		dog.output();
		dog.cry();
		
		System.out.println("====================");
		
		Bird bird = new Bird();
		bird.setType("조류");
		bird.output();
		bird.cry();
		
		System.out.println("====================");
		
		Cat cat = new Cat();
		cat.setType("포유류");
		cat.output();
		cat.cry();
	}

}
