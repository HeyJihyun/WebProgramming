package controller.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import controller.Controller;

public class InsertReBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int b_no = Integer.parseInt(request.getParameter("b_no"));

        BoardVO board = new BoardVO();
        board.setTitle(title);
        board.setContent(content);
        board.setParent_id(b_no);

        int result = new BoardDAO().insertBoard(board);

        String msg = "";
        if (result == 1) {
            msg = "답글이 등록되었습니다.";
        } else {
            msg = "답글 등록에 실패하였습니다. 잠시후 다시 시도해주세요.";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", "getBoardList.do");
        return "/jsp/etc/alert.jsp";

    }

}