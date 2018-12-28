<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>删除一条记录页面</title> 
  </head>
  <body> 
    <%
      String driverName = "com.mysql.jdbc.Driver";         //驱动程序名
      String userName = "root";                            //数据库用户名
      String userPwd = "123456";                           //密码
      String dbName = "students";                          //数据库名
      String  url1="jdbc:mysql://localhost:3306/"+dbName;
      String url2 ="?user="+userName+"&password="+userPwd;
      String  url3="&useUnicode=true&characterEncoding=GB2312";
      String url =url1+url2+url3;                   //形成带数据库读写编码的数据库连接字
      Class.forName(driverName);
      Connection conn=DriverManager.getConnection(url);      
      String sql="delete from stu_info where weight>=?";
      PreparedStatement stmt=conn.prepareStatement(sql);
      stmt.setFloat(1,80);
      try{ 
          int n= stmt.executeUpdate();
          if(n>=1){%>
              数据删除操作成功！<br>
          <%}
          else{%>
             数据删除操作失败！<br>
          <%} 
     }catch(Exception e){%>
           删除更新过程出现异常错误！<br>
           <%=e.getMessage()%>
     <%            
     }
     if(stmt!=null){ stmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
