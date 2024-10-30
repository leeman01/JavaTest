package fitness.service;

import fitness.VO.Fitness;

public interface FitnessService {
	public boolean insert(Fitness fitness);
	public Fitness selectOne(int id);
	public boolean update(Fitness fitness);
	public boolean delete(int id);
	public Fitness[] selectAll();
	public int getCount();
}
