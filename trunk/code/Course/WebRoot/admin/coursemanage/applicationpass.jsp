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
		<title>省报课程详细</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.refuseReason.value == "")
				{
					alert("反馈信息不能为空！");
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
					当前位置: 课程管理 -&gt; 申报课程列表 -&gt; <s:text name="">${course.name}</s:text>
				</td>
			</tr>
		</table>
		<s:form action="coursePassAction" onsubmit="return check(this);">
			<s:hidden name="course.id" />
			<s:hidden name="course.name" />
			<s:hidden name="course.remark" />
			<s:hidden name="course.department.id" />
			<s:hidden name="course.teacher.id" />
			<s:hidden name="course.level" />
			<s:hidden name="course.status" />
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7> 申报课程详细信息
				<br></td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center"> 
							课程名称： 
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:text name="">${course.name}</s:text>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							授课教师：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:text name="">${course.teacher.userInfo.name}</s:text>
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
						<s:text name="">${course.department.name}</s:text>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							级别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:text name="">${course.level}</s:text>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							简介：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:text name="">${course.remark}</s:text>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							反馈信息：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="refuseReason" name="refuseReason" value="该课程通过审核，可以上传教学资料!" label="发聩信息"></s:textfield>&nbsp;*
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="20%">
						&nbsp;
					</td>
					<td width="80%">						
						<s:submit cssClass="label" value="审核通过"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
