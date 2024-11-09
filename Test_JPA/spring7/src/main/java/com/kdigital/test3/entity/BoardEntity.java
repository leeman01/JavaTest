package com.kdigital.test3.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.kdigital.test3.dto.BoardDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
@Table(name="board")
public class BoardEntity {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="board_num")	
		private Long boardNum;
		@Column(name="board_writer", nullable=false)
		private String boardWriter;
		@Column(name="board_title")
		private String boardTitle;
		@Column(name="board_content")
		private String boardContent;
		@Column(name="hit_count")
		private int hitCount;
		@Column(name="create_date")
		@CreationTimestamp // 게시글이 처음 생성될 때 자동으로 날짜 세팅
		private LocalDateTime createDate;
		@Column(name="update_date")
		@UpdateTimestamp        //@LastModifiedDate				 
		private LocalDateTime updateDate ;
		// DTO를 받아서 Entity로 반환
		
		// 첨부파일이 있을 경우 
		@Column(name="original_file_name")
		private String OriginalFileName;
		@Column(name="saved_file_name")
		private String SavedFileName;
		// 참고(양방향 관계가 설정되어있을때 사용하는 방법)
		/*
		 * one에 해당하는 테이블 entity에 설정함
		 * mappedBy : 양방향 참조를 할경우 one에 해당하는 테이블 엔티티 값
		 * CascadeType.REMOVE : DB에서 테이블 생성할 때 on delete cascade 옵션과 동일
		 * fetch = FetchType.LAZY(지연호출)   FetchType.LAZY(즉시 호출)
		 * orphanRemoval : 1:N 일때 지정하는 옵션
		 * 자식엔터티에 변경이 일어나면 JPA(insert->update->delete 순으로 진행)
		 * 	PK(JoinColumn)의 ㄱ밧이 Null이 되는 자식을 고아객체라 하는데 , 고아객체는 연결점을 잃는다
		 * orphanRemoval을 true로 설정라면 고아객체가 삭제된다
		 * (게시판은 양방향 관계가 아니므로 아래 코드는 불필요하다)
		 */
//		@OneToMany(
//				mappedBy="boardEntity",
//				cascade = CascadeType.REMOVE,    // 부모를 지우면 자식들이 모두 삭제되는 걸 세팅함
//				fetch = FetchType.LAZY,
//				orphanRemoval = true
//				
//				)
//		@OrderBy("reply_num asc")
//		private List<ReplyEntity> replyEntity = new ArrayList<>();
		
		// 댓글개수 처리 쿼리문을 이용해 처리
		@Formula("(SELECT count(1) FROM reply r WHERE board_num =r.board_num)")
		private int replyCount;
		
		
		public static BoardEntity toEntity(BoardDTO boardDTO) {
			return BoardEntity.builder()
					.boardNum(boardDTO.getBoardNum())
					.boardWriter(boardDTO.getBoardWriter())
					.boardContent(boardDTO.getBoardContent())
					.boardTitle(boardDTO.getBoardTitle())
					.hitCount(boardDTO.getHitCount())
					.OriginalFileName(boardDTO.getOriginalFileName())
					.SavedFileName(boardDTO.getSavedFileName())
//					.createDate(boardDTO.getCreateDate()) // 자동생성되는 아래의 2개의 날짜는 굳이 들어갈 필요가 있나? => 없다
//					.updateDate(boardDTO.getUpdateDate()) // 즉 이 두개는 데이터베이스에서 자동생성 =>사용자가 입력x 안한걸 세팅한다는 건 모순
					.build();
								
		}

	

}
