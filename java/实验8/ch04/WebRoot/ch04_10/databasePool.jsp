<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<html>
    <head> <title>MySQL ����ԴӦ��</title> </head>
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
             rs.last(); //�������һ����¼ 
        %> 
              ��Ҫ��ѯ��ѧ�����ݱ��й���
            <font size="5" color="red"> <%=rs.getRow()%></font>��
            <table border="2" width="650">
                 <tr>
                   <td>��¼����</td> <td>ѧ��</td> <td>����</td>
                   <td>�Ա�</td> <td>����</td><td>����</td><td>���</td>
                 </tr>
                <% rs.beforeFirst();      //������һ����¼֮ǰ
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
	          �������⣬��Ϣ��:<%=e.getMessage()%>
		 <% }
         finally {
              if(rs!=null){ rs.close(); }
		      if(stmt!=null){ stmt.close(); }
              if(conn!=null){ conn.close(); }
	     }%>
	  </body>
	</html>
