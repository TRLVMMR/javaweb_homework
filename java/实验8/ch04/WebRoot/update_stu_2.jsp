<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>�޸ĺ���д��¼ҳ��</title> 
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
      String sql="update stu_info set id=?,name=?,sex=?,age=?,weight=?,hight=? where name=? and sex=?";
      PreparedStatement pstmt= conn.prepareStatement(sql);
      request.setCharacterEncoding("GB2312");//�����ַ����룬�����������
      int id=Integer.parseInt(request.getParameter("id"));     
      String name2=request.getParameter("name2");
      String sex2=request.getParameter("sex2");
      int age=Integer.parseInt(request.getParameter("age"));
      float weight=Float.parseFloat(request.getParameter("weight"));
      float hight=Float.parseFloat(request.getParameter("hight"));
      String name=(String) session.getAttribute("name");
      String sex=(String) session.getAttribute("sex");
      pstmt.setInt(1,id);
      pstmt.setString(2,name2);
      pstmt.setString(3,sex2);
      pstmt.setInt(4,age);
      pstmt.setFloat(5,weight);
      pstmt.setFloat(6,hight);
      pstmt.setString(7,name);
      pstmt.setString(8,sex);    
      try{ 
          int n=pstmt.executeUpdate();
          if(n>=1){%>
              ��д���ݲ����ɹ���<br>
          <%}
          else{%>
             ��д���ݲ���ʧ�ܣ�<%=n%><br>
          <%} 
     }catch(Exception e){%>
           ��д���̳����쳣����<br>
           <%=e.getMessage()%>
     <% 
     }
     if(pstmt!=null){ pstmt.close(); }
     if(conn!=null){ conn.close(); } 
    %>
  </body>
</html>
