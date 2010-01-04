<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<link href="../${ctx}/homepage/default.css" rel="stylesheet"
			type="text/css" />
		<title>精品课程搜索引擎->课程查询结果</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="${ctx}/homepage/images/back-body.jpg" style="overflow-x: hidden">
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%" background="${ctx}/homepage/images/back-left.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="${ctx}/homepage/images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="765" height="102">
                  <param name="movie" value="${ctx}/homepage/flash/delta46-2.swf">
                  <param name="quality" value="high"> <param name="menu" value="false">
                  <embed src="${ctx}/homepage/flash/delta46-2.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="765" height="102"></embed>
			  </object>
								</td>
							</tr>
							<tr>
								<td width="210" height="10" valign="top">
									<table width="214" height="543" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="${ctx}/homepage/images/up-1.jpg" width="214" height="60">
											</td>
										</tr>

										<tr>
											<td height="38">
												<img src="${ctx}/homepage/images/but-2-5.jpg" width="214" height="38" style="">
											</td>
										</tr>
										<tr>
											<td width="210" height="100%" valign="top"
												background="${ctx}/homepage/images/back-but-2.jpg"
												style="padding-left: 28px; padding-top: 4px; padding-bottom: 15px">
												<br>
												<div style="line-height: 15px; padding-bottom: 10px"></div>
												<a href="#">课程列表</a>
												<div style="line-height: 15px; padding-bottom: 10px">
												</div>
												
											</td>
										</tr>
									</table>
								</td>
								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0" background="${ctx}/homepage/images/back-up-3.jpg">
										<tr>
											<td width="555" height="10" background="${ctx}/homepage/images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="534" border="0" cellspacing="0"
													cellpadding="0" background="${ctx}/homepage/images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">
													
<tr><br><br><br><br></tr>
													<tr >
														<td width="389" valign="top" style="padding-left: 5px">
																	<table class=editTable cellSpacing=1 cellPadding=0 align=center
					border=1>
<tr><br></tr>
				<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						序号   
					</th>
					<th>
						课程名称   
					</th>
					<th>
						当前状态
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="courseList" status="course">
					<tr >
						<td >
							<s:property value="id" />
						</td>
						<td>
							<s:property value="name" />
						</td>
						<td>
							<s:property value="remark" />
						</td>
						<td>
							<a
								href="<s:url action="enterCourseAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看】</font></a>
						</td>
						<td>
							<a
								href="<s:url action="AddCollectionAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="red">【加入收藏】</font></a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<s:url id="url_pre" value="courses.action">
				<s:param name="pageNow" value="pageNow-1"></s:param>
			</s:url>
			<s:url id="url_next" value="courses.action">
				<s:param name="pageNow" value="pageNow+1"></s:param>
			</s:url>
<br><br><br>
			<s:a href="%{url_pre}">上一页</s:a>

			<s:iterator value="courses" status="status">
				<s:url id="url" value="courses.action">
					<s:param name="pageNow" value="pageNow" />
				</s:url>
			</s:iterator>
			<s:a href="%{url_next}">下一页</s:a>
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
									<img src="${ctx}/homepage/images/spacer.gif" width="1" height="1">
								</td>
							</tr>
						</table>
					</td>
					<td width="9" height="100%" background="${ctx}/homepage/images/back-right.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
	
	</BODY>
</html>