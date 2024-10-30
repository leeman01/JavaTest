/*
    DOM에 접근해서 객체를 받아오기
    1) getElemntById("아이디값")
*/
let writer = document.getElementById("writer");
console.log(writer);

// 2) getElementsTagName("태그명")

let tags = document.getElementsByTagName("p");
console.log(tags.length);
console.log(tags);

// 3) getelementsbyclassname("클래스명")
console.log(`================tagname`)

let poem = document.getElementsByClassName("poem");
console.log(poem.length); //2 
console.log(poem);

// 4)querySelector() => 문서내에 css 선택자에 맞는 데이터 한개만 반환
console.log(`==============querySelector`);
let poem2 = document.querySelector(".poem") // class . 클래스명 을 응용
console.log(poem2.length); // 한개만 반환해서 undefined 
console.log(poem2);

// 5)querySelectorAll() => 문서내에 css 선택자에 맞는 데이터 여러개를 반환
// getelemetntsByClassName : HTMLCollections 타입으로 반환한다 
//  quertyselectorAll() : nodelist 타입으로 반환
console.log(`==============querySelectorAll`);
let poem3 = document.querySelectorAll(".poem") // class . 클래스명 을 응용
console.log(poem3.length); // 한개만 반환해서 undefined 
console.log(poem3);
console.log(poem3[0]);

poem3[0].style.color = 'red';
poem3[0].style.backgroundColor = 'pink';
// 6) getAttribute("속성명") , serAttribute("속성명","값")
// -HTML 요소의 특정 속성값을 조회(get)하거나 치환하는 (set)메소드
let value = document.getElementById("image").getAttribute("src");
console.log(value);

console.log(document.getElementById("image").getAttribute("alt"));

// 다른값으로 치환 -- 이벤트 소스는 버튼이다 !! 
document.getElementById("change").addEventListener('click', function () {
    document.getElementById('image').setAttribute('src', '../Images/다운로드.jpeg')
});

// 그림자체가 이벤트 소스가 되도록 
//  그림에 걸리는 이벤트 연결
document.getElementById("image").addEventListener('mouseenter', function () {
    document.getElementById('image').setAttribute('src', '../Images/다운로드.jpeg')
});

document.getElementById("image").addEventListener('mouseleave', function () {
    document.getElementById('image').setAttribute('src', '../Images/ai-generated-8593968_1280.png')
});










