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
		<title>我的课程</title>
	</head>

	<body onload="getCourseByType(2)">
		<script type="text/javascript" src="../js/prototype.js"></script>
		<script language="javascript">
	function getCourseByState() {
		document.getElementById("form").submit();
	}
	function getCourseByType(type) {
		var url = "getMyCourseByStateAction.action?type=" + type;
		new Ajax.Updater('courseListMain', url, {
			onLoading : function() {
			},
			onSuccess : function(request) {
			},
			onFailure : function(request) {
				alert("服务器故障，请稍候重试");
			}
		});
	}
	function deleteCourse(courseId) {
		var url = "deleteCourseAction.action?courseId=" + courseId;
		new Ajax.Updater('courseListMain', url, {
			onLoading : function() {
			},
			onSuccess : function(request) {
			},
			onFailure : function(request) {
				alert("服务器故障，请稍候重试");
			}
		});
	}
</script>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程申报 -&gt; 课程申报
				</td>
			</tr>
		</table>
		<table class=listTable align="center">
			<tr>
				<td>
					筛选：&nbsp;&nbsp;&nbsp;
					<s:select name="type" list="#{2:'全部',1:'己审核',0:'未审核'}"
						listKey="key" listValue="value"
						onchange="javascript:getCourseByType(this.value)" />

				</td>
			</tr>
		</table>
		<div id="courseListMain" align="center">
			<s:include value="courseslist.jsp"></s:include>
		</div>
		<div style="border: 1px solid #ccc;">
			<h2>
				<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
				<strong><font color="red" size="3"> 提示</font> </strong>
			</h2>
			<div id="content_note">
				<ul>
					<li>
						第一次使用我的图书馆需输入姓名进行验证，防止被盗用。
					</li>
					<li>
						如您使用校园卡，您的读者证号为：“0000”+
						校园卡帐号的前6位数。如：您的校园卡帐号是12345678，则您的读者证号为0000123456；
					</li>
					<li>
						读者信息查询的初始密码有两种可能情况：
						<br>
						1.2005级以前的学生和社会办证人员的初始密码和您的读者证号相同；2006后办证的初始密码为您的学号或教工号。
						<br>
						2.在旧系统中已更改密码的，您的密码为更改后的密码。
					</li>
					<li>
						密码在进入系统后可由读者重新设置。
					</li>
					<li>
						Email由您自行设定，登录后可以修改。
					</li>
					<li>
						密码遗忘请持本人有效证件至图书馆总服务台办理密码重置
					</li>
					<!--  	  <li>密码取回需要您首先验证您的Email </li> -->
				</ul>

			</div>
		</div>
	</body>
</html>
