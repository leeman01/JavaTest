package class1;

public class ClassStart3 {
    public static void main(String[] args) {
        Student student1;
        student1 = new Student();
        student1.name = "학생1"; // 클래스에서는 .을 통해 접근이 가능
        student1.age=15;
        student1.grade=90;

        Student student2 = new Student(); // Student 클래스를 가지고(설계도) 만들어진 객체(인스턴스)이다
        student2.name="학생2";
        student2.age=16;
        student2.grade = 88;

        System.out.println("이름" + student1.name + student1.age + student1.grade);

        System.out.println("이름" + student2.name + student2.age + student2.grade);

        System.out.println(student2);// 참조값 주소
    }
}
