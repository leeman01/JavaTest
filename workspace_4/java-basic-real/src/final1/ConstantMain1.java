package final1;

public class ConstantMain1
{
    public static void main(String[] args) {
        System.out.println("프르그램 최대참여자수: " +Constatnt.MAX_USERS);
        int currentUser=999;
        process(currentUser++);
        process(currentUser++);
        process(currentUser++);
        process(currentUser++);

    }
    // 상수값이 그냥 숫자 1000이라고 하는 것보다 변수명을 MAX_USER라고 만들면 문맥상 이해하는데 도움을 준다
    private static void process(int currentUserCount){
        System.out.println("참여자수 : " + currentUserCount);
        if(currentUserCount>Constatnt.MAX_USERS){
            System.out.println("대기자로 등록합니다");
        }else{
            System.out.println("게임에 참가합니다");
        }
    }
}
