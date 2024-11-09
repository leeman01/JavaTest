package com.kdigital.diary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kdigital.diary.dto.UserDTO;
import com.kdigital.diary.entity.UserEntity;
import com.kdigital.diary.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	final UserRepository repository;
	
	public void insert(UserDTO userDTO) {
		// TODO Auto-generated method stub
		repository.save(UserEntity.toEntity(userDTO)); // 저장함
	}

	public List<UserDTO> retreiveAll() {
		// TODO Auto-generated method stub
		List<UserEntity> list = repository.findAll(Sort.by(Sort.Direction.DESC,"diarySeq"));
		log.info("{}",list);
		
		List <UserDTO> list1 = new ArrayList<>();
		list.forEach(auth -> list1.add(UserDTO.toUserDTO(auth)));
		log.info("{}",list1);
		return list1;
	}

	public void delete(int diaryseq1) {
		// TODO Auto-generated method stub
		repository.deleteById(diaryseq1);
	}


}
