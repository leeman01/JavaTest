package Io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 FileInputStream fis = null;
	      FileOutputStream fos = null;

	      try {
	         byte[] buffer = new byte[1000];
	         int count = 0;
	         
	         fis = new FileInputStream("supernova.txt");
	         fos = new FileOutputStream("supernova_copy.txt");
	         
	         while (true) {
	            count = fis.read(buffer); // count : 몇개를 한꺼번에 읽었는지 확인
	            if(count == -1) break;
	            
	            if(count == buffer.length) {
	               fos.write(buffer);
		            for(int i=0; i<count; ++i)
		            	System.out.print((char)buffer[i]);
	            }
		                  
	            else if(count<buffer.length) {
	               for(int i=0; i<count; ++i) {
//	                  fos.write(buffer[i]);
//	            	   System.out.print(buffer[i]);
	            	   System.out.print((char)buffer[i]);
	               }
	            }
	         }
	         System.out.println("복사 완료!");
	      } catch(IOException e) { // Exception - io - FileNoFound
	            System.out.println(e.getMessage());
	      } finally {
	            try {
	               if(fis!=null) fis.close();
	               if(fos!=null) fos.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	      }
	      System.out.println("\n끝!!!");
	      


	}

}
