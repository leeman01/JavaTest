package ttt;

public class Worker extends Man implements Speakable {

	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Worker(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return this.getName() + "일꾼은 자기가 맡은 일을 잘하고 싶어한다";
	}

}
