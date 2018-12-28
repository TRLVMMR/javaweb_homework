<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>使用PreparedStatement修改记录页面</title> 
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
      Connection conn=null;      
      PreparedStatement  pstmt=null;
      String sql;
      try{
      Class.forName(driverName);
      conn=DriverManager.getConnection(url); 
      sql="update stu_info set weight=? where name=?";
      pstmt= conn.prepareStatement(sql);     
      pstmt.setFloat(1,80);
      pstmt.setString(2,"张三");  
      int n= pstmt.executeUpdate();
      if(n==1){%>
              数据修改操作成功！<br>
          <%}
       else{%>
             数据修改操作失败！<br>
          <%} 
     }catch(Exception e){%>
           修改过程出现异常错误！<br>
           <%=e.getMessage()%>
     <%            
     }
     if(pstmt!=null){ pstmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
