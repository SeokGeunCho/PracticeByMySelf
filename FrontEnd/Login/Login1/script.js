// 📌 요소 선택
const wapperBox = document.getElementById("wrapper"); // 전체 wrapper div
const inputFieldGroup = document.getElementsByClassName("inputGroup"); // 입력 그룹 전체
const allInput = document.querySelector("input"); // 첫 번째 input 요소
const userNickname = document.getElementById("nickname"); // 사용자 이름 input
const userEmail = document.getElementById("email"); // 이메일 input
const userPassword = document.getElementById("userPassword"); // 비밀번호 input
const confirmPassword = document.getElementById("confirmPassword"); // 비밀번호 확인 input
const userPhone = document.getElementById("phone"); // 전화번호 input
const registrationForm = document.getElementById("registrationForm"); // 폼 요소

// ✅ helperText(도움말 텍스트)에 메시지와 유효 상태를 업데이트
const updateHelperText = (input, message, isValid) => {
  const inputGroup = input.parentElement; // 부모 div.inputGroup
  const helperText = inputGroup.getElementsByClassName("helperText")[0]; // span.helperText

  if (isValid == true) {
    inputGroup.classList.remove("invalid"); // 에러 스타일 제거
    inputGroup.classList.add("valid"); // 성공 스타일 추가
    helperText.style.visibility = "hidden"; // 도움말 숨기기
  }
  if (isValid == false) {
    inputGroup.classList.remove("valid"); // 성공 스타일 제거
    inputGroup.classList.add("invalid"); // 에러 스타일 추가
    helperText.style.visibility = "visible"; // 도움말 보이기
    helperText.innerText = message; // 에러 메시지 출력
  }
};

// ✅ 공백 입력인지 검사
const checkEmptyInput = (input) => {
  if (input.value.trim() === "") {
    updateHelperText(input, "값을 입력해주세요.", false);
    return false;
  } else {
    updateHelperText(input, "", true);
    return true;
  }
};

// ✅ 이메일 형식 유효성 검사
const validateEmailFormat = (input) => {
  const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i; // 기본 이메일 정규식
  if (emailPattern.test(input.value.trim()) == true) {
    updateHelperText(input, "", true);
    return true;
  } else {
    updateHelperText(input, "유효한 이메일 주소를 입력부탁드립니다.", false);
    return false;
  }
};

// ✅ 비밀번호 강도 검사 (문자 + 숫자 + 특수문자, 8~15자)
const checkPasswordStrength = (password) => {
  const strongPattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
  if (strongPattern.test(password.value.trim()) == true) {
    updateHelperText(password, "비밀번호 강도:강함", true);
    return true;
  } else {
    updateHelperText(
      password,
      "비밀번호는 8자이상이어야하며, 대문자, 소문자,특수문자를 포함하여야 합니다.",
      false
    );
    return false;
  }
};

// ✅ 비밀번호와 비밀번호 확인 일치 검사
const validatePasswordMatch = (passwordInput, confirmInput) => {
  if (passwordInput.value !== confirmInput.value) {
    updateHelperText(confirmInput, "비밀번호가 일치하지 않습니다.", false);
    return false;
  } else {
    updateHelperText(confirmInput, "", true);
    return true;
  }
};

// ✅ 전화번호 형식 유효성 검사
const validatePhoneNumber = (input) => {
  const phonePattern = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/; // 한국 휴대폰 번호
  if (phonePattern.test(input.value.trim())) {
    updateHelperText(input, "", true);
    return true;
  } else {
    updateHelperText(
      input,
      "유효한 전화번호를 입력해주세요.(예:010-1234-1234)",
      false
    );
    return false;
  }
};

// ✅ 폼 전체 유효성 검사 (각 필드별 검사 결과를 AND 연산으로 반환)
const validateForm = () => {
  const isNicknameValid = checkEmptyInput(userNickname);
  const isEmailValid = validateEmailFormat(userEmail);
  const isPasswordStrong = checkPasswordStrength(userPassword);
  const isPasswordMatch = validatePasswordMatch(userPassword, confirmPassword);
  const isPhoneValid = validatePhoneNumber(userPhone);

  return (
    isNicknameValid &&
    isEmailValid &&
    isPasswordStrong &&
    isPasswordMatch &&
    isPhoneValid
  );
};

// ✅ 폼 제출 시 유효성 검사
registrationForm.addEventListener("submit", (e) => {
  e.preventDefault(); // 기본 제출 이벤트 막기 (페이지 새로고침 방지)

  if (validateForm() == true) {
    console.log("모든 필드가 유효합니다. 즉 사용이 가능합니다.");
  } else {
    console.log(
      "위 필드중 일부분이 에러가 발생합니다. 유효성 검사가 실패 하였습니다."
    );
  }
});

// ✅ 입력값이 바뀔 때마다 즉시 검증 수행 (실시간 피드백)
document.querySelectorAll("input").forEach((input) => {
  input.addEventListener("input", () => {
    switch (input.id) {
      case "nickname":
        checkEmptyInput(input);
        break;
      case "email":
        validateEmailFormat(input);
        break;
      case "userPassword":
        checkPasswordStrength(input);
        break;
      case "confirmPassword":
        validatePasswordMatch(userPassword, confirmPassword);
        break;
      case "phone":
        validatePhoneNumber(input);
        break;
    }
  });
});
