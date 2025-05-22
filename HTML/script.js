const wapperBox = document.getElementById("wrapper");
const inputFieldGroup = document.getElementsByClassName("inputGroup");
const allInput = document.querySelectorSelector("input");
const userNickname = document.getElementById("nickname");
const userEmail = document.getElementById("email");
const userPassword = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const userPhone = document.getElementById("phone");
const registrationForm = document.getElementById("registrationForm");

const updateHelperText = (input, message, isValid) => {
  const inputGroup = input.parentElement;
  console.log(userEmail.parentElement);
  //한개의 input태그의 부모 태그에 접근하는것,
  //예시로,input태그를 저희가 userEmalil 로 접근하였다고 하면, 아래 태그들의 최상위태그를 의미한다.
  const helperText = inputGroup.getElementsByClassName("helperText")[0];
  // => 알림
  if (isValid == ture) {
    //isValid에는 boolean데이터 true/false가 들어가게끔 만든다.
    inputGroup.classList.remove("invalid");
    inputGroup.classList.add("valid");
    helperText.style.visibility = "hidden";
  }
  if (isValid == false) {
    //isValid에는 boolean데이터 true/false가 들어가게끔 만든다.
    inputGroup.classList.remove("valid");
    inputGroup.classList.add("invalid");
    helperText.style.visibility = "visible";
    helperText.innerText = message;
  }
};

//알림이 사용이되는것까지는 설정을 했는데, 언제 사용이 되야하나, 조건을 설정 안했음
//입력필드가 비어있는지 확인하는 함수 기능을 만든다.
const checkEmptyInput = (input) => {
  if (input.value.trim() === "") {
    //인풋입력칸에 입력한 문자열중 띄어쓰기를 없앤다.
    updateHelperText(input, "값을 입력해주세요.", false);
    return false;
  } else {
    // 입력이 있으면 도움말을 지운다.
    updateHelperText(input, "", ture);
  }
};

//이메일형식이 올바른지 확인하는 함수
//이메일 주소가 규칙에 맞에 작성되었는지 확인하는것!
const validateEmailFromat = (input) => {
  const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
  if (emailPattern.test(input.value.trim()) == true) {
    updateHelperText(input, "", ture);
    return true;
  } else {
    updateHelperText(input, "유효한 이메일 주소를 입력부탁드립니다.", false);
    return false;
  }
  // 이메일 => 정규식
};
