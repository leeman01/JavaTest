/*
    반복문 / 제어문
    1) 반복문 : while do-while for 문
        - for문은 3종류
        -continue , break 
    2) 제어문 : if ,switch-case문

*/
// 1) 첫번째 for문
let ary = [1, 2, 3, 4, 5];
for (let i = 0; i < ary.length; ++i) {
    console.log(ary[i])
}
// 2) 두번째 for문
console.log('==================================for~in 반복문: 변수에는 인덱스가 추출됨');
for (let j in ary) {
    console.log(ary[j])
}

// 3) 세번째 for문
console.log('==================================for~of 반복문: 변수에 값이 추출됨');
let cities = ['서울', '도쿄', '뉴욕', '상하이'];
for (let city of cities) {
    console.log(city)
}
// 연습문제 1~50까지 반복 3, 5의 배수만 출력
for (let i = 1; i <= 50; ++i) {
    if (i % 3 == 0 || i % 5 == 0) {
        console.log(i)
    }
}

// 나누기 연산식 주의
let x = "10";
let result = 10 / x;
console.log(`문자열 10을 산술연산한 결과:${result}`);

let y = "10!";
let result2 = 10 / y; // Nan (not a number)연산을 못함
console.log(`문자열 10!을 산술연산한 결과:${result2}`);

// 0 이 입력되면 , 아무것도 입력하지않으면?
// alert ("경고문구")- 경고문구가 출력되고 확인 버튼
// 확인 : 입력한 값이 변수로 대입 취소 : null값이 변수에대입
//confirm("문구") - 문구가 출력되고 "확인" 버튼 , "취소"
// prompt() , prompt("메시지")
let z = prompt("숫자를 입력");
console.log(isNaN(z)); // 문자가 포함되어있으면 ,true

if (isNaN(z))
    console.log("연산불가");
else {
    let result3 = 10 / z;
    console.log(`문자열 ${z}을 산술연산한 결과:${result3}`);
}

let cf = confirm("처리를 진행할까요"); //  true , false로 결과 반환
console.log(cf);
