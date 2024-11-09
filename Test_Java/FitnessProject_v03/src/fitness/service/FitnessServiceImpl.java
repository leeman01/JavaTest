package fitness.service; // 현재클래스가 패키지안에 포함되어있는지 정보
import java.util.ArrayList;
import java.util.List;

import fitness.VO.Fitness; // 사용하려는 클래스가 다른 패키지에 있을 때
public class FitnessServiceImpl implements FitnessService {
// 객체배열을 가지고있어야함
	 List<Fitness> list = new ArrayList<>();

	
	 public boolean insert(Fitness fitness) {
		return list.add(fitness);
	}
	
	
	public Fitness selectOne(int id){
		for(int i=0; i<list.size() ;++i) {
			if( list.get(i).getId() == id) return list.get(i);
		}
		return null;
	}

	public boolean update(Fitness fitness) { 
		double w = fitness.getWeight(); 
		double h = fitness.getHeight();
		for(int i=0 ; i<list.size();++i) {
			if ( fitness.getId() == list.get(i).getId()) {
				list.get(i).setWeight(w);
				list.get(i).setHeight(h);
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(int id) {
		for(int i=0 ; i<list.size();++i) {
			if (list.get(i).getId()==id) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * 모든 회원의 정보를 조회
	 * @return
	 */
	public List<Fitness>  selectAll() {
		return list;
	}
	/**
	 * 총 회원수를 반환
	 * @return
	 */
	public int getCount() {
		return list.size();
	}
}
