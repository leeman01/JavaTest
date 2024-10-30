package myinterface;

public class CirculatorImpl implements Calculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int substract(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double divide(int a, int b) {
		// TODO Auto-generated method stub
		return ((double)a) /b;
	}

	@Override
	public int modulas(int a, int b) {
		// TODO Auto-generated method stub
		return a%b;
	}

}
