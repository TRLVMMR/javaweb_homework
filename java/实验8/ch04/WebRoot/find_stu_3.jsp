<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<html>
    <head> <title>由提交页面获取查询条件并实现查询的页面</title> </head>
    <body>
        <div align="center">
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
          request.setCharacterEncoding("GB2312");//设置字符编码，避免出现乱码          
          String sex=request.getParameter("sex");
          float weight1=Float.parseFloat(request.getParameter("w1"));
          float weight2=Float.parseFloat(request.getParameter("w2"));                
          String sql="select  *  from  stu_info where sex=? and weight>=? and weight<=?"; 
          PreparedStatement  pstmt= conn.prepareStatement(sql);
          pstmt.setString(1,sex);        
          pstmt.setFloat(2,weight1);
          pstmt.setFloat(3,weight2);         
          ResultSet rs=pstmt.executeQuery();   
          rs.last(); //移至最后一条记录 
         %>你要查询的学生数据表中共有
          <font size="5" color="red"> <%=rs.getRow()%></font>人
          <table border="2" bgcolor= "ccceee" width="650">
               <tr bgcolor="CCCCCC" align="center">
                   <td>记录条数</td> <td>学号</td> <td>姓名</td><td>性别</td> <td>年龄</td><td>体重</td><td>身高</td>
               </tr>
          <% rs.beforeFirst(); //移至第一条记录之前
             while(rs.next()){
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
        </div>
         <%if(rs!=null){ rs.close(); }
           if(pstmt!=null){ pstmt.close(); }
           if(conn!=null){ conn.close(); } 
         %>  
    </body>
</html>
