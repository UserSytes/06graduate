<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>课程评价-厦门大学课程网络平台</title>
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
							href="<s:url action="evaluateAction"> 
                					</s:url>">课程评价</a>&gt;详细浏览
					</h2>
					<br class="clear" />
				</div>
				<!-- 正文 -->
				<div>
					<table align="center" cellpadding="0" cellspacing="0"
						class="table-news-list">
						<tr>
							<td>
								<div class="newslist">
									<dl>
										<dt class="topic">
											学生评价
										</dt>

										<dd class="author" style="margin-top: -20px;">
											<span>&nbsp;</span>
										</dd>
										<dd class="desc">
											<span><font style="font-size: 16px;">&nbsp;&nbsp;&nbsp;平均得分:
													<s:property value="stuAvgScore" /> 分 <br /> </font> <font
												style="font-size: 16px;">&nbsp;&nbsp;&nbsp;评价人数: <s:property
														value="stuCount" /> 人 </font> </span>
										</dd>
									</dl>

									<dl>
										<dd class="detail">
											<span><a href="#">详细内容</a> | <a
												href="<s:url action="sDetailEvaluateAction"></s:url>">我要评价</a>
											</span>
										</dd>

									</dl>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="newslist">
									<dl>
										<dt class="topic">
											同行评价
										</dt>

										<dd class="author" style="margin-top: -20px;">
											<span>&nbsp;</span>
										</dd>
										<dd class="desc">
											<span><font style="font-size: 16px;">&nbsp;&nbsp;&nbsp;平均得分:
													<s:property value="teaAvgScore" /> 分 <br /> </font> <font
												style="font-size: 16px;">&nbsp;&nbsp;&nbsp;评价人数: <s:property
														value="teaCount" /> 人 </font> </span>
										</dd>
									</dl>

									<dl>
										<dd class="detail">
											<span><a href="teacherEvaluateResultAction.action">详细内容</a>
												| <a
												href="<s:url action="tDetailEvaluateAction"> 
                					</s:url>">我要评价</a>
											</span>
										</dd>

									</dl>
								</div>
							</td>
						</tr>
<tr>
							<td>
								<div class="newslist">
									<dl>
										<dt class="topic">
											专家评价
										</dt>

										<dd class="author" style="margin-top: -20px;">
											<span>&nbsp;</span>
										</dd>
										<dd class="desc">
											<span><font style="font-size: 16px;">&nbsp;&nbsp;&nbsp;平均得分:
													<s:property value="expertAvgScore" /> 分 <br /> </font> <font
												style="font-size: 16px;">&nbsp;&nbsp;&nbsp;评价人数: <s:property
														value="expertCount" /> 人 </font> </span>
										</dd>
									</dl>

									<dl>
										<dd class="detail">
											<span><a href="expertEvaluateResultAction.action">详细内容</a>
												| <a
												href="<s:url action="eDetailEvaluateAction"> 
                					</s:url>">我要评价</a>
											</span>
										</dd>

									</dl>
								</div>
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
