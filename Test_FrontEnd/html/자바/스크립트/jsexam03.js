// ary에서 1~100 사이의 정수 10개를 발생시켜 추가
let ary = [];
let num;
let idx = [];
for (let i = 0; i < 10; ++i) {
    num = Math.ceil(Math.random() * 100);
    idx.push(num);
    if (num % 2 != 0)
        ary.push(i);

};
// ary.forEach((item, index) => { if (!(item % 2)) idx.push(index) })
// console.log(idx);
// console.log(ary);
console.log(ary, idx);