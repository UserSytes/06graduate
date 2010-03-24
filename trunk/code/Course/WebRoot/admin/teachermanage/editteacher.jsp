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
		<title>修改教师</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.teacherName.value == "")
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
				if (form.teacherNo.value == "")
				{
					alert("账号不能为空！");
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
					当前位置: 教师管理 -&gt; 修改教师信息 -&gt;<s:text name="">${teacher.userInfo.name}</s:text>
				</td>
			</tr>
		</table>
		<s:form action="editTeacherAction" method="post"
			onsubmit="return check(this);">
				<s:hidden name="teacher.id" />
				<s:hidden name="teacher.password" />
				<s:hidden name="userInfo.id" />
				<s:hidden name="teacher.teacherNo" />
				<s:hidden name="teacher.userInfo.id" />
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请更新教师信息
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
						<s:textfield cssClass="INPUT" id="teacherName"  size="30"
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
							职位：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="position"  size="30"
							name="teacher.position" label="职位"></s:textfield>

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
						<s:text name="">${teacher.teacherNo}</s:text>
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
						<s:submit cssClass="label" value="确定修改"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
