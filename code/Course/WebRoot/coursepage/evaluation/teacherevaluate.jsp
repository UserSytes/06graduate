<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>同行教师评价-课程评价-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link
			href="${ctx}/coursepage/style/<s:property value="course.style"/>/color.css"
			rel="stylesheet" type="text/css" />

		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<script type="text/javascript" src="${ctx}/js/mail.js"></script>
		<script type="text/javascript" src="${ctx}/js/prototype.js"></script>
<SCRIPT language=javascript>
	function check(form) {
		if (form.expertName.value == "") {
			alert("姓名不能为空！");
			return false;
		}
		var   filter=/0-100/; 
		if (!filter.test(form.score.value)) {
			alert("要输入0-100的数字");
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
                					</s:url>">课程评价</a>&gt;同行教师评价
					</h2>
					<br class="clear" />
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table-info">
						<tr height="29">
							<td align="center">
								<font style="font-size: 16px; font-weight: bold">同行教师评价课程</font>
							</td>
						</tr>
						<tr height="19">
							<td>
								<font class="timefont">当前平均得分：<s:property
										value="teaAvgScore" />分  | 评价人数: <s:property
										value="teaCount" />人
								</font>
							</td>
						</tr>
						<tr height="1" class="trborder">
							<td valign="top"></td>
						</tr>
						<tr>
							<td width="704">
								<s:form action="teacherEvaluateAction" method="post" onsubmit="return check(this);">
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
												&nbsp;&nbsp;&nbsp;
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
												&nbsp;&nbsp;&nbsp;
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
												&nbsp;&nbsp;&nbsp;
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
												&nbsp;&nbsp;&nbsp;
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
												&nbsp;&nbsp;&nbsp;
												<s:textfield cssClass="INPUT" id="expertEmail"
													name="evaluation.email" label="邮箱"></s:textfield>

											</td>

										</tr>
										<tr class="bg">
											<td>
												<div align="center">
													得分：
												</div>
											</td>
											<td colspan="3">
												&nbsp;&nbsp;&nbsp;
												<s:textfield cssClass="INPUT" id="score"
													name="evaluation.score" label="分数"></s:textfield>
&nbsp;*
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
										<s:submit cssClass="label" name="teacherEvaluate" value="确定添加"
											method="teacherEvaluate">
										</s:submit>
										<s:submit cssClass="label" name="teacherEvaluateDraft"
											value="保存草稿" method="teacherEvaluateDraft" />
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
