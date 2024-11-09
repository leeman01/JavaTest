package service;

import vo.PhoneBook;

public interface PhoneBookService {
	public boolean insert(PhoneBook book);
	public PhoneBook selectOne(String phoneNumber);
	public boolean update(PhoneBook book);
	public boolean delete(PhoneBook book);
	public PhoneBook[] SelectAll();
}
