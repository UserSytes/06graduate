<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
		<LINK href="${ctx}/css/mail.css" type=text/css rel=stylesheet>
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<script>jQuery.noConflict();</script>
		<title></title>
		<style type="text/css">
.notefilter {
	background: #EEF4F9 url(${ctx}/teacher/images/iconleft.gif) no-repeat
		5px 50%;
}
</style>
	</head>
<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">

		<s:include value="../homepage/include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<s:include value="left.jsp"></s:include>
				</td>
				<td width="750" valign="top" align="right">
					<!-- main -->
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- main2 主u-26472 图-->
							<td valign="top">
								<img src="${ctx}/homepage/image/main_img2.jpg" border="0">
							</td>
							<!--/main2 主u-26472 图-->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr height="27">
							<!-- 主u-26472  -->
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11"></td>
										<td>
											<img style="float: left"  src="${ctx}/homepage/image/title_myletter.gif"
												border="0" alt="">
										</td>
									</tr>
									<tr height="3">
										<td width="11"></td>
										<td bgcolor="#d7d7d7" width="738"></td>
									</tr>
								</table>
							</td>
							<!--/ 主u-26472  -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr>
							<td valign="top" align="center">
	
		<div align="center" style="width: 100%">
			<div class="with_side wrap" align="center" style="width: 95%;">
				<div class="cm_header itemtitle s_clear">
					<ul>
						<a style="color: #09C; float: right; font-weight: 700;"
														href="${ctx}/student/newmail.jsp" title="撰写短消息">+
														写新消息</a>
													<li>
														<a href="getReceiveMailByStuAction.action"><span>收件箱</span>
														</a>
													</li>
													<li>
														<a href="getSendMailByStuAction.action"><span>发件箱</span>
														</a>
													</li>
													<li>
														<a href="getDraftByStuAction.action"><span>草稿箱</span>
														</a>
													</li>
					</ul>
				</div>
				<s:hidden name="mail.id"></s:hidden>
				<ul class="note" style="margin: 15px;">

					<li class="f_bold" style="font-size: 15px;">
						<s:property value="mail.title" />
						<span class="time" style="padding-left: 10px"><s:date
								name="mail.time" format="yyyy-MM-dd hh:mm:ss" /> </span>
					</li>
					<li>
						<cite>发送人：<s:property value="mail.sender.name" /> </cite>
					</li>
					<li>
						-------------------------------------
					</li>
					<li id="msg">
						<s:property value="mail.content" escape="false" />
					</li>

				</ul>
				<div class="notefilter">

					<a href="getReceiveMailByStuAction.action">返回列表</a>
					<a
						href="<s:url action="goReplyMailByStuAction"> 
                     			<s:param name="mailId"> 
                       			 	<s:property value="mail.id"/> 
                    			</s:param> 
                					</s:url>">回复</a>
						<a
						href="<s:url action="goReSendMailByStuAction"> 
                     			<s:param name="mailId"> 
                       			 	<s:property value="mail.id"/> 
                    			</s:param> 
                					</s:url>">转发</a>
					<a
						href="<s:url action="deleteMailByStuAction"> 
                     			<s:param name="mailId"> 
                       			 	<s:property value="mail.id"/> 
                    			</s:param> 
                					</s:url>"
						onclick="if (confirm('您确定要删除吗?')){return true;}">删除</a>
				</div></div>
		</div>
</td>		</tr>					</table>
					<!-- /内容 -->
				</td>
			</tr>
		</table>
		<!-- 底部 -->
		<s:include value="../homepage/include/bottom.jsp"></s:include>
	</body>
</html>