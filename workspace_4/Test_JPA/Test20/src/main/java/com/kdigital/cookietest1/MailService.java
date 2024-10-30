package com.kdigital.cookietest1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.ParagraphFormat;
import com.aspose.words.Table;

import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j

public class MailService {
    private MailConfig a;
    private static final String FROM_ADDRESS = "leerexman01@naver.com";

  

    public void mailSend(MailDto mailDto) {
    	SimpleMailMessage message = new SimpleMailMessage();
    	JavaMailSender mailSender = a.javaMailService();
    	// 일단 이메일 보내는 내용으로 견적서 파일만들기
    	 Document doc = null;
 		try {
 			doc = new Document();
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
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
                     builder.write(mailDto.getMessage());
                 }
//             
             }
             builder.endRow();
         }

         builder.endTable();

         // 파일로 저장
         try {
             doc.save("C:\\Users\\user\\Desktop\\비밀의방\\메일견적의뢰서.docx");
             System.out.println("견적의뢰서 초안이 정상 저장되었습니다.");
         } catch (Exception e) {
             e.printStackTrace();
         }
         // 여기는 저장된 파일까지 다시 보내는 코드 시작입니다
        MimeMessage message1 = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message1, true); // true for multipart
            helper.setTo(mailDto.getAddress());
            helper.setFrom(MailService.FROM_ADDRESS);
            helper.setSubject(mailDto.getTitle());
            helper.setText(mailDto.getMessage());
           
            // 파일 첨부
            File file = new File("C:\\Users\\user\\Desktop\\비밀의방\\메일견적의뢰서.docx");
            if (file.exists()) {
                helper.addAttachment(file.getName(), file);
            } 

            log.info("정보는 다음과 같다 ==> {}", message);
            log.info("정보는 다음과 같다 ==> {}", message1);
            mailSender.send(message1);
        } catch (Exception e) {
            log.error("메일 전송 중 오류 발생: {}", e.getMessage());
        }
	   
    }
    public String returnVal() {
    	List<String> cookie = new ArrayList<>();
    	cookie.add("당신의 무역 운은 꽝입니다");
    	cookie.add("당신의 무역운을 좋을지도?");
    	cookie.add("무역이 천직입니다");
    	cookie.add("무역은 적성이 아닐지도?");
    	int a= (int) Math.floor(Math.random() * 4); 
    	return cookie.get(a);
    }
}