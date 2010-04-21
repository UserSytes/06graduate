<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>教学录像-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
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
							href="<s:url action="getCourseMovieListAction"> 
                					</s:url>">教学录像</a>&gt;列表浏览
					</h2>
					<br class="clear" />
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">						
						<tr>
							<td width="724" align="center">
								<!--게시판 -->
								<table border="0" cellpadding="0" cellspacing="0" width="704" class="table-list">
									<tr class="tr-title">
										<td width="48" height="40" align="center">
											序号
										</td>
										<td>
											&nbsp;
										</td>
										<td width="100" height="40" align="center">
											视频名称
										</td>
										<td>
											&nbsp;
										</td>
										<td width="182" height="40" align="center">
											简介
										</td>
										<td>
											&nbsp;
										</td>
										<td width="90" height="40" align="center">
											发布时间
										</td>
										<td>
											&nbsp;
										</td>
										<td width="78" height="40" align="center">
											观看
										</td>
									</tr>
									<s:iterator value="courseMovieList" status="courseMovie">
										<tr height="33" class="tr-content"
											<s:if test="#courseMovie.odd">style="background-color:#fFF"</s:if>>
											<td align="center">
												<s:property
														value="#courseMovie.count" />												
											</td>
											<td></td>

											<td width="100" align="center" style="font-weight: bold">
												<s:property
														value="title" />
											
											</td>
											<td></td>
											<td width="182" align="center">
												<s:property value="content" />
												
											</td>
											<td></td>
											<td width="90" align="center">
												<s:date name="time"
														format="yyyy-MM-dd" />
											
											</td>
											<td></td>
											<td width="78" align="center">
												<a
													href="<s:url action="watchMovieAction"> 
											                     			<s:param name="courseMovieId"> 
											                       			 	<s:property value="id"/> 
											                    			</s:param>
											                					</s:url>">
														<font color="green">【进入】</font>
												</a>												
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

								<!-- /페지검색 -->
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
