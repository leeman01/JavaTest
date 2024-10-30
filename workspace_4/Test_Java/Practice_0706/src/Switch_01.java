
public class Switch_01 {

	public static void main(String[] args) {
		String yoil = "월";
		
		switch (yoil) {
		case "월","화","수" -> System.out.println("요가");
		case "목","금","토" -> System.out.println("수영");
		default -> System.out.println("달리기");
		}

	}

}
