package controller.bank.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.AlertVO;
import biz.bank.account.AccountDAO;
import biz.bank.history.HistoryVO;
import controller.Controller;

public class TransferController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "loginPage.do";
        }

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HistoryVO history = new HistoryVO();
        history.setFrom_account_no(request.getParameter("from_account_no"));
        history.setTo_account_no(request.getParameter("to_account_no"));
        history.setFrom_bank_cd(request.getParameter("from_bank_cd"));
        history.setTo_bank_cd(request.getParameter("to_bank_cd"));
        history.setH_mount(Long.parseLong(request.getParameter("balance")));
        history.setFrom_nm(request.getParameter("from_nm"));
        history.setTo_nm(request.getParameter("to_nm"));

        int result = new AccountDAO().transfer(history);
        String msg = "";
        if (result == 1) {
            msg = "이체가 완료되었습니다.";
        } else {
            msg = "오류가 발생하였습니다. 잠시 후 다시 시도해주세요.";
        }

        String url = request.getContextPath() + "/accountList.do";
        request.setAttribute("alert", new AlertVO(result, msg, null, url));

        return "/jsp/etc/alert.jsp";

    }
}