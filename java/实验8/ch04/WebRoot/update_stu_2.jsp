<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>修改后重写记录页面</title> 
  </head>
  <body> 
    <%
      String driverName = "com.mysql.jdbc.Driver";         //驱动程序名
      String userName = "root";                            //数据库用户名
      String userPwd = "newpassword";                           //密码
      String dbName = "students";                          //数据库名
      String  url1="jdbc:mysql://localhost:3306/"+dbName;
      String url2 ="?user="+userName+"&password="+userPwd;
      String  url3="&useUnicode=true&characterEncoding=GB2312";
      String url =url1+url2+url3;                   //形成带数据库读写编码的数据库连接字
      Class.forName(driverName);
      Connection conn=DriverManager.getConnection(url);          
      String sql="update stu_info set id=?,name=?,sex=?,age=?,weight=?,hight=? where name=? and sex=?";
      PreparedStatement pstmt= conn.prepareStatement(sql);
      request.setCharacterEncoding("GB2312");//设置字符编码，避免出现乱码
      int id=Integer.parseInt(request.getParameter("id"));     
      String name2=request.getParameter("name2");
      String sex2=request.getParameter("sex2");
      int age=Integer.parseInt(request.getParameter("age"));
      float weight=Float.parseFloat(request.getParameter("weight"));
      float hight=Float.parseFloat(request.getParameter("hight"));
      String name=(String) session.getAttribute("name");
      String sex=(String) session.getAttribute("sex");
      pstmt.setInt(1,id);
      pstmt.setString(2,name2);
      pstmt.setString(3,sex2);
      pstmt.setInt(4,age);
      pstmt.setFloat(5,weight);
      pstmt.setFloat(6,hight);
      pstmt.setString(7,name);
      pstmt.setString(8,sex);    
      try{ 
          int n=pstmt.executeUpdate();
          if(n>=1){%>
              重写数据操作成功！<br>
          <%}
          else{%>
             重写数据操作失败！<%=n%><br>
          <%} 
     }catch(Exception e){%>
           重写过程出现异常错误！<br>
           <%=e.getMessage()%>
     <% 
     }
     if(pstmt!=null){ pstmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
