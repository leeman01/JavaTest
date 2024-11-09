/* ------------------
    문자열 관련 메소드
    문자열의 특징 : sequence 데이터이면서 imutable한 타입
    1) charAt(index) , at(index) :전달된 인덱스 위치의 문자 1개 반환
    2) startsWith(str) , endsWith(str) , include(str) , search(str)
    3) replace(m,n) : 문자열 m을 찾아 n 으로 수정
    4) slice(index1,index2) : index1 ~ index2-1 의 인덱스 까지 부분문자열 반환
    5) substring() : 부분 문자열을 반환 , substr()은  ES5이후에 사용을 권장하지않음

*/

let data = `abcdefg`;
// charAt() ,at()
console.log(data.charAt(3));
console.log(data.at(3));


// search()  startswith endswith

data = `Hello. world! Wecome to the javaScroipt! `;
console.log(data.startsWith(`Hello`)); // boolean 으롭 반환
console.log(data.endsWith('~'));

console.log(data.includes('world')); // boolean으로 반환
console.log(data.search(`world`)); // 찾는 글자의 인덱스 값으로 반환
console.log(data.search(`wworld`)); // 찾는 글자 없으면 -1 반환

// replace(m,n) ;
let text = data.replace(`Hello`, `Hi`); // 원본값에영향을 못줌
console.log('원본' + data);
console.log('비교: ' + text);

//  slice(m,n) ;
console.log(data.slice(5, 10)); // wor 반환???

console.log(data.slice(-5, -1)); // -1은 가장 마지막 데이터

// slice 사용 주의 사항 (앞 < 뒤) 이어야함
console.log(data.slice(10, 5))
console.log(data.slice(-1, -5));

// substring(m,n) : 부분문자열 추출 , 음수사용불가

console.log(data.substring(5, 10));
console.log(data.substring(10, 5)); // 인덱스 앞 뒤 상관없다

//  split(str) : 문자열의 토큰화 , 반환타입은 배열
let arr = data.split(' ');
console.log(typeof arr);
console.log(arr.length);
// trim() 문자열 앞 뒤의 공백문자를 제거
data = `   Hello ~~~     `
console.log(data);
console.log(data.trim());








