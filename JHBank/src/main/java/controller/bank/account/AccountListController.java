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

public class AccountListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "loginPage.do";
        }
        UserVO user = (UserVO) session.getAttribute("user");
        String id = user.getUser_id();

        List<AccountVO> accountList = new AccountDAO().getAccountList(id);

        long sumBalance = 0;
        for (AccountVO account : accountList) {
            sumBalance += account.getBalance();
        }

        request.setAttribute("sumBalance", sumBalance);
        request.setAttribute("accountList", accountList);

        if (user.getOpen_agreement() == 1) {
            Map<String, String> bankMap = new UserDAO().getOpenbankList(user);

            List<List<AccountVO>> openbankAccount = new AccountDAO().getOpenbankList(bankMap);

            request.setAttribute("openbankAccount", openbankAccount);
        }

        return "/jsp/bank/account/accountList.jsp";

    }
}