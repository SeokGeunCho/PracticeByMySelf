const wapperBox = document.getElementById("wrapper");
const inputFieldGroup = document.getElementsByClassName("inputGroup");
const allInput = document.querySelector("input");
const userNickname = document.getElementById("nickname");
const userEmail = document.getElementById("email");
const userPassword = document.getElementById("userPassword");
const confirmPassword = document.getElementById("confirmPassword");
const userPhone = document.getElementById("phone");
const registrationForm = document.getElementById("registrationForm");

const updateHelperText = (input, message, isValid) => {
  const inputGroup = input.parentElement;

  const helperText = inputGroup.getElementsByClassName("helperText")[0];

  if (isValid == true) {
    inputGroup.classList.remove("invalid");
    inputGroup.classList.add("valid");
    helperText.style.visibility = "hidden";
  }
  if (isValid == false) {
    inputGroup.classList.remove("valid");
    inputGroup.classList.add("invalid");
    helperText.style.visibility = "visible";
    helperText.innerText = message;
  }
};

const checkEmptyInput = (input) => {
  if (input.value.trim() === "") {
    updateHelperText(input, "값을 입력해주세요.", false);
    return false;
  } else {
    updateHelperText(input, "", true);
    return true;
  }
};

const validateEmailFormat = (input) => {
  const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
  if (emailPattern.test(input.value.trim()) == true) {
    updateHelperText(input, "", true);
    return true;
  } else {
    updateHelperText(input, "유효한 이메일 주소를 입력부탁드립니다.", false);
    return false;
  }
};

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

const validatePasswordMatch = (passwordInput, confirmInput) => {
  if (passwordInput.value !== confirmInput.value) {
    updateHelperText(confirmInput, "비밀번호가 일치하지 않습니다.", false);
    return false;
  } else {
    updateHelperText(confirmInput, "", true);
    return true;
  }
};

const validatePhoneNumber = (input) => {
  const phonePattern = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
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

registrationForm.addEventListener("submit", (e) => {
  e.preventDefault();
  if (validateForm() == true) {
    console.log("모든 필드가 유효합니다. 즉 사용이 가능합니다.");
  } else {
    console.log(
      "위 필드중 일부분이 에러가 발생합니다. 유효성 검사가 실패 하였습니다."
    );
  }
  console.log(e);
});

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
