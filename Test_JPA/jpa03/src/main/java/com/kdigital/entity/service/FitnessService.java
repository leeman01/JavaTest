package com.kdigital.entity.service;

import java.util.List;

import com.kdigital.entity.Fitness;


public interface FitnessService {
	public boolean insert(Fitness fitness);
	public Fitness selectOne(int id);
	public boolean update(Fitness fitness);
	public boolean delete(int id);
	public List<Fitness> selectAll();

}
