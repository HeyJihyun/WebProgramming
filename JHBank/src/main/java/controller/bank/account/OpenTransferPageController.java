package controller.bank.account;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.bank.account.AccountDAO;
import biz.bank.account.AccountVO;
import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class OpenTransferPageController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "loginPage.do";
        }
        UserVO user = (UserVO) session.getAttribute("user");
        String account_no = request.getParameter("account_no");
        String bank_cd = request.getParameter("bank_cd");

        Map<String, String> bankList = new UserDAO().getOpenbankList(user);

        List<AccountVO> accountList = new AccountDAO().getAccountList(bank_cd, bankList.get(bank_cd));
        AccountVO account = new AccountDAO().getAccount(account_no, bank_cd);
        System.out.println(account_no);
        System.out.println(bank_cd);
        System.out.println(account);
        System.out.println(accountList);
        request.setAttribute("accountList", accountList);
        request.setAttribute("account", account);

        return "/jsp/bank/account/transferPage.jsp";

    }
}