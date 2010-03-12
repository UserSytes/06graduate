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
			function check(form)
			{
				if (form.name.value == "")
				{
					alert("姓名不能为空！");
					return false;
				}
				if (form.sex.value == -1)
				{
					alert("性别不能为空！");
					return false;
				}
				if (form.departmentId.value == -1)
				{
					alert("所属系不能为空！");
					return false;
				}
				if (form.gradeId.value == -1)
				{
					alert("年级不能为空！");
					return false;
				}
				if (form.studentNo.value == "")
				{
					alert("账号不能为空！");
					return false;
				}
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
					当前位置: 学生管理 -&gt; 添加学生
				</td>
			</tr>
		</table>
		<s:form action="addMoreStudentAction" method="post" enctype="multipart/form-data" 
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请选择新学生信息
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							所属系：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="departmentId" list="departmentList" headerKey="-1"
							headerValue="请选择" listKey="id" listValue="name" />
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							年级：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="gradeId" list="gradeList" headerKey="-1"
							headerValue="请选择" listKey="id" listValue="name+grade" />
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							账号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:file name="studentFile" label="导入Excel表" id="fileName"></s:file>
						&nbsp;*
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							登陆密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<font color="#808080">初始密码为与账号相同 </font>&nbsp;
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
