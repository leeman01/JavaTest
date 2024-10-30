package ref;

public class Method2 {
    public static void main(String[] args) {
        Student student1 = createStudent("학생1",45,13);
        student(student1);

//        student1.namae = "학생1";
//        student1.age = 98;
//        student1.grade = 15;


        Student student2 = createStudent("학생2",455,153);
        student(student2);
//        student2.namae = "학생1";
//        student2.age = 98;
//        student2.grade = 15;
    }
    static Student createStudent(String name, int age, int grade){
        Student student = new Student();
        student.namae = name ;
        student.age=age;
        student.grade = grade;
        return  student ;
    }
    static void student(Student student){
        System.out.println("이름 :" + student.namae + student.grade + student.age);
    }
}
