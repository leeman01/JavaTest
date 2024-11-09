
public class SwitchTest_01 {

	public static void main(String[] args) {
		String family = "FATHER";
		
		switch (family) {
		//case "FATHERr" :  // 실행문이 없으니 아무것도 안하고 break도 없어서 밑으로 내려간다
		case "FATHER" :case "father" :case "Father" : System.out.println("아버지"); break ;
		case "Mother" : System.out.println("어머니"); break ;
		case "Brother" : System.out.println("남자형제"); break ;
		case "Sister" : System.out.println("여자형제"); break ;
		default : System.out.println("누구???");
		}
		System.out.println("!!끝!!");
		System.out.println("============");
		// ===========================================
		int value =1 ;
		String result = " ";
		
		switch(value) {
		case 0 : result +="*";
		case 1 : result +="^";
		case 2 : result +="^";
		case 3 : result +="*";
		}
		System.out.println(result);
	}

}
