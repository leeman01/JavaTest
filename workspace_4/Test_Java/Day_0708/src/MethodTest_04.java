
public class MethodTest_04 {

	public static void main(String[] args) {
		int [] a= {10,20};
		
		System.out.println("a[0]: " + a[0]+"a[1]: " + a[1]);
		exchange(a);
		System.out.println("a[0]: " + a[0]+"a[1]: " + a[1]);
	}
	
	public static void exchange(int[] a) {
		int temp=a[0];
		a[0]=a[1];
		a[1]= temp;
		
	}
}
