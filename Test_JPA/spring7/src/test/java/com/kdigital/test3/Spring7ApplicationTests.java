package com.kdigital.test3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kdigital.test3.entity.BoardEntity;
import com.kdigital.test3.repository.BoardRepository;

@SpringBootTest
class Spring7ApplicationTests {
	@Autowired
	private BoardRepository repository;
	// 게시글 여러개를 삽입하는 테스트 코드
	@Test
	void contextLoads() {
	}
	@Test
	void testInsertBoard() {
		String[] w = {"이몽룡","성춘향","김방자","전우치","콩쥐","팥쥐"};
		String[] c = {"나리나리 개나리 입에따다 물고요","송아지 송아지 우리 송아지","파란하늘 파란하늘 꿈이","학교 종이 땡땡떙",
				"동해물과 백두산이 마르고","이기상과 이맘으로 충성을 다함","식사는 없어 배고파도 음료도 없어","가을하늘 공활한데 높고 구름없이",
				"날씨가 매우 좋군요 이제 가을인가보오","가을이 다가오니 기분이 몹시 설렌다 나는 취직이 가능한가?"};
		for(int i=1;i<135;++i) {
			int index =(int) (Math.random()* w.length);
			String writer = w[index];
			
			index =(int) (Math.random()* c.length);
			String content = c[index];
			String title ="제목: " + content;
			
			BoardEntity entity = new BoardEntity();
			
			entity.setBoardWriter(writer);
			entity.setBoardTitle(title);
			entity.setBoardContent(content);
			
			repository.save(entity);
		}
	}

}
