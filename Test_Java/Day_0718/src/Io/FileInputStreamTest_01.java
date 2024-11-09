package Io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest_01 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		File file = new File("song.txt");
		// 배열에 읽어들이는 방법
		try {
			fis = new FileInputStream(file);
			System.out.println("파일 오픈 성공");
			
			int count=0;
			byte [] data = new byte[50]; // 176 => 50 + 50 +50+ 26
			while (true) {
				count = fis.read(data); // 몇개를 읽었는지 체크
				if (count==-1) break;
				for (int i=0;i<count;++i)
					System.out.print((char)data[i]);
//				System.out.println("\n");
//				System.out.println("Count: " + count);
			}
			
		} catch (IOException e) {  // IOexcetopn 자식으로 fileexception이 있어서 2개의 예외가 처리가 가능하다
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
//		System.out.println("끝!!!");
		
	}

}
