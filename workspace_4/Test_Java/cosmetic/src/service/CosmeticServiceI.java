package service;

import vo.Foundation;

import vo.Lipstick;
import vo.Product;

public interface CosmeticServiceI {
	
	public boolean insert(Product product); 
	public boolean update(Product product);
	public boolean delete(String productno); // 여기서 입력받는 것은 texture,또는 type color이다
	public Product selectOne(String Productno);
	public Product [] SelectAll();
	public int getCount();

}
