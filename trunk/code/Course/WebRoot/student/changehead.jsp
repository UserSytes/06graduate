<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人信息-厦门大学精品课程网站</title>
		<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<script>jQuery.noConflict();</script>
		<SCRIPT language=javascript>
	function check(form) {
		if (form.upload.value == "") {
			alert("照片不能为空！");
			return false;
		}

		return true;
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
											<img src="${ctx}/homepage/image/title_changehead.gif"
												border="0" alt="">
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
							<td valign="top" align="center">
								<!-- 内容 -->
								<s:form action="changeHeadAction" onsubmit="return check(this);"
									method="post" enctype="multipart/form-data">
									<table width="95%" border="3" cellpadding="0" cellspacing="0"
										bordercolor="#e7e7d7">

										<tr height="300">
											<td width="240">
												<table>
													<tr height="30">
														<td align="left" width="200">
															<strong>&nbsp;&nbsp;&nbsp;&nbsp;当前头像</strong>
														</td>
													</tr>
													<tr height="2">
														<td align="center" bgcolor="#d7d7d7" width="200"></td>
													</tr>
													<tr>
														<td align="center">
															<strong><a
																href="${ctx}/upload/<s:property value="student.userInfo.photo"/>"
																title="" class="thickbox"><img width="180"
																		src="${ctx}/upload/<s:property value="userInfo.photo"/>" border="0"/>
															</a> </strong>
														</td>
													</tr>
												</table>
											</td>
											<td>
												<table height="100%" width="100%">
													<tr height="38">
														<td align="left">
															<strong>设置新头像</strong>
														</td>
													</tr>
													<tr height="2">
														<td bgcolor="#d7d7d7" width="95%"></td>
													</tr>
													<tr height="30">
														<td align="left">
															支持JPG、JPEG、GIF、BMP和PNG文件，最大1M。
														</td>
													</tr>
													<tr height="30">
														<td align="left">
															<s:file id="upload" name="upload"></s:file>
														</td>
													</tr>
													<tr height="30">
														<td align="left">
															<s:submit cssClass="label" value="确认" />
															<s:reset cssClass="label" value="取消" />
														</td>
													</tr>
													<tr>
														<td></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</s:form>

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