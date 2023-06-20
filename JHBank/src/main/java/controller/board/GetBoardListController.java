package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import controller.Controller;

public class GetBoardListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        BoardDAO baordDAO = new BoardDAO();
        int total = baordDAO.getBoardTotal();
        int lastPage = (int) Math.ceil((double) total / 10);
        int vpage = Integer.parseInt(request.getParameter("vpage") == null ? "1" : request.getParameter("vpage"));

        request.setAttribute("vpage", vpage);

        vpage = (vpage - 1) * 10 + 1;
        List<BoardVO> boardList = baordDAO.getBoardList(vpage);

        request.setAttribute("boardList", boardList);
        request.setAttribute("total", total);
        request.setAttribute("lastPage", lastPage);

        return "/jsp/board/boardList.jsp";
    }

}
