package vo;
// 이름 차번호 전화번호 예약위치
public class CarRent {
	private String name;
	private String carnum;
	private String phone;
	private String location ;
	
	// 생성자
		public CarRent() { }
	
	public CarRent(String name,String carnum,String phone,String location) {
	
	this.name = name;
	this.carnum = carnum;
	this.phone = phone;
	this.location = location;
}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void output() {
		System.out.println("차번호: "+ carnum +"이름: "+ name+"전화번호: "+phone + " 예약 위치: " + location);
				
	}

}
