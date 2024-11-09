import java.util.Scanner;

public class SwitchTest_02 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);	
		
		int  score;
		String result= null;
		
		System.out.print("점수를 입력하시오:(0~100): ");
		score= keyin.nextInt();
		
		if (!(score >0 && score <=100)) {
			System.out.println("점수입력이 잘못됨");
			System.exit(1);
		
		}
		switch (score/10) {
		case 9: case 10: result="A 학점"; break;
		case 8: result="B 학점"; break;
		case 7: result="C 학점"; break;
		case 6: result="D 학점"; break;
		default : result ="F학점";
		}
		System.out.println(result);
		
	}

}
