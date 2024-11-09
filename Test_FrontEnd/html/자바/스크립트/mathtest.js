// 자바스크립트
alert("경고");

let value1 = document.getElementById("value1");
let value2 = document.getElementById("value2");
let final = document.getElementById("final");
let e = document.getElementById("clear3");
let clear = document.getElementById("clear");

// let plus = document.getElementById("plus");/
let equal = document.getElementById("equal");

equal.addEventListener('click', add);
clear.addEventListener('click', clear2);
e.addEventListener('click', display);
let a3 = 0;
function add() {
    let a1 = value1.value;
    let a2 = value2.value;
    if (isNaN(a1) || isNaN(a2) || a1.trim().length == 0 || a2.trim().length == 0) {
        clear2();
        alert("숫자만 입력하시오");

        value1.focus();
        value1.select();
        return;

    }
    // al = parseInt(a1);
    // a2 = parseInt(a2);
    // final.value = a1 + a2;
    // a3 = Math.abs(a1) + Math.abs(a2);
    // parseInt(n1)
    // parseint(a2) => 이렇게해야 원하는 값이 나온다
    a3 = a1 * 1 + a2 * 1;


    final.value = a3;
}
function clear2() {
    value1.value = " ";
    value2.value = " ";
    final.value = " ";
    value1.focus();
    value1.select();
}
function display() {

    alert(`값은 ${final.value} 입니다`)

}
let a = Date();




// innerHTML 시작태그와 끝태그 사이에 태그를 삽입
// innerTest 시작태그와 끝태그 사이에 문자열을 삽입
// value 폼태그의 데이터를 읽어오거나 쓴다




















