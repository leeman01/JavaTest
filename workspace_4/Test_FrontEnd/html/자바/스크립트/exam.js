
let btn = document.getElementById("targ");


// 난수 발생시키기
let body = document.getElementById("exam");
let color;
// 색깔만드는 함수 
function makecolor() {
    let red = Math.floor(Math.random() * 256);
    let green = Math.floor(Math.random() * 256)
    let blue = Math.floor(Math.random() * 256)
    color = `rgb(` + red + `,` + green + `,` + blue + `)`;

    body.style.backgroundColor = color;

};
setInterval(function () { makecolor(); }, 1000);
