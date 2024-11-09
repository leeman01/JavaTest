package com.kdigital.spring4.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor // 기본생성자
@Setter
@Getter
@ToString
// toString 이 없으면 이름: [[${friend.username}]] 이부분에서 주소가 출력된다
public class Friend {
	private Integer fseq ;
	private String username;
	private Integer age ;
	private String phone ;
	private LocalDate birthday;
	private boolean active ;
}
