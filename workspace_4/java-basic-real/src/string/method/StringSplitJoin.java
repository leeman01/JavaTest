package string.method;

public class StringSplitJoin {
    public static void main(String[] args) {
        String str = "사과 , 오렌지, 바나나";
        String [] split = str.split(",");
        for(String s:split){
            System.out.println(s);
        }
        String joinStr = "";
        for(String string:split){
            joinStr += string + "-";
        }
        System.out.println("joinStr= "+ joinStr);
        // join
        String joinedStr = String.join("-","A","B","C");
        System.out.println("joinedStr= "+ joinedStr);

        // 문자열 배열 연결
        String strResult = String.join("-",split);
        System.out.println("strResult= "+ strResult);
    }
}
