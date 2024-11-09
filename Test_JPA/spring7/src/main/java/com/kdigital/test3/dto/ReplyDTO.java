package com.kdigital.test3.dto;

import java.time.LocalDate;

import com.kdigital.test3.entity.ReplyEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ReplyDTO {
	private Long replyNum;
	private Long boardNum;
	private String replyWriter;
	private String replyText;
	private LocalDate createdate;
	// Entity를 받아서 DTO로 변환하는 코드
	public static ReplyDTO ToDTO(ReplyEntity entity,Long boardNum) {
		return ReplyDTO.builder()
				.replyNum(entity.getReplyNum())
				.replyWriter(entity.getReplyWriter())
				.replyText(entity.getReplyText())
				.boardNum(boardNum)
				.createdate(entity.getCreatedate())
				.build();
		
	}
}
