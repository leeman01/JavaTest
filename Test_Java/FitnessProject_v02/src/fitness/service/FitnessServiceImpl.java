package fitness.service; // 현재클래스가 패키지안에 포함되어있는지 정보
import fitness.VO.Fitness; // 사용하려는 클래스가 다른 패키지에 있을 때
public class FitnessServiceImpl implements FitnessService {
// 객체배열을 가지고있어야함
	Fitness [] list = new Fitness[5];
	int count=0;
	/*
	 * 전달받은 회원을 리스트에 저장
	 * @ param fitness
	 * @ return 등록성공시 true, 아니면 false 반환
	 */
	public boolean insert(Fitness fitness) {
		
		if (count==list.length) { // 받을 수 있는 회원수 초과
			return false;
		}
		list[count++] = fitness; // 0번방에 고객정보 입력후 그 다음에 count 에 1을 후순위로 더하기
		// count++;
		return true;
	/**
	 * 전달받은 id값에 해당하는 회원이 있는지 찾아서 반환 
	 * @ param id
	 * @ return 찾으면 회원정보 , 못찾으면 null을 반환
	 */
	}
	public Fitness selectOne(int id){
		for(int i=0; i<count ;++i) {
			if( list[i].getId() == id) return list[i];
		}
		return null;
	}
	//id , weight,height 전달받아서 
	/*
	 * 전달받은 회원 정보(fitness)에서 id에 해당하는 회원을 검색해서
	 * weight,height 를 수정
	 * 수정이 완료되면 true 회원 id가 없어서 수정을 못한 경우 false
	 */
	public boolean update(Fitness fitness) { //fitness는 단순한 변수명이고 Fitness는 타입이다
		double w = fitness.getWeight(); // 수정할 키와 몸무게를 꺼낸것
		double h = fitness.getHeight();
//		int id = fitness.getId();
		for(int i=0 ; i<count;++i) {
			if ( fitness.getId() == list[i].getId()) { // 탈퇴하려는 회원정보를 찾음
				list[i].setWeight(w);
				list[i].setHeight(h);
				return true;
			}
		}
		return false;
	}
	/**
	 * 전달받은 id ㅇ[ 헤당하는 회원의 정보를 찾아서 배열내에서 삭제
	 * @param id
	 * @return 삭제가 완료되면 true, 회원 id가 없어서 삭제를 못한경우 false
	 */
	public boolean delete(int id) {
		for(int i=0 ; i<count;++i) {
			if (list[i].getId()==id) {
				for(int j=i ; j <count-1;++j) { //뒤의 데이터를 앞으로 가져오기
					list[j] = list[i];
				}
				-- count;
				return true;
			}
		}
		return false;
	}
	/**
	 * 모든 회원의 정보를 조회
	 * @return
	 */
	public Fitness[] selectAll() {
		return list;
	}
	/**
	 * 총 회원수를 반환
	 * @return
	 */
	public int getCount() {
		return count;
	}
}
