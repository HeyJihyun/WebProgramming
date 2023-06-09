package controller.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.AlertVO;
import biz.board.BoardDAO;
import biz.board.BoardVO;
import biz.user.UserVO;
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

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        BoardVO board = new BoardVO();
        board.setTitle(title);
        board.setContent(content);
        board.setUser_id(user.getUser_id());
        board.setName(user.getUser_name());
        board.setParent_id(b_no);

        int result = new BoardDAO().insertBoard(board);

        String msg = "";
        if (result == 1) {
            msg = "답글이 등록되었습니다.";
        } else {
            msg = "답글 등록에 실패하였습니다. 잠시후 다시 시도해주세요.";
        }
        request.setAttribute("alert", new AlertVO(result, msg, null, "getBoardList.do"));
        return "/jsp/etc/alert.jsp";

    }

}