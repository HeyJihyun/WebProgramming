package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;

public class DeleteBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int seq = Integer.parseInt(request.getParameter("seq"));

        BoardVO vo = new BoardVO();
        vo.setSeq(seq);
        vo.setTitle(request.getParameter("title"));
        vo.setContent(request.getParameter("content"));

        BoardDAO dao = new BoardDAO();
        dao.deleteBoard(vo);

        return "getBoardList.do";
    }
}
