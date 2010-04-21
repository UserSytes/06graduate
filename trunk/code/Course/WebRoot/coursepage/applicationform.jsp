<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>申报表格-厦门大学课程网络平台</title>
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
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">申报表格</a>&gt;详细浏览
					</h2>
					<br class="clear" />
				</div>
				<!-- 正文 -->
				<div align="center">
					<table border="0" cellpadding="0" cellspacing="0">					
						<tr align="center">
							<td width="724" align="center">
								<!--게시판 -->
								<table border="1" cellpadding="0" cellspacing="0" width="600" class="table-app">
									<tr class="tr-title">
										<td width="600" height="40" align="center" colspan="2">
											<font style="font-size: 16px; font-weight: bold;">申报表格</font>
										</td>

									</tr>
									<tr height="34">
										<td width="200" align="center">
											推荐省份
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.province" />
										</td>
									</tr>
									<tr height="34">

										<td width="200" align="center">
											推荐单位
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.recommender" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											所属院校
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.school" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											课程名称
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.name" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											课程级别
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.level" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											课程类型
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.sort" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											所属一级学科名称
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.firstSubject" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											所属二级学科名称
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.secondSubject" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											课程负责人
										</td>
										<td width="290" align="center">
											<s:property value="applicationForm.responser" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											申报日期
										</td>
										<td width="290" align="center">
											<s:date name="applicationForm.time" format="yyyy-MM-dd" />
										</td>
									</tr>
									<tr height="34">
										<td width="200" align="center">
											申报表格下载
										</td>
										<td width="290" align="center">
											<a
												href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="applicationForm.fileLink"/> 
                    			</s:param> 
						<s:param name="originalFileName"> 
                       			 	<s:property value="applicationForm.filename"/> 
                    			</s:param> 
                					</s:url>"
												onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
												<font color="red">点此下载</font> </a>
										</td>
									</tr>
									<tr height="3" class="tr-title">
										<td colspan="3" width="630" align="center">
											中华人民共和国教育部制
										</td>
									</tr>

								</table>
								<!--/게시판 -->
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
