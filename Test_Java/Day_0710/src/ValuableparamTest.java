class Pearson{
	public void output(int ...ary) { // ary는 배열을 의미한다
		for (int i=0 ; i<ary.length;++i) {
			System.out.println(ary[i]);
		}
		System.out.println("===End===");
	}
	
}
public class ValuableparamTest { // 파일이름과 동일한 클래스에만 public을 붙임

	public static void main(String[] args) {
		Pearson p = new Pearson();
		p.output();
		p.output(1);
		p.output(1,2);
		p.output(1,2,3,4);  // 전달인자 개수가 다르거나 타입이 다르면 오버로딩을 진행
	}

}
