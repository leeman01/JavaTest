import java.util.Arrays;

public class DeepCopy {

	public static void main(String[] args) {
		int[] ary1 = {1, 2,3,4,5}; // ary1 has only 2 elements
		int[] ary2 = Arrays.copyOf(ary1, 6); // 부족하면 0으로 채운다
 // deep -copy
		
		ary2[0]=100;
		// 원본배열
		for(int temp:ary1) 
			System.out.println(temp+" ");
		System.out.println();
		
		// 복사배열
		for(int temp:ary2) 
			System.out.println(temp+" ");
		System.out.println();
		
	}

}
