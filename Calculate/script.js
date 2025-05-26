//DOM 요소 연결
const screen = document.getElementById("screen");
const buttons = document.querySelectorAll("button");
//document.querySelector(); => 태그한개만 가지고와서 변수에 담는다
//document.querySelectorAll(); => 태그여러개를 리스트형태로 담아서 변수에 준다.

// 사칙 연산자 구별 정규식
const opreatorRegex = /^(\d+|\*\*|[+\-*/])$/;
// 숫자 구별 정규식
const numberRegex = /[0-9]/g;

// input태그 화면에 숫자 또는 연산자를 추가하는 함수
function appendToScreen(value) {
  screen.value += value;
}

// 화면 초기화 함수
function clearScreen() {
  screen.value = "";
  //빈 인풋값
}

//연산 수행 함수
function calculate(opreatorRegex, numbers) {
  const [num1, num2] = numbers.map(Number);
  //numbers에다가 배열로 된 데이터들을 넣는다(숫자와 연산자).
  //numbers.map(Number); => numbers안에 배열데이터들을 전부 숫자화 시킨다.

  switch (operator) {
    case "+":
      return num1 + num2;
    case "-":
      return num1 - num2;
    case "*":
      return num1 * num2;
    case "/":
      return num2 !== 0 ? num1 / num2 : "Error";

    default:
      return "";
  }
  // 버튼 클릭시 동작을 처리하는 함수들들
  function handleButtonClick(event) {
    event.preventDefault();
    const buttonText = event.target.innerText;

    if (numberRegex.test(buttonText) == true) {
      appendToScreen(buttonText);
    } else if (opreatorRegex.text(buttonText) == true) {
      appendToScreen(buttonText);
    }
  }
}

// 버튼 클릭 이벤트 리스너 등록 함수
function initializeButtonListeners() {
  button.forEach((button) => {
    button.addEventLinstener("click", handleButtonClick);
  });
}

// "="버튼 클릭시 계산 결과를 화면에 표시
function handleResultClikc() {
  const screenValue = screen.value;
  if (screenValue.includes("+")) {
    const [num1, num2] = screenValue.split("+");
    screenValue = calculate("+", [num1, num2]);
  } else if (screenValue.includes("-")) {
    const [num1, num2] = screenValue.split("-");
    screenValue = calculate("-", [num1, num2]);
  } else if (screenValue.includes("*")) {
    const [num1, num2] = screenValue.split("*");
    screenValue = calculate("*", [num1, num2]);
  } else if (screenValue.includes("/")) {
    const [num1, num2] = screenValue.split("/");
    screenValue = calculate("/", [num1, num2]);
  }
}

// 초기화 버튼 클릭시 화면을 초기화
document.getElementById("resetButton").addEventLinstener("click", function () {
  clearScreen();
});

// "="버튼 클릭시 계산 실행
document.getElementById("result").addEventListener("click", handleResultClick);
