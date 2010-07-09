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
				
			}
		</SCRIPT>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 我的课程 -&gt; 专家评价详情
				</td>
			</tr>
		</table>
		
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						评价详情：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0" width="15%">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="evaluation.name"/>
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
						<s:property value="evaluation.position"/>
					</td>
				</tr>	
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							单位：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="evaluation.company"/>
					</td>
				</tr>		
<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							电话：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="evaluation.phone"/>
					</td>
				</tr>		
<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							电子邮箱：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="evaluation.email"/>
					</td>
				</tr>
<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							评价得分：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="evaluation.score"/>
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
						<s:property value="evaluation.content" escape="false"/>
					</td>
				</tr>
			</table>
	</body>
</html>