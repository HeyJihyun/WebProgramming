package controller.bank.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        history.setFrom_bank_cd("JH");
        history.setTo_bank_cd(request.getParameter("bank_cd"));
        history.setH_mount(Integer.parseInt(request.getParameter("balance")));
        history.setFrom_nm(request.getParameter("from_nm"));
        history.setTo_nm(request.getParameter("to_nm"));

        int result = new AccountDAO().transfer(history);
        System.out.println(result);

        return "accountList.do";

    }
}