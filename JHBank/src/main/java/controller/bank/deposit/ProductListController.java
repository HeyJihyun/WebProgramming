package controller.bank.deposit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.bank.deposit.DepositDAO;
import biz.bank.deposit.DepositVO;
import controller.Controller;

public class ProductListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        DepositDAO dao = new DepositDAO();
        List<DepositVO> depositList = dao.getDepositList();

        request.setAttribute("depositList", depositList);
        return "/jsp/bank/deposit/productList.jsp";

    }
}