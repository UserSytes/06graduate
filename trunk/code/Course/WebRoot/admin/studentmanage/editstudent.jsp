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
		<title>修改学生信息</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.name.value == "")
				{
					form.name.focus();
					alert("姓名不能为空！");
					return false;
				}
				if (form.sex.value == -1)
				{
					form.sex.focus();
					alert("性别不能为空！");
					return false;
				}
				form.button.disabled = true;
				return true;
			}
		</SCRIPT>
	</head>

	<body>
	<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 学生管理 -&gt; 修改学生信息  -&gt;<s:text name="">${teacher.userInfo.name}</s:text>
				</td>
			</tr>
		</table>
		<s:form action="editStudentAction" method="post"
			onsubmit="return check(this);">
				<s:hidden name="student.id" />
				<s:hidden name="student.password" />
				<s:hidden name="userInfo.id" />
				<s:hidden name="student.studentNo" />
				<s:hidden name="student.userInfo.id" />
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请更新学生信息
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="name"  size="30"
							name="userInfo.name" label="姓名"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							性别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select id="sex" name="userInfo.sex" list="{'男','女'}" />
						&nbsp;*
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
						<s:select name="userInfo.department.id"
							list="departmentList" listKey="id" listValue="name" />
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
						<s:select name="student.grade.id"
							list="gradeList" listKey="id" listValue="name+grade" />
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
						<s:text name="">${student.studentNo}</s:text>
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
							<a
								href="<s:url action="restoreStudentPasswordAction"> 
                     			<s:param name="studentId"> 
                       			 	<s:property value="student.id"/> 
                    			</s:param> 
                					</s:url>"  onclick="JAVAscript:if(!confirm('确认还原初始密码？')) return false;return true;">
								<font color="green">【还原初始密码】</font>
							</a>
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="20%">
						&nbsp;
					</td>
					<td width="80%">
						<s:submit id="button"  cssClass="label" value="确定修改"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	</body>
</html>
