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
		<LINK href="../Images/css1/admin.css" type=text/css rel=stylesheet>
		<title>添加学院</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>
	<body>
		<table>
				<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						序号   
					</th>
					<th>
						学院名称   
					</th>
					<th>
						所有系   
					</th>
					<th>
						操作   
					</th>
				</tr>
				<s:iterator value="allSchools" status="school">
					<tr>
						<td>
							<s:property value="#school.id" />
						</td>
						<td>
							<s:property value="#school.name" />
						</td>
						<td>
							<a
								href="<s:url action="findDepartmentAction"> 
                     			<s:param name="schoolId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看】</font></a>
						</td>
						<td>
							<a
								href="<s:url action="deleteSchoolAction"> 
                     			<s:param name="schoolId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="red">【删除】</font></a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<s:url id="url_pre" value="allSchools.action">
				<s:param name="pageNow" value="pageNow-1"></s:param>
			</s:url>
			<s:url id="url_next" value="allSchools.action">
				<s:param name="pageNow" value="pageNow+1"></s:param>
			</s:url>
			<s:a href="%{url_pre}">上一页</s:a>

			<s:iterator value="allSchools" status="status">
				<s:url id="url" value="allSchools.action">
					<s:param name="pageNow" value="pageNow" />
				</s:url>
			</s:iterator>
			<s:a href="%{url_next}">下一页</s:a>

	</body>
</html>