<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>无标题文档</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	color: #FFFFFF;
}

-->
.cm_header {
	padding: 6px;
	border: solid #E6E7E1;
	border-width: 1px 0;
	background: #F5F5F5;
}

.itemtitle {
	clear: both;
	overflow: hidden;
	margin-bottom: 10px;
	line-height: 23px;
}

.itemtitle h1 {
	align: left;
	float: left;
	margin: 0 20px 0 0;
	float: left;
}

.postpm {
	color: #09C;
	float: right;
	font-weight: 700;
}

.itemtitle ul {
	float: left;
}

.itemtitle li {
	float: left;
	margin-right: 5px;
}

.itemtitle ul a {
	display: block;
	overflow: hidden;
	height: 23px;
	cursor: pointer;
	
}

* html .itemtitle ul a {
	float: left;
}

.itemtitle ul a span {
	display: block;
	padding: 0px 7px; *
	line-height: 22px;
	font-size: 14px;
}

.s_clear {
	zoom: 1;
}

a:link {
	font-size: 12px;
	text-decoration: none;
	color: #000000;
}

a:visited {
	font-size: 12px;
	text-decoration: none;
	color: #000000;
}

a:hover {
	font-size: 12px;
	text-decoration: none;
	color: #FF0000;
}

a.v1:link {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}

a.v1:visited {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}

.cpcontent {
	margin-left: 10px;
	width: auto;
	padding: 0px 15px;
}

.cpcontent h1,.main h1 {
	font-size: 16px;
	font-weight: 400;
	margin-bottom: 5px;
}

.cpcontent h1 {
	margin-bottom: 15px;
}
</style>
		<SCRIPT language=javascript>
	function changeHead(type) {
		if (type == 1) {
			document.getElementById("receiveBox").style.display = "block";
			document.getElementById("sendBox").style.display = "none";
			document.getElementById("draftBox").style.display = "none";
		} else if (type == 2) {
			document.getElementById("receiveBox").style.display = "none";
			document.getElementById("sendBox").style.display = "block";
			document.getElementById("draftBox").style.display = "none";
		} else {
			document.getElementById("receiveBox").style.display = "none";
			document.getElementById("sendBox").style.display = "none";
			document.getElementById("draftBox").style.display = "block";
		}
	}
</script>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 教师信息-&gt;消息管理
				</td>
			</tr>
		</table>
		<div class="cpcontent">
			<h1 id="receiveBox">
				收件箱
			</h1>
			<h1 id="sendBox" style="display: none">
				发件箱
			</h1>
			<h1 id="draftBox" style="display: none">
				草稿箱
			</h1>
			<div class="cm_header itemtitle s_clear">
				<ul>

					<a style="color: #09C; float: right; font-weight: 700"
						href="usercppostpm.aspx">+ 写新消息</a>
					<li>
						<a id="rBox" href="#" onclick="changeHead(1)"><span>收件箱</span> </a>
					</li>
					<li>
						<a href="#" onclick="changeHead(2)"><span>发件箱</span> </a>
					</li>
					<li>
						<a href="#" onclick="changeHead(3)"><span>草稿箱</span> </a>
					</li>
				</ul>
			</div>
		</div>
		<ul class="popupmenu_popup headermenu_popup" id="notice_menu"
			style="display: none">
			<li>
				<a href="usercpnotice.aspx?filter=postreply">主题回复</a>
			</li>
			<li>
				<a href="usercpnotice.aspx?filter=all">全部通知</a>
			</li>
			<li>
				<a href="usercpnotice.aspx?filter=topicadmin">管理通知</a>
			</li>
		</ul>

	</body>
</html>
