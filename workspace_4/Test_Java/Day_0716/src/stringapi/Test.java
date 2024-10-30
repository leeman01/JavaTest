package stringapi;
// String에 있는 메소드만 사용해서 처리할것
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n1 = "1234"; // 숫자로변환 단 charArt()
		
		int sum=0;
		for (int i=0;i<n1.length();++i){
			int a = n1.charAt(i);
			a= a-'0';
			int z=1;
			for(int j =n1.length()-1;j>i ;--j ) {
				a = a*10;
				
			}
			sum+=a;
		
		}
		System.out.println(sum);
		Integer A = 1;
		String a="1";
	
		System.out.println(A.equals(a));
		}

}
 