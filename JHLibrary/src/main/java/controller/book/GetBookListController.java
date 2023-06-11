package controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class GetBookListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String sort = request.getParameter("sort");

        BookDAO dao = new BookDAO();
        List<BookVO> bookList = null;
        if (sort == null) {
            bookList = dao.getBookList();
        } else {
            bookList = dao.getBookList(sort);
        }
        request.setAttribute("bookList", bookList);

        return "/jsp/book/getBookList.jsp";
    }
}
