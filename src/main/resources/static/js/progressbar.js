// 게이지바 조작
const progressGaugeBar = document.getElementById('progress-gauge-bar');
const progressSteps = document.getElementById('progress-arrow-steps');
const progressDivs = progressSteps.querySelectorAll('div[data-progress]');
const count = progressDivs.length;

// 포인터 조작
const dataConatainer = document.getElementById('data-container');
const process = dataConatainer.dataset.process;
const currentStep = process;

console.log("process 확인")
console.log(process)
// 진행 상황 업데이트 함수
function updateProgressBar(currentStep) {
    const progressArrowSteps = document.getElementById("progress-arrow-steps")
    const progressTextSteps = document.getElementById("progress-text-steps")

    var progressArrowPointers = progressArrowSteps.querySelectorAll('.pointer');
    progressArrowPointers.forEach((step, index) => {
    if (step.dataset.progress === currentStep) {
      progressArrowPointers[index].classList.add("current");
    }
  });
    var progressTextPointers = progressTextSteps.querySelectorAll('.pointer');
    progressTextPointers.forEach((step, index) => {
      if (step.dataset.progress === currentStep) {
        progressTextPointers[index].classList.add("current");
      }
    });

    // Calculate percentage and update progress bar and percentage display
    let gaugeValue = Math.round((process / count) * 100, 1);
    progressGaugeBar.value = gaugeValue;
    const progressPercentage = document.querySelector('.progress-percentage');
    progressPercentage.textContent = `${gaugeValue}%`;

  }

// 초기화
updateProgressBar(currentStep);