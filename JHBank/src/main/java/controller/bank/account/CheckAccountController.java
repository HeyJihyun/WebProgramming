package controller.bank.account;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.bank.account.AccountDAO;
import controller.Controller;

public class CheckAccountController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String account_no = request.getParameter("account_no");
        String bank_cd = request.getParameter("bank_cd");

        String result = new AccountDAO().checkAccount(account_no, bank_cd);
        request.setAttribute("result", result);

        return "/jsp/etc/ajax.jsp";

    }
}