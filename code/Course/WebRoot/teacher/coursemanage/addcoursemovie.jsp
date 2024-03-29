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
		<title>添加教学录像</title>
		<SCRIPT language=javascript>
			function check(form)
			{				
				if(form.title.value == "")
				{
					alert("录像标题不能为空！");
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
					alert("主讲人不能为空！");
					form.author.focus();
					return false;
				}
				if (form.author.value.length>=40)
				{
					alert("作者长度不能超过40！");
					form.author.focus();
					return false;
				}
				if (form.position.value == "")
				{
					alert("职称不能为空！");
					form.position.focus();
					return false;
				}
				if (form.position.value.length >=50)
				{
					alert("职称长度不能大于50！");
					form.position.focus();
					return false;
				}
				if (form.content.value == "")
				{
					alert("内容不能为空！");
					form.content.focus();
					return false;
				}
				if (form.content.value.length >=255)
				{
					alert("内容长度不能超过255！");
					form.content.focus();
					return false;
				}
				var time= dojo.widget.byId("time");
				if (time.getValue() == "")
				{
					alert("录制时间不能为空！");
					return false;
				}
				if(form.upload.value == "")
				{
					alert("上传录像不能为空！");
					return false;
				}
				var pos = form.upload.value.lastIndexOf(".");
				if(pos==-1)
				{
					alert("上传录像格式错误，请重新上传！");
					return false;
				}
				var str = form.upload.value.substring(pos+1);
				var filename="rm,RM,avi,AVI,mpg,MPG,mpeg,MPEG,swf,SWF,wmv,WMV,";				
				if(filename.search(str+',') == -1)
				{
					alert("上传录像格式错误，请重新上传！");
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
					当前位置: 我的课程-&gt; 添加教学录像
				</td>
			</tr>
		</table>

		<s:form action="addCourseMovieAction" method="post"
			enctype="multipart/form-data" onsubmit="return check(this);">

			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						<span style="float: left;">添加教学录像：</span><span
							style="float: right"><a
							href="${ctx}/teacher/coursemanage/addcoursemoviesrc.jsp"><font
								color="green">【使用已有的网上视频链接，请点击这里】</font> </a> </span>
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
						<s:textfield id="title" size="50" name="courseMovie.title"
							cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							主讲人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="author" size="50" name="courseMovie.author"
							cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							职称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="position" size="50" name="courseMovie.position"
							cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							内容：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textarea id="content" name="courseMovie.content"
							cssClass="textarea" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							录制时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:head />
						<s:datetimepicker id="time" displayFormat="yyyy-MM-dd"
							name="courseMovie.time" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							上传录像：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:file id="upload" size="40" name="upload"></s:file>
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="submit" cssClass="label" value="确定" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>

		<div align="left"
			style="border: 1px solid #ccc; padding: 10px; width: 98%;">
			<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
			<strong><font color="red" size="3"> 提示</font> </strong>
			<div id="content_note">
				<ul>
					<li>
						本地上传录像文件格式必须为 rm, avi, mpg, swf 和 wmv 中的一种。
					</li>
					<li>
						如果想要使用网上已有的录像或视频链接，请单击左上角链接。
					</li>
					<li>
						上传录像文件大小最好不要超过100M。
					</li>
					<li>
						如果上传录像文件太大建议先使用其他途径上传到网站再引用该录像的网络链接。
					</li>
				</ul>

			</div>
		</div>
		<br>
		<br>
	</body>
</html>
