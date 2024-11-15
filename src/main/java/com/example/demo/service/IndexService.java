package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.OfDto;
import com.example.demo.entity.OfEntity;
import com.example.demo.repository.OfRepository;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
// 여기서는 인덱스와 마이페이지를 처리할거다
@Service
@RequiredArgsConstructor
@Slf4j

public class IndexService {
	private final OfRepository rep;
	
	public OfDto findOfEntity(int loading,String unloading) {
		OfEntity entitiy = rep.findByLoadingPortAndUnloadingPort(loading,unloading);
		return OfDto.ToDto(entitiy);
	}
}
