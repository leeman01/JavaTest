$(document).ready(function () {
    $('#subEmail').click(function () {
        // 폼 데이터 가져오기
        var formData = {
            name: $('#name').val(),
            email: $('#email').val(),
            phone: $('#phone').val()
        };

        // AJAX 요청
        $.ajax({
            type: 'POST',
            url: '/sendEmail',  // 요청을 보낼 URL
            data: formData,
            success: function (response) {
                // 성공 시 결과 메시지 표시
                $('#resultMessage').text(response.message);
            },
            error: function (xhr, status, error) {
                // 에러 처리
                $('#resultMessage').text('오류 발생: ' + error);
            }
        });
    });
});