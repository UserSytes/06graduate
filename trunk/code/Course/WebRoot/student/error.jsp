<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<LINK href="${ctx}/css/student.css" type=text/css rel=stylesheet>
		<title>厦门大学精品课程网站</title>
<script type="text/javascript">
	function redirect(URLStr) {
		location = URLStr;
	}
	var i = 10;
	function timer() {
		if (i > 1) {
			i = i - 1;
			document.getElementById("sec").innerHTML = i;
		} else {
			stop();
			redirect("javascript:history.back()");
		}
	}
	var tid = null;
	function start() {
		if (tid == null) {
			tid = setInterval("timer()", 500);
		}
	}
	function stop() {
		if (tid != null) {
			clearInterval(tid);
			tid = null;
		}
	}
</script>
<!-- Force MSIE without  javascript actived to take the default theme. not conforms to the standards but functional -->

		<!-- path favicon -->
		<link rel="shortcut icon" type="image/ico"
			href="http://xoops.org.cn/icons/favicon.ico">
		<link rel="icon" type="image/png"
			href="http://xoops.org.cn/icons/favicon.png">

		<!-- include xoops.js and others via header.php -->


		<!-- Xoops style sheet -->
		<link rel="stylesheet" type="text/css" media="screen"
			href="${ctx}/error/xoops.css">

		<!-- Theme style sheets -->
		<link rel="stylesheet" type="text/css" media="screen" title="Color"
			href="${ctx}/error/style.css">
	</head>
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="${ctx}/homepage/images/back-body.jpg" style="overflow-x: hidden">
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%"
						background="${ctx}/homepage/images/back-left.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="${ctx}/homepage/images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<s:include value="include/header.jsp"></s:include>
								</td>
							</tr>
							<tr>
								<s:include value="left.jsp"></s:include>

								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0"
										background="${ctx}/homepage/images/back-up-3.jpg">
										<tr>
											<td width="555" height="10"
												background="${ctx}/homepage/images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="100%" border="0" cellspacing="0"
													cellpadding="0"
													background="${ctx}/homepage/images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">

													<tr>
														<br>
														<br>
														<br>
														<br>
														<div style="padding-left: 5px" class="content1-pagetitle">
															当前位置: 操作信息提示
														</div>
													</tr>
													<tr>
														<td width="389" valign="top" style="padding-left: 5px">
															<div class="table">
																<img src="${ctx}/student/img/bg-th-left.gif" width="8"
																	height="7" alt="" class="left" />
																<img src="${ctx}/student/img/bg-th-right.gif" width="7"
																	height="7" alt="" class="right" />
																<div id="con-wrapper" class="con-center">
			<div id="ctr">
			</div>
			<div id="cbl">
				<img src="${ctx}/error/blue_bl.gif">
			</div>
			<div id="cbr">
				<img src="${ctx}/error/blue_br.gif">
			</div>
			<div id="xo-redirect">
				<div class="message">
					<br>
					系统正忙，操作超时！
					<br>
					<img src="${ctx}/error/ajax_indicator_01.gif" alt="&lt;br&gt;登录错误">
				</div>
				<div class="notreload">
					如果页面没有自动跳转回上一页，请
					<a href="javascript:history.back()"><strong><font color="#ffff00">点击此处</font></strong></a>继续
				</div>
			</div>
		</div>
															</div>
														</td>
													</tr>

												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<s:include value="include/bottom.jsp"></s:include>
							<tr>
								<td colspan="2" height="100%">
									<img src="${ctx}/homepage/images/spacer.gif" width="1"
										height="1">
								</td>
							</tr>
						</table>
					</td>
					<td width="9" height="100%"
						background="${ctx}/homepage/images/back-right.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
	</BODY>
</html>