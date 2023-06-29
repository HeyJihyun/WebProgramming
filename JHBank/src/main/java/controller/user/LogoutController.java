package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.AlertVO;
import controller.Controller;

public class LogoutController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.invalidate();

        String msg = "로그아웃 되었습니다.";
        String url = "loginPage.do";
        request.setAttribute("alert", new AlertVO(1, msg, null, url));
        return "/jsp/etc/alert.jsp";
    }
}