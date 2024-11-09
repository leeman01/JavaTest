package com.kdigital.spring6.dto;

import java.time.LocalDate;

import com.kdigital.spring6.entity.FriendEntity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor // 기본생성자
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
// toString 이 없으면 이름: [[${friend.username}]] 이부분에서 주소가 출력된다
// Entity를 받아서 DTO반환 (조회할때)
public class Friend {
	private Integer fseq;
	// 이름입력 : 2~10 길이로 제어
	@Size(min=2, max=10,message="이름은 2글자~10글자 이내로 입력해주세요")
	private String fname;
	// 나이는 15세 이상만 가입 가능하도록
	@Min(value=15,message="나이는 15세 이상 입력해 주세요")
	private Integer age ;
	// 정규표현식 
	@Pattern(regexp="01[016789]\\d{4}\\d{4}",message="- 표시없이 숫자로만 입력해주세요")
	private String phone ;
	// 미래날짜는 입력하지 못하도록 제어
	@PastOrPresent(message="과거의 날짜를 선택해 주세요") 
	private LocalDate birthday;
	private boolean active ;
	public static Friend toDTO(FriendEntity friendentity) {
		return Friend.builder()
				.fseq(friendentity.getFseq())
				.fname(friendentity.getFname())
				.age(friendentity.getAge())
				.birthday(friendentity.getBirthday())
				.phone(friendentity.getPhone())
				.active(friendentity.isActive())
				.build();
	}
	
}