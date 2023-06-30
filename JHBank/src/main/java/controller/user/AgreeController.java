package controller.user;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.AlertVO;
import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class AgreeController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        user = new UserDAO().updateAgree(user);
        int result = 0;
        StringBuilder msg = new StringBuilder();
        if (user.getOpen_agreement() == 1) {
            result = 1;
            Map<String, String> bankMap = new UserDAO().getOpenbankList(user);

            msg.append(bankMap.size() + "개의 은행 ");
            if (bankMap.size() > 0) {
                msg.append(bankMap.keySet().toString());
            }
            msg.append(" 을 불러왔습니다.");
            session.setAttribute("user", user);
        } else {
            msg.append("오류가 발생했습니다. 관리자에게 문의 바랍니다.");
        }

        String url = request.getContextPath() + "/accountList.do";
        request.setAttribute("alert", new AlertVO(result, msg.toString(), null, url));
        return "/jsp/etc/alert.jsp";

    }
}