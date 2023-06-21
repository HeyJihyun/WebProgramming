package controller.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardVO;
import controller.Controller;

public class ReBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String title = request.getParameter("title");
        int b_no = Integer.parseInt(request.getParameter("b_no"));

        BoardVO board = new BoardVO();
        board.setTitle(title);
        board.setB_no(b_no);
        request.setAttribute("board", board);

        return "/jsp/board/reBoard.jsp";
    }

}
