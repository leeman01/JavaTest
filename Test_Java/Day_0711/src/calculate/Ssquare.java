package calculate;

public class Ssquare extends Point {
	double height; //높이 ,길이
	double w;
	
	public Ssquare() {
		super();
	}
	
	public Ssquare(double height, double w) {
		super();
		this.height = height;
		this.w = w;
	}


	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	@Override
	public void square() {
		double result = height * w;
		double x =this.getX();
		double y = this.getY();
		System.out.println("x의 좌표: " + x +"y의 좌표: " +y+"높이: "+height +"길이: "+w
				+"결과: "+ result);

	}

}
