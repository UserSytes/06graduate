<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
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
		<script>
	jQuery.noConflict();
</script>
		<title></title>
		<script type="text/javascript">
	var flag = false;
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
	
	function validateTeacher() {
		jQuery.post("findTeacherJsonAction.action", {
			teacherNo :jQuery("#receiverid").val()
		}, function(data) {
			if (data == null) {
			jQuery("#receiverIdError").html(
						"<font color='red'>该老师不存在，请重新输入！</font>");
			flag = false;	}
			 else {
			 table1 = document.getElementById("receiverid").value=data;		 
			 flag = true;
			}
		}, "json");
	}
	
	function findTeachers() {
		jQuery.post("findAllTeachersJsonAction.action", "", callBackTea, "json");
	}

	function callBackTea(json) {
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
<body onload="findTeachers()" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">

		<s:include value="../homepage/include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<s:include value="left.jsp"></s:include>
				</td>
				<td width="750" valign="top" align="right">
					<!-- main -->
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- main2 主u-26472 图-->
							<td valign="top">
								<img src="${ctx}/homepage/image/main_img2.jpg" border="0">
							</td>
							<!--/main2 主u-26472 图-->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr height="27">
							<!-- 主u-26472  -->
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11"></td>
										<td>
											<img style="float: left" src="${ctx}/homepage/image/title_myletter.gif"
											 	border="0" alt="">
										</td>
									</tr>
									<tr height="3">
										<td width="11"></td>
										<td bgcolor="#d7d7d7" width="738"></td>
									</tr>
								</table>
							</td>
							<!--/ 主u-26472  -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr>
							<td valign="top" align="center">
		

		<div class="with_side wrap" align="center" style="width: 95%;">
			<div class="cm_header itemtitle s_clear">
				<ul>
					<a style="color: #09C; float: right; font-weight: 700;"
														href="${ctx}/student/newmail.jsp" title="撰写短消息">+
														写新消息</a>
													<li>
														<a href="getReceiveMailByStuAction.action"><span>收件箱</span>
														</a>
													</li>
													<li>
														<a href="getSendMailByStuAction.action"><span>发件箱</span>
														</a>
													</li>
													<li>
														<a href="getDraftByStuAction.action"><span>草稿箱</span>
														</a>
													</li>
				</ul>
			</div>
			<div class="with_side wrap" align="center" style="width: 95%;">
				<s:form id="postpm" name="postpm" method="post"
					action="addMailByStuAction" onsubmit="return check(this);">

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
									<s:textfield name="teacherNo" cssClass="txt" size="40"
										id="receiverid" onblur="validateTeacher()"></s:textfield>
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
									<s:textarea id="content" name="mail.content" cols="60" rows="12"
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
									<s:submit id="sendmsg" method="addNewMailByStu" value="立即发送"></s:submit>
									<s:submit method="addDraftByStu" value="存为草稿" />
								</td>
							</tr>

						</tbody>

					</table>
				</s:form>
			</div>
</td>		</tr>					</table>
					<!-- /内容 -->
				</td>
			</tr>
		</table>
		<!-- 底部 -->
		<s:include value="../homepage/include/bottom.jsp"></s:include>
	</body>
</html>