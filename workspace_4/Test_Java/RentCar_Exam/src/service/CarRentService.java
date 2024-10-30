package service;


import vo.CarRent;

public class CarRentService {
	CarRent [] list = new CarRent[100];
	int count=0;
	public boolean insert(CarRent carrent) {
		
		if (count==list.length) { // 받을 수 있는 회원수 초과
			System.out.println("여기서문제발생");
			return false;
			
		}
		list[count++] = carrent; // 0번방에 고객정보 입력후 그 다음에 count 에 1을 후순위로 더하기
		// count++;
		return true;

	}
	public CarRent selectOne(String phone){
		for(int i=0; i<count ;++i) {
			if( list[i].getPhone().equals(phone)) return list[i];
		}
		return null;
		
	}
	public CarRent[] selectAll() {
		return list;
	}
	public int getCount() {
		return count;
	}
}