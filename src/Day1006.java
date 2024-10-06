
public class Day1006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] ch = new int[] {1,2,3,4};
		System.out.println(solution(ch));

	}
	private static double solution(int [] arr) {
		double c=0;
		for(int a:arr) {
			c+=a;
		}
		return c/arr.length;
		
	}

}
