<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top">
					<!-- 로그인부분 -->
					<table border="0" cellpadding="0" cellspacing="0" align="center">
						<tr>
							<td>
								<img src="${ctx}/homepage/image/mycourse_title.gif" border="0"
									alt="">
							</td>
						</tr>
						<tr height="11">
							<td>
								<!-- 로그인 웃부분 여백 -->
								<table border="0" cellpadding="0" cellspacing="0" width="100%"
									height="100%">
									<tr>
										<td width="2" bgcolor="#e7e7e7"></td>
										<td width="190"></td>
										<td width="2" bgcolor="#e7e7e7"></td>
									</tr>
								</table>
								<!--/ 로그인 웃부분 여백 -->
							</td>
						</tr>
						<tr>
							<td width="194">
								<!-- 头像 -->
								<s:form action="loginFromHomePageAction" method="post">
									<table border="0" cellpadding="0" cellspacing="0" width="100%">
										<tr height="29">
											<td width="2" bgcolor="#e7e7e7" valign="top"></td>
											<td width="10" valign="top"></td>
											<td valign="top" width="170">
												<img width="170" src="${ctx}/upload/<s:property value="student.userInfo.photo"/>" /> 
											</td>
											<td width="10" valign="top"></td>
											<td width="2" bgcolor="#e7e7e7" valign="top"></td>
										</tr>
									</table>
								</s:form>
								<!--/ 头像 -->
							</td>
						</tr>
						<tr height="16">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="100%"
									height="100%">
									<tr>
										<td width="2" bgcolor="#e7e7e7"></td>
										<td width="190"></td>
										<td width="2" bgcolor="#e7e7e7"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="2" bgcolor="#e7e7e7"></td>
										<td width="13"></td>

										<td width="2" bgcolor="#e7e7e7"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="2" bgcolor="#e7e7e7"></td>
										<td width="13"></td>
										<td>
											<a href="<s:url action="goChangeHeadAction"></s:url>"><img
													src="${ctx}/homepage/image/change_head.gif" border="0"
													alt="修改头像"> </a>
										</td>
										<td width="6"></td>
										<td width="83">
											<a href="#"><img
													src="${ctx}/homepage/image/change_head.gif" border="0"
													alt=""> </a>
										</td>
										<td width="11"></td>
										<td width="2" bgcolor="#e7e7e7"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<img src="${ctx}/homepage/image/login_bottom.gif" border="0"
									alt="">
							</td>
						</tr>
					</table>


					<!-- 리스트 -->
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<img src="${ctx}/homepage/image/mycourse_menu_title.gif"
									border="0">
							</td>
						</tr>
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">											
											<img src="${ctx}/homepage/image/mycourse_menu_01.gif" border="0">
										</td>
										<td width="11" background=""></td>
									</tr>
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">
											<a href="<s:url action="myCoursesAction"></s:url>">
												<img src="${ctx}/homepage/image/mycourse_menu2_1.gif"
													border="0"> </a>
										</td>
										<td width="11" background=""></td>
									</tr>
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">
											<a href="<s:url action="myCollectionAction"></s:url>">
												<img src="${ctx}/homepage/image/mycourse_menu2_2.gif"
													border="0"> </a>
										</td>
										<td width="11" background=""></td>
									</tr>
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">
											<img src="${ctx}/homepage/image/mycourse_menu_02.gif" border="0">
										</td>
										<td width="11" background=""></td>
									</tr>
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">
											<a href="<s:url action="myInfoAsStudentAction"></s:url>">
												<img src="${ctx}/homepage/image/mycourse_menu2_3.gif"
													border="0"> </a>
										</td>
										<td width="11" background=""></td>
									</tr>
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">
											<a href="<s:url action="goChangeStudentPwdAction"></s:url>">
												<img src="${ctx}/homepage/image/mycourse_menu2_4.gif"
													border="0"> </a>
										</td>
										<td width="11" background=""></td>
									</tr>
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">
											<a href="<s:url action="myTopicAction"></s:url>">
												<img src="${ctx}/homepage/image/mycourse_menu_03.gif"
													border="0"> </a>
										</td>
										<td width="11" background=""></td>
									</tr>
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">
											<a href="<s:url action=""></s:url>">
												<img src="${ctx}/homepage/image/mycourse_menu_04.gif"
													border="0"> </a>
										</td>
										<td width="11" background=""></td>
									</tr>
									<tr>
										<td width="11" background=""></td>
										<td width="172" align="center">
											<a href="<s:url action=""></s:url>">
												<img src="${ctx}/homepage/image/mycourse_menu_05.gif"
													border="0"> </a>
										</td>
										<td width="11" background=""></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<img src="${ctx}/homepage/image/left_menu_bottom.gif" border="0">
							</td>
						</tr>
					</table>

				</td>
			</tr>
		</table>
		<!--/left -->

	</body>
</html>