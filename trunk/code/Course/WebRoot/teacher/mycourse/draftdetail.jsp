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
		<LINK href="${ctx}/css/thickbox.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/mail.css" type=text/css rel=stylesheet>
		<link rel="stylesheet" type="text/css"
			href="${ctx}/css/jquery.autocomplete.css" />
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox-compressed.js"></script>
		<script type='text/javascript' src='${ctx}/js/jquery.bgiframe.min.js'></script>
		<script type='text/javascript' src='${ctx}/js/jquery.ajaxQueue.js'></script>
		<script type='text/javascript' src='${ctx}/js/thickbox-compressed.js'></script>
		<script type='text/javascript' src='${ctx}/js/jquery.autocomplete.js'></script>
		<script type='text/javascript' src='${ctx}/js/thickbox.js'></script>
		<script>
	jQuery.noConflict();
</script>
		<title></title>
		<script type="text/javascript">
	var flag = true;
	function check(form) {

		if (form.receiverid.value == "") {
			alert("收件人不能为空！");
			return false;
		}
		if (flag == false) {
			alert("该学生不存在，请重新输入！");
			return false;
		}
		if (form.title.value == "") {
			alert("消息标题不能为空！");
			return false;
		}
		if (form.content.value == "") {
			alert("消息内容不能为空！");
			return false;
		}
	}

	function validateStudent() {
		jQuery.post("findStudentJsonAction.action", {
			studentNo :jQuery("#receiverid").val()
		}, function(data) {
			if (data == null) {
				jQuery("#receiverIdError").html(
						"<font color='red'>该学生不存在，请重新输入！</font>");
				flag = false;
			} else {
				table1 = document.getElementById("receiverid").value = data;
				flag = true;
			}
		}, "json");
	}

	function findStudent() {
		jQuery
				.post("findAllStudentsJsonAction.action", "", callBackStu,
						"json");
	}

	function callBackStu(json) {
		jQuery("#receiverid").autocomplete(json, {
			matchContains :true,
			minChars :0
		});
		jQuery("#receiverid").result( function(event, data, formatted) {
			jQuery("#receiverIdError").html("");
		});
	}
</script>

	</head>
	<body onload="findStudent()">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 教师信息 -&gt; 消息管理 -&gt; 发邮件
				</td>
			</tr>
		</table>
		<div class="with_side wrap" align="center" style="width: 95%;">
			<div class="cm_header itemtitle s_clear">
				<ul>					
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
				<s:form id="postpm" name="postpm" method="post"
					action="addMailByTeaAction" onsubmit="return check(this);">

					<table cellspacing="0" cellpadding="0" class="formtable"
						summary="撰写短消息" border="0px">

						<s:hidden name="mail.receiver.id"></s:hidden>
						<tbody>
							<tr>
								<th>
									<label for="receiverid">
										收件人
									</label>
								</th>
								<td>
									<s:textfield name="studentNo" cssClass="txt" size="40"
										id="receiverid" onblur="validateStudent()"></s:textfield>
									<span id="receiverIdError"></span>
								</td>
							</tr>
							<tr>
								<th>
									<label for="title">
										标题
									</label>
								</th>
								<td>
									<s:textfield name="mail.title" id="title" size="60"
										cssClass="txt"></s:textfield>
								</td>

							</tr>
							<tr>
								<th>
									<label for="content">
										内容
									</label>
								</th>
								<td>
									<s:textarea id="content" name="mail.content" cols="60" rows="8"
										cssStyle="width: 80%;" cssClass="txtarea"></s:textarea>
								</td>
							</tr>
							<tr>
								<th></th>
								<td>
									<s:checkbox name="savetosentbox" id="savetosentbox"></s:checkbox>
									保存到发件箱
								</td>

							</tr>
							<tr>
								<th></th>
								<td>
									<s:submit id="sendmsg" method="addNewMailByTea" value="立即发送"></s:submit>
									<s:submit method="addDraftByTea" value="存为草稿" />
								</td>
							</tr>

						</tbody>

					</table>
				</s:form>
			</div>
	</body>
</html>