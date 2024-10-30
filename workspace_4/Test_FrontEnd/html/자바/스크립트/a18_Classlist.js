// 이벤트소스

let get = document.getElementById("get");
let add = document.getElementById("add");
let remove = document.getElementById("remove");
let replace = document.getElementById("replace");
let toggle = document.getElementById("toggle");
let contains = document.getElementById("contains");
// 이벤트,타세쇼
let target = document.getElementById("target");
let content = document.getElementById("content");


get.addEventListener('click', getHandler);
add.addEventListener('click', addHandler);
remove.addEventListener('click', removeHandler);
replace.addEventListener('click', replaceHandler);
toggle.addEventListener('click', toggleHandler);
contains.addEventListener('click', containsHandler)
// 이벤트 헨들러
function getHandler() {
    let data = '';
    data = content.classList;
    console.log(data);
    output(data); // 사용자 정의 함수명

}
function addHandler() {
    content.classList.add('info', 'blue');
}
function removeHandler() {
    content.classList.remove('info', 'blue');
}
function replaceHandler() {
    content.classList.replace('red', 'green');

}
function toggleHandler() {
    content.classList.toggle('visible');
}
// 사용자 정의함수
function output(data) {
    target.innerHTML = data;
}
function containsHandler() {
    let result = content.classList.contains("danmger");
    output(result);
}