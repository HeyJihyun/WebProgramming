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
		
	   // 아이디와 패스워드 파라미터 가져오기
        String id = request.getParameter("id");
        String password = request.getParameter("pw");

     // Login.txt 파일에서 아이디와 패스워드 읽기
        boolean isUser = false;

        // Login.txt 파일의 절대 경로를 지정하여 파일을 열기
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspaceJSP\\example1\\src\\main\\java\\homework\\Login.txt"))) {
            String line;
            
            // 파일에서 한 줄씩 읽기
            while ((line = br.readLine()) != null) {
                // 줄을 콜론(":")을 기준으로 분할하여 배열에 저장
                String[] userInfo = line.split(":");
                
                // userInfo 배열의 길이가 2이고, 첫 번째 요소가 입력한 아이디와 일치하고 두 번째 요소가 입력한 패스워드와 일치하는 경우
                if (userInfo.length == 2 && userInfo[0].equals(id) && userInfo[1].equals(password)) {
                    // 로그인 성공 처리를 위해 isUser 변수를 true로 설정하고 반복문 종료
                    isUser = true;
                    break;
                }
            }
        }

        // 로그인 결과에 따라 처리
        if (isUser) {
            // 입력한 아이디와 패스워드가 Login.txt 파일에 존재하는 경우
            response.getWriter().println(id + "님 환영!!!!");
        } else {
            // 입력한 아이디와 패스워드가 Login.txt 파일에 존재하지 않는 경우
            response.getWriter().println("없는 아이디! 회원가입 요망!!");
        }

   }
}