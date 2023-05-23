package homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculator
 */
@WebServlet("/Calculator2")
public class Calculator2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (!cookie.getName().equals("count")) {
					String decodedValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
					out.println("<h3>" + decodedValue + "</h3>");
				}
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("./calculator.html");
		rd.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String operator = request.getParameter("operator");

		float result = 0;
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "x":
			result = num1 * num2;
			break;
		case "¡À":
			result = (num1 / (float) num2);
			break;
		}

		int cnt = 0;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("count")) {
				cnt = Integer.parseInt(cookies[i].getValue());
				break;
			}
		}

		String value = num1 + " " + operator + " " + num2 + " = " + result;
		String encodedValue = URLEncoder.encode(value, "UTF-8");
		Cookie cookie = new Cookie(cnt++ + "", encodedValue);
		Cookie cntCookie = new Cookie("count", cnt + "");

		response.addCookie(cookie);
		response.addCookie(cntCookie);
		response.sendRedirect("Calculator2");
	}

}
