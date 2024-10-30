package construct;

public class MethodMain3 {
    public static void main(String[] args) {
        // 초기값을 설정하는 부분이 반복된다

        MemberInit member1 = new MemberInit(); // ??? 생성자가 없는데 생성자를 호출햇다?????

        member1.initMember("user1",215,1100);

        MemberInit member2 = new MemberInit();

        member2.initMember("user2",25,100);

    }

}
