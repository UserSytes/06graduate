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
					<table border="0" cellpadding="0" cellspacing="0" class="table-info">
						<tr height="29">
							<td align="center">
								<font style="font-size: 16px; font-weight: bold">
									我对该课程的评价</font>
							</td>
						</tr>
						<tr height="19">
							<td class="timefont">
								<font class="timefont"><span style="float: left;">当前平均得分：<s:property
										value="stuAvgScore" />分  | 评价人数: <s:property
										value="stuCount" />人</span>
								</font><a
									style="float: right;"
									href="reStuEvaluationAction.action">我要重新评价</a>
								
							</td>
						</tr>
						<tr height="1" class="trborder">
							<td></td>
						</tr>
						<tr>
							<td>
								<table cellpadding="0" cellspacing="0" align="center">
									<tr>
										<td>
											<font style="font-size: 16px; font-weight: bold;">&nbsp; <br />
												<s:property value="scorestring" />
											</font>
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
