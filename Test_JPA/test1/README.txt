8월 20일

[문제-1]

1) test1 프로젝트 생성
2) 프로그램이 구동되면 첫 화면에서 x y 값을 정수로 입력받는다
3) equals 버튼을 만들어서 이 버튼을 누르면 x,y값을 서버로 전송한다 서버쪽에서는 입력받은
데이터를(정수)를 더하여 그 더해진 값을 반환한다

* 생성할 파일 : 
-maincontroller : 프로그램이 처음으로 구동되엇을 때 index.html로 포워딩하는 파일
- calculatorcontroller : index.html에서 Get 방식으로 전달한 변수값 x,y를 더한 후 그 결과를
다시  index.html로ㅜ 반환하여 출력

클라이언트 측 생성파일 
- index.html

만약 데이터가 전달되지 않으면 x y 값은 1