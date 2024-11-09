package vo;

public class PhoneBook {
	private String phoneNumber;
	private String name;
	private String relation; 
	private int age;
	// 생성자만들기
	public PhoneBook() {
		super();
	}
	public PhoneBook(String phoneNumber, String name, String relation, int age) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.relation = relation;
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer(50);
		buf.append("phoneNumber=").append(phoneNumber).append("name= ").append(name)
		.append(", relation = ").append(relation).append("age = " ).append(age);
	
		return buf.toString();
	}
}
