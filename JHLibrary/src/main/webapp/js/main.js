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
  xhr.open("POST", "/JHLibrary/idCheck.do");
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
  const fields = ["id", "password", "checkPassword", "name", "phone"];

  for (let i = 0; i < fields.length; i++) {
    let field = document.getElementById(fields[i]);
    const regex = /\d{3}-\d{3,4}-\d{4}/;

    // 빈칸있는지 확인
    if (field.value === null || field.value === "") {
      field.classList.add("is-invalid");
      isValidForm = false;
    } else if (fields[i] === "phone" && !regex.test(field.value)) {
      field.classList.add("is-invalid");
      isValidForm = false;
    } else if (fields[i] === "id" || fields[i] === "checkPassword") {
      if (field.classList.contains("is-invalid")) {
        isValidForm = false;
      }
    } else {
      field.classList.remove("is-invalid");
      field.classList.add("is-valid");
    }
  }

  return isValidForm;
}

function inputBook() {
  const isbn = document.getElementById("isbn").value;
  if (isbn.trim().length === 13) {
    location.href = "/JHLibrary/inputBook.do?isbn=" + isbn.trim();
  } else {
    document.getElementById("isbn").classList.add("is-invalid");
  }
}

function bookSubmitCheck() {
  if (document.getElementById("isbn").classList.contains("is-invalid")) {
    return false;
  }
}
