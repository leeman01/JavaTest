프로젝트 주제

피트니스 관리

1) Controller 
maintcontroller.java
fitnessController

2) FitnessDTO => fseq 이름 키 몸무게 성별(라디오버튼 0,1) joindate(가입날짜)// 소수 weight height
// stdweight 표준체중 bmi bmiResult 

3) FitnessEntity  =>fseq 이름 키 몸무게 성별(라디오버튼 0,1) joindate// 소수 weight height // 계산되는건데 데이터 베이스에
저장되어야하나?

joindate는 초기에 저장되면 수정되지 x

4) FitnessService.java 

==> crud   // insertmember , selectmember(한명의 정보조회) , deletemember(한명의 정보삭제) , updatemember()

selectAll

5) Repoistort ==jparepository 상속

==> FitnessRepository 

6) index.html
insertMember.html
listMember.html
updateMember.html

7) DB설계


