package com.kdigital.score.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdigital.score.dto.ScoreDTO;
import com.kdigital.score.entity.ScoreEntity;
import com.kdigital.score.repository.ScoreRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class ScoreService {
	private final ScoreRepository repository;
	private int num=0; // 여기서는 학생들의 번호를 전달한다  // 이거 굳이 필요없겟다
	public int insert(ScoreDTO scoreDTO) {
	
		// 정보저장완료
		repository.save(ScoreEntity.toEntity(scoreDTO));
		num++;
		return num ; // 저장이완료되면 번호 1개반환
		// 정보가 저장되는 것 확인
	}
	
	public List<ScoreDTO> retreveAll() {
		// TODO Auto-generated method stub
		// 정보 모조리 반환하기
		List<ScoreEntity> list = repository.findAll();
	
		// dto로반환
		List<ScoreDTO> real = new ArrayList<>();
		list.forEach((auth)->real.add(ScoreDTO.toDTO(auth))); // 정보 전달완료
		log.info("real 저장된 정보 DTO : {}",real);
		return real;
	}
	public void delete(String diarySeq1) {
		// TODO Auto-generated method stub
		repository.deleteById(diarySeq1);
		
	}

}
