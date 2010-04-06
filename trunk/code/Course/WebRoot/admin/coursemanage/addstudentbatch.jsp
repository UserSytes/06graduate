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
							请选择学生信息文件：
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

	  <table bgcolor="white" class=editTable cellSpacing=1 cellPadding=0
			width="90%" align=center border=0>
			<TR>
				<td bgcolor="white">
					<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
					<strong><font color="red" size="3"> 提示</font> </strong>
					<div id="content_note">
						<ul>
							<li>
								您可以上传学生信息文件添加该文件中的学生到该课程中。
							</li>
							<li>
								文件中的学生必须已经在本系统中有自己的帐号。
							</li>
							<li>
								上传文件格式为“Excel”，且文件第一列为学生学号既可，其他列不要求。
							</li>
						</ul>
					</div>
				</td>
			</TR>
		</table>
	</body>
</html>
