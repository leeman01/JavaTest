/*
 * [문제] 구구단 2단에서 9단까지 모두 출력
 */
public class Exam_23 {

    public static void main(String[] args) {

        // 첫 번째 그룹 (2단부터 5단까지)
        for (int i = 1; i <= 9; ++i) {
            for (int dan = 2; dan <= 5; ++dan) {  // 여기에서 ++i를 ++dan으로 수정
                System.out.printf("%d X %d = %2d\t", dan, i, (dan * i));
            }
            System.out.println();
        }
        System.out.println();

        // 두 번째 그룹 (6단부터 9단까지)
        for (int i = 1; i <= 9; ++i) {
            for (int dan = 6; dan <= 9; ++dan) {  // 여기에서 ++i를 ++dan으로 수정하고, 조건식도 수정
                System.out.printf("%d X %d = %2d\t", dan, i, (dan * i));
            }
            System.out.println();
        }
        System.out.println();
    }
}

		


