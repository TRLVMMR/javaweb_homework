<%@ page    pageEncoding="UTF-8"%>
<html>
    <head><title>登录处理</title></head>
    <body>
         <%
          String un=request.getParameter("username");
          if(un!=null){
             Cookie c=new Cookie("username",un);
             c.setMaxAge(30*24*3600);
             response.addCookie(c);
             session.setAttribute("username",un);
             response.sendRedirect("main.jsp");
            }
          %>
    </body>
</html>