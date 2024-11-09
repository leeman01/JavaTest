
public class StaticData {
	// 인스턴스 변수는 객체를 포인팅하는 참조변수가 없어지면 GC에 의해서 소멸된다
	 String title = "Hisory of island";  //인스턴스(멤버) 변수이다: 자신의 클래스가 생성되면 탄생한다 (Heap 영역)
	 int page; // 멤버변수는 this라는 키워드를 붙일수잇다
	
	static int CODE =12; // 위치상으로는 멤버변수이라 보지만 static이 붙어서 클래스 변수라고 부른다 // 프로그램이 구동되면 생성 => 프로그램이 종료되면 사라짐
	
	public void setPage(int page) {
		
		this.page = page;
	}
	public void process(int page) {
		int maxPage = 500; // 지역변수 (Stack이라는 메모리 공간에 저장된다) - 메소드를 호출하면 탄생
		{
			int inner = 150;
			maxPage+=10;
			System.out.println("inner ="+inner);
		}// 지역종료 -> 메모리에서 삭제됨
		
	}
	public void calc() {
		this.title = "2024년 7월 어느날";
		this.page = 1500;
		CODE=7; // static이붙어서 this 사용 x // 하나의 변수를 여러객체에서 공유하면서 사용할때
		StaticData.CODE =7;
	}
		
	
//	inner += 1 ; 이 경우 지역변수라서 벗어나는 순간 없어진다
}
	