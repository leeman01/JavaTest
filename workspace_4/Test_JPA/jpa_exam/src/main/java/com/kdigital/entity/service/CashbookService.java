package com.kdigital.entity.service;

import java.util.List;

import com.kdigital.exam.entity.CashBook;

public interface CashbookService {
	public boolean insert(CashBook cashbook);
	public boolean delete(int id);
	public List<CashBook> selectData(String date);
	public List<CashBook> statistics(String date);
	
	public List<CashBook> selectAll();

}
