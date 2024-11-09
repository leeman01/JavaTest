
public class SwallowCopy {

	public static void main(String[] args) {
		int [] ary1 = {1,2,3,4,5};
		int[ ] ary2;
		
		// 얕은복사
		ary2=ary1;// 주소 복사 
		for(int temp:ary1) {
			System.out.println(temp+" ");
		System.out.println();
		}
		ary2[1]=100;
		for(int temp:ary1) {
			System.out.println(temp+" ");
		System.out.println();
		}
	}

}
