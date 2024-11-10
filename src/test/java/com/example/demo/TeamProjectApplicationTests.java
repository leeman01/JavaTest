package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.AccountCompanyEntity;
import com.example.demo.entity.AuthUserEntity;
import com.example.demo.entity.ExportingCargoEntity;
import com.example.demo.entity.ExportingExportEntity;
import com.example.demo.repository.AccountCompanyRepository;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.repository.CargoInfoRepository;
import com.example.demo.repository.ExportingRepository;

@SpringBootTest
class TeamProjectApplicationTests {
	@Autowired
	AuthUserRepository userRep;
	@Autowired
	ExportingRepository exportRep;
	@Autowired
    CargoInfoRepository cargoRep;
	@Autowired
	AccountCompanyRepository comRep;

	@Test
	void contextLoads() {
	}
	@Test
	void realTest() {
		AuthUserEntity user1=new AuthUserEntity();
		userRep.save(user1);
		AccountCompanyEntity com = new AccountCompanyEntity();
		com.setUserId(user1);
		comRep.save(com);
		// 유저정보저장
		
		for(int i=0;i<50;++i) {
			ExportingExportEntity export = new ExportingExportEntity();
			export.setBuyerCompanyAddress(Integer.toString(i));
			export.setBuyerCompanyName(Integer.toBinaryString(i));
			export.setUserId(user1);
			export.setProcess(2);
			exportRep.save(export);
			ExportingCargoEntity cargo=new ExportingCargoEntity();
			cargo.setHeight(i);
			cargo.setLength(i);
			cargo.setExportId(export);
			cargoRep.save(cargo);
		}
		
	}

}
