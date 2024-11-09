package com.kdigital.test3.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kdigital.test3.dto.UserDTO;
import com.kdigital.test3.entity.UserEntity;
import com.kdigital.test3.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	final UserRepository userRepository;
	final BCryptPasswordEncoder bCryptPasswordEncoder;
	/**
	 * 전달받은 userDTO를 userEntity로 변경한 후 DB save()
	 * @param userDTO
	 */

	public boolean join(UserDTO userDTO) {
		//가입하려는 id가 이미 사용중이면 쓸수는 없음
		boolean isExistUser = userRepository.existsById(userDTO.getUserId());
		if(isExistUser) return false; // 이미 사용중인 아이디이므로 가입 실패
		// 비밀번호 암호화
		userDTO.setUserPwd(bCryptPasswordEncoder.encode(userDTO.getUserPwd()));
		
		UserEntity userEntity = UserEntity.toEntity(userDTO) ;
		userRepository.save(userEntity); //가입 성공	
		return true;
		
	}
	public boolean existId(String userId) {
		// TODO Auto-generated method stub
		boolean result = userRepository.existsById(userId); // id가 존재하면  true 아이디가 없으면  false
		return result;
	}
	/**
	 * 개인정보 수정을 위해 아이디와 비밀번호 확인처리 요청
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	public UserDTO pwdCheck(String userId, String userPwd) {
		// 비밀번호 암호화(사용자가 입력한 비밀번호)
		String encodedPwd = bCryptPasswordEncoder.encode(userPwd);
		Optional<UserEntity> userEntity = userRepository.findById(userId);
		if(userEntity.isPresent()) {
			UserEntity temp = userEntity.get();
			String pwd = temp.getUserPwd(); // DB에 저장된 비밀번호
//			암호화되지않은 비밀번호 , DB에 저장된 번호
			boolean result = bCryptPasswordEncoder.matches(userPwd, pwd);
			if(result) 
				return UserDTO.toDTO(temp); // 수정하려는 정보 전달
			
		}
		return null;
	}
	/**
	 * 개인정보 수정
	 *  수정하려는 정보만 Set 해서 수정하면됨 ==> 수정하려는 정보가 굉장히 많다면?
	 *  JPA의 save()메소드 : 저장+ 수정도 가능
	 *  저장: 동일한 PK가 없으면 insert
	 *  수정: 동일한 PK가 있으면 update
	 * @param userDTO
	 * @return
	 */
	@Transactional
	public boolean update(UserDTO userDTO) {
		//Roles pwd  enabled 처리가 안도미
		String userId = userDTO.getUserId();
		boolean isExist = userRepository.existsById(userId);
		
		log.info("{}",isExist);
		
		Optional<UserEntity> userEntity = userRepository.findById(userId);
		if(userEntity.isPresent()) {
			UserEntity entity = userEntity.get();
			// 비밀번호 암호화하여 DB 정보 갱신
			entity.setUserPwd(bCryptPasswordEncoder.encode(userDTO.getUserPwd()));
			entity.setEmail(userDTO.getEmail());
			return true; //정보가 바뀜
//			userRepository.save(entity);
		}
		// 비밀번호 암호화
		return false;	// 정보가 안바뀜
	}
	

}
