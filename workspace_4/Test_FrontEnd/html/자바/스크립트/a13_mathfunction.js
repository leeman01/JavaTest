// Date , Math  , Number  클래스: 숫자를 다루는 클래스
// 1) 문자열을 숫자로 변환
console.log(`===========Number()`)
let data = "2.25";
let temp = Number(data);
console.log(typeof data); // 문자
console.log(typeof temp); // 숫자가됨

let data2 = "2.5a7";
temp = Number(data2);
console.log(temp); // nan값이 나옴

// 2) 문자열을 숫자로 변환하는 다른 메소드
console.log(parseInt(data2));
console.log(parseFloat(data2));
console.log(parseInt(data2));

// 3) 자바스크립트의 최대 , 최소값을 확인
console.log(`Float형 최댓값: ${Number.MAX_VALUE}`)
console.log(`Float형 최소값: ${Number.MIN_VALUE}`)






















