let equal = document.getElementById("equal"); // = 버튼 
let calculate = document.getElementById("calculate"); // 계산버튼

equal.addEventListener('click', equalize);
calculate.addEventListener('click', clearall);

let first = document.getElementById("1");
let second = document.getElementById("2");
let final = document.getElementById("3"); s

function equalize() {

    // 연산자 구하기
    let operator = document.getElementsByClassName("real")[0].value; // 연산자 문자열 나옴
    if (isNaN(first.value) || first.value.trim().length == 0) {
        alert("1번째 숫자입력해")
        first.value = "";
        first.select();
        first.focus();
        return;
    } else if (isNaN(second.value) || second.value.trim().length == 0) {
        alert("두번째 숫자입력헤");
        second.value = "";
        second.select();
        second.focus();
        return;
    }

    // alert(operator);
    let data;
    if (operator == "+") {
        data = parseInt(first.value) + parseInt(second.value);
        final.value = data;
    } else if (operator == "-") {
        data = parseInt(first.value) - parseInt(second.value);
        final.value = data;
    } else if (operator == "/") {
        data = parseInt(first.value) / parseInt(second.value);
        final.value = data;
    } else if (operator == "*") {
        data = parseInt(first.value) * parseInt(second.value);
        final.value = data;
    }

}
function clearall() {
    first.value = "";
    second.value = "";
    final.value = "";

    first.select()
    first.focus();

}