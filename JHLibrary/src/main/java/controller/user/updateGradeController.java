package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import controller.Controller;

public class updateGradeController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        UserDAO dao = new UserDAO();

        dao.updateGrade(id);

        request.setAttribute("msg", id + "님이 관리자로 임명되었습니다.");
        request.setAttribute("url", "getUserList.do");
        return "/jsp/alert.jsp";
    }
}
