package Io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRWCopy {
// Reader Writer 사용
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 FileReader fr = null;
	     FileWriter fw = null;

	      try {
	         char[] buffer = new char[1000];
	         int count = 0;
	         
	         fr = new FileReader("supernova.txt");
	         fw = new FileWriter("supernova_copy.txt");
	         
	         while (true) {
	        	count = fr.read(buffer);

	            if(count == -1) break;
	            
	            if(count == buffer.length) {
	            	fw.write(buffer);
	              
		            for(int i=0; i<count; ++i)
		            	System.out.print((char)buffer[i]);
	            }
		                  
	            else if(count<buffer.length) {
	               for(int i=0; i<count; ++i) {
	                  fw.write(buffer[i]);
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
	               if(fr!=null) fr.close();
	               if(fw!=null) fw.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	      }
	      System.out.println("\n끝!!!");
	      


	}

}
