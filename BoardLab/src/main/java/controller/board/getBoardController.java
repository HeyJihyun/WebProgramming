package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import controller.Controller;

public class getBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        BoardDAO dao = new BoardDAO();
        int seq = Integer.parseInt(request.getParameter("seq"));
        BoardVO board = dao.getBoard(seq);

        request.setAttribute("board", board);

        return "getBoard.jsp";

    }
}