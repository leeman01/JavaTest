// alert("경고합니다");
// 이벤트 소스
let check = document.getElementById("check");

//이벤트 타겟
let userid = document.getElementById("userid"); // 태그
let birthday = document.getElementById("birthday");


check.addEventListener('click', validation);

// 이벤트 핸들러
function validation() {
    // alert("rudrh") 연결 확인후 주석처리
    let id = userid.value; // 문자열 의미
    if (id.includes(' ')) {
        alert("아이디는 한 단어로 입력하시오");
        userid.value = " ";
        userid.focus();
        return;
    }
    if (!(id.trim().length >= 5 && id.trim().length <= 10)) {
        alert("5~10글자로 정확히입력");
        userid.focus();
        userid.select();
        return;

    }
    let birth = birthday.value; // 숫자가 아닌 문자가 포함되어잇다면
    if (birth.length != 8 || isNaN(birth)) {
        alert("생년월일을 숫로만 8자리 입력하시오");
        birthday.focus(); // 포커스를 넣은 후 안에 데이터는 없애버렷다
        birthday.value = " ";
        return;
    }
    alert("아이디: " + id + "\n생년월일: " + birth);
}













