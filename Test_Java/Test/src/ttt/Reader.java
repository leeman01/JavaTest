package ttt;

public class Reader extends Man implements Speakable {

	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reader(String name) {
		super(name);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return this.getName() + "독자는 자바를 잘하고 싶다";
	}

}
