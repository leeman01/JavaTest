// 1) defer  가 없는 상태의 스크립트 코드가 실행되었을 때
let btn = document.getElementById("btn"); // HTML Object
let del = document.getElementById("del"); // HTML Object
let printStar = document.getElementById("printStar"); // HTML Object
let print = document.getElementById("print"); // 삼각별 그리기

console.log(btn);


btn.onclick = write;
del.onclick = remove;
printStar.onclick = Star;
print.onclick = prints;


function write() {
    let result = document.getElementById("result");
    let data = '<h3 style="color : red"> 클릭햇습니다 </h3>';
    result.innerHTML = data;
};
function remove() {
    let result = document.getElementById("result");

    result.innerHTML = "";
};

function Star() {
    let result = document.getElementById("result");
    let data = '<img src="../Images/다운로드.jpeg">';
    result.innerHTML = data;

};
function prints() {
    let result = document.getElementById("result");
    let data = '';
    for (let i = 0; i < 5; ++i) {
        for (let j = 0; j < (i + 1); ++j) {
            data += '*';
        }
        data += "<br>";

    }
    result.innerHTML = data;

};