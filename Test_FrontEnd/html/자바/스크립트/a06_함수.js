// alert("경고창");

// 매개변수위치에 ... 연산자 사용하기
function add(a, b) {
    return a + b;
}
let result = add(10, 20);
console.log(`합계의결과 :${result}`);

result = add(1, 2, 3, 4);
console.log(`합계의 결과2: ${result}`) // 에러 안나오고 2개 값만 더해서 반환함=> 매개변수를 늘려도 처리할수 있도록 만들고싶음


function add1(a, b, ...c) {
    // 1) 매개변수 위치에 ...사용하기
    // ...연산자는 전달된 모든 데이터를 배열의 형태로 받는 문법
    console.log(a);
    console.log(b);
    console.log(c); //  배열의 형태로 데이터를 받는다 => 몇개의 데이터를 받앗는지확인하고자 하면 length
    console.log("배열로 받은데이터의 개수: " + c.length);
    console.log(arguments); // 실제 데이터가 몇개 전달되었는지 알려주는 속성값 내부 property

    return a + b;
}
result = add1(1, 23, 4, 5, 6);
console.log(`합계의결과3: ${result}`);

// ===================================2) 함수를 반환하는 함수 -1


function temp() {
    return function () {
        console.log(2 * 3);
    }
}

let x = temp();

x(); // 6 을 반환

temp()(); // 6을 반환

// ===================================3) 함수를 반환하는 함수 -2 
function temp2(a, b) {
    let result = a * b;
    console.log(result);

    return function () {
        return result;
    }
}

console.log(temp2(5, 7)());



















