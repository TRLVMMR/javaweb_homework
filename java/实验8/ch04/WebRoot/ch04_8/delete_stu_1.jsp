<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>ɾ��һ����¼ҳ��</title> 
  </head>
  <body> 
    <%
      String driverName = "com.mysql.jdbc.Driver";         //����������
      String userName = "root";                            //���ݿ��û���
      String userPwd = "123456";                           //����
      String dbName = "students";                          //���ݿ���
      String  url1="jdbc:mysql://localhost:3306/"+dbName;
      String url2 ="?user="+userName+"&password="+userPwd;
      String  url3="&useUnicode=true&characterEncoding=GB2312";
      String url =url1+url2+url3;                   //�γɴ����ݿ��д��������ݿ�������
      Class.forName(driverName);
      Connection conn=DriverManager.getConnection(url);      
      String sql="delete from stu_info where weight>=?";
      PreparedStatement stmt=conn.prepareStatement(sql);
      stmt.setFloat(1,80);
      try{ 
          int n= stmt.executeUpdate();
          if(n>=1){%>
              ����ɾ�������ɹ���<br>
          <%}
          else{%>
             ����ɾ������ʧ�ܣ�<br>
          <%} 
     }catch(Exception e){%>
           ɾ�����¹��̳����쳣����<br>
           <%=e.getMessage()%>
     <%            
     }
     if(stmt!=null){ stmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
