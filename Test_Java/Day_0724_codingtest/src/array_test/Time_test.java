package array_test;

public class Time_test {

	public static void main(String[] args) {
		solutions(6);

	}

	private static void solutions(int n) {
		int count=0;
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				count++;
			}
		}
		for(int i=0;i<n;++i) {
			count++;
		}
		for (int i=0;i<n*2;++i) {
			count++;
		}
		for (int i=0;i<5;++i) {
			count++;
		}
		System.out.println(count);
	}

}
