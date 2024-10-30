$(function () {
    init();
    $('#button1').on('click', confirm1);
});
function init() {
    $.ajax({
        url: '/retrieve'
        , method: 'GET'
        , success: great
    })
}
function confirm1() {
    let title = $('#title').val();
    let records = $('#content').val();
    let regdate = $('#date').val();
    let feeling = $('input[name="feeling"]:checked').val()

 
    if (title.trim().length == 0 || records.trim().length == 0) {
        alert('제목과 내용은 무조건 입력되어야 합니다 !');
        return;
    }
	
	// 아니 이거 왜 안되지 화난다 그냥
	if(confirm("정말 등록희망?")){
		alert("정상적으로 등록완료");
	}else{
		alert("등록이 취소되었습니다");
		return;
	}
   
   
  
    let sendData = { "title": title, "records": records, "regdate": regdate, "feeling": feeling };

    $.ajax({
        url: "diary",
        method: 'POST',
        data: sendData,
        success: function () {
            $('#title').val("");
            $('#content').val("");
			init();
        }
    })

}
function great(resp) {
	
    if (resp.length == 0) return;
    let tag = `<table>
                <tr>
                    <th>날짜</th>
                    <th>그날의기분</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>비고</th>
                </tr>
    `;

    $.each(resp, function (index, item) {
        console.log("정보");
        console.log(resp);
        tag += `
      <tr>         
         <td class='reply-writer'>${item["regdate"]}</td>
            <td class='reply-date'><img src="/images/${item["feeling"]}" alt=""></td>
         <td class='reply-text'>${item["title"]}</td>
         <td class='reply-content'>${item["records"]}</td>
         <td class='btns'>`;
        tag += `<input type="button" class="deleteBtn btn btn-danger" data-num="${item['diarySeq']}" value="삭제">`;

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
	if(confirm("정말 삭제??")){
			alert("정상적으로 삭제완료");
		}else{
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

