//
/**
 * 회원정보수정을 위해 비밀번호를 다시 입력받아 확인하는 콛,
 */

$(function () {
    $('#submitBtn').on('click', validation);
});
// 비밀번호가 잘입력되는지 확인하는 코드 + 서버 쪽으로 전송
function validation() {
   
    let userPwd = $('#userPwd').val();

    if (userPwd.trim().length < 3 || userPwd.trim().length > 5) {
        alert("비밀번호는 3~5자사이로 입력")
        $('#userPwd').select();
        return;
    }
    let pwdForm = $('#pwdForm');
    pwdForm.submit();
}



