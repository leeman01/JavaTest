수정버튼을 누르면

pk 값을 컨트롤러에 전달

service에 전달받은 pk를 이용해 데이터를 조회

조회된 데이터는 controller로 반환

사용자가 정보를 직접수정


## 8월 26일 추가
-- VALIDATION
	
	
1) 자바스크립트 검증기능 넣기
2) spring에서 제공하는 validation 기능
	-DTO에 validation 관련 annotation을 추가해서 사용	
	
	(1) depeendency 추가해야함 => 리프레시 한번 해야 함
	(2) GET 방식으로 화면을 요청할 때 빈데이터를 생성해서 넘겨줘야함
	 --> 입력하는 용도 + Validation 해서 결과를 받는 용도
	(3) DTO에 검증 기능을 추가( ex ) @Size등을 이용)
	(4) 입력하는 html에 메시지를 출력할 수 있도록 th:error 값을 갖는 태그 추가
	(5) POST로 데이터를 받는 부분에서 @Valid , BindingResult를 추가
	
	


