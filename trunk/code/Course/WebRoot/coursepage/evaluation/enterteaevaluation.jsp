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
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<title></title>
		<style type="text/css">
itemtitle ul a:hover span {
	background: url(${ctx}/teacher/images/btn_block.gif) no-repeat 100%
		-69px;
}

.itemtitle ul .current a,.itemtitle ul .current a:hover {
	background: url(${ctx}/teacher/images/btn_block.gif) no-repeat 0 0;
}

.itemtitle ul .current a span,.itemtitle ul .current a:hover span {
	background: url(${ctx}/teacher/images/btn_block.gif) no-repeat 100%
		-23px;
	color: #FFF;
}
</style>
		<script type="text/javascript" src="${ctx}/js/mail.js"></script>
		<script type="text/javascript" src="${ctx}/js/prototype.js"></script>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<script>
	jQuery.noConflict();
</script>
		<script type="text/javascript">
	var prepmdiv = '';
	var folder = 'inbox';
	var table1;
	var row1;
	var currpmdiv;
	function getMailDetail(mailId, e, obj, status) {
		currpmdiv = mailId + '_div';
		if (!$(currpmdiv)) {

			table1 = document.getElementById("table");
			row1 = table1.insertRow(obj.parentNode.parentNode.rowIndex + 1);
			if (status == 1) {
				var e = table1.rows[obj.parentNode.parentNode.rowIndex].cells[0].firstChild;
				e.src = "${ctx}/teacher/images/pm_0.gif";
			}

			jQuery.post("eDetailEvaluateAction.action", {
				mailId :mailId
			}, callBack, "json");

			$(prepmdiv).style.display = 'none';

			changestatus(obj);
			prepmdiv = currpmdiv;
		} else {
			if ($(currpmdiv).style.display == 'none') {
				$(currpmdiv).style.display = '';
				changestatus(obj);
				if (prepmdiv) {
					$(prepmdiv).style.display = 'none';
				}
				prepmdiv = currpmdiv;
			} else {
				$(currpmdiv).style.display = 'none';
				prepmdiv = '';
			}
		}

	}
</script>

	</head>
	<body>
		<div id="header">
			<h1>
				<s:text name="">${course.name}</s:text>
				精品课程
				<br />
				<span class="text1"><s:property value="applicationForm.name" />
				</span>
			</h1>
		</div>
		<jsp:include page="${ctx}/coursepage/top.jsp"></jsp:include>
		<div id="content">
			<div id="right">
				<h2 align="center">
					<strong>教师对课程《<s:text name="">${course.name}</s:text>》的评价</strong>
				</h2>
				<hr id="border-top" />

				<table class="listing form" cellpadding="0" cellspacing="0">

					<tr class="bg">
						<td class="first">

							教师
							<s:property value="evaluation.name" />
							对该门课程的评价分数是：
							<br>
							<s:text name="">${evaluation.score}</s:text>
							<br>
							<br>
							评价内容是：
							<br>
							<s:text name="">${evaluation.content}</s:text>

						</td>
					</tr>
					<tr class="bg">
						<td class="first" align="center">
							<br>
							<a style="color: #09C; float: right; font-weight: 700;"
								href="${ctx}/coursepage/evaluation/login.jsp?height=150&width=250"
								class="thickbox" title="登陆">登陆</a>
							<a
								href="<s:url action="tDetailEvaluateAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">我要评价</a>

						</td>
					</tr>
					<tr>
						<td>
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

			<div id="left">
				<h2>
					<strong>最新更新</strong>
				</h2>
				<p>
					<strong>[06/09/2009]</strong>面向对象以及设计模式
					<a href="#"></a>
				</p>
				<p>
					<strong>[06/06/2009]</strong>Java 语言的基本语句、语法、应用程序开发技巧
				</p>
				<p>
					<strong>[06/03/2009]</strong> 软件工程中的流程模型之瀑布模型
				</p>
				<p>
					<strong>[06/06/2009]</strong>Java 语言的基本语句、语法、应用程序开发技巧
				</p>
				<p>
					<strong>[06/03/2009]</strong> 软件工程中的流程模型之瀑布模型
				</p>
				<p>
					&nbsp;
				</p>
				<h2>
					在线学生
				</h2>
				<ul>
					<li>
						访客用户
					</li>
					<li>
						陈晓明
					</li>
					<li>
						刘晓庆
					</li>
					<li>
						潘粤明
					</li>
				</ul>
				<p>
					&nbsp;
				</p>
			</div>
		</div>
		<jsp:include page="${ctx}/coursepage/bottom.jsp"></jsp:include>
	</body>
</html>