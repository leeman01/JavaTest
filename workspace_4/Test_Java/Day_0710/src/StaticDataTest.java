
public class StaticDataTest {

	public static void main(String[] args) {
		System.out.println("static 변수: "+StaticData.CODE);
		StaticData data= new StaticData();
		System.out.println("멤버변수: "+data.title);
		data.process(55);
	}
}
