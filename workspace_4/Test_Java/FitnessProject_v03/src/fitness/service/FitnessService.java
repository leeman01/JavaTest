package fitness.service;

import java.util.List;

import fitness.VO.Fitness;

public interface FitnessService {
	public boolean insert(Fitness fitness);
	public Fitness selectOne(int id);
	public boolean update(Fitness fitness);
	public boolean delete(int id);
	public List<Fitness> selectAll();
	public int getCount(); // 동건.getcount() == 2
}
