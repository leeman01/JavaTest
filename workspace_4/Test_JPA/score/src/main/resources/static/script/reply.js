$(function () {
    init();
});
function init() {
    $.ajax({
        url: '/retrieve'
        , method: 'GET'
        , success: great
    })
}

function great(resp) {

    if (resp.length == 0) return;
    let tag = ``;

    $.each(resp, function (index, item) {

        tag += `
      <tr>         
         <td class='reply-writer'>${index}</td>
         <td class='reply-text'>${item["stId"]}</td>
         <td class='reply-content'>${item["stName"]}</td>
          <td class='reply-content'>${item["korean"]}</td>
           <td class='reply-content'>${item["english"]}</td>
            <td class='reply-content'>${item["math"]}</td>
         <td class='btns'>`;
        tag += `<input type="button" class="deleteBtn btn btn-danger" data-num="${item['stId']}" value="삭제">`;

        tag += `</td>
      </tr>
      `;
    });

    tag += `</table>`;
    $('#contents').html(tag);
    $('.deleteBtn').on('click', deleteReply);   // 이벤트 설정
}


// 댓글 삭제관련된 함수(댓글을 쓴 사람만 삭제가 가능하게 만들것이다)
function deleteReply() {
    let diarySeq1 = $(this).attr("data-num");
    if (confirm("정말 삭제??")) {
        alert("정상적으로 삭제완료");
    } else {
        alert("삭제취소");
        return;
    }


    $.ajax({
        url: 'delete',
        method: 'GET',
        data: { "diarySeq1": diarySeq1 },
        success: function (resp) {
            init();
            console.log(resp);
        }
    })
}

