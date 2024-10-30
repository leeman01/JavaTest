
public class StringToNumber {

	public static void main(String[] args) {
		String str = null;
		String source = "2345";
		int data = 19;
		System.out.println(isNumber(source));
		System.out.println(toNumber(source));
		
		System.out.println("덧셈연산의결과" +":" +  (toNumber(source)+data));
	}
	public static boolean isNumber(String str) {
		
		for (int i=0;i<str.length();++i) {
			char k = str.charAt(i);
			if ( !(k>='0' && k<='9')) {
				return false;
			}
		}
		return true;
	}
	public static int toNumber(String str) {
		
		int sum=0;
		int num;
		for (int i=0;i<str.length();++i) {
			int number =1; 
			int  k = str.charAt(i)-'0'; // 3
			for(int j=str.length()-1 ; j>i;--j) {
				k=k*10;
			}
			sum+=k;
		}
		return sum;
	}

}
