"use strict"; // 문법적으로 제약사항이 엄격하지않아서  자바처럼 문법을 엄격히 체크해달라

// 이벤트 소스 얻어오기
document.getElementById("join").addEventListener('click', joincheck);
document.getElementById('userid').addEventListener('keyup', idCheck)
document.getElementById("email2").addEventListener('change', emailcheck);


// 이벤트 핸들러


function idCheck() {
    let userid = document.getElementById("userid");
    let idcheck = document.getElementById("idcheck");

    if (userid.value.trim().length < 3 || userid.value.trim().length > 5) {
        idcheck.style.color = "red";
        idcheck.innerText = "아이디는 영문 숫자포함 3~5글자로 입력"
        return;
    }
    idcheck.innerText = "";
}
function joincheck() {
    // 1) 이름체크하기
    let username = document.getElementById('username');
    if (username.value.trim().length < 3 || username.value.trim().length > 5) {
        alert("이름은 실명으로 3~5글자로 작성");
        username.select();
        return; // 더이상 진행 안되도록 막기
    }

    //2 비번길이체크
    let userid = document.getElementById("userid");

    if (userid.value.trim().length < 3 || userid.value.trim().length > 5) {
        alert("아이디는 영문,숫자포함 3~5글자로 입력해주세요");
        return;
    }

    let userpwd = document.getElementById("userpwd");
    // userpwdcheck.value = ""; 비동기통신으로 각각 체크할 때는 있는게좋음
    if (userpwd.value.trim().length < 3 || userpwd.value.trim().length > 5) {
        alert("비밀번호는 영문,숫자포함 3~5글자로 입력해주세요");
        return;
    }
    // 페스워드 확인체크
    let userpwdcheck = document.getElementById("userpwdcheck");
    if (userpwdcheck.value.trim() != userpwd.value.trim()) {
        alert("비밀번호는 비밀번호확인값과 같아야 합니다");
        userpwdcheck.value = "";
        userpwdcheck.focus();
        return;

    }
    // 4-1 전화번호 맨 앞자리
    let phone1 = document.getElementById("phone1").value; // 문자열가져옴
    // 4-2 전화번호 중간자리
    let phone2 = document.getElementById("phone2"); //태그만 가져오기

    if (isNaN(phone2.value) || phone2.value.trim().length != 3) {
        alert("전화번호를 정확히 입력해주세요");
        phone2.select();
        return;
    }
    // 4-3 전화번호 마지막
    let phone3 = document.getElementById("phone3"); //태그만 가져오기

    if (isNaN(phone3.value) || phone3.value.trim().length != 4) {
        alert("전화번호를 정확히 입력해주세요");
        phone3.select();
        return;

    }

    let phone = phone1 + phone2.value + phone3.value;
    // 이메일 처리하는 부분은 다른 함수로 전이한다
    // 5-1 이메일가져오기
    let email1 = document.getElementById("email1");
    if (email1.value.trim().length == 0) {
        alert("이메일을 정확히 입력해주세요");
        email1.select();
        return;
    }
    // 5-3 마지막 이메일가져오기
    let email3 = document.getElementById("email3");
    if (email3.value.trim().length == 0) {
        alert("이메일을 정확히 입력해주세요");
        email3.select();
        return;
    }
    let email = email1.value + '@' + email3.value;
    // 6)주소 + 상세주소 얻어오기
    let addr1 = document.getElementById("addr1").value;
    let addr2 = document.getElementById("addr2");

    if (addr2.value.trim().length == 0) {
        alert("상세 주소를 입력해주새요");
        addr2.focus();
        return;
    }
    let address = `${addr1} - ${addr2.value}`;

    // 7 ) 사이트를 알게된경로 : 체크박스이므로 여러개 선택이 가능
    // let p = document.querySelectorAll('input[type="checkbox"]:checked')  // 체크상태인 체크박스 값들을 리스트로 불러옴/ / => 실패
    // let p = document.getElementsByName("path");
    let p = document.querySelectorAll('input[name="path"]:checked');
    let path = ' ';
    p.forEach(function (item) {
        if (item.value)
            path += item.value + " ";
    })
    // alert(path);
    let receive = document.querySelector("input[type='radio'].receive:checked").value;
    // alert(receive);
    let receive1 = document.querySelector("input[name='kakaotalk']:checked ").value;

    let kakaoreceive = false;
    if (receive1 == null) {
        kakaoreceive = false;

    } else {
        kakaoreceive = true;
    }
    // alert(kakaoreceive);
    // 최종결과물을 출력하는 
    // 사이트를 알게된 경위 이메일 수신 여부 카카오톡 수신
    let finalresult = `이름 : ${username.value} \n 아이디: ${userid.value} \n 연락처: ${userpwd.value} \n 전화번호:${phone1}-${phone2.value} - ${phone3.value} \n `;
    finalresult += `이메일: ${email} \n 주소: ${address} \n `;
    let finalResult = `<ul>`;
    finalResult += `<li>이름: ${username.value}</li>`;
    finalResult += `<li>아이디: ${userid.value}</li>`;
    finalResult += `<li>연락처: ${phone}</li>`;
    finalResult += `<li>이메일: ${email}</li>`;
    finalResult += `<li>주소: ${address}</li>`;
    finalResult += `<li>사이트를 알게된 경로: ${path}</li>`;
    finalResult += `<li>이메일 수신여부: ${receive}</li>`;
    finalResult += `<li>카카오톡 수신여부: ${kakaoreceive ? "동의" : "비동의"}</li>`;
    finalResult += `</ul>`;
    document.getElementById('final').innerHTML = finalResult;
    console.log(finalresult);

}
// 이메일 중간부분의 상태가 변화되면  발생하는 처리함수ㅡ
function emailcheck() {

    // 5-2 이메일 중간자리

    let email2 = document.getElementById("email2");
    if (email2.value.length != 0) {
        document.getElementById("email3").value = email2.value;
        return;
    } else {
        document.getElementById("email3").value = "";
        document.getElementById("email3").focus();
        return;
    }
}


























