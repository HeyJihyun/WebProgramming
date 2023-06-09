package controller.rental;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.rental.RentalDAO;
import biz.rental.RentalVO;
import biz.user.UserVO;
import controller.Controller;

public class RentalListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        String url = "";
        if (user == null) {
            request.setAttribute("msg", "로그인이 필요합니다.");
            request.setAttribute("url", "login.do");
            url = "/jsp/alert.jsp";
        } else {
            String id = user.getId();

            RentalDAO dao = new RentalDAO();
            List<RentalVO> rentalList = dao.getRentalList(id);

            request.setAttribute("rentalList", rentalList);
            url = "/jsp/rental/rentalList.jsp";
        }
        return url;
    }
}
