package Io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStream_03 {
	public static void main(String[] args) {
		FileOutputStream fos =null;
		
		try {
			fos = new FileOutputStream("./src/target.txt"); //자동생성
			for(int i='a';i<='z';++i )
				try {
					fos.write(i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("기록완료");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fos!= null) fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
