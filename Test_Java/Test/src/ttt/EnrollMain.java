package ttt;

import java.util.Scanner;

public class EnrollMain {
	
	public static void main(String[] args) {
		 Scanner keyin = new Scanner(System.in);
		Speakable [] list = new Speakable[2];
		for (int i=0;i<list.length;++i) {
			// TODO Auto-generated method stub
			System.out.println("어떤 Speaker를 등록하시는지 선택하세요");
			System.out.println("1.Reader 등록");
			System.out.println("2.Worker 등록");
			int check1 = keyin.nextInt();
			System.out.println("이름을 입력하세요");
			String check2 =keyin.next();
			if (check1==1) {
				Reader target = new Reader(check2);
				list[i] = target;
			}else if(check1 ==2){
				Worker target = new Worker(check2);
				list[i] = target;;
			}
		}
		System.out.println("두명 Speaker 의 등록이 완료되었습니다 이제 스피커들의 스피킹 진행결과입니다");
		for(int j=0;j<list.length;++j) {
			System.out.println(list[j].speak());
			
		}
	}

}
