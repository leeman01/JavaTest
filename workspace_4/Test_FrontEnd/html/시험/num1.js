// 
let button = document.getElementById("print");
let target = document.getElementById("text");

button.addEventListener('click', Printtext);

function Printtext() {
    let data = "    이동건입니다";
    target.insertAdjacentHTML('beforeend', data);
}