<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
    <head><title>me</title></head>
    <body>
      <center>
                  现在的日期和时间是:<%=new Date()%>
               
          <hr>
      
      
<table width="100%" height="100%" cellpadding="0" cellspacing="0">
<tr>
<td valign="middle" align="center">

           <% 
    for(int i=0;i<50;i++){
    if(i%2!=0){
    out.print(i+"  ");
  }              
}
          %>
</td>
</tr>
</table>
          
           
<table height="100%" > 
<tr>
<td width="99%"  valign="bottom" ><b>班级:<br>学号:<br>姓名:</b>
</td>
</tr>

<table align="right">
<tr>
  <td width="99%"  valign="bottom" align="right" >
</td>
</tr></table> 



       </body>
      </center>
    
</html>