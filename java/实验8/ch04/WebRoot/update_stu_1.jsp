<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>ʹ��PreparedStatement�޸ļ�¼ҳ��</title> 
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
      Connection conn=null;      
      PreparedStatement  pstmt=null;
      String sql;
      try{
      Class.forName(driverName);
      conn=DriverManager.getConnection(url); 
      sql="update stu_info set weight=? where name=?";
      pstmt= conn.prepareStatement(sql);     
      pstmt.setFloat(1,80);
      pstmt.setString(2,"����");  
      int n= pstmt.executeUpdate();
      if(n==1){%>
              �����޸Ĳ����ɹ���<br>
          <%}
       else{%>
             �����޸Ĳ���ʧ�ܣ�<br>
          <%} 
     }catch(Exception e){%>
           �޸Ĺ��̳����쳣����<br>
           <%=e.getMessage()%>
     <%            
     }
     if(pstmt!=null){ pstmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
