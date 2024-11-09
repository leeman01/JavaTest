let afterend = document.getElementById("afterend");
let afterbegin = document.getElementById("afterbegin");
let beforeeend = document.getElementById("beforeend");
let beforebegin = document.getElementById("beforebegin");


// 이벤트 타겟
let list = document.getElementById('list');
let data = "추가데이터";

// 이벤트 핸들러
// afterend.addEventListener('click', afterendfunc);///
afterbegin.addEventListener('click', afterbeginfunc);
beforeeend.addEventListener('click', beforeeendfunc);

function afterendfunc() {
    list.insertAdjacentHTML('afterend', data);
    // innerHTML과 비슷하지만 어느위치에 데이터를 추가할지 결정할 수 있다

}
function afterbeginfunc() {
    list.insertAdjacentHTML('afterbegin', data);
}
function beforeeendfunc() {
    list.insertAdjacentHTML('beforeend', data);
}

