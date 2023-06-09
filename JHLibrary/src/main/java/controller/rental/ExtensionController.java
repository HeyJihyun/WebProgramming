package controller.rental;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.rental.RentalDAO;
import controller.Controller;

public class ExtensionController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        int r_no = Integer.parseInt(request.getParameter("r_no"));

        RentalDAO dao = new RentalDAO();
        int result = dao.extension(r_no);
        request.setAttribute("msg", result + "권의 책이 연장완료 되었습니다.");
        request.setAttribute("url", "rentalList.do");
        return "/jsp/alert.jsp";
    }
}
