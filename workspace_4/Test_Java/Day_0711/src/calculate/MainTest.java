package calculate;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		
		Scanner keyin = new Scanner(System.in);
		Point [] polygon = new Point[10];
		int cnt=0;
		while(true) {
			System.out.println("1.원 2.사각형 3. 전체보기 0. 종료");
			int check = keyin.nextInt();
			if (check==1) {
				System.out.println("x좌표를 입력하시오");
				double X=keyin.nextDouble();
				
				System.out.println("y좌표를 입력하시오");
				double Y=keyin.nextDouble();
				
				System.out.println("반지름을 입력하시오");
				double R=keyin.nextDouble();
				
				Circle cir = new Circle();
				cir.setX(X);
				cir.setR(R);
				cir.setY(Y);
				
				polygon[cnt] = cir;
				cnt++;
					
			}else if(check ==2) {
				System.out.println("x좌표를 입력하시오");
				double X=keyin.nextDouble();
				
				System.out.println("y좌표를 입력하시오");
				double Y=keyin.nextDouble();
				
				System.out.println("높이을 입력하시오");
				double H=keyin.nextDouble();
				
				System.out.println("길이을 입력하시오");
				double W=keyin.nextDouble();
				
				Ssquare sq = new Ssquare();
				sq.setX(X);
				sq.setY(Y);
				sq.setHeight(H);
				sq.setW(W);
				
				polygon[cnt] = sq;
				cnt++;
			}
			else if(check ==3) {
				for (int i=0 ; i<cnt;++i) 
					process(polygon[i]);		
			}
			else break;
		}

	}
	public static void process(Point point) {
		// 부모의 추상 메소드가 아닌 경우에는 다형성을 처리하기 어렵다
		if (point instanceof Circle) {
			point.square();
		}else if (point instanceof Ssquare) {
			point.square();
		}
	}
}
