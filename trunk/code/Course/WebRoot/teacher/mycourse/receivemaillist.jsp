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
		<title>课程列表</title>
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
	</head>
	<body>
<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程管理 -&gt; 课程列表 
				</td>
			</tr>
		</table>
		<div align="center">
			<table cellspacing="0" cellpadding="0" class="pm_list" summary="收件箱">
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
				<s:iterator value="mailList" status="mail">
					<tr class="listTr">
						<td width="5%">
							<s:property value="#mail.count" />
						</td>
						<td width="20%">
							<img width="48" onerror="this.onerror=null;this.src='${ctx}/teacher/images/noavatar_small.gif'" src="${ctx}/teacher/images/noavatar_small.gif"/>

						</td>
						<td width="10%">
							<s:property value="mail.userInfo.name" />
						</td>
						<td width="35%">
							
						</td>
						<td width="30%">
							<a
								href="<s:url action="viewCourseStudentByTeaAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看】</font>
							</a>
							<a
								href="<s:url action="goAddCourseStudentByTeaAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="blue">【添加】</font>
							</a>
							<a
								href="<s:url action="goAddCourseStudentBatchByTeaAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="blue">【批量添加】</font>
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</body>
</html>