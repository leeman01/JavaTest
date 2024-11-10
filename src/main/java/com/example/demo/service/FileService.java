package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aspose.words.Document;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.repository.CargoInfoRepository;
import com.example.demo.repository.ExportingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {
	public static String saveFile(XWPFDocument document, String filePath)  {
	    // 현재 날짜와 시간을 포맷팅하여 파일 이름에 포함
	    LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
	    String formattedDateTime = now.format(formatter);
	    String fileName = "견적의뢰서_" + formattedDateTime + ".docx"; // 파일 이름 형식 지정

	    // 파일 저장 경로 확인 및 생성
	    File path = new File(filePath);
	    if (!path.isDirectory()) {
	        path.mkdirs(); // 경로가 없으면 생성
	    }

	    // 랜덤 UUID를 생성해 고유 파일 이름 만들기
	    String uuid = UUID.randomUUID().toString();
	    String ext = ".docx"; // 기본적으로 Word 파일 확장자
	    String savedFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "_" + uuid + ext;

	    // 파일 경로와 파일 이름을 결합해 최종 저장 경로 설정
	    File serverFile = new File(filePath + "/" + savedFileName);

	    // 문서를 해당 경로에 저장
	    try (FileOutputStream fos = new FileOutputStream(serverFile)) {
	        document.write(fos);
	        return filePath + "/" + savedFileName;
	    } catch (IOException e) {
	        log.error("Error while generating invoice: ", e);
	        
	    }
		return savedFileName;

	    // 최종 저장된 파일 이름 반환
	  
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



