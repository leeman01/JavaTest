package com.kdigital.test3.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.kdigital.test3.dto.ReplyDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name="reply")
public class ReplyEntity {
	@Id
	@Column(name="reply_num")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long replyNum;
	/**
	 * Board = Reply의 관계 ==> 1대 다
	 * 댓글이 다의 위치 , boardNum은 join 컬럼
	 */
	// boardentity를 필요할 때 요청 => 요청이 오면 그때 객체 생성(이래서 반응이 느리다)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="board_num")
	private BoardEntity boardEntity;
	@Column(name="reply_writer")
	private String replyWriter;
	@Column(name="reply_text")
	private String replyText;
	@Column(name="create_date")
	@CreationTimestamp
	private LocalDate createdate;
	
	//dto를 받아서 entity로 반환
	public static ReplyEntity toEntity(ReplyDTO dto,BoardEntity boardEntity) {
		return ReplyEntity.builder()
				.replyNum(dto.getReplyNum())
				.replyWriter(dto.getReplyWriter())
				.replyText(dto.getReplyText())
				.createdate(dto.getCreatedate())
				.boardEntity(boardEntity)
				.build();
	}
	
	
}
