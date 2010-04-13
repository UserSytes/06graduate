<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>邀请专家</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.evaname.value == "")
				{
					alert("名字不能为空！");
					return false;
				}
				if (form.evapassword.value == "")
				{
					alert("密码不能为空！");
					return false;
				}
				if (form.confirmPwd.value == "")
				{
					alert("确认密码不能为空！");
					return false;
				}
				if (form.password.value != form.confirmPwd.value)
				{
					alert("两次输入的密码不一致，请重新输入！");
					return false;
				}
			}
		</SCRIPT>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 我的课程 -&gt; 邀请专家评价
				</td>
			</tr>
		</table>
		<s:form action="addEvaTeacherAction" method="post"
			enctype="multipart/form-data" onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						邀请专家：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							用户名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="evaname" name="evaluation.name" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:password  id="evapassword" name="evaluation.password" cssClass="input" />
					</td>
				</tr>	
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							确认密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:password id="confirmPwd" cssClass="input" />
					</td>
				</tr>				
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit cssClass="label" value="确认" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>