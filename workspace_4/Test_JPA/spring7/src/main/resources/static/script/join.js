$(function () {
    $('#userId').on('keyup', confirm);
    $('#userId').on('blur', function () {
        $('#confirmId').html('');
    });
    $('#userPwd').on('focus', function () {
        $('#userPwdCheck').val('');
    });
    $('#submitBtn').on('click', join);
});

let idCheck = false; // false의 경우 가입 불가능!
let pwdCheck = false; // false의 경우 가입 불가능!

function join() {
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

    // 사용자 이름 체크
    let userName = $('#userName').val();
    if (userName.trim().length == 0) {
        $('#userNameCheck').css('color', 'red');
        $('#userNameCheck').html('실명을 입력하세요.');
        $('#userName').select();
        return;
    }
    $('#userNameCheck').html('');

    let email = $('#email').val();
    if (email.trim().length == 0) {
        $('#emailCheck').css('color', 'red');
        $('#emailCheck').html('이메일을 입력하세요.');
        $('#email').select();
        return;
    }
    $('#emailCheck').html('');

    // 가입
    if (!idCheck || !pwdCheck) {
        alert("모든 정보를 정확히 입력하세요.");
        return;
    }
    $('#joinForm').submit();
}

// 사용가능한 아이디인지 여부를 판단(ajax로 작업)
function confirm() {
    let userId = $('#userId').val();

    if (userId.trim().length < 3 || userId.trim().length > 5) {
        $('#confirmId').css('color', 'red');
        $('#confirmId').html('아이디 길이는 3~5자 사이여야 합니다!');
        return;
    }
    $('#confirmId').html('');

    // 중복 아이디인지 체크
    $.ajax({
        url: "/user/confirmId",
        method: "POST",
        data: { "userId": userId },
        success: function (resp) { // resp가 true면 사용 가능
            if (resp) {
                $('#confirmId').css('color', 'blue');
                $('#confirmId').html('사용 가능한 아이디입니다.');
                idCheck = true;
            } else {
                $('#confirmId').css('color', 'red');
                $('#confirmId').html('이미 존재하는 아이디입니다.');
                idCheck = false;
            }
        }
    });
}
