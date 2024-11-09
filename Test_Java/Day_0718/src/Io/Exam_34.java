package Io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam_34 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
	    FileOutputStream fos = null;
	    BufferedInputStream bis =null;
		BufferedOutputStream bos = null;
	    byte[] buffer = new byte[1000];
	    int count = 0;
	    try {
	    	
	         bis = new BufferedInputStream(new FileInputStream("dog.jpg"));
	         bos = new BufferedOutputStream(new FileOutputStream("dog_copy.jpg"));;
			
			while (true){
				 count =bis.read(buffer);
		         if (count==-1) break;
		         if (count<buffer.length) {
		        	 for(int i=0;i<count;++i) {
		        		 bos.write(buffer[i]);
		        	 }
		        	 break;
		         }
		         bos.write(buffer);
			}
			System.out.println("복사완료!");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 System.out.println(e.getMessage());
	      } finally {
	            try {
	               if(bis!=null) fis.close();
	               if(bos!=null) fos.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	      }
	      System.out.println("\n끝!!!");
	      


	}

}
