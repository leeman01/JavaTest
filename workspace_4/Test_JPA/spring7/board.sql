USE dima;
DROP TABLE dima.board;
CREATE TABLE dima.board(
	board_num int AUTO_INCREMENT ,
	board_writer varchar(50) NOT NULL  ,
	baord_title varchar(200) DEFAULT 'untitled' ,
	board_content varchar(3000) ,
	hit_count int DEFAULT 0  ,                           -- 누구도 글을 조회하지 않은 경우
	create_date datetime DEFAULT current_timestamp ,
	update_date datetime DEFAULT current_timestamp
	, CONSTRAINT boardboard_num PRIMARY key(board_num)
) ;

COMMIT ;

-- 첨부파일이 있을 경우에 컬럼 추가
ALTER  TABLE dima.board ADD original_file_name varchar(500) ; -- 파일의 이름 저장
ALTER TABLE dima.board ADD saved_file_name varchar(500) ; -- 변형된 파일명 저장

-- 이력서.hwp (파일명.확장명)       =>  이름을 이력서_(난수로 발생되는 값).hwp  형식으로 설정하고자 함

-- 필요하지 않은 컬럼삭제시

ALTER TABLE dima.board DROP COLUMN original_fil_name ;
ALTER TABLE dima.board DROP COLUMN saved_file_name ;


SELECT * FROM dima.boarduser b ;

-- 3) 댓글 테이블 만들기(게시글과 1: 다 관계를 형성)
DROP TABLE dima.reply ;

CREATE TABLE dima.reply(
	reply_num int AUTO_INCREMENT ,
	board_num int ,
	reply_writer varchar(50) NOT NULL ,
	reply_text varchar(1000) NOT NULL ,
	create_date datetime DEFAULT current_timestamp,
		CONSTRAINT replyreply_num PRIMARY key(reply_num),
		CONSTRAINT replyboard_num FOREIGN KEY(board_num) REFERENCES dima.board(board_num) ON DELETE CASCADE 
);

SELECT * FROM dima.reply r ;