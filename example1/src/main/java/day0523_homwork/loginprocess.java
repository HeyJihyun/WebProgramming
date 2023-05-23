package day0523_homwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginprocess
 */
@WebServlet("/loginprocess")
public class loginprocess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginprocess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
	    String password = request.getParameter("password");

	    if (idCheck(id, password)) {
	        session.setAttribute("id", id);
	        response.sendRedirect("./day0523_homwork/main.jsp");
	        // 3. 등록되지 않은 사용자면 error 페이지로 이동
	    } else 
	    	response.sendRedirect("./day0523_homwork/error.jsp");
	}
	
	private boolean idCheck(String id, String pw) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspaceJSP\\example1\\src\\main\\webapp\\day0523_homwork\\Login.txt"));
		String info;
		while((info = br.readLine()) != null) {
			String[] parts = info.split(":");
			if(parts[0].equals(id) && parts[1].equals(pw)) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
	}

}
