package controller.user;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.AlertVO;
import biz.user.UserVO;
import controller.Controller;

public class AgreePageController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        int result = 0;
        String msg = "";
        String url = "";
        if (user == null) {
            msg = "로그인 해주세요.";
            url = request.getContextPath() + "/loginPage.do";
        } else if (user.getOpen_agreement() == 0) {
            return "/jsp/bank/account/agreePage.jsp";
        } else {
            result = 1;
            msg = "이미 동의 되었습니다.";
            url = request.getContextPath() + "/accountList.do";
        }

        request.setAttribute("alert", new AlertVO(result, msg, null, url));
        return "/jsp/etc/alert.jsp";

    }
}