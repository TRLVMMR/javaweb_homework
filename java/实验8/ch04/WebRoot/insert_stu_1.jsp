<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>����PreparedStatement�������һ����¼ҳ��</title> 
  </head>
  <body> 
    <%
		//����mysql��Ӧ���ݿ�
      String driverName = "com.mysql.jdbc.Driver";         //����������
      String userName = "root";                            //���ݿ��û���
      String userPwd = "newpassword";                           //����
      String dbName = "students";                          //���ݿ���
      String  url1="jdbc:mysql://localhost:3306/"+dbName;
      String url2 ="?user="+userName+"&password="+userPwd;
      String  url3="&useUnicode=true&characterEncoding=GB2312";
      String url =url1+url2+url3;                   //�γɴ����ݿ��д��������ݿ�������
      Class.forName(driverName);					//�������ݿ��������
      Connection conn=DriverManager.getConnection(url); 	//�������ݿ�
      
     //�������ݱ�
      String sql="Insert into stu_info(id,name,sex,age,weight,hight) values(?,?,?,?,?,?)";
      PreparedStatement  pstmt= conn.prepareStatement(sql);     
      pstmt.setInt(1,16);
      pstmt.setString(2,"����");
      pstmt.setString(3,"��");
      pstmt.setInt(4,20);
      pstmt.setFloat(5,70);
      pstmt.setFloat(6,175);
      try{ 
          int n=pstmt.executeUpdate();
          if(n==1){%>
              ���ݲ�������ɹ���<br>
          <%}
          else{%>
             ���ݲ������ʧ�ܣ�<br>
          <%} 
     }catch(Exception e){%>
           ���¹��̳����쳣����<br>
           <%=e.getMessage()%>
     <%; 
     }
     //�ر�Statement�Լ����ݿ�����
     if(pstmt!=null){ pstmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
