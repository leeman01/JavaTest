package chicken;

public class ChickenTest {

	public static void main(String[] args) {
		Chicken chicken = new FriedChicken();
		chicken.cook();
		
		Chicken chicken2 = new SeasonedChicken();
		chicken2.cook();


	}

}
