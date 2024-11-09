let receivedData = [
    { "name": "홍길동", "email": "hong@naver.com", "phone": "010-1111-2222" }
    , { "name": "1홍길동", "email": "hong1@naver.com", "phone": "010-2111-2222" }
    , { "name": "2홍길동", "email": "hong2@naver.com", "phone": "010-3111-2222" }
    , { "name": "3홍길동", "email": "hong3@naver.com", "phone": "010-4111-2222" }
    , { "name": "4홍길동", "email": "hong4@naver.com", "phone": "010-5111-2222" }
];
$(function () {
    // receive 버튼에 이벤트 설정
    $('#receive').on('click', init);


})

function init() {
    // let name = receivedData[0]["name"];
    // alert(receivedData.length);
    // tbody에 삽입될 태그를 만들어야함
    let name = "";
    let email = "";
    let phone = "";
    let final = '';
    $(receivedData).each(function (index, item) {
        name = receivedData[index]["name"];
        email = receivedData[index]["email"];
        phone = receivedData[index]["phone"];
        let sfinal = `
             <tr>
                   <td><input type="checkbox"></td>
                    <td>${name}</td>
                    <td>${email}</td>
                    <td>${phone}</td>
                    <td><button id="reset">삭제</button></td> 
                </tr>`;
        final += sfinal;
    })

    $('tbody').html(final);

    $('button#reset').on('click', function () {
        if (confirm('정말로 삭제하기겟습니까?'))
            $('#reset').parent().parent().remove();
    })
    //  버튼 그 자체를 this 객체로 불러온다

}

$(function () {
    // 전체 선택상자를 체크하면 나머지를 모두 실행하도록
    $('#checkAll').on('click', function () {
        // alert('체크박스!');
        if ($(this).is(':checked')) {
            $('tbody input:checkbox').prop('checked', true);
        } else {
            $('tbody input:checkbox').prop('checked', false);
        }
    });
    // 삭제버튼 클릭하면 체크된 고객명단 삭제
    $('#deleteMember').on('click', function () {
        let checkedItem = $('tbody input:checked').parent().parent();
        checkedItem.remove();
    })
});

