<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="../commons/taglibs.jsp"%>
<html>
  <head> 
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
  </head>
  <body><br>      
     <s:form action="loginAction">
       <s:textfield name="userName" label="名字"></s:textfield>
       <s:password name="password" label="密码"></s:password>
       <s:submit value="login"></s:submit>
     </s:form>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
   
  </body>
</html>
