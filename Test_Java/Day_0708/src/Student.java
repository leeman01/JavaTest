/*
 * 단순하게 값을 저장하기위한 용도로 만들어진 클래스, 관련있는 값을 저장하기 위한 용도로 만들어진 클래스
 * VO(Value Object)
 * 접근지정가(acess): private,public,(default),protected
 * 속성에 값을 대입하기 위해 접근하는 메소드 :setter
 * 속성에 값을 꺼내기 위해 접근하는 메소드 : getter
 * =========================================
 * 메소드는 선언한 후 사용(Call)
 * 사용하겟다 --> 호출
 * 사용후에는 반드시 호출했던 쪽으로 되돌아감
 * 반환활때 반환할 데이터가 없으면 void
 * 접근지정자 [특정키워드] 반환타입 func(파라미터) {
 * 	// 실행문
 * 		[return] [변수,값,식]
 */
public class Student {
	private String name; // 메인 메소드 밖에서 선언 => 멤버변수라고 한다 / instance 변수 ,멤버변수는 각각 따로 쓴다
	private int kor; // private로 접근을 막음 국어 영어 수학 점수는 입력받는 그대로 씀
	private int eng;
	private int mat;
	private double avg; // 계산해서 나오는 값
	// 세터 설정하기
	public void setName(String name) {//이때의 n을 지역변수라 한다
		this.name = name; // name 은 멤버변수이다
	} // 블럭 안에서는 지역변수가 우선순위를 가짐
	public void setKor(int kor) { //국어
		this.kor=kor;
	}

	public void setEng(int eng) { //영어
		this.eng=eng;
	}
	
	public void setMat(int mat) { //수학
		this.mat=mat;
	}
	public void setAvg(double avg) { //수학
		this.avg=avg;
	}
	public String getName() {
		return this.name;
	}
	
	public int getKor() {
		return this.kor;
	}
	public int getEng() {
		return this.eng;
	}
	public int getMat() {
		return this.mat;
	}
	public double getAvg() {
		return this.avg;
	}
	// 일반 메소드
	public void output() { // 같은 클래스안에 들어와서 동일한 멤버변수가 됨 멤버변수끼리는 setter,getter 적용하지 않음 this 생략해도된다
		System.out.printf("%3s %3d %3d %3d %.2f%n",this.name,kor,eng,mat,avg);
	}
}	
