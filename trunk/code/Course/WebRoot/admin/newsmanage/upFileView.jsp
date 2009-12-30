<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html> 
<head > 
</head > 
<body > 
    <div style ="padding: 3px; border: solid 1px #cccccc; text-align: center" > 

      <!--提取UploadFile目录下的imageFileName 注：这里是对上传附件的图书有效 但只显示一个-->
        <img src ='${pageContext.request.contextPath}/UploadFile/<s:property value ="imageFileName" /> ' />
        <br/> 
       
    </div > 
</body > 
</html >