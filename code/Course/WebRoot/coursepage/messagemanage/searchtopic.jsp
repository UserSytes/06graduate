<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>高级搜索-师生留言-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/<s:property value="course.style"/>/color.css" rel="stylesheet"
			type="text/css" />

<SCRIPT language=javascript>
	function check(form) {
		if (form.keyword.value == "" && form.keyname.value==""&&form.keydate.value=null) {
			alert("搜索条件不能全为空，请重新搜索！");
			return false;
		}
		return true;
	}
</SCRIPT>
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/%{course.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a href="<s:url action="showTopicsAction"> 
                					</s:url>">师生留言</a>&gt;高级搜索
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
															style="font-size: 18px; font-weight: bold">主题高级搜索</font>
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
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
										<td width="24"></td>
										<td><div>多条件查询</div>
<br />
												<s:form action="searchTopicByKeyAction" onsubmit="return check(this);" method="post" enctype="multipart/form-data">
									<table border="0" cellpadding="0" cellspacing="0" align="center" >
										<tr height="35">
											<td width="100" align="right">
												标题关键字
											</td>
											<td width="300" align="center">
												<s:textfield name="keyword" cssClass="text" size="40"/>
											</td>
										</tr>
<tr height="35">
											<td width="100" align="right">
												发帖人姓名
											</td>
											<td width="300" align="center">
												<s:textfield name="authorName" cssClass="text" size="40"/>
											</td>
										</tr>
<tr height="35">
											<td width="100" align="right">
												搜索时间
											</td>
											<td width="300" align="center">
											
												<s:head /> 
												<s:datetimepicker id="time" displayFormat="yyyy-MM-dd"
							name="keydate" />
											</td>
										</tr>
<tr><td width="80" colspan="2" align="center">
												<input type="submit" name="submit" value="提交 ">
											</td></tr>
									</table>
								</s:form>
										</td>
										<td width="24"></td>
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
