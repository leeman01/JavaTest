package com.kdigital.test3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kdigital.test3.controller.ReplyController;
import com.kdigital.test3.dto.ReplyDTO;
import com.kdigital.test3.entity.BoardEntity;
import com.kdigital.test3.entity.ReplyEntity;
import com.kdigital.test3.repository.BoardRepository;
import com.kdigital.test3.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyService {
	final BoardRepository boardRepository;
	final ReplyRepository replyRepository;
	
	public ReplyDTO replyInsert(ReplyDTO replyDTO) {
		// 부모의 게시글이 존재하는 여부 확인
		
		Optional<BoardEntity> boardEntity = boardRepository.findById(replyDTO.getBoardNum());
		if(boardEntity.isPresent()) {
			BoardEntity entity = boardEntity.get(); //부모글을 꺼
			ReplyEntity replyEntity =ReplyEntity.toEntity(replyDTO,entity);
			ReplyEntity temp = replyRepository.save(replyEntity);
			return ReplyDTO.ToDTO(temp,replyDTO.getBoardNum());
		}
		return null;
		
	}

	public List<ReplyDTO> replyAll(Long boardNum) {
		Optional <BoardEntity> boardEntity =boardRepository.findById(boardNum);
		
		List <ReplyEntity> replyEntityList = replyRepository.findAllByBoardEntityOrderByReplyNumDesc(boardEntity);
		// entity를 dto로 전부 변환
		List<ReplyDTO> replyDTOList = new ArrayList<>();
		replyEntityList.forEach((item)->replyDTOList.add(ReplyDTO.ToDTO(item, boardNum)));
		
		return replyDTOList;
	}
	/**
	 * 댓글삭제
	 * @param replynum: 삭제하려는 댓글번호
	 * @return
	 */
	public boolean replyDelete(Long replynum) {
		// TODO Auto-generated method stub
		replyRepository.deleteById(replynum);
		// 삭제후에 댓긓의 존재여부확인
		
		return replyRepository.existsById(replynum);
	}

}
