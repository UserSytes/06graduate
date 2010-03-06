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
	function check(form) {
		if (form.userName.value == "") {
			alert("名字不能为空！");
			return false;
		}
		if (form.password.value == "") {
			alert("密码不能为空！");
			return false;
		}
		if (form.confirmPwd.value == "") {
			alert("确认密码不能为空！");
			return false;
		}
		if (form.password.value != form.confirmPwd.value) {
			alert("两次输入的密码不一致，请重新输入！");
			return false;
		}
	}
</SCRIPT>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 我的课程 -&gt; 课程评价结果
				</td>
			</tr>
		</table>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>
					学生评价
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="left">
						<font size="3">&nbsp;&nbsp;&nbsp;平均得分: <s:property value="stuAvgScore"/><br> </font>
						<font size="3">&nbsp;&nbsp;&nbsp;评价人数: <s:property value="stuCount"/><br> </font>
					</div>
				</td>
			</tr>
		</table>

		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>
					专家评价
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="left">
						<font size="3">&nbsp;&nbsp;&nbsp;平均得分: <s:property value="expertAvgScore"/> <a
							href="getEvaluationListByCourseAction.action">
								<font color="green">【查看详情】</font> </a>
						<br> </font>
						<font size="3">&nbsp;&nbsp;&nbsp;评价人数: <s:property value="expertAvgScore"/><br> </font>
<font size="3">&nbsp;&nbsp;&nbsp;点击<a
							href="${ctx}/teacher/courseinfomanage/addevaluation.jsp">这里</a>邀请专家新的专家进行课程评价<br> </font>
					</div>
				</td>
			</tr>
		</table>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<div style="border: 1px solid #ccc;">
				<h2>
					<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
					<strong><font color="red" size="3"> 提示</font> </strong>
				</h2>
				<div id="content_note">
					<ul>
						<li>
							学生评价只有评分无评价内容，每名学生只能评价一次。
						</li>
						<li>
							专家评价有评分和评价内容，只有接受邀请的专家才能对课程进行评价。
						</li>
						<li>
							如果要邀请新的专家来对课程进行评价，需要产生一个用户和密码，
							同时<br>受邀请专家通过专门的网站登录点进行登录，登录后方可进行评价。
						</li>
						<li>
							专家登录网址为：http://……
						</li>
						<li>
							学生和专家评价均不能进行删除操作。
						</li>						
					</ul>

				</div>
			</div>
		</table>
	</body>
</html>