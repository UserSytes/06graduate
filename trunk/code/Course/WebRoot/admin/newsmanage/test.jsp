<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>发布新闻政策</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>

	<body>
		<a
			href="<s:url action="coursePassAction">
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
								<s:param name="departmentId"> 
                       			 	国家级
                    			</s:param> 
                					</s:url>"
			onclick="JAVAscript:if(!confirm('确认通过？')) return false;return true;">
			<font color="green">【通过】</font> </a>

	</body>
</html>
