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
		<title>添加学生</title>
		<SCRIPT language=javascript>
	function check(form) {
		if (form.studentNo.value == "") {
			alert("学号不能为空！");
			return false;
		}
		return true;
	}
		function ajax()
			{
				var xhr = false;
				function ajax() {//创建对象
				if (window.ActiveXObject) {//IE浏览器
 				  xhr = new ActiveXObject("Microsoft.XMLHTTP");
				} else {
  				if (window.XMLHttpRequest) {//fireFOX浏览
    			xhr = new XMLHttpRequest();
   					}
				}
				if (!xhr) {
  				alert("浏览器不支持，请换成其他浏览器再进行操作！");
  				return false;
				}
				//发送请求
				xhr.open("post", "/addMoreStudentAction.action?studentFileName=" + document.getElementById("fileName").value , "true");
				xhr.send(null);
				xhr.onreadystatechange = ok;
			}
			function ok() {//成功后调用此方法
				if (xhr.readyState == 4 && xhr.status == 200) {
   				alert("成功了");
				}
				return false;
			 }
			}
</SCRIPT>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程管理 -&gt;
					<s:text name="">${course.name}</s:text>
					-&gt; 添加学生
				</td>
			</tr>
		</table>
		<s:form action="addMoreCourseStudentAction" method="post" enctype="multipart/form-data">
			<s:hidden name="course.id" />
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						<s:text name="">${course.name}</s:text>
						课程批量添加学生
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							请输入学号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:file name="studentFile" label="导入Excel表" id="fileName"></s:file>
						&nbsp;*
					</td>
				</tr>
				
				<tr bgcolor="#ECF3FD">
					<td width="20%">
						&nbsp;
					</td>
					<td width="80%">
						<s:submit cssClass="label" value="确定添加"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
