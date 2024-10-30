let add = document.getElementById("end");
let target = document.getElementById("result"); // 내용이 들어갈것들



// 이벤트 클릭
add.addEventListener('click', addevent);

function addevent(event) {
    event.preventDefault(); // form이 문서를 날려버리는 기능을 못하게함
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let name1 = document.getElementById("username").value;

    let data = `${email} + ${phone} + ${name1}`;

    target.insertAdjacentHTML('beforeend', data);



};