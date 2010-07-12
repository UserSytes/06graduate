<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>专家评价-课程评价-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check(form) {		
		if (form.expertName.value == "") {
			alert("姓名不能为空！");
			form.expertName.focus();
			return false;
		}
		if (form.expertCompany.value == "") {
			alert("单位不能为空！");
			form.expertCompany.focus();
			return false;
		}
		if (form.expertPosition.value == "") {
			alert("职位不能为空！");
			form.expertPosition.focus();
			return false;
		}
		if (form.expertPhone.value == "") {
			alert("电话不能为空！");
			form.expertPhone.focus();
			return false;
		}
		var re2 = /^[0-9]*$/;
		if (!re2.test(form.expertPhone.value)) {
			alert("电话格式错误，请输入正确电话！");
			form.expertPhone.focus();
			return false;
		}
		if (form.expertEmail.value == "") {
			alert("邮箱不能为空！");
			form.expertEmail.focus();
			return false;
		}
		var re = /^([a-zA-Z0-9_-])+@+([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (!re.test(form.expertEmail.value)) {
			alert("Email格式错误，请输入正确邮箱！");
			form.expertEmail.focus();
			return false;
		}
		if (form.score.value == "") {
			alert("分数不能为空！");	
			form.score.focus();	
			return false;
		}			
		if (!re2.test(form.score.value)) {
			alert("评价分数的格式必须为整数！");
			form.score.focus();
			return false;
		}		
		if (form.score.value<0 ||form.score.value>100 ) {
			alert("请输入0~100的整数");
			form.score.focus();
			return false;
		}		
		var oEditor = FCKeditorAPI.GetInstance("evaluation.content");
   		if(oEditor.GetXHTML(true) == "")
   		{
   			alert("内容不能为空！");
			return false;
   		}	
		return true;
		}
</SCRIPT>
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/%{#session.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="evaluateAction"> 
                					</s:url>">课程评价</a>&gt;专家评价
					</h2>
					<br class="clear" />
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table-info">
						<tr height="29">
							<td align="center">
								<font style="font-size: 16px; font-weight: bold">专家评价课程</font>
							</td>
						</tr>
						<tr height="19">
							<td>
								<font class="timefont">当前平均得分：<s:text
														name="global.format.score">
														<s:param value="expertAvgScore" />
													</s:text>分  | 评价人数: <s:property
										value="expertCount" />人
								</font>
							</td>
						</tr>
						<tr height="1" class="trborder">
							<td valign="top"></td>
						</tr>
						<tr>
							<td width="704">
								<s:form action="expertEvaluateAction" method="post" onsubmit="return check(this);">
									<s:hidden name="evaluation.id"></s:hidden>
									<s:hidden name="evaluation.course.id"></s:hidden>
									<s:hidden name="evaluation.username"></s:hidden>
									<s:hidden name="evaluation.password"></s:hidden>
									<s:hidden name="evaluation.status"></s:hidden>
									<s:hidden name="evaluation.sort"></s:hidden>
									<table cellSpacing=1 cellPadding=0 width="100%" align=center
										border=0 style="padding: 10px;" class="table-input">
										<tr>
											<td>
												<div align="center">
													姓名：
												</div>
											</td>
											<td colspan="3">
												<s:textfield cssClass="INPUT" id="expertName"
													name="evaluation.name" label="姓名"></s:textfield>
												&nbsp;*
											</td>
										</tr>
										<tr>
											<td>
												<div align="center">
													单位：
												</div>
											</td>
											<td colspan="3">
												<s:textfield cssClass="INPUT" id="expertCompany"
													name="evaluation.company" label="单位"></s:textfield>
												
											</td>
										</tr>
										<tr>
											<td>
												<div align="center">
													职位：
												</div>
											</td>
											<td colspan="3">
												<s:textfield cssClass="INPUT" id="expertPosition"
													name="evaluation.position" label="职位"></s:textfield>
											
											</td>
										</tr>
										<tr>
											<td>
												<div align="center">
													电话：
												</div>
											</td>
											<td colspan="3">
												<s:textfield cssClass="INPUT" id="expertPhone"
													name="evaluation.phone" label="电话"></s:textfield>

											</td>
										</tr>
										<tr>
											<td>
												<div align="center">
													邮箱：
												</div>
											</td>
											<td colspan="3">
												<s:textfield cssClass="INPUT" id="expertEmail"
													name="evaluation.email" label="邮箱"></s:textfield>

											</td>

										</tr>
										<tr>
											<td>
												<div align="center">
													得分:
													<div>
											</td>
											<td colspan="3">
												<s:textfield cssClass="INPUT" id="score"
													name="evaluation.score" label="分数"></s:textfield>
											</td>
										</tr>
										<tr>
											<td>
												<div align="left">
													<br>
													<font size="3"> <strong><s:fielderror /> </strong>
													</font>
													<font size="3"> <strong><s:actionmessage />
													</strong> </font>
													<font size="3"> <strong><s:actionerror />
													</strong> </font>
												</div>
											</td>

										</tr>
										<tr>
											<td colspan="4">
												<FCK:editor instanceName="evaluation.content" width="100%"
													height="405" toolbarSet="Default">
													<jsp:attribute name="value">
<s:property value="evaluation.content" escape="false" />
                            </jsp:attribute>
												</FCK:editor>
											</td>
										</tr>
									</table>
									<div style="margin-left: 200px;">
										<s:submit id="submit1" cssClass="label" name="expertEvaluate" value="确定添加"
											method="expertEvaluate">
										</s:submit>
										<s:submit id="submit2" cssClass="label" name="expertEvaluateDraft"
											value="保存草稿" method="expertEvaluateDraft" />
										<s:reset cssClass="label" value="取消" />
									</div>
								</s:form>
							</td>
						</tr>
					</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="../style/bottom.jsp"></s:include>
	</body>
</html>
