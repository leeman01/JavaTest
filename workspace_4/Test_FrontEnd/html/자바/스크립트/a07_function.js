// 1)선언함수
function one(x, y) {
    return x - y;
}


let oneResult = one(11, 12);
console.log(oneResult);

// 2) 표현적함수의 생김새
let two = function (x, y) {
    return x * y;
};
console.log(two(10, 12));

// 3) 화살표함수
// (1) function 키워드를 지운다
// (2) { 사이에 => 삽입
// (3)함수의 body부분인 { }안에 코드가 1줄이면 {} 생략
// (4) return 키워드 생략
// (5) 매개변수가 1개일때는 소괄호 생략 가능
// (6) 매개변수가 0개일때는 생략 불가
// (7) 매개변수 값을 디폴트 값으로 처리할 수 있다 디폴트값은 오른쪽에서부터 채워져야함!~

let three = (x, y) => x * y;
// 파이썬의 람다식과유사 , 반환값이 1개면 return 제거 , {} 제거 , 기존선언함수에서  function 제거

let four = (a) => a ** 3;

// 예 6번의 예
// setInterval(function () {
//     console.log(`아무값이나 출력`);
// }, 1000);

// setInterval(() => console.log(`아무값`), 1000);


function five(a, b, c = 5) {
    return a * b * c;
}
console.log(`함수의결과: ${five(1, 2)}`); // 디폴트 파라미터가 없으면 nan 값이 출력

// 디폴트 파라미터를화살표함수에 적용
let six = (x, y = 10) => console.log(`${x}+${y}=${x + y}`)

six(10, 20);
six(8);

/* [연습문제] html 문서내에있는 div.box의 데이터를 가져와서  첫번째 요소는 화면 여기저기에 나타나도록 하고자한다
    1초에 한번씩 위치를 이동한다 반드시 화살표함수 시용
*/
let items = document.getElementsByClassName("box"); // 배열형태로 블러옴
let firstItems = items[0];

let lft = Math.floor(Math.random() * 1820);
let tp = Math.floor(Math.random() * 980);
firstItems.style.top = `${tp}px`;
firstItems.style.left = `${lft}px`;

setInterval(() => {
    let lft = Math.floor(Math.random() * 1820);
    let tp = Math.floor(Math.random() * 980);
    firstItems.style.top = `${tp}px`;
    firstItems.style.left = `${lft}px`;
}, 500);

// 두번쨰 상자를 얻어오기
let boxes = document.getElementsByTagName("div"); // 배열형태로 블러옴
let box = items[1];

let w = box.style.width;
let h = box.style.height;
setInterval(() => {
    box.style.width = ++w + `px`;
    box.style.height = ++h + `px`;
}, 50);