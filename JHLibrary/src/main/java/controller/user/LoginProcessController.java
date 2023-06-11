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

        UserVO vo = new UserVO();
        vo.setId(id);
        vo.setPwd(password);

        UserDAO dao = new UserDAO();

        if (dao.getUser(vo) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", vo);
            return "main.do";
        } else {
            request.setAttribute("msg", "아이디 또는 비밀번호가 맞지 않습니다.");
            request.setAttribute("url", "login.do");
            return "/jsp/alert.jsp";
        }

    }
}
