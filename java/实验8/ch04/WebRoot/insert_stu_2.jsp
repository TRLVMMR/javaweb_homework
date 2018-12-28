<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>利用PreparedStatement对象添加一条记录页面</title> 
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
      
      String sql="Insert into stu_info(id,name,sex,age,weight,hight) values(?,?,?,?,?,?)";
      PreparedStatement  pstmt= conn.prepareStatement(sql);   
      request.setCharacterEncoding("GB2312");//设置字符编码，避免出现乱码
      //获取request的参数，保存到数据库
      int id=Integer.parseInt(request.getParameter("id"));     
      String name=request.getParameter("name");
      String sex=request.getParameter("sex");
      int age=Integer.parseInt(request.getParameter("age"));
      float weight=Float.parseFloat(request.getParameter("weight"));
      float hight=Float.parseFloat(request.getParameter("hight"));
      pstmt.setInt(1,id);
      pstmt.setString(2,name);
      pstmt.setString(3,sex);
      pstmt.setInt(4,age);
      pstmt.setFloat(5,weight);
      pstmt.setFloat(6,hight);
      try{ 
          int n=pstmt.executeUpdate();
          if(n==1){%>
              数据插入操作成功！<br>
          <%}
          else{%>
             数据插入操作失败！<br>
          <%} 
     }catch(Exception e){%>
           更新过程出现异常错误！<br>
           <%=e.getMessage()%>
     <%; 
     }
     if(pstmt!=null){ pstmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
