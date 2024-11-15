package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ExportingExportDto;
import com.example.demo.entity.AuthUserEntity;
import com.example.demo.entity.ExportingExportEntity;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.repository.CargoInfoRepository;
import com.example.demo.repository.ExportingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CargoTrackingService {
	private final AuthUserRepository userRep;
	private final ExportingRepository exportRep;
	/**
	 * 여기서는 프로세스가 2인 화물만 화물트래킹이 가능하게 만들어애한다
	 * @return
	 */
	
	public List<ExportingExportDto> cargoTracking() {
		Optional<AuthUserEntity> user = userRep.findById("leeman");
		AuthUserEntity userEntity = user.get();
		List<ExportingExportEntity> exportList = exportRep.findByuserId(user); // 
		List<ExportingExportDto> dtoList = new ArrayList<>();
		exportList.forEach(entity -> {
		    if (entity.getProcess() == 2) {
		        dtoList.add(ExportingExportDto.ToDto(entity, "leeman")); // 필요한 값을 DTO로 변환하여 추가할 수도 있음
		    }
		});
		return dtoList;
	}

}
