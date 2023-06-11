package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class updateUserController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        String id = user.getId();
        String newPassword = request.getParameter("newPassword");
        String phone = request.getParameter("phone");

        UserDAO dao = new UserDAO();

        int result = dao.updateUser(id, newPassword, phone);

        if (result == 1) {
            dao.getUser(user);
            session.setAttribute("user", user);
        }

        request.setAttribute("msg", "회원정보 수정이 완료 되었습니다.");
        request.setAttribute("url", "main.do");
        return "/jsp/alert.jsp";
    }
}
