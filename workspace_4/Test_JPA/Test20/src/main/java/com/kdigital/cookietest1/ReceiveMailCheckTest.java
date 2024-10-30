package com.kdigital.cookietest1;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.mail.MessagingException;

public class ReceiveMailCheckTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String userName="leerexman01@gmail.com";
		String password ="lumm srte xkut ajum";
		Date endDate = Date.valueOf(LocalDate.now());
	    Date startDate= Date.valueOf(LocalDate.of(2024, 9, 25));
	    ReceiveCehck a= new ReceiveCehck();
	    a.setSaveDirectory("C:\\Users\\user\\Desktop\\비밀의방");
	    a.receiveMailAttachedFile(userName, password, startDate, endDate,(long) 1);
	}

}
