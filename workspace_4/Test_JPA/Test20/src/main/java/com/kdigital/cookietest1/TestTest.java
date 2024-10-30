package com.kdigital.cookietest1;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.ParagraphFormat;
import com.aspose.words.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service

 class TestTest {
	// Document 및 DocumentBuilder 객체 생성
	public void realService() {
		Document doc=null;
		
		try {
			 doc = new Document();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    DocumentBuilder builder = new DocumentBuilder(doc);
	    
	    // 현재 ParagraphFormat을 중앙 정렬로 설정
	    ParagraphFormat format = builder.getParagraphFormat();
	    format.setAlignment(com.aspose.words.ParagraphAlignment.CENTER); // 중앙 정렬 설정

	    // 중앙 정렬된 텍스트 추가
	    builder.writeln("<선박 견적의뢰서>");

	    // 다시 기본 정렬로 설정 (예: 좌측 정렬)
	    format.setAlignment(com.aspose.words.ParagraphAlignment.LEFT); // 좌측 정렬로 변경
	    builder.insertParagraph(); // 빈 문단 추가
	    format.setAlignment(com.aspose.words.ParagraphAlignment.RIGHT);
	    builder.writeln("작성일: ");
	    builder.writeln("의뢰회사: ");
	    builder.writeln("작성자: ");
	    format.setAlignment(com.aspose.words.ParagraphAlignment.CENTER);
	    builder.insertParagraph();
	    List<String> a = new ArrayList<>();
	    a.add("선적지");
	    a.add("양하지");
	    a.add("품목");
	    a.add("출고예정일");
	    a.add("중량");
	    a.add("Incoterms");
	    a.add("컨테이너유형");
	    a.add("수량");
	    a.add("물품가액(화폐필수)");
	    a.add("HS Code");
	    a.add("견적의뢰서 내용");
	    // 테이블 생성
	    Table table = builder.startTable();

	    // 테이블에 데이터 추가 (3행, 3열)
	    for (int rowIndex = 0; rowIndex < a.size(); rowIndex++) {
	        for (int colIndex = 0; colIndex < 2; colIndex++) {
	            if(colIndex==0) {
	            	builder.insertCell();
	                builder.write(a.get(rowIndex));
	            }
	              
	           else {
	            	builder.insertCell();
	                builder.write("내용"+rowIndex);
	            }
//	        
	        }
	        builder.endRow();
	    }

	    builder.endTable();

	    // 파일로 저장
	    try {
	        doc.save("C:\\Users\\user\\Desktop\\비밀의방\\견적의뢰서.docx");
	        System.out.println("견적의뢰서 초안이 정상 저장되었습니다.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	


}
