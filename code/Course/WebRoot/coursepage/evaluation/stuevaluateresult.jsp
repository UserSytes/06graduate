<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>课程评价-厦门大学课程网络平台</title>
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
                					</s:url>">课程评价</a>&gt;详细浏览
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
															style="font-size: 18px; font-weight: bold">学生对课程《<s:text name="">${course.name}</s:text>》的评价</font>
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
								<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td>
							<font color="#74582f" style="font-size:16px;font-weight:bold;">《<s:text name="">${course.name}</s:text>》课程学生的评价结果：&nbsp; 
							<s:property value="scorestring" /></font>
						</td>
					</tr>
					<tr>
							<td align="center"><br />
<a style="color: #09C; float: right; font-weight: 700;"
								href="${ctx}/coursepage/evaluation/login.jsp?height=350&width=450"
								class="thickbox" title="登陆"><font color="#74582f" style="font-size:16px;font-weight:bold;">登陆</font></a>
								<a href="<s:url action="sDetailEvaluateAction"> 
	                     											<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param></s:url>"><font color="#74582f" style="font-size:16px;font-weight:bold;">进入评价</font></a>

							</td>
						</tr>
				</table>
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
