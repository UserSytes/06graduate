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
						<br>
						<font size="3">&nbsp;&nbsp;&nbsp;平均得分: 5<br> </font>
						<font size="3">&nbsp;&nbsp;&nbsp;评价人数: 5<br> </font>
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
						<br>
						<font size="3">&nbsp;&nbsp;&nbsp;平均得分: 5 <a
							href="<s:url action="updateCourseInfoAction"> 
                     			<s:param name="courseInfoId"> 
                       			 	<s:property value="courseInfo.id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看详情】</font> </a>
						<br> </font>
						<font size="3">&nbsp;&nbsp;&nbsp;评价人数: 5<br> </font>
<font size="3">&nbsp;&nbsp;&nbsp;点击<a
							href="<s:url action="updateCourseInfoAction"> 
                     			<s:param name="courseInfoId"> 
                       			 	<s:property value="courseInfo.id"/> 
                    			</s:param> 
                					</s:url>">这里</a>邀请专家新的专家进行课程评价<br> </font>
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
		</table>
	</body>
</html>