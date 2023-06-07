package controller.book;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import controller.Controller;

public class UpdateBookController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int b_no = Integer.parseInt(request.getParameter("b_no"));
        String b_status = request.getParameter("b_status");

        int result = new BookDAO().updateBook(b_no, b_status);

        request.setAttribute("msg", result + "권의 책이 수정되었습니다.");
        request.setAttribute("url", "getBookList.do");
        return "/jsp/alert.jsp";

    }
}
