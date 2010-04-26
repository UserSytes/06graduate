<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>信息提示-留言板-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />

	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/%{#session.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="showTopicsAction"> 
                					</s:url>">师生留言</a>&gt;信息提示
					</h2>
				</div>

				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">						
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="700">
									<tr>	<td width="100"></td>									
										<td width="600" align="left">
											<br />
											<font size="3"><strong ><s:fielderror /> </strong> </font>
											<font style="font-size: 14px; color: #574434"><strong><s:actionmessage />
											</strong> </font>
											<font style="font-size: 14px; color: #574434"><strong><s:actionerror />
											</strong> </font>											
											<a
												href="<s:url action="showTopicsAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												<font style="font-size: 14px; color: #574434">请点此查看主题列表</font>
											</a>
										</td>										
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
