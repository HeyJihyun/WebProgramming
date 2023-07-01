window.Kakao.init("0aebe6a45346423e17101d47f32c083e");

function kakaoLogin() {
  window.Kakao.Auth.login({
    scope: "profile_nickname, account_email, gender, birthday, age_range",
    success: function (authObj) {
      console.log(authObj);
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
          const kakao_account = res.kakao_account;
          console.log(kakao_account);
          console.log(kakao_account.email);
          console.log(res);
          console.log(res.properties.nickname);
          Kakao.Auth.logout();

          let kakaoID = kakao_account.email + "K";
          $.ajax({
            url: "/JHBank/kakaoLogin.do",
            type: "get",
            data: {
              kakaoID: kakaoID,
            },

            success: function (response) {
              console.log(response);
              if (response.trim() === "0") {
                $().ready(function () {
                  Swal.fire({
                    icon: "warning", // Alert 타입
                    title: "가입 페이지로 이동합니다.", // Alert 제목
                    text: "가입되지 않은 카카오 아이디입니다.", // Alert 내용
                  }).then(function () {
                    let f = document.createElement("form");

                    let obj;
                    obj = document.createElement("input");
                    obj.setAttribute("type", "hidden");
                    obj.setAttribute("name", "userid");
                    obj.setAttribute("value", kakaoID);

                    let obj2;
                    obj2 = document.createElement("input");
                    obj2.setAttribute("type", "hidden");
                    obj2.setAttribute("name", "name");
                    obj2.setAttribute("value", res.properties.nickname);

                    f.appendChild(obj);
                    f.appendChild(obj2);
                    f.setAttribute("method", "post");
                    f.setAttribute("action", "/JHBank/kakaoJoinPage.do");
                    document.body.appendChild(f);
                    f.submit();
                  });
                });
              } else {
                console.log("로그인 짠짠!!");
                location.href = "/JHBank/";
              }
              // 세션 저장이 완료되었을 때 index.jsp로 이동
            },
            error: function (xhr, status, error) {
              console.log("세션에 카카오 ID 저장 실패");
              // 실패 시에도 index.jsp로 이동
            },
          });
        },
      });
    },
  });
}

function kakaoLogout() {
  Kakao.Auth.logout(function (response) {
    if (response === true) {
      console.log("카카오 로그아웃 성공");
    } else {
      console.log("카카오 로그아웃 실패");
    }
  });
}
