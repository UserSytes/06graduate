<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>优秀作业-厦门大学课程网络平台</title>
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
							href="<s:url action="getAllExerciseAction"> 
                					</s:url>">作业习题</a>&gt;优秀作业 
					</h2>
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">						
						<tr>
							<td width="724" align="center">
								<!--게시판 -->
								<table border="0" cellpadding="0" cellspacing="0" width="704" class="table-list">
									<tr class="tr-title">
										<td width="30" height="40" align="center">
											序号
										</td>
										<td>
											&nbsp;
										</td>
										<td width="200" height="40" align="center">
											作业名称
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
										<td width="180" height="40" align="center">
											评语
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
									<s:iterator value="excellentWorkList" status="excellentWork">
										<tr height="33" class="tr-content"
											<s:if test="#excellentWork.odd">style="background-color:#FFF"</s:if>>
											<td align="center" width="30">
												<s:property value="#excellentWork.count" />
											</td>
											<td></td>

											<td width="200" align="center" style="font-weight: bold;">
												<s:property value="title" />
											</td>
											<td></td>
											<td width="70" align="center">
													<s:property value="author" />
											</td>
											<td></td>
											<td width="180" align="center">
												<s:property value="reason" />
											</td>
											<td></td>
											<td width="62" align="center">
												<s:date name="time" format="yyyy-MM-dd" />
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
