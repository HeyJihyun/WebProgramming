package controller.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import controller.Controller;

public class UpdateBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(request.getParameter("seq")));
        vo.setTitle(request.getParameter("title"));
        vo.setContent(request.getParameter("content"));
        vo.setHit(Integer.parseInt(request.getParameter("hit")));

        BoardDAO dao = new BoardDAO();
        dao.updateBoard(vo);

        return "getBoardList.do";
    }
}
