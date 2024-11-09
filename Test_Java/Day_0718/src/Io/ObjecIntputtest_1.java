package Io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjecIntputtest_1 {
// 저장하려는 객체는 반드시 시리얼번호 입력이 중요하다
	public static void main(String[] args) {
		// 파일로 저장하려는 데이터는 Serial 상태로 변환되어있어야한다
		// TODO Auto-generated method stub
//		FriendVO f = new FriendVO("손오공","010-1234-5678",25);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("friend.dat"));
			try {
				FriendVO f =(FriendVO)ois.readObject();
				f.output();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("저장완료");;
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois!=null) ois.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
