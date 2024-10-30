package calculate;

public abstract class Point {
	private double x;
	private double y;
	public Point() {
		super();
	}
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	// 면적을 구하는 부모 클래스 메소드
	public abstract void  square();
	

}
