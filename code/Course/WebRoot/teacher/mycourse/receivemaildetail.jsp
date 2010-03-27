<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/mail.css" type=text/css rel=stylesheet>
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<title></title>
		<style type="text/css">
.notefilter {
	background: #EEF4F9 url(${ctx}/teacher/images/iconleft.gif) no-repeat
		5px 50%;
}
</style>
		<script type="text/javascript">
			
</script>

	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 教师信息 -&gt; 消息管理 -&gt;查看短消息
				</td>
			</tr>
		</table>

		<div class="with_side wrap" align="center" style="width: 95%;">
			<div class="cm_header itemtitle s_clear">
				<ul>
					<a style="color: #09C; float: right; font-weight: 700;"
						href="${ctx}/teacher/mycourse/newmail.jsp?height=350&width=550"
						class="thickbox" title="撰写短消息">+ 写新消息</a>
					<li>
						<a href="#"><span>收件箱</span> </a>
					</li>
					<li>
						<a href="#"><span>发件箱</span> </a>
					</li>
					<li>
						<a href="#"><span>草稿箱</span> </a>
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
				<li>-------------------------------------</li>
				<li id="msg">
					<s:property value="mail.content" escape="false" />
				</li>

			</ul>
			<div class="notefilter">

				<a href="getReceiveMailByTeaAction.action">返回列表</a>
				<a
					href="<s:url action="goReplyMailAction"> 
                     			<s:param name="mailId"> 
                       			 	<s:property value="mail.id"/> 
                    			</s:param> 
                					</s:url>">回复</a>
				<a href="usercpshowpm.aspx?action=noread&amp;pmid=529018">标记为未读</a>
				<a href="usercpshowpm.aspx?action=delete&amp;pmid=529018"
					onclick="if (confirm('您确定要删除吗?')){return true;}">删除</a>
			</div>


		</div>

	</body>
</html>