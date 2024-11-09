let deletebtn = document.getElementById("deleteBtn");

let updatebtn = document.getElementById("updateBtn");
let writer = document.getElementById("boardWriter");
// 로그인 한 사람과 글쓴이 사람이 다르면 updataBtn 과 deleteBtn 을 읽어올수없다

if (deletebtn != null) deletebtn.addEventListener('click', goto);
if (updatebtn != null) updatebtn.addEventListener('click', goto);

function goto() {
    let target = this.getAttribute("id"); // deleteBtn , updateBtn
    // let boardNum = this.getAttribute("data-no");/
    let go = '';
    let boardNum = document.getElementById("boardNum").value;
    let searchItem = document.getElementById("searchItem").value;
    let searchWord = document.getElementById("searchWord").value;
    // alert("삭제버튼 클릭" + url);
    switch (target) {
        case "updateBtn": go = "boardUpdate"; break;
        case "deleteBtn":
            if (!confirm("정말삭제할까요")) return;
            go = "boardDelete";
            break;
    }
    let modifyForm = document.getElementById("modifyForm");
    modifyForm.action = `/board/${go}`;
    modifyForm.submit();
    // let url = `/board/${go}?boardNum=${boardNum}&searchItem=${searchItem}&searchWord=${searchWord}`;
    //&searchItem=boardWriter&searchWord=홍길동
    // alert(url);
    // location.replace(url); // 이렇게 보내면 boardDelete 컨트롤러에서  get 을 받음
}

// function updateFunc() {
//     let boardNum = this.getAttribute("data-no");

//     let url = `board/boardUpdate?boardNum=${boardNum}`;
//     // alert("수정버튼 클릭" + url);
// }










