package controller.board;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import controller.Controller;

public class SearchBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String search = request.getParameter("search");
        String content = request.getParameter("content");

        BoardDAO dao = new BoardDAO();
        List<BoardVO> boardList = dao.searchBoard(search, content);

        request.setAttribute("boardList", boardList);

        return "getBoardList.jsp";

    }
}
