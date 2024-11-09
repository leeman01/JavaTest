package construct;

public class MemberDefaultString {
    String name; // 여기서 아무런 기본 생성자가 없으면 기본생성자가 붙는다
    MemberDefaultString(){ // 기본생성자 작성
        System.out.println("생성자 호출");
    }
}
