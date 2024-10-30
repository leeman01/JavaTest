package mycollect;
import java.util.ArrayList;
import java.util.List;

import vo.Emp;

public class ArrayListTest_02 {

	public static void main(String[] args) {
		List <Emp> list = new ArrayList<>();
		
		// 1) 직원을 저장
		list.add(new Emp(1,"이몽룡",2500,"기획부"));
		list.add(new Emp(2,"변사또",3400,"전산실"));
		list.add(new Emp(3,"성춘향",2700,"영업부"));
		list.add(new Emp(4,"김방자",3000,"고객응대팀"));
			
		// 2) 직원수 출력하기 
		
		// 3) 전체데이터 조회
		list.forEach((item)->System.out.println(item));
		
		// 4) 사원번호 3번인 직원을 조회
		for(int i=0; i<list.size();++i) {
			Emp emp =list.get(i);
			if (emp.getEmpno() ==3) { // integer 는 객체이므로 3인 기본자료형과 비교가 불가능할거같지만 언박싱이 이를 가능하게함
				System.out.println(emp);
				break;
			}
		}
		// 4) 김방자라는 사람이 있는지 조회
//		boolean result = list.contains("김방자");  // 이건 오류이다 절대 못찾는다
		// Emp 클래스 내부에 equals() 메소드가 Overriding 되어 있어야 비교 가능
		boolean result = list.contains(new Emp(4,"김방자",3000,"고객응대팀")); // 데이터는 동일하지만  new를 사용함으로 주소가 달라져 false값이 나옴
	}

}
