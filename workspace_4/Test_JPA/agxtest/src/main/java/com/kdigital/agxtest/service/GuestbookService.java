package com.kdigital.agxtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kdigital.agxtest.dto.GuestbookDTO;
import com.kdigital.agxtest.entity.GuestbookEntity;
import com.kdigital.agxtest.repository.GuestbookRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class GuestbookService {
	final GuestbookRepository repository;
	/**
	 * 방명록의 모든 글을 조회
	 * @return
	 */
	public List<GuestbookDTO> selectAll() {
		List<GuestbookDTO> list = new ArrayList<>();
		List<GuestbookEntity> guestEntity = repository.findAll();
		// entity를 dto로 바꾸는 작업
		guestEntity.forEach((item)->list.add(GuestbookDTO.toDTO(item)));
		
		return list;
	}
	/**
	 * 전달받은 dto를 DB에 저장
	 * @param dto
	 */
	public void inputGuestbook(GuestbookDTO dto) {
		GuestbookEntity entity = GuestbookEntity.toEntity(dto);
		repository.save(entity);
		
	}
	/**
	 * 전체 방명록을 전부 조회하는 코드
	 * @return
	 */
	public List<GuestbookDTO> retreieveAll() {
		// TODO Auto-generated method stub
		List <GuestbookEntity> entity = repository.findAll(Sort.by(Sort.Direction.DESC,"seq"));
		List <GuestbookDTO> list = new ArrayList<>();
		entity.forEach((item)->list.add(GuestbookDTO.toDTO(item)));
		return list;
	}
	/**
	 * DB에서 글 삭제
	 * @param seq
	 * @param pwd
	 */
	@Transactional
	public void deleteGuestbook(Long seq, String pwd) {
		repository.deleteBySeqAndPwd(seq,pwd);
		
	}

}
