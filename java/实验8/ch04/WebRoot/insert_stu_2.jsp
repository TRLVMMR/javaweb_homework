<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>����PreparedStatement�������һ����¼ҳ��</title> 
  </head>
  <body> 
    <%
      String driverName = "com.mysql.jdbc.Driver";         //����������
      String userName = "root";                            //���ݿ��û���
      String userPwd = "newpassword";                           //����
      String dbName = "students";                          //���ݿ���
      String  url1="jdbc:mysql://localhost:3306/"+dbName;
      String url2 ="?user="+userName+"&password="+userPwd;
      String  url3="&useUnicode=true&characterEncoding=GB2312";
      String url =url1+url2+url3;                   //�γɴ����ݿ��д��������ݿ�������
      Class.forName(driverName);
      Connection conn=DriverManager.getConnection(url); 
      
      String sql="Insert into stu_info(id,name,sex,age,weight,hight) values(?,?,?,?,?,?)";
      PreparedStatement  pstmt= conn.prepareStatement(sql);   
      request.setCharacterEncoding("GB2312");//�����ַ����룬�����������
      //��ȡrequest�Ĳ��������浽���ݿ�
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
     if(pstmt!=null){ pstmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
