<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><s:property value="achievement.title"></s:property>-成果展示-厦门大学课程网络平台</title>
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
							href="<s:url action="findAchievementAction"> 
                					</s:url>">教学成果</a>&gt;详细浏览
					</h2>
					<br class="clear" />
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table-info">
						<tr height="29">
							<td align="center">
								<font style="font-size: 16px; font-weight: bold"><s:property
										value="achievement.title" /> </font>
							</td>
						</tr>
						<tr height="19">
							<td>
								<font class="timefont">发布时间：<s:date
										name="achievement.time" format="yyyy-MM-dd hh:mm:ss" /> </font>
							</td>
						</tr>
						<tr height="1" class="tr-title">
							<td></td>
						</tr>
						<tr>
							<td width="704">
								<table border="0" cellpadding="0" cellspacing="0" width="100%" style="padding: 10px;">
									<tr><td>
											<s:property
													value="achievement.content" escape="false" /><font style="font-size: 14px; color: #74582f"> <br /> 附件：<a
												href="<s:url action="download"> 
                     			<s:param name="achievement.fileName"> 
                       			 	<s:property value="achievement.fileLink"/> 
                    			</s:param> 
                					</s:url>"
												onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
													<font color="red"><s:property value="achievement.fileName" /></font> </a> </font>
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
		<s:include value="style/bottom.jsp"></s:include>
	</body>
</html>
