package construct;

public class MemberInit {
    String name;
    int age;
    int grade ;
    // this : 자기 자신의 인스턴스 가르킴
     void initMember(String name,int age,int grade){
        this.name = name;
        this.age = age;
        this.grade = grade ;
        System.out.println(this.age + "," +this.name +"," + this.grade );
    }
}
