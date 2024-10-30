/*
 * LocalDate 클래스를 이용하여 나이 계산하는 로직이 추가 // 현재날짜 - 생년월일 
 * 생년월일보다 현재날짜가  과거이면 안된다
 * 메소드 생성해서 나이 계산
 */
package stringapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Scanner;

public class JuminValidation2 {
	
	public static void main(String[] args) {
		String jumin = "981127-1047715";
		Scanner keyin = new Scanner(System.in);
		if(jumin.length() !=14) {
			System.out.println("잘못된 주민번호(길이)");
			System.exit(0);
		}
		if ( ! isvalid(jumin)) {
			System.out.println("잘못된 주민번호(-)");
		}
		String [] str = jumin.split("-");
		if(!(isNumeric(str[0]) && isNumeric(str[1]))) {
			System.out.println("잘못된 주민번호(숫자)");
			System.exit(0);
		}
		char gt = jumin.charAt(7);
		// 성별은 1 2 3 4만 허용
		if(!(gt>='1' && gt<='4')) {
			System.out.println("잘못된 주민번호(성별)");
			System.exit(0);
		}
		// 검증을 할 수 있는 조건 구비
		if (!codeCheck(jumin)){
			System.out.println("잘못된주민번호입니다(검증알고리즘)");
			System.exit(0);
		}
		// 올바른 주민번호
		String year , month,day,gender;
		year = birthyear(jumin);
		month = jumin.substring(2,4);
		day =jumin.substring(4,6);
		gender = gendercheck(jumin);
		int age = claculateAge(jumin);
		System.out.println("당신은 "+ year +month +day+ gender+"생일입니다"+" "+ age + "살");
	}
	private static boolean codeCheck(String id) {
		int total = 0; // 합계
		int temp =0; //  주민번호 한개씩 따와서 저장할 변수
		int value =2;
		for(int i=0 ; i<id.length()-1;++i) {
			if ( i == 6) continue; // -를 건너 띄는 로직
			temp =id.charAt(i)-'0';
			total += value * temp;
			value++; 
			if (value==10) value=2;
		}
		
		int check  =id.charAt(id.length()-1)-'0';
		int tmp = 11 -(total%11);
		if (tmp>9) tmp = tmp%10;
		if (tmp==check) return true;
		return false;
	
		
	}
	public static int claculateAge(String id) {
		LocalDateTime now = LocalDateTime.now();
		int Year = now.getYear();
		
		int year = Integer.parseInt(id.substring(0,2));
		int  month = Integer.parseInt(id.substring(2,4));
		int day = Integer.parseInt(id.substring(4,6));
		LocalDateTime birth = LocalDateTime.of(year,month,day,0,0,0);
		if (now.isBefore(birth)) return 0;
		
		if ( (now.getMonthValue()>=month) && (now.getDayOfMonth()>=day)) return Year-year+2;
		
		return Year-year+1;
	}
	public static String birthyear(String id) {
		String birth = null ;
		int gender = id.charAt(7);
		if (gender =='1' || gender =='2' )
			birth = "19".concat(id.substring(0,2));
		else
			birth = "20".concat(id.substring(0,2));
		return birth;
	}
	
	public static String gendercheck(String id) {
		char gender = id.charAt(7);
		if((gender-'0') %2==0) return "여성";
		return "남성";
	}
	
	
	
	public static boolean isvalid(String id) {
	
		if(id.charAt(6) != '-') return false;
		
		char gender = id.charAt(7);
		if (gender>='1' && gender <='4') return true;
		
		return false;
	}
	
	public static boolean isNumeric(String id) {
		
		for (int i=0;i<id.length();++i) {
			char ch = id.charAt(i);
			if(!(ch>='0' && ch <= '9')) {
				return false;
			}
		}return true;
	}
	
}

