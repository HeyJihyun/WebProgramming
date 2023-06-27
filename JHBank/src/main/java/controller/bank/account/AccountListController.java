package controller.bank.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.bank.account.AccountDAO;
import biz.bank.account.AccountVO;
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

        request.setAttribute("accountList", accountList);

        return "/jsp/bank/account/accountList.jsp";

    }
}