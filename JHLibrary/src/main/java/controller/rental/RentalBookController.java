package controller.rental;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.rental.RentalDAO;
import biz.user.UserVO;
import controller.Controller;

public class RentalBookController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        String id = user.getId();
        String isbn = request.getParameter("isbn");

        RentalDAO dao = new RentalDAO();
        dao.insertRental(id, isbn);

        return "index.jsp";
    }
}
