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
		<title>添加作业习题</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.chapterId.value == -1)
				{
					alert("请先选择章节目录！");
					return false;
				}
				if(form.title.value == "")
				{
					alert("习题标题不能为空！");
					form.title.focus();
					return false;
				}
				if(form.title.value.length >= 50)
				{
					alert("标题长度不能超过50！");
					form.title.focus();
					return false;
				}	
				if (form.author.value == "")
				{
					alert("习题作者不能为空！");
					form.author.focus();
					return false;
				}	
				if (form.author.value.length>=40)
				{
					alert("作者长度不能超过40！");
					form.author.focus();
					return false;
				}
				if(form.upload.value == "")
				{
					alert("上传习题不能为空！");
					return false;
				}
				form.submit.disabled = true;
			}
		</SCRIPT>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#22cc77">
				<td>
					当前位置: 我的课程-&gt; 添加习题
				</td>
			</tr>
		</table>

		<s:form action="addExerciseAction" method="post"
			enctype="multipart/form-data" onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						添加习题：
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							章节目录：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select id="chapterId" name="chapterId" list="chapterList"
							listKey="id" listValue="number+name" headerValue="请选择章节"
							headerKey="-1" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							标题：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="title" size="50" name="exercise.title" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							作者：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="author" size="50" name="exercise.author"
							cssClass="input" />
					</td>
				</tr>	
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							上传课件：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:file id="upload" size="50" name="upload"></s:file>
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
	</body>
</html>
