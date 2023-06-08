package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class getUserListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        UserDAO dao = new UserDAO();

        List<UserVO> userList = dao.getUserList();
        request.setAttribute("userList", userList);

        return "/jsp/user/getUserList.jsp";
    }
}
