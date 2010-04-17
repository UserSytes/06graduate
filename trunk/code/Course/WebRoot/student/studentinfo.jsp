<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人信息-厦门大学精品课程网站</title>
		<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
</head>
	<body topmargin="0" leftmargin="0"
		marginheight="0" marginwidth="0"
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
											<img src="${ctx}/homepage/image/title_myinfo.gif" border="0"
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
							<td valign="top" align="center">
								<!-- 内容 -->
							<table border="0" cellpadding="0" cellspacing="0"  width="95%" >
									<tr>
										<td width="90%" align="left">
											<s:actionerror />
										</td>
									</tr>
								</table>
								<s:form action="goChangeMyInfoAction" method="post">
									<table width="95%" border="0" cellpadding="0" cellspacing="0">
									
										<tr height="30">
											<td width="100" align="right"><strong>  
												姓名：</strong>
											</td>
											<td >
												&nbsp;&nbsp; <s:property value="student.userInfo.name" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 学号：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property value="student.studentNo" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 性别：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property value="student.userInfo.sex" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 院系：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property
													value="student.userInfo.department.school.name+student.userInfo.department.name" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 年级：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property value="student.grade.name+student.grade.grade" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 电话：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property value="userInfo.mobile" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 邮箱：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property value="userInfo.email" />
											</td>
										</tr>
										<tr height="10">
											<th colspan="2"></th>
									    </tr>
										<tr height="2">
											<th colspan="2" bgcolor="#d7d7d7"></th>
									    </tr>
										<tr  height="30">
											<th colspan="2">
												<div align="right">
													<s:submit value="修改信息" />
												</div>
											</th>
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