//  여기서 먼저 어떤 버튼을 클릭해야지 어떤 이벤트가 발생하는지 정헤야한다

// 1) 먼저 제출 버튼을 누르자

document.getElementById("summit").addEventListener("click", createForm);

let data = document.getElementById("data");

function createForm() {
    let first1 = ` <h1>설문결과</h1>
        <ul>`;

    let name = document.getElementById("name").value;
    // 이름을 먼저 찾자
    if (name.trim().length == 0 || name.length != name.trim().length) {
        alert("이름을 제대로 입력하세요(띄워쓰기는 허용하지 않습니다)");

        document.getElementById("name").value = "";
        document.getElementById("name").select();
        document.getElementById("name").focus();
        return;

    }

    // 전화번호
    //1) 첫번째 값
    let first = document.getElementById("callphone").value;
    // 텍스트 문자열 

    let call = document.getElementById("tell");
    if (isNaN(call.value)) {
        alert("전화번호입력시 -은 빼고 입력해")
        call.value = "";
        call.focus();
        return;
    }
    else if (call.value.trim().length != 8) {
        alert("전화번호는 8자리가 되어야 합니다");
        call.value = "";
        call.focus();
        return;

    }
    // 전화번호 클리어
    // alert("전화번호는 다음과 같습니다: " + first +"-" + call.value.substring(0, 4) + "-" + first + call.value.substring(4, 8));
    let finalcall = first + "-" + call.value.substring(0, 4) + "-" + first + call.value.substring(4, 8);

    // 이메일 정보 불러오기

    let email = document.getElementById("email").value;
    let cnt = 0;
    for (let i = 0; i < email.length; ++i) {
        if (email.charAt(i) == '@')
            cnt += 1;
    }
    if (cnt == 0) {
        alert("이메일에 @의 부재");
        document.getElementById("email").value = "";
        email.select();
        email.focus();
    }

    //  IT 직업군
    let it = document.getElementById("job").value;

    // 서브스중 가장 많이 사용
    let service = document.getElementsByClassName("2")[0].getElementsByTagName("input");

    let t = 0;
    for (let i = 0; i < service.length; ++i) {
        if (!(service[i].checked)) {
            t += 1;

        } else if (service[i].checked) {
            break;
        } else {
            alert("구글 서비스중 가장 많이 사용하는것이 무엇인지 체크해주세요");
            return;
        }
    }

    let finalservice = service[t].value;

    // 구글 문서도구
    let n = 0;

    let finaltool = "";
    let tool = document.getElementsByClassName("5")[0].getElementsByTagName("input");
    for (let i = 0; i < tool.length; ++i) {
        if ((tool[i].checked)) {
            finaltool += tool[i].value + " ";
            n += 1;
        } else if (i == tool.length - 1 && n == 0) {
            alert("강화햇으면 하는 아이템을 선택하시오");
        }
    }
    // 남기실말은?
    let text = document.getElementById("text").value;

    // 태그로 내용 정리
    first1 += `<li>이름: ${name}</li>`;
    first1 += `<li>전화번호부: ${finalcall}</li>`;
    first1 += `<li>이메일: ${email}</li>`;
    first1 += `<li>IT직업: ${it}</li>`;
    first1 += `<li>가장 맘에 드는 서비스: ${finalservice}</li>`;
    first1 += `<li>강화햇으면하는 tool: ${finaltool}</li>`;
    first1 += `<li>하고싶은 말: ${text}</li>`;
    first1 += `</ul>`;

    data.innerHTML = first1;



}