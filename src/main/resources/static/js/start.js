const koreanPorts = ['인천', '경인', '평택.당진', '부산', '광양', '울산', '대산', '포항', '마산', '군산', '목포', '부산 신항'];

const destinationPorts = {
    'europe': ['LE HAVRE', 'ROTTERDAM', 'ANTWERPEN', 'HAMBURG', 'FELIXSTOWE'],
    'southeast_asia': ['MANILA', 'BANGKOK', 'KAOHSIUNG', 'HONG KONG', 'SINGAPORE'],
    'japan': ['YOKOHAMA', 'MOJI/KITAKYUSHU', 'NAGOYA'],
    'china': ['TIANJIN XINGANG PT', 'QINGDAO', 'SHANGHAI'],
    'usa': ['OAKLAND, CA', 'LOSANGELES', 'NEWYORK']
};

function updateShippingPorts() {
    const shippingPortSelect = document.getElementById("shippingPort");
    const selectedCountry = document.getElementById("shippingPortCountry").value;

    // 기존 옵션 제거
    shippingPortSelect.innerHTML = '<option value="">항구를 선택하세요</option>';

    // 한국 항구 추가
    if (selectedCountry === 'korea') {
        koreanPorts.forEach(port => {
            const option = document.createElement("option");
            option.value = port;
            option.textContent = port;
            shippingPortSelect.appendChild(option);
        });
    }
}

function updateDestinationPorts() {
    const destinationPortSelect = document.getElementById("destinationPort");
    const selectedCountry = document.getElementById("destinationCountry").value;

    // 기존 옵션 제거
    destinationPortSelect.innerHTML = '<option value="">양하지 항구를 선택하세요</option>';

    // 양하지 국가에 따른 항구 추가
    if (selectedCountry) {
        destinationPorts[selectedCountry].forEach(port => {
            const option = document.createElement("option");
            option.value = port;
            option.textContent = port;
            destinationPortSelect.appendChild(option);
        });
    }
}
document.getElementById("emailForm").addEventListener("submit", function (event) {
    event.preventDefault(); // 기본 제출 동작 방지

    const emailInput = document.getElementById("email").value;
    const errorMessage = document.getElementById("error-message");

    // 이메일 정규 표현식
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (emailPattern.test(emailInput)) {
        errorMessage.textContent = ""; // 에러 메시지 지우기
        alert("이메일이 유효합니다!");
        // 여기에 실제 제출 처리 코드를 추가할 수 있습니다.
        // 예: document.getElementById("emailForm").submit();
    } else {
        errorMessage.textContent = "유효하지 않은 이메일 형식입니다.";
    }
});
