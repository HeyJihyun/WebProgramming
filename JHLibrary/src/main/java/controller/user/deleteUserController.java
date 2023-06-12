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

        int result = dao.deleteUser(id);

        String msg = "";
        if (result == 1) {
            msg = id + "님이 탈퇴되었습니다.";
        } else {
            msg = "회원탈퇴에 실패했습니다. 대여목록을 확인해주세요.";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", "getUserList.do");
        return "/jsp/alert.jsp";
    }
}
