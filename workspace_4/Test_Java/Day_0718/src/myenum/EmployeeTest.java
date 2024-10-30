package myenum;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee [] emp = Employee.values();
		for(Employee e : emp)
			System.out.println(e+"-"+e.title+ ":" + e.work());
	}

}
