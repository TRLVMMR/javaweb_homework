<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<html>
    <head> <title>显示所有学生的页面</title> </head>
    <body>
        <center>
        <%String driverName = "com.mysql.jdbc.Driver";         //驱动程序名
          String userName = "root";                            //数据库用户名
          String userPwd = "newpassword";                           //密码
          String dbName = "students";                          //数据库名
          String  url1="jdbc:mysql://localhost:3306/"+dbName;
          String url2 ="?user="+userName+"&password="+userPwd;
          String  url3="&useUnicode=true&characterEncoding=GB2312";
          String url =url1+url2+url3;        //形成带数据库读写编码的数据库连接字
          Class.forName(driverName);
          Connection conn=DriverManager.getConnection(url); 
          
          String sql="select  *  from  stu_info "; 
          PreparedStatement  pstmt= conn.prepareStatement(sql);   
          ResultSet rs=pstmt.executeQuery();  
          rs.last(); //移至最后一条记录 
         %>你要查询的学生数据表中共有
          <font size="5" color="red"> <%=rs.getRow()%></font>人
          <table border="2" bgcolor= "ccceee" width="650">
               <tr bgcolor="CCCCCC" align="center">
                   <td>记录条数</td> <td>学号</td> <td>姓名</td><td>性别</td> <td>年龄</td><td>体重</td><td>身高</td>
               </tr>
          <% rs.beforeFirst(); //移至第一条记录之前
          	
             while(rs.next()){	//re.next在结束时反回false
          %>   <tr align="center">
                  <td><%= rs.getRow()%></td>
                  <td><%= rs.getString("id") %></td>
                  <td><%= rs.getString("name") %></td>
                  <td><%= rs.getString("sex") %></td>
                  <td><%= rs.getString("age") %></td>
                  <td><%= rs.getString("weight") %></td>
                  <td><%= rs.getString("hight") %></td>
                </tr>            
             <% }%>
           </table>
        </center>
         <%if(rs!=null){ rs.close(); }
           if(pstmt!=null){ pstmt.close(); }
           if(conn!=null){ conn.close(); } 
         %>  
    </body>
</html>
