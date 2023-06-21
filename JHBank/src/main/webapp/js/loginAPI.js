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
            url: "http://localhost:8080/JHBank/kakaoLogin.do",
            type: "get",
            data: {
              kakaoID: kakaoID,
            },

            success: function (response) {
              console.log(response);
              if (response.trim() === "0") {
                alert("가입되지 않은 사용자 입니다. 가입화면으로 넘어갑니다.");
                location.href = "/JHBank/joinPage.do";
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

// function kakaoLogout() {
//   Kakao.init("0aebe6a45346423e17101d47f32c083e");
//   Kakao.isInitialized();
//   if (!Kakao.Auth.getAccessToken()) {
//     console.log("Not 뭐래");
//     return;
//   }

//   Kakao.Auth.logout(function () {
//     console.log(KaKao.auth.getAccessToken());
//   });
// }
