let ary = [10, 11, 100, 101, 1001];
console.log(`배열의 크기: ${ary.length}`)
/*
    1) foreach() 는 배열의 모든 데이터에 접근하여 합계구하
*/
let total = 0;
ary.forEach(function (item, index, ary) {
    console.log(item + " ," + index + ", " + ary);
    total += item;
});
console.log(`배열의총합:${total}`)

// 2) 위 예제를 화살표함수로변경
total = 0;
ary.forEach(item => total += item);
console.log(`배열의총합2:${total}`)

// ============================================

/*
    map() : 배열의 요소를 변경
    배열요소 전체를 순회 그 결과값으로 새로운 배열을 만들어서 반환
    원본의 값은 변경하지않는다
*/
let result = ary.map(item => item * 2);
console.log(`map으로처리한결과~:${result}`);
console.log(`원본~:${ary}`);

/*
    filter() : 배열의 요소의 데이터를 필터링하여 원하는 데이터만 추출
    배열요소 전체를 순회 연산의결과가 true 인 데이터만 모아
    그 요소들로 묶은 새로운 배열을 반환 원본의 값은 변경하지 않는다
    
*/
result = ary.filter(item => { if (item % 2 == 0) return true });
result1 = ary.filter(item => { if ((item % 2)) return !true });
console.log(`filter로처리한결과~:${result}`);
console.log(result1 == true);
console.log(`filter로처리한결과~:${result1}`);

let a = [];
console.log(a == false);























