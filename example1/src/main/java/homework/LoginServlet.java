package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");
		
	   // ���̵�� �н����� �Ķ���� ��������
        String id = request.getParameter("id");
        String password = request.getParameter("pw");

     // Login.txt ���Ͽ��� ���̵�� �н����� �б�
        boolean isUser = false;

        // Login.txt ������ ���� ��θ� �����Ͽ� ������ ����
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspaceJSP\\example1\\src\\main\\java\\homework\\Login.txt"))) {
            String line;
            
            // ���Ͽ��� �� �پ� �б�
            while ((line = br.readLine()) != null) {
                // ���� �ݷ�(":")�� �������� �����Ͽ� �迭�� ����
                String[] userInfo = line.split(":");
                
                // userInfo �迭�� ���̰� 2�̰�, ù ��° ��Ұ� �Է��� ���̵�� ��ġ�ϰ� �� ��° ��Ұ� �Է��� �н������ ��ġ�ϴ� ���
                if (userInfo.length == 2 && userInfo[0].equals(id) && userInfo[1].equals(password)) {
                    // �α��� ���� ó���� ���� isUser ������ true�� �����ϰ� �ݺ��� ����
                    isUser = true;
                    break;
                }
            }
        }

        // �α��� ����� ���� ó��
        if (isUser) {
            // �Է��� ���̵�� �н����尡 Login.txt ���Ͽ� �����ϴ� ���
            response.getWriter().println(id + "�� ȯ��!!!!");
        } else {
            // �Է��� ���̵�� �н����尡 Login.txt ���Ͽ� �������� �ʴ� ���
            response.getWriter().println("���� ���̵�! ȸ������ ���!!");
        }

   }
}