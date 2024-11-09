package fitnessManager;
/*
 * 이름, 키,몸무게,성별 // name height weight gender 
 * 표준체중 ,bmi , bmi결과
 */
public class FitnessVO {
	 private String name;
	 private double height;
	 private double weight;
	 private String gender;
	 
	 public void setName(String name){
		 this.name=name;
	 }
	public void setHeight(double height) {
		this.height = height;
		
	}
	public void setWeight(double weight) {
		 this.weight = weight;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
		 
	public String getName() {
		return this.name;
	}
	public double getHeight() {
		return this.height;
		
	}
	public double getWeight() {
		return this.weight;
	}
	public String getGender() {
		return this.gender;
	}
}

