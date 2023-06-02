package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import controller.Controller;

public class getBoardListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        BoardDAO dao = new BoardDAO();
        List<BoardVO> boardList = dao.getBoardList();

        request.setAttribute("boardList", boardList);

        return "getBoardList.jsp";

    }
}
