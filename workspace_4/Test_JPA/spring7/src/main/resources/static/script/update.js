

$(function () {

    $('#userPwd').on('focus', function () {
        $('#userPwdCheck').val('');
    });
    $('#submitBtn').on('click', update);
});

let idCheck = false; // false의 경우 가입 불가능!
let pwdCheck = false; // false의 경우 가입 불가능!

function update() {
    let userPwd = $('#userPwd').val();
    let userPwdCheck = $('#userPwdCheck').val();

    if (userPwd.trim() != userPwdCheck.trim()) {
        $('#confirmPwd').css('color', 'red');
        $('#confirmPwd').html('비밀번호와 비밀번호 확인은 값이 같아야 합니다!');
        return;
    }
    $('#confirmPwd').html("");
    if (userPwd.trim().length < 3 || userPwd.trim().length > 5) {
        $('#confirmPwd').css('color', 'red');
        $('#confirmPwd').html('비밀번호 길이는 3~5자 사이여야 합니다!');
        return;
    }
    pwdCheck = true;
    $('#confirmPwd').html("");



    let email = $('#email').val();
    if (email.trim().length == 0) {
        $('#emailCheck').css('color', 'red');
        $('#emailCheck').html('이메일을 입력하세요.');
        $('#email').select();
        return;
    }
    $('#emailCheck').html('');

    // 수정작업진행전에 확인하는 코드
    if (!pwdCheck) {
        alert("모든 정보를 정확히 입력하세요.");
        return;
    }
    $('#updateForm').submit();
}



