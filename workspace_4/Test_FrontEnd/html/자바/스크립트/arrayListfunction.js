/*
    배열을 다루는 여러 메소드

    1) join("문자열") : 전달된 문자열을 구분자로하여 배열을 문자열로 합친 후 반환
    2) reverse() : 리스트 순서를 반대로
    3) slice() : 부분 문자열을 가져옴 원본은 그대로
    * splice() : 부분 문자열을 가죠옴 원본은 수정됨
    4) sort() : 배열의 요소를 정렬
    5) concat() : 두개이상의 배열을 연결
    6) push() , pop() :
    7) unshift(),shift(): 
    8) toString() : 베열을 문자로 반환
*/


let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(arr.join("/"));
// console.log(arr.reverse());
let temp = arr.slice(1, 5);
console.log(`슬라이슨된 배열:${temp}`);
console.log(`원본: ${arr}`)

// 원본을 수정하면 temp는 어떻게되는걸까
arr[2] = 22;

console.log(`슬라이슨된 배열:${temp}`); // 원본으로부터 분리된 복사본
console.log(`원본: ${arr}`)

temp = arr.slice(0, -2); // 음수 사용가능?
console.log(`부분 배열의 성공?(마이너스):${temp}`)
console.table(temp);

// splice() -부분 문자열
let color = [`빨강`, `주황`, `노랑`, `남색`, `파랑`, `남`, `보라`];
temp = color.splice(4); // 지정된 인덱스를 포함해서 그 후순위 인덱스도 모조리 가져와라
console.log(temp);
console.log(color); // 원본에도 영향을 준다

color = [`빨강`, `주황`, `노랑`, `남색`, `파랑`, `남`, `보라`];
color.splice(2, 1, 'Yeoolw', '노랑'); // 2번 인덱스 1개자리에 yel;low 노랑을 넣음
console.log(color);

// concat() 
let food = ['피자', '죽', '뼈해장국'];
let drink = ['물', '주스', '커피'];
let fruit = ['볷숭아', '수박', '블루베리'];

let lunch = food.concat(drink);
console.log(`점심: ${lunch}`);

lunch = food.concat(drink, fruit);
console.log(`점심: ${lunch}`);

console.log(lunch.toString()); // 배열요소를 콤마로 연결된 문자열로 반환

// push pop 
let data = "짜장면";
food.push(data); // 가장 끝부분의 인덱스로 삽입
console.log(food);

data = food.pop();
console.log(food);

//
food = ['라뽀끼'];
food.pop();
console.log(food); // 데이터가 하나도 없는데 꺼내면 무엇이 꺼내질까???
data = food.pop();
console.log(data);

// unshift shift
drink = ['물', '주스', '커피'];
data = drink.shift();
console.log(data);
console.log(drink);

drink.unshift('맥주');
console.log(drink);

fruit.sort(); // 원본을 정렬
console.log(fruit);

let idx = fruit.indexOf("블루베리");
console.log('블루베리의 위치: ' + idx);





