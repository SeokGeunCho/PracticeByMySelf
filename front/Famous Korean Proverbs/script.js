// HTML에서 특정 부분(태그)을 가져와서 사용 준비를 합니다.
const quoteDisplayArea = document.querySelector("#quoteContainer");  // 명언을 보여주는 전체 영역
const currentQuote = document.querySelector("#quote");               // 명언 텍스트가 들어갈 곳
const loadingSpinner = document.getElementById("loader");           // "로딩중..." 표시하는 부분
const favoriteQuoteList = document.getElementById("quotePickList"); // 즐겨찾기 명언을 모아놓는 목록
const nextQuoteButton = document.getElementById("nextQuote");       // 다음 명언 보기 버튼
const svarQuoteButton = document.getElementById("selectQuote");     // 명언 저장(선택) 버튼

let currentQuoteText = "";     // 지금 보고 있는 명언을 저장해두는 변수
let isQuoteSaved = false;      // 이 명언이 이미 저장되었는지 알려주는 표시 (처음엔 저장 안 됐음)

// 로딩중일 때: 명언은 안 보이고 "로딩중..." 만 보이게 하기
function showLoadingSpinner() {
  loadingSpinner.style.display = "block";      // 로딩은 보이게
  quoteDisplayArea.style.display = "none";     // 명언은 안 보이게
}

// 로딩이 끝났을 때: "로딩중..." 숨기고 명언을 보여주기
function hideLoadingSpinner() {
  loadingSpinner.style.display = "none";       // 로딩은 숨기기
  quoteDisplayArea.style.display = "block";    // 명언은 보이게
}

// 인터넷에서 한국어 명언 하나를 가져오는 함수
async function fetchKoreaQuotes() {
  showLoadingSpinner();  // 명언을 가져오는 동안 "로딩중..." 보이게

  const apiUrl = "https://korean-advice-open-api.vercel.app/api/advice";  // 명언을 가져올 주소
  try {
    const response = await fetch(apiUrl);  // 인터넷에서 명언을 가져와요
    const data = await response.json();    // 가져온 데이터를 보기 쉽게 바꿔요

    currentQuoteText = data.message;                 // 명언만 골라서 저장
    currentQuote.innerText = currentQuoteText;       // 명언을 화면에 보여주기
    localStorage.setItem("currentQuote", currentQuoteText); // 지금 명언을 컴퓨터에 잠깐 저장
    isQuoteSaved = false;                            // 아직 저장 안 했다는 표시
  } catch (error) {
    console.log(`에러 발생: ${error}`);              // 명언을 못 가져오면 에러 메시지
    currentQuote.innerText = "명언을 불러올 수 없습니다. 다시 시도해주세요."; // 화면에 실패 알림
  }

  hideLoadingSpinner();  // 명언을 다 가져오면 "로딩중..." 숨기기
}

// 즐겨찾기 목록에 이 명언이 이미 들어있는지 확인하는 함수
function isQuoteAlreadyInList(quote) {
  const listItems = favoriteQuoteList.getElementsByTagName("li");  // 모든 명언 목록을 가져오기

  for (const item of listItems) {
    if (item.innerText.replace("삭제", "").trim() === quote) {
      // 같은 명언이 있다면 true (이미 있음)
      return true;
    }
  }
  return false; // 없으면 false (새로운 명언임)
}

// 명언을 즐겨찾기에 저장하는 함수
function saveFavoriteQuote() {
  const storedQuote = localStorage.getItem("currentQuote");  // 지금 화면에 보이는 명언을 가져옴

  // 아직 저장 안 했고, 명언이 있고, 목록에 같은 게 없을 때만 저장
  if (!isQuoteSaved && storedQuote !== null && !isQuoteAlreadyInList(storedQuote)) {
    const listItem = document.createElement("li");   // 새로운 목록 줄 만들기
    listItem.innerText = storedQuote;                // 줄에 명언 텍스트 넣기

    // 삭제 버튼 만들기
    const deleteButton = document.createElement("button");
    deleteButton.innerText = "삭제";                  // 버튼에 글씨 "삭제"
    deleteButton.style.marginLeft = "10px";           // 명언과 버튼 사이 약간 띄우기

    // 삭제 버튼을 누르면 이 명언 줄을 삭제하기
    deleteButton.addEventListener("click", () => {
      favoriteQuoteList.removeChild(listItem);        // 이 줄을 목록에서 지우기
      isQuoteSaved = false;                           // 다시 저장 가능하게 표시 바꾸기
    });

    listItem.appendChild(deleteButton);               // 명언 줄에 삭제 버튼 붙이기
    favoriteQuoteList.appendChild(listItem);          // 전체 목록에 명언 줄 추가하기
    isQuoteSaved = true;                              // 저장했다고 표시하기
  } else if (isQuoteSaved) {
    alert("이 명언은 이미 저장되었습니다.");         // 이미 저장했을 때
  } else {
    alert("이 명언은 이미 즐겨찾기에 추가되었습니다."); // 중복 방지용
  }
}

// 버튼을 눌렀을 때 어떤 함수가 실행될지 정해주는 코드
nextQuoteButton.addEventListener("click", fetchKoreaQuotes); // "다음 명언" 버튼 → 새로운 명언 가져오기
svarQuoteButton.addEventListener("click", saveFavoriteQuote); // "선택" 버튼 → 명언 저장하기

// 페이지가 처음 열릴 때 바로 명언 하나 가져오기
fetchKoreaQuotes();
