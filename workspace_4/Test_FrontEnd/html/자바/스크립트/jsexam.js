// 서버에서 받은 데이터
// 분해해서 테이블로 만들어서 htmlk문세에 출력
// 자격증 란에 없으면 자격증 없음이라는 문구가 들어가야함
let receiveddata = [
    { id: '001', name: '홍길동', license: '정보처리기사' },
    { id: '002', name: '임꺽정', license: '빅데이터분석기사' },
    { id: '003', name: '전우치', license: 'ADSP' },
    { id: '004', name: '손오공' },
    { id: '005', name: '사오정', license: '운전면허증' }
];
let table =
    `<table border=1>
        <tbody>
            <tr>
                <th>아이디</th>
                <th>이름</th>
                <th>보유자격증</th>
            </tr>
    `
    ;
let data;
result = document.getElementById("result");
// 결과값
receiveddata.forEach((item, index, receiveddata) => {
    let { id, name, license = "없음" } = item;


    data =
        `<tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>${license}</td>
    </tr>
    
    `
        ;
    table += data;

});
table = table + `</tbody>` + `</table>`;

result.innerHTML = table;