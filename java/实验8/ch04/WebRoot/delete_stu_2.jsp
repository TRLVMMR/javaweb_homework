<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>利用提交条件删除记录页面</title> 
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
      
      Statement stmt=conn.createStatement();
      request.setCharacterEncoding("GB2312");//设置字符编码，避免出现乱码        
      String name=request.getParameter("name");
      String sex=request.getParameter("sex");      
      String ww1=request.getParameter("w1"); 
      String ww2=request.getParameter("w2");  
      String s="1=1 ";
      if(!name.equals("")) s=s+" and name='"+name+"'";
      if(sex!=null) s=s+" and sex='"+sex+"'";
      float w1,w2;
      if(!ww1.equals("")) {
        w1=Float.parseFloat(ww1);
        s=s+"and weight>="+w1;
      }
      if(!ww2.equals("")) {
        w2=Float.parseFloat(ww2);
        s=s+"and weight<="+w2;
      }      
      String sql="delete from stu_info where "+s;
      PreparedStatement  pstmt= conn.prepareStatement(sql);   
      try{ 
          int n=pstmt.executeUpdate();
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
