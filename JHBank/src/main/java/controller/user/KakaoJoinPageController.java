package controller.user;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class KakaoJoinPageController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String id = request.getParameter("userid");
        String name = request.getParameter("name");

        request.setAttribute("kakaoID", id);
        request.setAttribute("kakaoName", name);

        return "/jsp/user/kakaoJoin.jsp";

    }
}