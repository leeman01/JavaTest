package construct;

public class MethodMain2 {
    public static void main(String[] args) {
        // 초기값을 설정하는 부분이 반복된다

        MemberInit member1 = new MemberInit();

        initMember(member1,"user1",215,1100);

        MemberInit member2 = new MemberInit();

        initMember(member2,"user2",25,100);

    }
    static  void initMember(MemberInit member,String name,int age,int grade){
        member.name = name;
        member.age = age;
        member.grade = grade ;
        System.out.println(member.age + "," +member.name +"," + member.grade );
    }
}
