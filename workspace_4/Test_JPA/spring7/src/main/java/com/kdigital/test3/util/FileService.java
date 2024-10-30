package com.kdigital.test3.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

// MultiPart파일을 받아서 savedFileName을 만드는 작업
public class FileService {
	// 1. 서버에 디렉토리가 없으면 디렉토리 생성
	
	// 2. 전달받은 업로드 파일에서 원본파일명을 꺼내서  저장용 파일명 생성(랜덤값 생성)
	
	// 3. 1번과 2번을 이용해서 실제 디렉토리에 파일을 저장하는 작업
	
	// 4. 저장파일명을 DB에 저장할 수 있도록 함
	// @value 는 applicationproperty에 저장된 값을 사용할 수 있도록 함
	public static String saveFile(MultipartFile uploadFile,String uploadPath) {
		
		// 파일이 첨부되면 디렉토리가 있는지 확인하는 작업
		// 디렉토리가 없으면 생성 , 있으면 그대로 사용
		if(!uploadFile.isEmpty()) {
			File  path = new File(uploadPath);
			if(!path.isDirectory())
				path.mkdirs(); // 실제 디렉토리 만드는 메소드
		}
		
		// 원본파일명 추출
		String originalFileName = uploadFile.getOriginalFilename(); // 이력서.hwp
		
		// 저장될 파일에 부가될 랜덤값
		String uuid =UUID.randomUUID().toString(); // 숫자가 아닌 문자열이겟지?
		// 이력서 hwp를 분리하는 작업  =>  이력서_uuid
		String filename;
		String ext ;
		String SavedFileName;
		// 가장 마지막에있는 . 이 파일명과 확장명을 분리한다고 볼수 있다
		
		// .의 위치
		int position = originalFileName.lastIndexOf('.');
		
		// 확장자가 없는경우: -1값임
		if(position==-1) 
			ext="";
		//확장자가 있는 경우
		else 
			ext = '.'+originalFileName.substring(position+1); // 확장자 출력 jpg
		// 파일명 추출
		filename = originalFileName.substring(0,position);
		
		// SavedFileName
		SavedFileName = filename +"_" + uuid + ext;
		// 서버공간에 파일 저장하기
		File serverFile =null;
		serverFile = new File(uploadPath+"/"+SavedFileName);
		
		try {
			uploadFile.transferTo(serverFile);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			SavedFileName=null ; // 파일을 저장하는 도중 오류가 발생하면 DB에 파일명도 저장되면 안됨
			e.printStackTrace();
		}
		return SavedFileName ;
		
	}
	// 서버공간에 저장된 파일을 삭제(경로 + SaveFileName)
	public static boolean deleteFiles(String fullPath) {
		boolean result =false;
		
		File delFile = new File(fullPath);
		
		if(delFile.isFile())
			result =delFile.delete();
		
		
		
		
		return result;
	}
}
