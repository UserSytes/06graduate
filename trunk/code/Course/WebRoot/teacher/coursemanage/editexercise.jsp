﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		<title>编辑习题</title>
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
					return false;
				}
				if(form.author.value == "")
				{
					alert("习题作者不能为空！");
					return false;
				}
				if(form.upload.value == "")
				{
					alert("上传习题不能为空！");
					return false;
				}
			}
		</SCRIPT>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#22cc77">
				<td>
					当前位置: 我的课程-&gt; 编辑习题
				</td>
			</tr>
		</table>

		<s:form action="updateExerciseAction" method="post"
			enctype="multipart/form-data" onsubmit="return check(this);">

			<s:hidden name="exercise.id"></s:hidden>
			<s:hidden name="exercise.chapter.id"></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						编辑习题：
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
							listKey="id" listValue="number+name" />
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
						<s:textfield id="title" name="exercise.title" cssClass="input" />
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
						<s:file id="upload" name="upload"></s:file>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							查看原来课件：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<a
							href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="exercise.fileLink"/> 
                    			</s:param> 
								<s:param name="originalFileName"> 
                       			 	<s:property value="exercise.filename"/> 
                    			</s:param> 
                					</s:url>">
							<font color="red"><s:property value="exercise.filename" />
						</font> </a>
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit cssClass="label" value="修改" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>