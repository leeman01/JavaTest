package service;

import vo.PhoneBook;
	
public abstract class PhoneBookServiceImpl implements PhoneBookService{
	// 여기서 리스트를 만듦
	PhoneBook [] list = new PhoneBook[10];
	int cnt=0;
	
	@Override
	public boolean insert(PhoneBook book) {
		list[cnt++]=book;
		return true;
	}

	@Override  // 책 고르고 한권 뽑기
	public PhoneBook selectOne(String phoneNumber) {
		for (int i =0; i<cnt;++i) {
			String a= list[i].getPhoneNumber();
			if (a.equals(phoneNumber)) {
				return list[i] ;
			}
		}
		return null;
	}

	@Override
	public boolean delete(PhoneBook book) {
		for(int i=0 ; i<cnt;++i) {
			String a = book.getPhoneNumber();
			String b= list[i].getPhoneNumber();
			if (a.equals(b)) {
				for(int j=i ; j <cnt-1;++j) { //뒤의 데이터를 앞으로 가져오기
					list[j] = list[i];
				}
				-- cnt;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(PhoneBook book) {
		for(int i=0;i<cnt;++i) {
			String a = book.getPhoneNumber();
			String b= list[i].getPhoneNumber();
			if (a.equals(b)) return true;	
		}
		return false;
	}

	@Override
	public PhoneBook[] SelectAll() {
		// TODO Auto-generated method stub
		return list;
	}	

	}
