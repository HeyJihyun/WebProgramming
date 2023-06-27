package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import biz.user.UserVO;
import controller.Controller;

public class MyBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String id = ((UserVO) session.getAttribute("user")).getUser_id();

        BoardDAO baordDAO = new BoardDAO();
        int total = baordDAO.getBoardTotal(id);
        int lastPage = (int) Math.ceil((double) total / 10);
        int vpage = Integer.parseInt(request.getParameter("vpage") == null ? "1" : request.getParameter("vpage"));

        request.setAttribute("vpage", vpage);

        vpage = (vpage - 1) * 10 + 1;
        List<BoardVO> boardList = baordDAO.getBoardList(vpage, id);

        request.setAttribute("boardList", boardList);
        request.setAttribute("total", total);
        request.setAttribute("lastPage", lastPage);

        return "/jsp/board/myBoardList.jsp";
    }

}
