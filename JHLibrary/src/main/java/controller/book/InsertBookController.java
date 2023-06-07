package controller.book;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class InsertBookController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String isbn = request.getParameter("isbn");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        BookVO book = new BookVO();
        book.setIsbn13(request.getParameter("isbn"));
        book.setTitle(request.getParameter("title"));
        book.setCover(request.getParameter("cover"));
        book.setAuthor(request.getParameter("author"));
        book.setPubDate(request.getParameter("pubDate"));
        book.setPublisher(request.getParameter("publisher"));
        book.setCategoryName(request.getParameter("categoryName"));
        book.setItemPage(Integer.parseInt(request.getParameter("itemPage")));
        book.setDescription(request.getParameter("description"));

        BookDAO dao = new BookDAO();
        int result = dao.insertBook(book);

        request.setAttribute("msg", result + "권의 책이 등록되었습니다.");
        request.setAttribute("url", "inputBook.do");
        return "/jsp/alert.jsp";
    }
}
