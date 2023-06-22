package controller.user;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class KakaoLoginController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String id = request.getParameter("kakaoID");
        UserDAO dao = new UserDAO();
        int result = dao.checkId(id, "K");

        if (result == 1) {
            UserVO user = new UserVO();
            user.setUser_id(id);
            user.setUser_pwd("kakao");
            user.setSingup_type("K");
            HttpSession session = request.getSession();

            user = dao.getUser(user);
            session.setAttribute("user", user);
        }

        request.setAttribute("result", result);

        return "/jsp/etc/ajax.jsp";

    }
}