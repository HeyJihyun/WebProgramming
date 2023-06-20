<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/jsp/include/top.jsp" />
    <c:if test = "${not empty user}">
    <script>alert("이미 로그인 되었습니다."); location.href = "main.do";</script>
    </c:if>
    <section class="loginSection">
        <form action="${ pageContext.request.contextPath }/loginProcess.do" method="post">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput" name="id" value = "${cookie.id.value }" placeholder="name@example.com"> 
                <label for="floatingInput">Id</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password"> 
                <label for="floatingPassword">Password</label>
            </div>

            <div class="checkbox mb-3">
                <label> <input type="checkbox" name = "saveID" value="check"> Remember me
                </label>
            </div> 
            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        </form>
        <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.2.0/kakao.min.js"
  integrity="sha384-x+WG2i7pOR+oWb6O5GV5f1KN2Ko6N7PTGPS7UlasYWNxZMKQA63Cj/B2lbUmUfuC" crossorigin="anonymous"></script>
<script>
  Kakao.init('0aebe6a45346423e17101d47f32c083e'); // 사용하려는 앱의 JavaScript 키 입력
</script>

<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
    alt="카카오 로그인 버튼" />
</a>
<p id="token-result"></p>

<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost:8080/JHBank/jsp/user/login.jsp',
    });
  }

  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    var token = getCookie('authorize-access-token');

    if(token) {
      Kakao.Auth.setAccessToken(token);
      Kakao.Auth.getStatusInfo()
        .then(function(res) {
          if (res.status === 'connected') {
            document.getElementById('token-result').innerText
              = 'login success, token: ' + Kakao.Auth.getAccessToken();
            console.log('login success, token: ' + Kakao.Auth.getAccessToken());
            alert('login success, token: ' + Kakao.Auth.getAccessToken());
          }
        })
        .catch(function(err) {
          Kakao.Auth.setAccessToken(null);
        });
    }
  }

  function getCookie(name) {
    var parts = document.cookie.split(name + '=');
    if (parts.length === 2) { return parts[1].split(';')[0]; }
  }
</script>
    </section>
    <jsp:include page="/jsp/include/bottom.jsp" />
    </body>

    </html>