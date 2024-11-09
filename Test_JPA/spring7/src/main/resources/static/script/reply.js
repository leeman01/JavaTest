// 댓글관련 Ajax 코드

$(function () {
    // alert("경고 제발됗라");
    init();
    $('#replyBtn').on('click', replyWrite);
});
// 타임리프기법을 사용할 수 없다  == 타임리프기법을 해석하는 것은 서버이다
function init() {
    let boardNum = $('#boardNum').val();

    $.ajax({
        url: '/reply/replyAll',
        method: 'GET',
        data: { "boardNum": boardNum },
        success: output
    })

}
// 댓글 목록을 만드는 메소드
function output(resp) { // let resp = []  이런식으로 리스트이다
    if (resp.length == 0) return;
    let tag = `<table>
                <tr>
                    <th>작성자</th>
                    <th>댓글내용</th>
                    <th>작성일</th>
                    <th></th>
                </tr>
    `;

    $.each(resp, function (index, item) {
        tag += `
      <tr>         
         <td class='reply-writer'>${item["replyWriter"]}</td>
         <td class='reply-text'>${item["replyText"]}</td>
         <td class='reply-date'>${item["createdate"]}</td>
         <td class='btns'>`;

        //로그인한 아이디(html에서 읽어온 값)와 댓글 쓴 사용자
        if ($('#loginId').val() == item["replyWriter"]) {
            tag += `<input type="button" class="deleteBtn btn btn-danger" data-num="${item['replyNum']}" value="삭제">`;
        }
        tag += `</td>
      </tr>
      `;
    });

    tag += `</table>`;
    $('#reply-list').html(tag);
    $('.deleteBtn').on('click', deleteReply);   // 이벤트 설정
}


// 댓글 삭제관련된 함수(댓글을 쓴 사람만 삭제가 가능하게 만들것이다)
function deleteReply() {
    let replyNum = $(this).attr("data-num");  // 괄호안에 전달인자가 하나면 속성값을 읽는것이고 2개면 바꾸는 것이다
    $.ajax({
        url: '/reply/replyDelete',
        method: 'GET',
        data: { "replyNum": replyNum },
        success: function (resp) {
            init();
            console.log(resp);
        }
    })
}
// 댓글 쓰기
function replyWrite() {
    let writer = $('#loginId').val(); //로그인 한 사람의 이름
    let replyText = $('#replyText').val(); // 댓글을 입력하지않고 전송버튼을 누를 경우
    let boardNum = $('#boardNum').val();
    let sendData = { "replyWriter": writer, "replyText": replyText, "boardNum": boardNum };
    $.ajax({
        url: '/reply/replyInsert',
        method: "POST",
        data: sendData,
        success: function () {
            $('#replyText').val("");
            init();
        }

    })
}