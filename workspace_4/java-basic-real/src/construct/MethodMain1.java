package construct;

public class MethodMain1 {
    public static void main(String[] args) {
        // 초기값을 설정하는 부분이 반복된다
        MemberInit member1 = new MemberInit();
        member1.name="user1";
        member1.age= 15;
        member1.grade = 90;

        MemberInit member2 = new MemberInit();
        member2.name="user2";
        member2.age= 25;
        member2.grade = 100;

        MemberInit[] members = {member1,member2};
        for(int i=0;i<members.length;++i){
            System.out.println(members[i].age + "," +members[i].name +"," + members[i].grade );
        }
    }
}
