package com.kdigital.test3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kdigital.test3.dto.FitnessDto;
import com.kdigital.test3.entity.FitnessEntity;
import com.kdigital.test3.repository.FitnessRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class FitnessService {

	final FitnessRepository repository ;
	/**
	 * DB에 데이터를 저장하기위한 메소드
	 * @param friend
	 */
	public void insert(FitnessDto fitness) {
		
		// DTO를 Entity로 변환
		FitnessEntity fitnessEntity = FitnessEntity.toEntity(fitness) ;
		repository.save(fitnessEntity);
		
	}
	/**
	 * DB에서 Friend 목록을 조회
	 * @return
	 */
	public List<FitnessDto> list() {
		// TODO Auto-generated method stub
		List<FitnessDto> list = new ArrayList<>();
		List<FitnessEntity> entityList = repository.findAll();
		// entity들을 dto로 반환한다~~! 
		entityList.forEach((entity)->list.add(FitnessDto.toDTO(entity)));
		
		log.info("{}",list.get(0).toString());
		
		return list ;
	}
	public  void deleteOne(Integer seq) {
		repository.deleteById(seq);	
	}
	public FitnessDto SelectOne(Integer seq) {
		// TODO Auto-generated method stub
		log.info("수정할 번호==>{}",seq);
		// null 로 인한 오류로 인해 FriendENtity를 반홚라지않고 
		// Optional 이라는 Wrapper 클래스로 감싸서 반환한다
		Optional<FitnessEntity> entity = repository.findById(seq) ; // 저장된 모든 데이터 조회
		if (entity.isPresent()) {
			FitnessEntity fitness = entity.get();
			return FitnessDto.toDTO(fitness);
		}
		return null;
	}
	@Transactional
	public void updateOne(FitnessDto fitness) {
		log.info("updateOne=============>{}",fitness.toString());
		
		// 1) PK를 이용해서 그데이터가 있는지 조회한다 => findbyid를 이용해서 받는다
		// 2) 조회된 데이터에서 수정할 정보를 setting 한다
		Optional<FitnessEntity> entity= repository.findById(fitness.getSeq());
		if (entity.isPresent()) {
			FitnessEntity fitnessEntity = entity.get(); // 바뀌기전 데이터
			// 나이 전화번호 성함
			fitnessEntity.setHeight(fitness.getHeight());
			fitnessEntity.setWeight(fitness.getWeight());
			fitnessEntity.setBmi(fitness.getBmi());
			fitnessEntity.setBmiResult(fitness.getBmiResult());
			fitnessEntity.setStdWeight(fitness.getStdWeight());
			
		}
			
		
	}
	

}
