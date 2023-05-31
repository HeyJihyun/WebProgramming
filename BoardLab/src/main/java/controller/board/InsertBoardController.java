package controller.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import biz.user.UserVO;
import controller.Controller;

public class InsertBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();

        BoardVO vo = new BoardVO();
        vo.setTitle(request.getParameter("title"));
        vo.setWriter(((UserVO) session.getAttribute("user")).getId());
        vo.setTitle(request.getParameter("content"));

        BoardDAO dao = new BoardDAO();
        dao.insertBoard(vo);

        return "ok.jsp";
    }
}
