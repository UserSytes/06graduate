<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>提示信息-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link
			href="${ctx}/coursepage/style/<s:property value="course.style"/>/color.css"
			rel="stylesheet" type="text/css" />
<script language="JavaScript"> 
window.setTimeout("location='javascript:history.back(-1)'", 5000); 
</script>
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="style/%{#session.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="style/left.jsp"></s:include>
			<div id="right-cnt">
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						提示信息
					</h2>
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" align="center" cellpadding="0" cellspacing="0" 
						width="704"
						style="padding-top: 30px; padding-left: 5px; padding-right: 5px;">
<tr align="center">
<td align="center"><img src="${ctx}/coursepage/style/common/load.gif" border="0" height="48" width="48"></td>
<td align="center"><div align="center"><font size="3">
						<s:fielderror />
						<s:actionmessage />
						<s:actionerror />
						</font>
</div>
<br />
<br />
现在将转入之前页面<br />
<a href="javascript:history.back(-1)">如果浏览器没有相应，请点击这里</a>
</td>
</tr>
					</table>
				</div>
			</div>

			<br class="clear" />
		</div>
		<s:include value="style/bottom.jsp"></s:include>
	</body>
</html>
