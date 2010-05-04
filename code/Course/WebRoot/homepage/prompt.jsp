<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻公告——厦门大学精品课程网站</title>
<style type="text/css">
.alert_info {
	padding:0px 0 6px 20px;
	line-height: 160%;
	background: url() no-repeat 8px 50%;
	font-size: 14px;
}
.alertmsg a{
	font-size: 14px;
	color: #000;
}
ul li {
	list-style: none;
	text-align: left;
}
</style>
	</head>
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">

		<s:include value="include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<img src="${ctx}/homepage/image/left_menu_title6.gif"
												border="0">
										</td>
									</tr>
									<tr>
										<td>
											<img src="${ctx}/homepage/image/jiannan.jpg" border="0">
										</td>
									</tr>
								</table>

							</td>
						</tr>
					</table>
					<!--/left -->
				</td>
				<td width="750" valign="top" align="right">
					<!-- main -->
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- main2 主题图 -->
							<td valign="top">
								<img src="${ctx}/homepage/image/main_img2.jpg" border="0">
							</td>
							<!--/main2 主题图 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr height="27">
							<!-- 主题 -->
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11"></td>
										<td>
											<img src="${ctx}/homepage/image/title_new.gif" border="0"
												alt="">
										</td>
									</tr>
									<tr height="3">
										<td width="11"></td>
										<td bgcolor="#d7d7d7" width="738"></td>
									</tr>
								</table>
							</td>
							<!--/ 主题 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr>
							<td valign="top" align="left">
								<!-- 内容 -->
								<table width="98%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<div style="padding: 15px 30px;">
												<div class="alert_info"
													style="background-image: url(${ctx}/coursepage/style/common/error_big.gif)">
												
														<font style="font-size: 14px;"><s:actionmessage />
															<s:actionerror /> <br /> </font>
												

													
														<ul class="alertmsg"
														style="margin-top: 8px; text-decoration: underline"><li><a href="javascript:history.back(-1)">[请点击这里返回上一页]</a></li></ul>
													
												</div>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

					<!-- /内容 -->
				</td>
			</tr>
		</table>
		<!--/ 오른쪽부분 -->
		</td>
		</tr>
		</table>

		<!-- 底部 -->
		<s:include value="include/bottom.jsp"></s:include>
	</body>
</html>