package controller.book;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import controller.Controller;

public class DeleteBookController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int b_no = Integer.parseInt(request.getParameter("b_no"));

        int result = new BookDAO().deleteBook(b_no);

        request.setAttribute("msg", result + "권의 책이 삭제되었습니다.");
        request.setAttribute("url", "getBookList.do");
        return "/jsp/alert.jsp";

    }
}
