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
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/mail.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/thickbox.css" type=text/css rel=stylesheet>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<script>
	jQuery.noConflict();
</script>
		<title></title>
		<style type="text/css">
</style>
		<script type="text/javascript">
	
</script>

	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 教师信息 -&gt; 消息管理 -&gt; 提示
				</td>
			</tr>
		</table>

		<div class="with_side wrap" align="center" style="width: 95%;">
			<div class="cm_header itemtitle s_clear">
				<ul>
					<a style="color: #09C; float: right; font-weight: 700;"
								href="${ctx}/teacher/mycourse/newmail.jsp?height=350&width=500"
								title="撰写短消息" class="thickbox">+ 写新消息</a>
					<li>
						<a href="getReceiveMailByTeaAction.action"><span>收件箱</span> </a>
					</li>
					<li>
						<a href="getSendMailByTeaAction.action"><span>发件箱</span> </a>
					</li>
					<li>
						<a href="getDraftByTeaAction.action"><span>草稿箱</span> </a>
					</li>
				</ul>
			</div>


			<div class="with_side wrap" align="center" style="width: 95%;">
				<table class=formtable cellSpacing=1 cellPadding=0 width="100%"
					align=center border=0>					
					<tr>
						<td bgcolor="#FFFFFF">
							<div align="left">
								<br>
								<font size="3"><strong><s:fielderror /> </strong> </font>
								<font size="3"><strong><s:actionmessage /> </strong> </font>
								<font size="3"><strong><s:actionerror /> </strong> </font>
							</div>
						</td>
					</tr>
				</table>
			</div>
	</body>
</html>