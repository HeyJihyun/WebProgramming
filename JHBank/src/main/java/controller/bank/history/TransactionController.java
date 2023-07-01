package controller.bank.history;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.bank.history.HistoryDAO;
import biz.bank.history.HistoryVO;
import controller.Controller;

public class TransactionController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String account_no = request.getParameter("account_no");
        String bank_cd = request.getParameter("bank_cd");
        List<HistoryVO> historyList = new HistoryDAO().getHistoryList(account_no, bank_cd);

        if (bank_cd.equals("BGH") || bank_cd.equals("H.J")) {
            System.out.println(historyList);
            long balance = Long.parseLong(request.getParameter("balance"));
            historyList.get(0).setH_balance(balance);
            for (int i = 1; i < historyList.size(); i++) {
                if (historyList.get(i - 1).getH_class().equals("1")) {
                    balance += historyList.get(i - 1).getH_mount();
                    historyList.get(i).setH_balance(balance);
                } else {
                    balance -= historyList.get(i - 1).getH_mount();
                    historyList.get(i).setH_balance(balance);
                }
            }
        }

        request.setAttribute("historyList", historyList);

        return "/jsp/bank/history/transaction.jsp";

    }
}