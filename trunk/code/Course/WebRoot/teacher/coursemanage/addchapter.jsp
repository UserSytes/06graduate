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
		<title>修改密码</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.number.value == "")
				{
					alert("章节不能为空！");
					form.number.focus()
					return false;
				}
				if (form.name.value == "")
				{
					alert("名字不能为空！");
					form.name.focus()
					return false;
				}
				form.submit.disabled = true;
			}
		</SCRIPT>
	</head>

	<body>
<div align="center" width="98%">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#22cc77">
				<td>
					当前位置: 我的课程-&gt; 添加章节目录
				</td>
			</tr>
		</table>

		<s:form action="addChapterAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						添加章节目录：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							章号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="number"  size="50"  name="chapter.number" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="name"  size="50"  name="chapter.name" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							备注：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textarea name="chapter.remark" cssClass="TEXTAREA" />
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="submit" cssClass="label" value="确认" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
		
			<div align="left" style="border: 1px solid #ccc; padding: 10px;width: 98%;">
				<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
				<strong><font color="red" size="3"> 提示</font> </strong>
				<div id="content_note">
					<ul>
						<li>
							每个课程必须要添加完章节目录后才能上传课件、习题和实验指导。
						</li>
						<li>
							为了方便师生查阅，建议章节目录序号命名如“第一章节”或“第一部分”等。								
						</li>
						<li>
							章节目录的名称命名教师可根据需要自主命名。								
						</li>
						<li>
							如果您未将该课程细分为章节，那么请至少添加一个章节目录以便管理。
						</li>
					</ul>

				</div>
			</div>
		
</div>
	</body>
</html>
