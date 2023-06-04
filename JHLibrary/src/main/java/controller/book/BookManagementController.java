package controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class BookManagementController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        BookDAO dao = new BookDAO();
        List<BookVO> bookList = dao.getBookList();

        request.setAttribute("bookList", bookList);

        return "/jsp/book/bookManagement.jsp";
    }
}
