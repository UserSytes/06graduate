<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站——搜索课程</title>
		<link rel="stylesheet" href="${ctx}/homepage/link.css">
<SCRIPT language=javascript>
	function check(form) {
		if (form.flag.value == -1) {
			alert("请选择关键字类型！");
			return false;
		}
		if (form.keyword.value == "") {
			alert("关键字不能为空！");
			return false;
		}
		return true;
	}
</script>
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		width="100%" height="100%"
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
											<img src="${ctx}/homepage/image/left_menu_title5.gif"
												border="0">
										</td>
									</tr>
									<tr>
										<td>
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="center">
														<a href="<s:url action="forwardToSearchAction"></s:url>">
															<img src="${ctx}/homepage/image/left_menu_06.gif" border="0">
														</a>
													</td>
													<td width="11" background=""></td>
												</tr>
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="center">
														<a href="<s:url action="forwardToSuperSearchAction"></s:url>">
															<img src="${ctx}/homepage/image/left_menu_07.gif" border="0">
														</a>
													</td>
													<td width="11" background=""></td>
												</tr>
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="center">
														<a href="<s:url action="forwardToSuperSearchAction"></s:url>">
															<img src="${ctx}/homepage/image/left_menu_08.gif" border="0">
														</a>
													</td>
													<td width="11" background=""></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<img src="${ctx}/homepage/image/jiannan2.jpg" border="0">
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
											<img src="${ctx}/homepage/image/title_last1.gif" border="0"
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
								<s:form action="searchCourseByKeywordAction" onsubmit="return check(this);" method="post" enctype="multipart/form-data">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td width="420" align="right">
												<s:select name="flag" list="# {'0':'课程名称','1':'教师姓名'}" headerKey="-1" headerValue="请选择" />
											</td>
											<td width="194" width="192" align="center">
												<s:textfield name="keyword" cssClass="text" />
											</td>
											<td width="84">
												<input type="submit" name="submit" value="关键字搜索 ">
											</td>
										</tr>
									</table>
								</s:form>

                             <table width="90%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td width="90%" align="left"><s:actionmessage /></td>
										</tr>
							</table>
							<table width="95%" cellpadding="0" cellspacing="0">
									<tr height="40">
							<td colspan="5" background="${ctx}/homepage/image/bbs_bg.gif">		
								<table border="0" cellpadding="0" cellspacing="0" style="height: 23px;" width="100%" >
								<tr height="1"><td bgcolor="#d7d7d7" colspan="5" width="100%"></td></tr>
								<tr>
									<td width="50" align="center">序号</td>
									<td width="355" align="center">课程名</td>
									<td width="64" align="center">教师</td>
									<td width="145" align="center">所属系</td>
									<td width="50" align="center">点击</td>
								</tr>
								</table>
							</td>
						</tr>                  
									
									<s:iterator value="courseList" status="course">
										<tr>
											<td width="50" align="center">
												<s:property value="#course.count" />
											</td>
											<td width="355" align="center">
												<a
													href="<s:url action="enterCourseAction"> 
																				<s:param name="courseId"> <s:property value="id"/> </s:param> </s:url>">
													<s:property value="name" /></a>
											</td>
											<td width="64" align="center">
												<s:property value="teacher.userInfo.name" />
											</td>
											<td width="145" align="center">
												<s:property value="department.name" />
											</td>
											<td width="50" align="center">
												<s:property value="count" />
											</td>
										</tr>
										<tr height="3">
											<td colspan="5"
												background="${ctx}/homepage/image/table_line.gif"></td>
										</tr>
									</s:iterator>
								</table>

							</td>
						</tr>
					</table>

					<!-- /内容 -->
				</td>
			</tr>
		</table>
	

		<!-- 底部 -->
		<s:include value="include/bottom.jsp"></s:include>
	</body>
</html>