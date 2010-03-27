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

		<title></title>
		<style type="text/css">

</style>
		<script type="text/javascript">
			
</script>

	</head>
	<body>

		<div class="with_side wrap" align="center" style="width: 95%;">
			<s:form id="postpm" name="postpm" method="post"
				action="addReplyMailByTeaAction">
				
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
								<s:textfield name="mail.receiver.name" readonly="true" cssClass="txt" size="25"
									id="msgto"></s:textfield>
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
								<s:textarea theme="ajax" id="content" name="mail.content" cols="60" rows="8"
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
								<s:submit id="sendmsg" method="addReplyMailByTea" value="立即发送"></s:submit>
								<s:submit method="addReplyDraftByTea" value="存为草稿" />
							</td>
						</tr>

					</tbody>

				</table>
			</s:form>			
		</div>

	</body>
</html>