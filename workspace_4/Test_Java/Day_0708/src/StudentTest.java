
public class StudentTest {

	public static void main(String[] args) {
		// student는 사용자가 만든 새로운 타입의 데이터
		// 반드시 생성해야 사용할 수 있다\
		Student s1 = new Student(); //생성한 내용
		// s1.name = "홍길동";
		s1.setName("홍길동");
		s1.setKor(90);
		s1.setEng(80) ;
		s1.setMat(77) ;
		s1.setAvg((s1.getKor()+s1.getMat()+s1.getEng())/3.0);
		s1.output();
//		s1.avg = (s1.kor+s1.mat+s1.eng)/3.0 ;
//		System.out.printf("%5s %3d %3d %3d %.2f%n",s1.getName(),s1.getKor(),s1.getMat(),s1.getEng(),s1.getAvg());
		
		Student s2 = new Student();
		s2.setName("임꺽정");
		s2.setKor(90);
		s2.setEng(85);
		s2.setMat(64);
		s2.setAvg((s2.getKor()+s2.getMat()+s2.getEng())/3.0);
		s2.output();
//		s2.name ="임꺽정";
//		s2.kor=88;
//		s2.eng=85;
//		s2.mat=64;
//		s2.avg=(s2.kor+s2.eng+s2.mat)/3.0;
//		System.out.printf("%5s %3d %3d %3d %.2f%n",s2.getName(),s2.getKor(),s2.getMat(),s2.getEng(),s2.getAvg());
		
	}

}
