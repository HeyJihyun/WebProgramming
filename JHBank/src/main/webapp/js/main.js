window.onload = function () {
  // mainmenu hover이벤트
  let secondNavs = document.querySelectorAll(".second-nav li");
  let subMenus = document.querySelectorAll(".sub-menu");
  secondNavs.forEach(function (nav) {
    nav.addEventListener("mouseover", function () {
      subMenus.forEach(function (smenu) {
        smenu.style.display = "block";
        document.querySelector(".sub_bg").style.display = "block";
      });
    });
    nav.addEventListener("mouseout", function () {
      subMenus.forEach(function (smenu) {
        smenu.style.display = "none";
        document.querySelector(".sub_bg").style.display = "none";
      });
    });
  });

  // 모바일 버전 메뉴 이벤트
  document.querySelector(".bi-x-lg").addEventListener("click", function () {
    document.querySelector(".mobileMenu").style.display = "none";
  });

  document.querySelector(".bi-list").addEventListener("click", function () {
    document.querySelector(".mobileMenu").style.display = "block";
  });

  // 신간도서, 인기도서 선택
  let bannerNav = document.querySelectorAll(".booksBannerNav li");
  bannerNav.forEach(function (b_li) {
    b_li.addEventListener("click", function () {
      document
        .querySelector(".booksBannerNav .active")
        .classList.remove("active");
      this.classList.add("active");
    });
  });

  // 비밀번호 확인체크
  let checkPassword = document.getElementById("checkPassword");
  checkPassword.addEventListener("change", function () {
    let password = document.getElementById("password");

    if (password.value !== checkPassword.value) {
      checkPassword.classList.add("is-invalid");
    } else {
      checkPassword.classList.remove("is-invalid");
      checkPassword.classList.add("is-valid");
    }
  });
};

// 아이디 중복체크
function checkId() {
  var id = document.getElementById("id");
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "/JHBank/idCheck.do");
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        var response = xhr.responseText;
        console.log(response);
        let msgBox = id.nextElementSibling;
        if (response.trim() === "0") {
          // 아이디가 중복되지 않았을 경우
          id.classList.remove("is-invalid");
          id.classList.add("is-valid");
          // id.readOnly = true;
          msgBox.innerHTML = "사용가능한 아이디입니다.";
          msgBox.classList.remove("invalid-feedback");
          msgBox.classList.add("valid-feedback");
        } else {
          id.classList.remove("is-valid");
          id.classList.add("is-invalid");
          msgBox.innerHTML = "중복된 아이디입니다.";
          msgBox.classList.remove("valid-feedback");
          msgBox.classList.add("invalid-feedback");
        }
      } else {
        // 요청이 실패했을 경우의 처리
        console.error("아이디 중복 체크 요청 실패:", xhr.status);
      }
    }
  };

  var data = "id=" + encodeURIComponent(id.value);
  xhr.send(data);
}

// 회원가입 제출폼 유효성 확인
function submitForm() {
  let isValidForm = true;
  const fields = [
    "id",
    "password",
    "name",
    "postcode",
    "phone",
    "birthday",
    "detailAddress",
    "checkPassword",
  ];

  for (let i = 0; i < fields.length; i++) {
    let field = document.getElementById(fields[i]);
    const regex = /\d{3}-\d{3,4}-\d{4}/;

    if (field != null) {
      // 빈칸있는지 확인
      if (field.value === null || field.value === "") {
        field.classList.add("is-invalid");
        isValidForm = false;

        // 폰넘버 구조식 확인
      } else if (fields[i] === "phone" && !regex.test(field.value)) {
        field.classList.add("is-invalid");
        isValidForm = false;

        // id, password 체크 확인
      } else if (fields[i] === "id" || fields[i] === "checkPassword") {
        if (field.classList.contains("is-invalid")) {
          isValidForm = false;
        }
      } else {
        field.classList.remove("is-invalid");
        field.classList.add("is-valid");
      }
    }
  }

  return isValidForm;
}

function daumPostcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var roadAddr = data.address; // 도로명 주소 변수
      var extraRoadAddr = ""; // 참고 항목 변수

      // 법정동명이 있을 경우 추가한다. (법정리는 제외)
      // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
      if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
        extraRoadAddr += data.bname;
      }
      // 건물명이 있고, 공동주택일 경우 추가한다.
      if (data.buildingName !== "" && data.apartment === "Y") {
        extraRoadAddr +=
          extraRoadAddr !== "" ? ", " + data.buildingName : data.buildingName;
      }
      // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
      if (extraRoadAddr !== "") {
        extraRoadAddr = " (" + extraRoadAddr + ")";
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      document.getElementById("postcode").value = data.zonecode;
      document.getElementById("roadAddress").value = roadAddr;

      var guideTextBox = document.getElementById("guide");
      // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
      if (data.autoRoadAddress) {
        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
        guideTextBox.innerHTML = "(예상 도로명 주소 : " + expRoadAddr + ")";
        guideTextBox.style.display = "block";
      } else {
        guideTextBox.innerHTML = "";
        guideTextBox.style.display = "none";
      }
    },
  }).open();
}