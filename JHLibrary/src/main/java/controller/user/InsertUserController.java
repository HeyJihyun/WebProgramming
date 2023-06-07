package controller.user;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class InsertUserController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        UserVO vo = new UserVO(id, password, name, phone);

        UserDAO dao = new UserDAO();
        dao.insertUser(vo);

        request.setAttribute("msg", "회원가입이 완료되었습니다.");
        request.setAttribute("url", "login.do");
        return "/jsp/alert.jsp";

    }
}
