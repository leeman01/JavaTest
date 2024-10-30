package friend;
// 1. 멤버변수 /필드 가 첫번째 2. 생성자  3. Setter ,getter  4. 일반 메소드 순서로 코딩 
public class FriendVO {

	private String name;
	private String phone;
	private int age;
//	this.name = "김갑돌";
//	this.phone="010-0000-0000";
//	this.age = 75 ;
	
	// 생성자
	
	public FriendVO() {
		super();
	}
//	오버로딩 생성장
	public FriendVO(String name, String phone, int age) {
		
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	// 기본 생성자는 무조건 써야한다
//	public FriendVO() {}
	
//	
//	public FriendVO(String name,String phone, int age) {
//		this.name = name;
//		this.phone = phone;
//		this.age = age;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void output() {
		System.out.printf("이름: %3s%n  전화번호: %15s%n 나이: %3d%n",name,phone,age);
	}
	
}

