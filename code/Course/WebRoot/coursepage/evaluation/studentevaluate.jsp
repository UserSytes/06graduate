<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>学生评价-课程评价-厦门大学课程网络平台</title>
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
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<script>
     jQuery.noConflict();
</script>
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
                					</s:url>">课程评价</a>&gt;学生评价
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
															style="font-size: 18px; font-weight: bold">学生评价课程</font>
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
								<s:form action="studentEvaluateAction" method="post">
&nbsp;&nbsp; 
			<table cellpadding="0" cellspacing="0" align="center">
						<tr>
							<td>
								<font style="font-size:16px;font-weight:bold;">请认真填写评价分数（0到100分的整数）</font>
							</td>
						</tr>
						<tr>
							<td align="center">
								&nbsp;&nbsp;&nbsp;
								<s:textfield cssClass="INPUT" id="score" name="score" label="分数"></s:textfield>
							</td>
						</tr>
						<tr>
							<td><font color="#74582f" style="font-size: 16px">
								评价标准：
								<br />
								0-10分：上课不认真。
								<br />
								10-20分：课程内容准备不充分。
								<br />
								20-30分：上课认真。
								<br />
								30-40分：上课认真，课程内容准备充分。
								<br />
								40-50分：上课认真，关心同学。
								<br />
								50-60分：上课不认真。
								<br />
								60-70分：课程内容准备不充分。
								<br />
								70-80分：上课认真。
								<br />
								80-90分：上课认真，课程内容准备充分。
								<br />
								90-100分：上课认真，关心同学。</font>
							</td>
						</tr>

						<tr class="bg">

							<td class="first">
								<s:submit cssClass="label" value="确认" />
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
