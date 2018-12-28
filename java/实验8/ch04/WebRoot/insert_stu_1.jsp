<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>利用PreparedStatement对象添加一条记录页面</title> 
  </head>
  <body> 
    <%
		//链接mysql相应数据库
      String driverName = "com.mysql.jdbc.Driver";         //驱动程序名
      String userName = "root";                            //数据库用户名
      String userPwd = "newpassword";                           //密码
      String dbName = "students";                          //数据库名
      String  url1="jdbc:mysql://localhost:3306/"+dbName;
      String url2 ="?user="+userName+"&password="+userPwd;
      String  url3="&useUnicode=true&characterEncoding=GB2312";
      String url =url1+url2+url3;                   //形成带数据库读写编码的数据库连接字
      Class.forName(driverName);					//加载数据库的驱动类
      Connection conn=DriverManager.getConnection(url); 	//链接数据库
      
     //插入数据表
      String sql="Insert into stu_info(id,name,sex,age,weight,hight) values(?,?,?,?,?,?)";
      PreparedStatement  pstmt= conn.prepareStatement(sql);     
      pstmt.setInt(1,16);
      pstmt.setString(2,"张三");
      pstmt.setString(3,"男");
      pstmt.setInt(4,20);
      pstmt.setFloat(5,70);
      pstmt.setFloat(6,175);
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
     //关闭Statement以及数据库链接
     if(pstmt!=null){ pstmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
