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
		<title>编辑参考书籍</title>
		<SCRIPT language=javascript>
			function check(form)
			{				
				if(form.name.value == "")
				{
					alert("书名不能为空！");
					form.name.focus();
					return false;
				}
				if (form.author.value == "")
				{
					alert("作者不能为空！");
					form.author.focus();
					return false;
				}
				if (form.publication.value == "")
				{
					alert("出版社不能为空！");
					form.publication.focus();
					return false;
				}				
				var time= dojo.widget.byId("time");
				if (time.getValue() == "")
				{
					alert("出版时间不能为空！");
					return false;
				}
				if(form.upload.value == "")
				{
					alert("上传书籍不能为空！");					
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
					当前位置: 我的课程-&gt; 编辑参考书籍
				</td>
			</tr>
		</table>

		<s:form action="updateBookAction" method="post"
			enctype="multipart/form-data" onsubmit="return check(this);">
			<s:hidden name="book.id"></s:hidden>
			<s:hidden name="book.course.id"></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							书名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="name" name="book.name" cssClass="input" />
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
						<s:textfield id="author" name="book.author" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							出版社：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="publication" name="book.publication" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							出版时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:head />
						<s:datetimepicker id="time" displayFormat="yyyy-MM-dd"
							name="book.time" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							上传书籍：
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
							查看原来书籍：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<a
							href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="book.fileLink"/> 
                    			</s:param> 
								<s:param name="originalFileName"> 
                       			 	<s:property value="book.filename"/> 
                    			</s:param> 
                					</s:url>">
							<font color="red"><s:property value="book.filename" /> </font> </a>
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="submit" cssClass="label" value="修改" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
