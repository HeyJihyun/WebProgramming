package controller.book;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class UpdateBookPageController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String isbn = request.getParameter("isbn");

        List<BookVO> list = new BookDAO().getBook(isbn);

        request.setAttribute("bookList", list);

        return "/jsp/book/updateBook.jsp";

    }
}
