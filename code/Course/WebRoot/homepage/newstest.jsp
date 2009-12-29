<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站</title>
	</head>
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="images/back-body.jpg" style="overflow-x: hidden">
<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/DepartmentDAO.js"></script>
		<script type="text/javascript" src="/dwr/interface/SchoolDAO.js"></script>
<script type="text/javascript" src="/dwr/interface/NewsDAO.js"></script>
		<script language="javascript">
		function callbackorgcus(data) {
		if (data) {
			DWRUtil.setValue("check", "该用户已存在");
		} else {
			DWRUtil.setValue("check", "可用用户名");
		}
	}
	//获得学校列表
	function getSchool() {

		SchoolDAO.findAll(callbackorg);

	}
	
	//显示学校级别
	function callbackorg(data) {
		DWRUtil.addOptions("School", data, "id", "name");

	}
		//获得新闻列表
	function getNews() {

		NewsDAO.findAll(callbackorg);

	}
	
	//显示新闻列表
	function callbackorg(data) {
		DWRUtil.addOptions("School", data, "id", "name");

	}
	//显示院系级别
	function callbackorg2(data) {

		DWRUtil.removeAllOptions("Department");
		DWRUtil.addOptions("Department", data, "id", "name");
	}
	//获得院系列表
	function getDepartment(prvid) {

		if (prvid == -1) {
		} else {
			DepartmentDAO.findBySchool(prvid, callbackorg2);

		}
	}
	
		
</script>
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%" background="images/back-left.jpg">
						<img src="images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<s:include value="include/header2.jsp"></s:include>
								</td>
							</tr>
							<tr>
								<td width="210" height="10" valign="top">
									<table width="214" height="543" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="images/up-1.jpg" width="214" height="60">
											</td>
										</tr>

										<tr>
											<td height="38">
												<img src="images/but-2-1.jpg" width="214" height="38" style="">
											</td>
										</tr>
										<tr>
											<td width="210" height="100%" valign="top"
												background="images/back-but-2.jpg"
												style="padding-left: 28px; padding-top: 4px; padding-bottom: 15px">
												<br>
												<div style="line-height: 15px; padding-bottom: 10px"></div>
												<a href="<s:url action="newsAction"> 
                					</s:url>" class="style3">新闻公告</a>
												<div style="line-height: 15px; padding-bottom: 10px">
												</div>
												
											</td>
										</tr>
									</table>
								</td>
								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0" background="images/back-up-3.jpg">
										<tr>
											<td width="555" height="10" background="images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="534" border="0" cellspacing="0"
													cellpadding="0" background="images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">
													
<tr><br><br></tr>
													<tr>
														<td width="389" valign="top" style="padding-left: 5px">
															<img src="images/text-19.jpg" width="114" height="17"
																style="margin-bottom: 10px">
															<br>
															<font face="tahoma"
																style="font-size: 16px; color: #828688"><strong>

																	<s:iterator value="newsList" status="new">
																		<img src="images/but.jpg" width="4" height="7">&nbsp;
																		<a
																			href="<s:url action="enterNewsAction"> 
	                     											<s:param name="newsId"> 
	                       			 									<s:property value="id"/> 
	                    											</s:param> 
	                													</s:url>">
																			<s:property value="title" />&nbsp;&nbsp; <s:property
																				value="time" /> </a>
																		<br>
																	</s:iterator> </strong> </font>
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
									<img src="images/spacer.gif" width="1" height="1">
								</td>
							</tr>
						</table>
					</td>
					<td width="9" height="100%" background="images/back-right.jpg">
						<img src="images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
		</center>
	</BODY>
</html>