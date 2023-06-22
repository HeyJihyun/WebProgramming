package controller.user;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class LoginProcessController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String saveID = request.getParameter("saveID");

        if (saveID == null) {
            Cookie cookie = new Cookie("id", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("id", id);
            response.addCookie(cookie);
        }

        UserVO user = new UserVO();
        user.setUser_id(id);
        user.setUser_pwd(password);
        user.setSingup_type("W");

        UserDAO dao = new UserDAO();

        user = dao.getUser(user);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "main.do";
        } else {
            request.setAttribute("msg", "아이디 또는 비밀번호가 맞지 않습니다.");
            request.setAttribute("url", "loginPage.do");
            return "/jsp/etc/alert.jsp";
        }

    }
}