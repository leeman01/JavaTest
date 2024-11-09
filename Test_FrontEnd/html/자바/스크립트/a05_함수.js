/*
    1) 함수의 정의(선언함수)

    function 함수명 ([파라미턴 선언부]){
        실행문;
        [return 데이터] ;
    }


    2) 호출(Call)
    함수명([아규먼트]);


    3) 함수의 정의(표현함수)
    let 변수명 =function([파라미터선언부]){
        실행문;
        [return 데이터];
    
    }
     4) 호출(Call)
    함수명([아규먼트]);

*/
// 첫번째 예제
function add(a, b) {
    return a + b;
}

function minus(a, b) {
    return a - b;
}

let temp = add;
temp(10, 20);

function proxy(func, a, b) {
    return func(a, b);
};
let result = proxy(add, 11, 21);
console.log(`결과 ${result}`);

let result1 = proxy(minus, 11, 21);
console.log(`결과 ${result1}`);

//2) Dom애 접근하는 함수

let start = document.getElementById("start");
let stop = document.getElementById("stop");

let colock = document.getElementById("clock");

// 시스템 시간을 얻어와서 처리하는 애
function makeHour() {
    let now = new Date();
    let hour = now.getHours();
    let minute = now.getMinutes();
    let second = now.getSeconds();

    let data = `<span style ="color:red";>${hour}시${minute}분${second}초</span>`;
    colock.innerHTML = data;
}
let timer = ' '
// makeHour(); // 이벤트와 상관없이 시간을 화면에 출력
start.addEventListener(`click`, function () { timer = setInterval(function () { makeHour(); }, 1000); });
// let timer = setInterval(function () { makeHour(); }, 1000);
stop.addEventListener(`click`, function () {
    clearInterval(timer);
    alert("시간이 멈췄습니다");
});