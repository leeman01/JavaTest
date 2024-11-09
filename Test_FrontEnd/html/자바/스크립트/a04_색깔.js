let btn = document.getElementById("btn");
btn.onmouseenter = changeColor;
// onmouseover는 사용을 권하지 않음
// event 처리
let theBody = document.getElementById("theBody");

let cnt = 0;

function changeColor() {
    let color = ["yellow", "white", "skyblue", "pink", "silver"];
    theBody.style.backgroundColor = color[cnt];
    cnt++;
    if (cnt > 4)
        cnt = cnt % 5;
}



















