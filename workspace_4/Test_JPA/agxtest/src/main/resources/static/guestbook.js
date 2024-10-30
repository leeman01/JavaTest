// ajax 코드

$(function () {
    init();
    $('#save').on('click', input);
    // 전체데이터를 다시 로딩

    function init() {
        $.ajax({
            url: 'retreieveAll',
            method: 'GET',
            success: output
        })
    }
    // 출력함수
    function output(resp) {
        let tag = '';
        $.each(resp, function (index, item) {
            // console.log(index);
            tag += ` <tr>
                    <td class="idx">${index + 1}</td>
                    <td class="name">${item["name"]}</td>
                    <td class="content">${item["content"]}</td>
                    <td class="phone">${item["createDate"]}</td>
                    <td class="btn"><input type="button" class="btn" value="삭제" data-seq=${item["seq"]}></td>
                </tr>
            `;
        });
        $('tbody').html(tag);
        $('.btn').on('click', deleteItem);
    }
    function deleteItem(e) {
        // attr은 값을 1개만 넣으면 값을 얻어오는 것 2개면 값을 변경한다
        let seq = $(this).attr("data-seq");
        let pwd = prompt("비밀번호를 입력하세요");
        let answer = confirm("삭제?");
        e.stopPropagation();
   
        if (answer == false || pwd==false)
            return;

        $.ajax({
            url: 'deleteguestbook',
            method: 'POST',
            async: false, // 화면을 딜레이 할때 자주 사용한다
            data: { "seq": seq, "pwd": pwd },
            success: init

        });
    }

    // 방명록 데이터를 수집하는 역할 ajax를 기반으로 데이터베이스(DB)에 전송
    function input() {
        let name = $('#name').val();
        let pwd = $('#pwd').val();
        let content = $('#content').val();

        let sendData = { "name": name, "pwd": pwd, "content": content };

        // alert(JSON.stringify(sendData));
        $.ajax({
            url: 'inputGuestbook',
            data: sendData,
            method: 'POST',
            success: function () {
                init();
                clearAll();
            }
        });
    }
    // 입력상자의 데이터를 삭제
    function clearAll() {
        let name = $('#name').val(""); // 괄호안에 아무것도 없으면 값을 읽어오지만 값이 잇으면 그걸로 채운다.
        let pwd = $('#pwd').val("");
        let content = $('#content').val("");

    }


})