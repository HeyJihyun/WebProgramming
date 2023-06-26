package controller.bank.account;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.bank.account.AccountDAO;
import biz.bank.deposit.DepositDAO;
import biz.bank.deposit.DepositVO;
import controller.Controller;

public class CreateAccountController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        int deposit_cd = Integer.parseInt(request.getParameter("deposit_cd"));
        DepositVO deposit = new DepositDAO().getDeposit(deposit_cd);

        Random rand = new Random();

        String account_no = "";
        do {
            int no = rand.nextInt(999999999);
            account_no = String.format("%d%09d", deposit.getDeposit_cd(), no);
            System.out.println(account_no);
        } while (new AccountDAO().chackAccount(account_no));

        request.setAttribute("deposit", deposit);
        request.setAttribute("account_no", account_no);

        return "/jsp/bank/account/createAccount.jsp";

    }
}