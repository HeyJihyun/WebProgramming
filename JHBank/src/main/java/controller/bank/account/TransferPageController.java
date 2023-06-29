package controller.bank.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.bank.account.AccountDAO;
import biz.bank.account.AccountVO;
import biz.user.UserVO;
import controller.Controller;

public class TransferPageController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "loginPage.do";
        }
        UserVO user = (UserVO) session.getAttribute("user");
        String id = user.getUser_id();

        List<AccountVO> accountList = new AccountDAO().getAccountList(id);

        String account_id = request.getParameter("account_id");
        AccountVO account = new AccountDAO().getAccount(account_id);
        request.setAttribute("accountList", accountList);
        request.setAttribute("account", account);

        return "/jsp/bank/account/transferPage.jsp";

    }
}