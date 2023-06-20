package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import controller.Controller;

public class GetBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        int b_no = Integer.parseInt(request.getParameter("b_no"));
        BoardVO board = new BoardDAO().getBoard(b_no);

        request.setAttribute("board", board);
        return "/jsp/board/getBoard.jsp";
    }

}
