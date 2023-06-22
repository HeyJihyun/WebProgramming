package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogoutController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.invalidate();

        request.setAttribute("msg", "로그아웃 되었습니다.");
        request.setAttribute("url", "loginPage.do");
        return "/jsp/etc/alert.jsp";
    }
}