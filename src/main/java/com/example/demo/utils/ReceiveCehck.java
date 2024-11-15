package com.example.demo.utils;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import org.springframework.stereotype.Service;
import jakarta.mail.Address;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.Part;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.search.AndTerm;
import jakarta.mail.search.ComparisonTerm;
import jakarta.mail.search.FromStringTerm;
import jakarta.mail.search.ReceivedDateTerm;
import jakarta.mail.search.SearchTerm;
import jakarta.mail.search.SubjectTerm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReceiveCehck {
    private String saveDirectory;
    private String host = "imap.gmail.com";
    private String userName="leerexman01@gmail.com";
	private String password ="lumm srte xkut ajum";

    public void setSaveDirectory(String dir) {
        this.saveDirectory = dir;
    }

 // receiveMailAttachedFile 메서드 매개변수에 exportId 추가
    public String receiveMailAttachedFile(String userName, String password, Date startDate, Date endDate, Long exportId) {
     System.out.println("프로그램작동");
     Properties props = System.getProperties();
     props.setProperty("mail.store.protocol", "imaps");

     try {
         Session session = Session.getDefaultInstance(props, null);
         Store store = session.getStore("imaps");
         store.connect("imap.gmail.com", userName, password);

         Folder inbox = store.getFolder("INBOX");
         inbox.open(Folder.READ_ONLY);

         // 기간 필터
         SearchTerm olderThan = new ReceivedDateTerm(ComparisonTerm.GE, startDate);
         SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.LE, endDate);
         SearchTerm dateTerm = new AndTerm(olderThan, newerThan);

         // 송신자 필터
         SearchTerm senderTerm = new FromStringTerm("leeman01@naver.com");

         // exportId 필터 (제목에 포함된 경우)
         SearchTerm subjectTerm = new SubjectTerm(String.valueOf(exportId));

         // 모든 조건을 결합
         SearchTerm combinedTerm = new AndTerm(new AndTerm(dateTerm, senderTerm), subjectTerm);

         Message[] arrayMessages = inbox.search(combinedTerm);
         for (int i = arrayMessages.length; i > 0; i--) {
             Message msg = arrayMessages[i - 1];
             Address[] fromAddress = msg.getFrom();
             String from = fromAddress[0].toString();
             String subject = msg.getSubject();
             String sentDate = msg.getSentDate().toString();
             String receivedDate = msg.getReceivedDate().toString();
             String contentType = msg.getContentType();
             String messageContent = "";
             String attachFiles = "";

             if (contentType.contains("multipart")) {
                 Multipart multiPart = (Multipart) msg.getContent();
                 int numberOfParts = multiPart.getCount();
                 for (int partCount = 0; partCount < numberOfParts; partCount++) {
                     MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                     if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                         String fileName = part.getFileName();
                         attachFiles += fileName + ", ";
                         part.saveFile(saveDirectory + File.separator + fileName);
                     } else {
                         messageContent = part.getContent().toString();
                     }
                 }
                 if (attachFiles.length() > 1) {
                     attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                 }
             } else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
                 Object content = msg.getContent();
                 if (content != null) {
                     messageContent = content.toString();
                 }
             }

             System.out.println("Message #" + (i + 1) + ":");
             System.out.println("\t From: " + from);
             System.out.println("\t Subject: " + subject);
             System.out.println("\t Received: " + sentDate);
             System.out.println("\t Message: " + messageContent);
             System.out.println("\t Attachments: " + attachFiles);
             return attachFiles;
         }

         inbox.close(false);
         store.close();

     } catch (Exception e) {
         e.printStackTrace();
     }
	return null;
    }
 }

