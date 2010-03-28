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
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<title></title>
		<style type="text/css">
</style>
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
	function findStudent() {
		$.post("findStudentJsonAction.action", {
			studentNo :$("#receiverid").val()
		}, function(data) {
			if (data == null) {
				$("#receiverIdError").html(
						"<font color='red'>该学生不存在，请重新输入！</font>");
				flag = false;
			} else {
				$("#receiverIdError").html(
						"<font color='green'>" + data + " 同学</font>");
				flag = true;
			}
		}, "json");
	}
</script>

	</head>
	<body onload="findStudent()">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 教师信息 -&gt; 消息管理 -&gt;回复邮件
				</td>
			</tr>
		</table>

		<div class="with_side wrap" align="center" style="width: 95%;">
<div class="cm_header itemtitle s_clear">
							<ul>
								<a style="color: #09C; float: right; font-weight: 700;"
									href="##">+ 写新消息</a>
								<li>
									<a href="getReceiveMailByTeaAction.action"><span>收件箱</span>
									</a>
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
									<s:textfield name="studentNo" cssClass="txt" size="25"
										id="receiverid" onblur="findStudent()"></s:textfield>
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
									<s:textfield name="mail.title" id="title" size="40"
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
									<s:textarea theme="ajax" id="content" name="mail.content"
										cols="60" rows="8" cssStyle="width: 80%;" cssClass="txtarea"></s:textarea>
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