<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<html>	
  <head>
	</head>
  <body>
    <div id="left-nav-bar" class="bg_white">
		  <h2>公告信息</h2>
			 <div id="demo" style="overflow: hidden; height: 232px; width: 210px; border: 0px solid #dde5bc;">
																					<div id="demo1">
																						<table border="0" cellpadding="0" cellspacing="0">
																							<s:iterator value="noticeList2" status="notice">
																								<tr>
																									<td width="210">
																										&nbsp;&nbsp;
																										<img src="${ctx}/homepage/image/but.jpg"
																											border="0" alt="">
																										&nbsp;&nbsp;
																										<a href="<s:url action="viewNoticeAction"> <s:param name="noticeId"> 
	                       			 									<s:property value="id"/> </s:param> </s:url>" title="<s:property value="title" />">
																											<s:if test="title.length()>16"> 
      																											<s:property value="title.substring(0, 16)+'...'" />
																											</s:if> <s:else>
																												<s:property value="title" />
																											</s:else> </a> &nbsp;<s:date name="time" format="yyyy.MM.dd" />
																									</td>
																								</tr>
																								<tr height="1">
																									<td width="331" colspan="2"
																										background="${ctx}/homepage/image/main_line.gif"></td>
																								</tr>
																							</s:iterator>
																						</table>
																					</div>
																					<div id="demo2"></div>
																				</div>
																				<script>
	var speed = 80
	var demo = document.getElementById("demo");
	var demo2 = document.getElementById("demo2");
	var demo1 = document.getElementById("demo1");
	demo2.innerHTML = demo1.innerHTML
	function Marquee() {
		if (demo2.offsetTop - demo.scrollTop <= 0)
			demo.scrollTop -= demo1.offsetHeight
		else {
			demo.scrollTop++
		}
	}
	var MyMar = setInterval(Marquee, speed)
	demo.onmouseover = function() {
		clearInterval(MyMar)
	}
	demo.onmouseout = function() {
		MyMar = setInterval(Marquee, speed)
	}
</script>
		  <br>
<h2>任课教师</h2>
		  <ul>
&nbsp;&nbsp;<img width="48" src="<s:property value="userInfo.photo" />"/>
			 <li>姓名：<s:property value="userInfo.name" /></li>
			  <li>职称：<s:property value="teacher.position" /></li>
			  <li>电话：<s:property value="userInfo.mobile" /></li>
			  <li>Email：<s:property value="userInfo.email" /></li>

		  </ul>

		  <span id="hits">现在已经有[132342342342]次点击</span>
  </div> 
  </body>
</html>
