<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>教学成果-厦门大学课程网络平台</title>
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
							href="<s:url action="findAchievementAction"> 
                					</s:url>">教学成果</a>&gt;成果列表
					</h2>
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" align="center" cellpadding="0" cellspacing="0"
						width="704"
						style="padding-top: 30px; padding-left: 5px; padding-right: 5px;">
						<s:iterator value="achievementList" status="achievement">
							<tr>
								<td>
									<div class="newslist" >
										<dl>
											<dt class="topic">
												<a
													href="<s:url action="viewAchievementAction">
								<s:param name="achievementId"> 
								<s:property value="id"/> 
								</s:param>
								</s:url>"><strong><s:property
															value="title" /> </strong> </a>
											</dt>

											<dd class="author">
												<span>发布于 <s:date name="time" format="yyyy-MM-dd" />
												</span>
											</dd>
											<dd class="desc">
												<span><s:if test="content.length()>200">
														<s:property value="content.substring(0, 200)+'...'"
															escape="false" />
													</s:if> <s:else>
														<s:property value="content" escape="false" />
													</s:else> </span>
											</dd>
										</dl>

										<dl>
											<dd class="detail">
												<span><a
													href="<s:url action="viewAchievementAction">
								<s:param name="achievementId"> 
								<s:property value="id"/> 
								</s:param>
								</s:url>"><strong>详细内容</strong>
												</a> </span>

												<em></em>
											</dd>

										</dl>
									</div>

								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>

			<br class="clear" />
		</div>
		<s:include value="style/bottom.jsp"></s:include>
	</body>
</html>
