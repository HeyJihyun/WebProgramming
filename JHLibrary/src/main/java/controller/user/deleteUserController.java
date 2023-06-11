package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import controller.Controller;

public class deleteUserController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        UserDAO dao = new UserDAO();

        dao.deleteUser(id);

        request.setAttribute("msg", id + "님이 탈퇴되었습니다.");
        request.setAttribute("url", "getUserList.do");
        return "/jsp/alert.jsp";
    }
}
