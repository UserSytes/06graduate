<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>实验指导-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/<s:property value="course.style"/>/color.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="style/%{course.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="getAllExperimentAction"> 
                					</s:url>">实验指导</a>&gt;详细浏览
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
									background="${ctx}/coursepage/classical/image/titlebg2.gif"
									style="background-repeat: no-repeat">
									<tr>
										<td width="724" valign="top" align="right">											
										</td>
									</tr>
									<tr height="69">
										<td valign="bottom" align="left">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td class="table-title">
														实验指导
													</td>
												</tr>
												<tr>
													<td>														
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="1">
										<td width="724" class="td-foot" valign="top"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr height="20">
							<td></td>
						</tr>
						<tr>
							<td width="750" align="center">
								<!--게시판 -->
								<table border="0" cellpadding="0" cellspacing="0" width="724">
									<tr height="3" class="tr-head">
										<td colspan="14"></td>
									</tr>
									<tr class="tr-title">
										<td width="48" height="40" align="center">
											序号
										</td>
										<td>
											&nbsp;
										</td>
										<td width="150" height="40" align="center">
											实验文档名称
										</td>
										<td>
											&nbsp;
										</td>
										<td width="100" height="40" align="center">
											章节
										</td>
										<td>
											&nbsp;
										</td>
										<td width="70" height="40" align="center">
											作者
										</td>
										<td>
											&nbsp;
										</td>
										<td width="62" height="40" align="center">
											发布时间
										</td>
										<td>
											&nbsp;
										</td>
										<td width="68" height="40" align="center">
											链接
										</td>
									</tr>
									<s:iterator value="experimentList" status="experiment">
										<tr height="33" class="tr-content"
											<s:if test="#experiment.odd">style="background-color:#fff"</s:if>>
											<td align="center">
												<s:property
														value="#experiment.count" />
											</td>
											<td></td>
											<td width="150" align="center" style="font-weight: bold">
												<s:property value="title" />
											</td>
											<td></td>
											<td width="100" align="center">
												<s:property
														value="chapter.name" />
											</td>
											<td></td>
											<td width="70" align="center">
												<s:property value="author" />
											</td>
											<td></td>
											<td width="62" align="center">
												<s:date name="time"
														format="yyyy-MM-dd" />
											</td>
											<td></td>
											<td width="68" align="center">
												<a
													href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="fileLink"/> 
                    			</s:param>  
<s:param name="originalFileName"> 
                       			 	<s:property value="filename"/> 
                    			</s:param> 
                					</s:url>"
													onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
														<font color="red">点此下载</font> </a>
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
