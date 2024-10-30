package construct;

public class ConstructMain1 {
    public static void main(String[] args) {
        // 객체를 생성함과 동시에 멤버변수 초기화  <= 생성자로 한번에 처리한다
        MemberConstruct member1 = new MemberConstruct("user1",45,100);
        MemberConstruct member2 = new MemberConstruct("user2",15,130);
        MemberConstruct[] members = {member1,member2};
        for(MemberConstruct s : members){
            System.out.println(s.name+" " +s.grade + " " +s.age);
        }
    }
}
