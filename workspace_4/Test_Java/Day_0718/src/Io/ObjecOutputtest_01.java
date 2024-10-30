package Io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjecOutputtest_01 {
// 저장하려는 객체는 반드시 시리얼번호 입력이 중요하다
	public static void main(String[] args) {
		// 파일로 저장하려는 데이터는 Serial 상태로 변환되어있어야한다
		// TODO Auto-generated method stub
		FriendVO f = new FriendVO("손오공","010-1234-5678",25);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("friend.dat"));
			oos.writeObject(f);
			System.out.println("저장완료");;
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null) oos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
