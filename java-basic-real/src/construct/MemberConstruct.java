package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;
    MemberConstruct(String name,int age,int grade){
//        System.out.println("생성자 호출:" +name + "," + age + "," + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;

    }
    // 새로 오버로딩한 생성자
    // 지금 this 가 중복된다
    MemberConstruct(String name,int age){
//        System.out.println(""); this가 맨위에 없으면 컴파일 오류!
        this(name,age,50);  // 이런식으로 객체 불러와서 중복을 방지할수잇다
//        this.name = name;
//        this.age=age;
//        this.grade = 50;
    }
}
