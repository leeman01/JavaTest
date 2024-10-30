/*-------------------------------------------
    구조분해 할당
---------------------------------------------*/
let one = [10, 20, 30];

// 데이터를 각각 꺼내려면
let a = one[0];
let b = one[1];
let c = one[2];
console.log(a, b, c);

let [a1, b1, c1] = one;
console.log(a1, b1, c1);

let [a2, b2, c2, d2] = one;
console.log(a2, b2, c2, d2); // 마지막 d2에는 umdefined

// 예전방식
let x = 10;
let y = 20;

// let temp;
// temp = x;
// x = y;
// y = temp;

// 구조분해 할당을 이용한 데이터교환
[y, x] = [x, y];
console.log(`두변수의 교환결과:${x},${y}`)

/*-------------------------------------------
    구조분해 할당(객체)
---------------------------------------------*/
let objOne = {
    name: '손오공',
    age: 29
};

// 예전방식
// let name = objOne['name'];

// 구조분해 할당
let { name, age } = objOne;
console.log(`객체를 구조분해 할당: ${name} ${age}`);

//
let objTwo = {
    name: '저팔계',
    age: 25
};
// 구조분해 할당할 때 객체의 키값과 변수명이 같아야한다
// 다른 이름을 사용할 때에는 별칭으로 사용해야 한다
let { name: nickName, age: hisAge } = objTwo;
console.log(`객체를 구조분해 할당:${nickName} ${hisAge}`);

// default 파라미터를 이용하여 데이터 처리
let { name: k, age: d, address = "서울" } = objTwo;

console.log(`객체를 분해해 할당 : ${k}, ${d}, ${address}`)













