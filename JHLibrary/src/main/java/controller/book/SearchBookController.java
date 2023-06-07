package controller.book;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class SearchBookController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String search_item = request.getParameter("search_item");
        String search_txt = request.getParameter("search_txt");

        BookDAO dao = new BookDAO();
        List<BookVO> bookList = dao.getBookList(search_item, search_txt);

        request.setAttribute("bookList", bookList);

        return "/jsp/book/getBookList.jsp";
    }
}
