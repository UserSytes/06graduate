<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html> 
<head > 
</head > 
<body > 
    <div style ="padding: 3px; border: solid 1px #cccccc; text-align: center" > 

      <!--��ȡUploadFileĿ¼�µ�imageFileName ע�������Ƕ��ϴ�������ͼ����Ч ��ֻ��ʾһ��-->
        <img src ='${pageContext.request.contextPath}/UploadFile/<s:property value ="imageFileName" /> ' />
        <br/> 
       
    </div > 
</body > 
</html >