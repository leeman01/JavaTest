package class1;

public class ClassStart2 {
    public static void main(String[] args) {
        String[] studentNames = {"학생1","학생2","학생3","학생4"};
        int[] ages = {15,16,89,90};
        int [] grade = {90,80,99,100};

        for(int i=0;i<ages.length;++i){
            System.out.println("이름:" + studentNames[i] + ages[i] + grade[i]);


        }

    }
}
