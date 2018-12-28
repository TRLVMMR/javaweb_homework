<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<html>
    <head> <title>MySQL 数据源应用</title> </head>
      <body>	
      <%
	    DataSource ds = null;
	    Connection conn=null;
	    PreparedStatement  stmt=null;
        ResultSet rs=null;
        
	    try {
	         InitialContext ctx = new InitialContext();
	         ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
	         conn = ds.getConnection();
             String sql="select * from  stu_info"; 
             stmt= conn.prepareStatement(sql);
             rs=stmt.executeQuery(); 
             rs.last(); //移至最后一条记录 
        %> 
              你要查询的学生数据表中共有
            <font size="5" color="red"> <%=rs.getRow()%></font>人
            <table border="2" width="650">
                 <tr>
                   <td>记录条数</td> <td>学号</td> <td>姓名</td>
                   <td>性别</td> <td>年龄</td><td>体重</td><td>身高</td>
                 </tr>
                <% rs.beforeFirst();      //移至第一条记录之前
                   while(rs.next()){%>
                     <tr align="center">
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
	     <%} catch (Exception e) {%>
	          出现意外，信息是:<%=e.getMessage()%>
		 <% }
         finally {
              if(rs!=null){ rs.close(); }
		      if(stmt!=null){ stmt.close(); }
              if(conn!=null){ conn.close(); }
	     }%>
	  </body>
	</html>
