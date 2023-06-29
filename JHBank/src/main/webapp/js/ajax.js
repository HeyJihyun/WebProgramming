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

function checkAccount() {
  let account_no = $("#account_no").val();
  let bank_cd = $("#bank_cd").val();

  $.ajax({
    url: "/JHBank/checkAccount.do",
    method: "POST",
    data: { account_no: account_no, bank_cd: bank_cd },
    success: function (response) {
      console.log(response);
      if (response.trim() === "") {
        $("#result").text("계좌가 존재하지 않습니다.");
      } else {
        $("#result").text("");
        $("#to_nm").val(response);
      }
    },
    error: function () {
      $("#result").text("계좌 확인 중 오류가 발생했습니다.");
    },
  });
}
