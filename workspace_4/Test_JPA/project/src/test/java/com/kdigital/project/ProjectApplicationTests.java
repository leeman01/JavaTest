package com.kdigital.project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kdigital.project.Entity.AuthUserEntity;
import com.kdigital.project.Entity.ExportingExportEntity;
import com.kdigital.project.Entity.ManagingDocumentCertificateoriginEntity;
import com.kdigital.project.Entity.ManagingDocumentInvoiceEntity;
import com.kdigital.project.Entity.ManagingDocumentParentEntity;
import com.kdigital.project.Entity.OfEntity;
import com.kdigital.project.Entity.ScfiEntity;
import com.kdigital.project.repository.BookingShipmentPredictionScfiRepository;
import com.kdigital.project.repository.BookingShipmentPriceOfRepository;
import com.kdigital.project.repository.CoRepository;
import com.kdigital.project.repository.ExportRepository;
import com.kdigital.project.repository.ManagingDocumentInvoiceRepository;
import com.kdigital.project.repository.ManagingDocumentRepository;
import com.kdigital.project.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import service.UserService;

@SpringBootTest

class ProjectApplicationTests {
	@Autowired
	private UserRepository rep;
	@Autowired
	private BookingShipmentPredictionScfiRepository scfi;
	@Autowired
	private BookingShipmentPriceOfRepository of;
	@Autowired
	private ManagingDocumentInvoiceRepository invoice;
	@Autowired
	private ManagingDocumentRepository document;
	@Autowired
	private ExportRepository export;
	@Autowired
	private CoRepository cor;
	@Test
	void contextLoads() {
	}
	@Test
	void testInsertBoard() {
		AuthUserEntity a = new AuthUserEntity();
		a.setPassword("1");
		a.setIsSuperuser(0);
		a.setUsername("d64654684");
		a.setFirstName("a78eq8");
		a.setLastName("d64684477");
		a.setEmail("12q54@eqa99j7");
		a.setIsStaff(0);
		a.setIsActive(0);
		a.setDateJoined(LocalDateTime.now()); // 유저정보 삽입완료
		rep.save(a);
		System.out.println("유저정보 등록완료");
//		OfEntity b= new OfEntity();
//		ScfiEntity c = new ScfiEntity();
		ManagingDocumentParentEntity aa = new ManagingDocumentParentEntity();
//		ManagingDocumentInvoiceEntity bb =new ManagingDocumentInvoiceEntity();
		ManagingDocumentCertificateoriginEntity co = new ManagingDocumentCertificateoriginEntity();
		ExportingExportEntity cc = new ExportingExportEntity();
		System.out.println("수출 삽입 진행");
		cc.setBuyerCompanyName("123");
		cc.setBuyerCompanyAddress("123");
		cc.setBuyerCompanyTel("123");
		cc.setBuyerCountry("123");
		cc.setBuyerEmail("123");
		cc.setIncoterm("123");
		cc.setPaymentMethod("123");
		cc.setPlaceOfLoading("123");
		cc.setPlaceOfUnloading("123");
		cc.setContractDate(LocalDateTime.now());
		cc.setDeadlineDate(LocalDateTime.now());
		cc.setRegisteredDatetime(LocalDateTime.now());
		cc.setProcess(0);
		cc.setUserId(a);
		export.save(cc);
		System.out.println("작동중");
		aa.setIssueDate(LocalDate.now());
		aa.setIsPaid(0);
		aa.setExportId(cc);
		document.save(aa);
		co.setCertificateOriginNumber("123456");
		co.setEntity(aa);
		cor.save(co);
//		c.setScfiWeekl1(0);
//		c.setScfiWeekl2(1);
//		c.setScfiWeekl3(0);8
//		c.setScfiWeekl4(0);
//		scfi.save(c);
//		b.setLoadingPort("1");
//		b.setDisChargePort("1");
//		b.setOfWeek1(1);
//		b.setOfWeek2(2);
//		b.setOfWeek3(3);
//		b.setOfWeek4(4);
//		b.setScfiEntity(c);
//		of.save(b);
		System.out.println("작동완료");
	}

}
