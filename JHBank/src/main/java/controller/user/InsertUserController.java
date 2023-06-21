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
        String signup_type = request.getParameter("signup_type");
        if (signup_type == null) {
            signup_type = "W";
        }
        UserVO user = new UserVO();
        user.setUser_id(request.getParameter("id"));
        user.setUser_pwd(request.getParameter("password"));
        user.setUser_name(request.getParameter("name"));
        user.setUser_birthday(request.getParameter("birthday"));
        user.setPhone_no(request.getParameter("phone"));
        user.setSingup_type(signup_type);
        user.setPostcode(request.getParameter("postcode"));
        user.setAddress(request.getParameter("address"));
        user.setDetail_address(request.getParameter("detailAddress"));

        int result = new UserDAO().insertUser(user);
        String msg = "";
        if (result == 1) {
            msg = "회원가입이 완료되었습니다.";
        } else {
            msg = "오류가 발생하였습니다. 잠시 후 다시 시도해주세요.";
        }

        request.setAttribute("msg", msg);
        request.setAttribute("url", request.getContextPath() + "/jsp/user/login.jsp");
        return "/jsp/etc/alert.jsp";

    }
}