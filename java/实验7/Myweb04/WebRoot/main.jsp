<%@page    pageEncoding="UTF-8"%>
<html>
     <head><title>主页面</title></head>
     <body><%
         String username=(String)session.getAttribute("username");
         if(username==null){
            Cookie[] cs=request.getCookies();
            String v=null;
            if(cs!=null){
                for(int i=0;i<cs.length;i++){
                    if(cs[i].getName().equals("username")){
                       v=cs[i].getValue();
                     }
                   }
                 }
            if(v!=null){
               session.setAttribute("username",v);
               out.print(v+",您好");
               }
            else{
                  out.print("您还没注册，2秒后转到注册页面");
                  response.setHeader("Refresh","2;url=login.jsp");
                }
            }
              else{
                    out.println(username+",您好");
              }
      %>
     </body>
</html>