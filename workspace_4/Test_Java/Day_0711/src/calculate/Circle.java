package calculate;

public class Circle extends Point {
	double r;
	

	public Circle() {
		super();
	}
	
	public Circle(double x, double y,double r) {
		super(x, y);
		this.r = r;
		
	}
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public void square() {
		double result = r * r * Math.PI;
		double x =this.getX();
		double y = this.getY();
		System.out.println("x의 좌표: " + x +"y의 좌표: " +y+"반지름: "+r+"넓이: " +result);

	}



	

}
