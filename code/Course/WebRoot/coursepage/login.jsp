<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户登录-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="style/%{#session.header}"></s:include>	
		<div class="content">
			<!-- 左侧 -->
			<s:include value="style/left.jsp"></s:include>
			<div id="right-cnt">
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt; 提示信息
					</h2>
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0" style=""
						class="table-msg">
						<tr height="29">
							<td align="left" class="table-title">
								<font style="font-size: 16px; font-weight: bold">提示信息 </font>
							</td>
						</tr>
						<tr height="1" class="tr-title">
							<td></td>
						</tr>
						<tr>
							<td>
								<div style="padding: 15px;">
									<div class="alert_info" style="background-image: url(${ctx}/coursepage/style/common/error_big.gif)">
										<p>
											请登录后再进行相关操作。
										</p>

										<p class="alertmsg" style="margin-top: 8px;">
											<a href="${ctx}/coursepage/messagemanage/messagelogin.jsp" rel="facebox">[ 点击这里进行登录]</a>
										</p>
									</div>
								</div>
							</td>
						</tr>
					</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="style/bottom.jsp"></s:include>
	</body>
</html>
