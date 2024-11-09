/*
    Math 클래스는 수학이나 수치와 관련된 데이터를 처리하는 함수
    1) 값: PI(원주율) E(오일러상수)  Math.PI와 같은 방식으로 사용
    2) 함수
*/
// Math 클래스에 선언된 함수
console.log(`원주율: ${Math.PI}`);
console.log(`오일러 상수: ${Math.E}`);

// abs(m) : 절대값을 반환하는 함수
// false 값 : 0 ,  null , undefined , ''
// true값 : [] , 공백이있는 문자열 , 0을 제외한 숫자들
console.log(`-----------------------abs()---------------------------`);
console.log(Math.abs(-1)); // 1
console.log(Math.abs(`-1`)); // 1
console.log(Math.abs(null)); // null은 Object => 결과 0
console.log(Math.abs('')); //0
console.log(Math.abs(' ')); //0
console.log(Math.abs('korea')); // NaN
console.log(Math.abs()); // NaN
console.log(Math.abs([])); // 0
console.log(Math.abs([1, 2, 3])); // NaN

// ceil(n) :올림 , 주어진숫자의 양의 방향으로 만나는 정수(오른쪽)
console.log(`-----------------------ceil()---------------------------`);
console.log(Math.ceil(0.95));
console.log(Math.ceil(5.0000000000001)); //6
console.log(Math.ceil(5));
console.log(Math.ceil(-0.95)); // -0
console.log(Math.ceil(-5.0000000000001));

// floor(n) : 버림 , 주어진 숫자의 음의방향으로 만나는 정수(왼쪽)
console.log(`-----------------------floor()---------------------------`);
console.log(Math.floor(0.95));
console.log(Math.floor(5.0000000000001)); //5
console.log(Math.floor(5));
console.log(Math.floor(-0.95)); // -1
console.log(Math.floor(-5.0000000000001)); // -6

console.log(Math)
// trunc(n) : 소수 자릿수들을 절삭
console.log(`-----------------------floor()---------------------------`);
console.log(Math.trunc(0.95));
console.log(Math.trunc(5.0000000000001)); //5
console.log(Math.trunc(5.23));
console.log(Math.trunc(-0.95)); // -1
console.log(Math.trunc(-5.0000000000001)); // -6

// round(n) : 소수 자릿수들을 반올림, 소수점 자릿수를 제어할수없닺
console.log(`-----------------------round()---------------------------`);

console.log(Math.round(0.95));
console.log(Math.round(5.0000000000001)); //5
console.log(Math.round(5.23));
console.log(Math.round(-0.95)); // -1
console.log(Math.round(-5.0000000000001)); // -6


// 참고
console.log(`==============================NaN , infinity==========================`);
console.log(0 / 0);  // NaN
console.log(10 / 0);  // infinity(양의 무한대)
console.log(10 / -0);  // infinity(양의 무한대)

// min(n) ,max(n) : 최솟값 최댓값
console.log(`-----------------------min() max()---------------------------`);

console.log(Math.max(1, 5, 3));

console.log(Math.max([-1, -5, -3])); // -1
console.log(Math.max()); //  -infinity
console.log(Math.max(-0.94)); //  - 0.94

console.log(Math.min(1, 5, 3)); //  1
console.log(Math.min(-1, -5, -3)); // -5
console.log(Math.min()); //  +infinity
console.log(Math.min(-0.94)); //  - 0.94

// 연습문제 ary = [2,5,6,1,6]
let ary = [2, 5, 7, 1, 6];
console.log(Math.max(...ary));
console.log(Math.min(...ary));

// pow(n1,n2): 거듭제곱 함수
console.log(`-----------------------pow()---------------------------`);
console.log(Math.pow(5, 3));
console.log(5 ** 3);
console.log(Math.pow(4, 0.5));
console.log(4 ** 0.5);

console.log(Math.pow(4, -2));
console.log(4 ** -2);

console.log(Math.pow(-5, 3)); // -125
console.log((-5) ** 3);

console.log(Math.pow(-4, -2));

console.log(Math.pow(-4, 0.5));

// random() 함수 : 0이상 1미만의 실수 난수 발생
console.log(`-----------------------random()---------------------------`);

for (let i = 0; i < 5; ++i) {
    console.log(Math.random())
}

// [tofixed()
console.log(`==============tofixed()`)
let data = Math.random();
console.log(data);
console.log(data.toFixed(2));
console.log(data.toFixed(4));
































