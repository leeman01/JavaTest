package month7;

import java.util.Arrays;
import java.util.Collections;

public class Num_23 {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }
    // 틀림 => 스트링 빌더와 Array에 대해서 좀더 공부필요
    public static String solution(String s) {
        // Convert the string to a character array
        char[] charArray = s.toCharArray();
       Arrays.sort(charArray);

       return new StringBuilder(new String(charArray)).reverse().toString();
    }
}
