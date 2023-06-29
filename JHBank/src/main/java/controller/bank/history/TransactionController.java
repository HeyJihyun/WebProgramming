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
        List<HistoryVO> historyList = new HistoryDAO().getHistoryList(account_no);

        request.setAttribute("historyList", historyList);

        return "/jsp/bank/history/transaction.jsp";

    }
}