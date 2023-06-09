package controller.rental;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.rental.RentalDAO;
import controller.Controller;

public class ReturnRentalController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        int b_no = Integer.parseInt(request.getParameter("b_no"));

        RentalDAO dao = new RentalDAO();
        int result = dao.returnRental(b_no);
        request.setAttribute("msg", result + "권의 책을 반납하였습니다.");
        request.setAttribute("url", "rentalList.do");
        return "/jsp/alert.jsp";
    }
}