package controller.bank.account;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.AlertVO;
import biz.bank.account.AccountDAO;
import biz.bank.account.AccountVO;
import biz.user.UserVO;
import controller.Controller;

public class InsertAccountController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();

        AccountVO account = new AccountVO();
        account.setAccount_no(request.getParameter("account_no"));
        account.setAccount_nm(request.getParameter("account_nm"));
        account.setAccount_pwd(request.getParameter("account_pwd"));
        account.setBank_cd("JH");
        account.setDeposit_cd(request.getParameter("deposit_cd"));
        account.setUser_id(((UserVO) session.getAttribute("user")).getUser_id());
        account.setBalance(Long.parseLong(request.getParameter("balance")));

        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        account.setReg_date(date);
        cal.setTime(date);
        cal.add(Calendar.MONTH, Integer.parseInt(request.getParameter("d_period")));
        date = cal.getTime();

        account.setExpiration_date(date);

        System.out.println(account);
        int result = new AccountDAO().insertAccount(account);
        String msg = "";
        if (result == 1) {
            msg = "계좌개설이 완료되었습니다.";
        } else {
            msg = "오류가 발생하였습니다. 잠시 후 다시 시도해주세요.";
        }

        request.setAttribute("alert", new AlertVO(result, msg, null, request.getContextPath()));
        return "/jsp/etc/alert.jsp";

    }
}