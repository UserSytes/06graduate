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
		<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="style/header.jsp"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a href="<s:url action="getCourseMovieListAction"> 
                					</s:url>">教学录像</a>&gt;列表浏览
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
								<table border="0" cellpadding="0" cellspacing="0" width="724" height="94" background="${ctx}/coursepage/classical/image/titlebg5.gif" style="background-repeat:no-repeat">
						<tr>
							<td width="724" valign="top" align="right"><font style="font-size:12px; color:#574434"></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold"></font></td>
								</tr>
								<tr>
									<td><font color="#92a35d"style="font-size:12px;"></font></td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="724" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
					<td width="724" align="center">
						<!--게시판 -->
						<table border="0" cellpadding="0" cellspacing="0" width="724">
						<tr height="3" bgcolor="#d3b981"><td colspan="14"></td></tr>
						<tr bgcolor="#f1e1be">
							<td width="48" height="40" align="center"><font style="font-size:14px;font-weight:bold;">序号</font></td>
							<td>&nbsp;</td>
							<td width="100" height="40" align="center"><font style="font-size:14px;font-weight:bold;">视频名称</font></td>
							<td>&nbsp;</td>
							<td width="182" height="40" align="center"><font style="font-size:14px;font-weight:bold;">简介</font></td>
							<td>&nbsp;</td>
							<td width="90" height="40" align="center"><font style="font-size:14px;font-weight:bold;">发布时间</font></td>
							<td>&nbsp;</td>
							<td width="78" height="40" align="center"><font style="font-size:14px;font-weight:bold;">观看</font></td>
						</tr>
<s:iterator value="courseMovieList" status="courseMovie">
						<tr height="33" bgcolor="#fdfbf3" <s:if test="#courseMovie.even">style="background-color:#faefda"</s:if>>
							<td align="center"><font color="#74582f"><s:property value="#courseMovie.count" /></font></td>
							<td></td>
							
							<td width="100" align="center"><font color="#74582f" style="font-size:12px;font-weight:bold;"><s:property value="title" /></font></td> 
							<td></td>
							<td width="182" align="center"><font color="#74582f"><s:property value="content" /></font></td>
							<td></td>
							<td width="90" align="center"><font color="#74582f"><s:date name="time" format="yyyy-MM-dd" /></font></td>	
							<td></td>
							<td width="78" align="center"><font color="#74582f"><a href="<s:url action="watchMovieAction"> 
											                     			<s:param name="courseMovieId"> 
											                       			 	<s:property value="id"/> 
											                    			</s:param>
											                					</s:url>">
																			<font color="green">【进入】</font></a></font></td></tr>
</s:iterator>					
						<tr height="4"><td></td></tr>
						<tr height="1" bgcolor="#d3b981"><td colspan="14"></td></tr>
						<tr height="3" bgcolor="#eedcb3"><td colspan="14" width="630"></td></tr>
						</table>
						<!--/게시판 -->
					</td></tr>
<tr>
					<td>
						<!-- 페지검색 -->
						
						<!-- /페지검색 -->
					</td></tr>
						</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="style/bottom.jsp"></s:include>
	</body>
</html>
