package ref;

public class Method1 {
    public static void main(String[] args) {
        Student student1 = new Student();
        initStudent(student1,"학생1",45,13);
//        student1.namae = "학생1";
//        student1.age = 98;
//        student1.grade = 15;

        Student student2 = new Student();
        initStudent(student2,"학생2",55,53);
//        student2.namae = "학생1";
//        student2.age = 98;
//        student2.grade = 15;

        student(student1);
        student(student2);
    }
    static void student(Student student){
        System.out.println("이름 :" + student.namae + student.grade + student.age);
    }
    static void initStudent(Student student ,String name, int age, int grade){
        student.namae = name;
        student.grade = grade;
        student.age = age;
    }
}
