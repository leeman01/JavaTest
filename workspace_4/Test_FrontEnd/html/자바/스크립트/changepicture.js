let imageAry = ['../../Images/다운로드 (2).jpeg', '../ Images / 다운로드.jpeg', '../Images/다운로드 (1).jpeg'];

let elementsource = document.getElementById("space");
let i = 0;
setInterval(function () {
    let myimg = imageAry[i];
    elementsource.setAttribute('src', myimg);
    i++;
    if (i >= imageAry.length)
        i = 0;

}, 1500);