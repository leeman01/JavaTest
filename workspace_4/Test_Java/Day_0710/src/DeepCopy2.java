import java.util.Arrays;

public class DeepCopy2 {

	public static void main(String[] args) {
		int[] ary1 = {1, 2,3,4,5}; // ary1 has only 2 elements
		int[] ary2 = Arrays.copyOfRange(ary1, 1,10);    // (ary1 , from 1 ,to 10) to값이 원본의 크기본다 크면 0으로 채움
 // deep -copy
	
		// 원본배열
		for(int temp:ary1) 
			System.out.print(temp+" ");
		System.out.println();
		
		// 복사배열
		for(int temp:ary2) 
			System.out.print(temp+" ");
		System.out.println();
		
	}

}
