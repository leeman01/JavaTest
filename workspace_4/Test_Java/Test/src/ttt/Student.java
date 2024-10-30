package ttt;

public class Student extends Man {

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name) { // 이게 없으면 부모의 기본생성자가 없는 거 이므로 에러가 난다
		super(name);
		// TODO Auto-generated constructor stub
	}

}
