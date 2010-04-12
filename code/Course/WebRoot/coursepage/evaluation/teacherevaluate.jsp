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
		<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet"
			type="text/css" />
<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<script type="text/javascript" src="${ctx}/js/mail.js"></script>
		<script type="text/javascript" src="${ctx}/js/prototype.js"></script>
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/header.jsp"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a href="<s:url action="evaluateAction"> 
                					</s:url>">课程评价</a>&gt;同行教师评价
					</h2>
					<br class="clear" />
				</div>

<ul id="products-list">
			</ul>
		<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="724" align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="724"
									height="94"
									background="${ctx}/coursepage/style/green/titlebg.gif"
									style="background-repeat: no-repeat">
									<tr>
										<td width="724" valign="top" align="right">
											<font style="font-size: 12px; color: #574434"></font>
										</td>
									</tr>
									<tr height="69">
										<td valign="bottom" align="left">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td align="center">
														<font color="#966f48"
															style="font-size: 18px; font-weight: bold">专家评价课程</font>
													</td>
												</tr>
												<tr>
													<td>
														<font color="#92a35d" style="font-size: 12px;"></font>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="1">
										<td width="724" bgcolor="#c4ae86" valign="top"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
				<s:form action="teacherEvaluateAction" method="post">
<s:hidden name="evaluation.id"></s:hidden>
<s:hidden name="evaluation.course.id"></s:hidden>
<s:hidden name="evaluation.username"></s:hidden>
<s:hidden name="evaluation.password"></s:hidden>
<s:hidden name="evaluation.status"></s:hidden>
<s:hidden name="evaluation.sort"></s:hidden>
					<table cellSpacing=1 cellPadding=0 width="100%"
						align=center border=0>
						<tr>
							<td colspan="7">
								请输入个人信息及对该课程的评价
							</td>
						</tr>
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
								&nbsp;*
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
								&nbsp;*
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
								请填写评价分数（0到100分的整数）
							</td>
<td colspan="3">
								&nbsp;&nbsp;&nbsp;
								<s:textfield cssClass="INPUT" id="score" name="evaluation.score" label="分数"></s:textfield>
							</td>
						</tr>
						<tr class="bg">
							<td colspan="4">
								<FCK:editor instanceName="evaluation.content" width="100%"
									height="405" toolbarSet="Default">
									<jsp:attribute name="value">
<s:property value="evaluation.content" escape="false"/>
                            </jsp:attribute>
								</FCK:editor>
							</td>
						</tr>
						<tr bgcolor="#ECF3FD">
							<td width="20%">
								&nbsp;
							</td>
							<td width="80%">
								<s:submit cssClass="label" value="确定添加"></s:submit>
								<s:reset cssClass="label" value="取消" />
							</td>
						</tr>
					</table>
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
