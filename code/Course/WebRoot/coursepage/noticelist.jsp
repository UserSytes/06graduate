<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><s:if test="sort==0">
课程通知</s:if> <s:else>课程公告</s:else>-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link
			href="${ctx}/coursepage/style/<s:property value="course.style"/>/color.css"
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
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	<s:property value="sort" /> 
                    			</s:param>
                					</s:url>"><s:if
								test="sort==0">
课程通知</s:if> <s:else>课程公告</s:else> </a>&gt;列表浏览
					</h2>
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="724" align="center">
								<!--게시판 -->
								<table border="0" cellpadding="0" cellspacing="0" width="704"
									class="table-list">
									<tr class="tr-title">
										<td width="48" height="40" align="center">
											序号
										</td>
										<td>
											&nbsp;
										</td>
										<td width="319" height="40" align="center" colspan="2">
											标题
										</td>
										<td>
											&nbsp;
										</td>
										<td width="83" height="40" align="center">
											发布时间
										</td>
										<td>
											&nbsp;
										</td>
										<td width="48" height="40" align="center">
											点击量
										</td>
									</tr>
									<s:iterator value="noticeList" status="notice">
										<tr height="33" class="tr-content"
											<s:if test="#notice.odd">style="background-color:#fff"</s:if>>
											<td align="center">
												<s:property value="#notice.count" />
											</td>
											<td></td>
											<td width="10"></td>
											<td width="239" align="center" style="font-weight: bold">
												<a
													href="<s:url action="viewNoticeAction"> 
											                     			<s:param name="noticeId"> 
											                       			 	<s:property value="id"/> 
											                    			</s:param>
																			<s:param name="sort"> 
											                       			 	<s:property value="sort"/>
											                    			</s:param>
											                					</s:url>"><s:property
														value="title" /> </a>
											</td>
											<td></td>
											<td width="83" align="center">
												<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />
											</td>
											<td></td>
											<td width="48" align="center">
												12
											</td>
										</tr>
									</s:iterator>
									<tr height="4">
										<td></td>
									</tr>
									<tr height="3" class="tr-foot">
										<td colspan="14" width="630"></td>
									</tr>
								</table>
								<!--/게시판 -->
							</td>
						</tr>
						<tr>
							<td>
								<!-- 페지검색 -->
								<table border="0" cellpadding="0" cellspacing="0">
								</table>
								<!-- /페지검색 -->
							</td>
						</tr>
						<tr>
							<td width="724" align="center">
								<!--검색 -->
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<td>
											<s:form action="getNoticeByNameAndSortAction"
												onsubmit="return check(this);" method="post"
												enctype="multipart/form-data">
												<table border="0" cellpadding="0" cellspacing="0"
													width="724">
													<tr height="40" class="tr-title">
														<td width="7"></td>
														<td>
															<img src="${ctx}/coursepage/classical/image/search.gif"
																border="0">
														</td>
														<td width="8"></td>
														<td>
															<s:select name="searchFlag"
																cssStyle="width:73px;height:21px;background-color:#ffffff;color:#777777"
																list="# {'0':'通知','1':'公告'}" headerKey="-1"
																headerValue="请选择" />
														</td>
														<td width="3"></td>
														<td>
															<s:textfield name="keyword" cssClass="text" size="40" />
														</td>
														<td width="5"></td>
														<td>
															<input type="submit" name="submit" value=" 查 询 "
																style=" background-image:${ctx}/coursepage/classical/image/button3.gif;">
														</td>
														<td width="200"></td>
														<td>
															<!--<a href="#"><img src="${ctx}/coursepage/classical/image/button2.gif" border="0"></a>
-->
														</td>
														<td width="6"></td>
												</table>
											</s:form>
										</td>
									</tr>
								</table>
								<!--/검색 -->
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
