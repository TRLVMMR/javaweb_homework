package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckServlet extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)
         throws ServletException,IOException{
	  String userName=request.getParameter("username");
	  String userPwd=request.getParameter("userpwd");
	  String info="";
	  if(("abc".equals(userName))&&"123".equals(userPwd)){
		  info="��ӭ��"+userName+"!";
	  }
	  else{
		  info="�û��������벻��ȷ!";
	  }
	  request.setAttribute("outputMessage", info);
	  request.getRequestDispatcher("/info.jsp").forward(request, response);
  }
}