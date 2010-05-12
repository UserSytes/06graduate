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
		<title>回复邮件</title>
<script type="text/javascript">
function check(form) {		
		if (form.title.value == "") {
			alert("消息标题不能为空！");
			form.title.focus();
			return false;
		}
		if(form.title.value.length >= 50)
		{
			alert("标题长度不能超过50！");
			form.title.focus();
			return false;
		}	
		if (form.content.value == "") {
			alert("消息内容不能为空！");
			form.content.focus();
			return false;
		}		
	}
</script>
	</head>
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
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
											<img style="float: left"
												src="${ctx}/homepage/image/title_myletter.gif" border="0"
												alt="">
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
												href="goNewMailByStuAction.action">+ 写新消息</a>
											<li>
												<a href="getReceiveMailByStuAction.action"><span>收件箱</span>
												</a>
											</li>
											<li>
												<a href="getSendMailByStuAction.action"><span>发件箱</span>
												</a>
											</li>
											<li>
												<a href="getDraftByStuAction.action"><span>草稿箱</span> </a>
											</li>
										</ul>
									</div>
									<s:form id="postpm" name="postpm" method="post"
										action="addReplyMailByStuAction">
										<table cellspacing="0" cellpadding="0" class="formtable"
											summary="撰写短消息" border="0px">
											<s:hidden name="mail.receiver.id"></s:hidden>
											<tbody>
												<tr>
													<th>
														<label for="msgto">
															收件人
														</label>
													</th>
													<td>
														<s:textfield name="mail.receiver.name" readonly="true"
															cssClass="txt" size="25" id="msgto"></s:textfield>
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
															cols="60" rows="12" cssStyle="width: 80%;height:80%;"
															cssClass="txtarea"></s:textarea>
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
														<s:submit id="sendmsg" method="addReplyMailByStu"
															value="立即发送"></s:submit>
														<s:submit id="saveDraft" method="addReplyDraftByStu" value="存为草稿" />
													</td>
												</tr>

											</tbody>

										</table>
									</s:form>
								</div>
							</td>
						</tr>
					</table>
					<!-- /内容 -->
				</td>
			</tr>
		</table>
		<!-- 底部 -->
		<s:include value="../homepage/include/bottom.jsp"></s:include>
	</body>
</html>