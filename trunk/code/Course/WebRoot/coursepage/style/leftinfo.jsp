<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<h2>
	公告信息
</h2>
<div class="notice-list">
	<div>
		<table border="0" cellpadding="0" cellspacing="0">
			<s:iterator value="noticeList2" status="notice">
				<tr>
					<td width="210">
						&nbsp;&nbsp;
						<img src="${ctx}/homepage/image/but.jpg" border="0" alt="">
						&nbsp;&nbsp;
						<a
							href="<s:url action="viewNoticeAction"> <s:param name="noticeId"> 
	                       			 									<s:property value="id"/> </s:param> </s:url>"
							title="<s:property value="title" />"> <s:if
								test="title.length()>16">
								<s:property value="title.substring(0, 16)+'...'" />
							</s:if> <s:else>
								<s:property value="title" />
							</s:else> </a> &nbsp;
						<s:date name="time" format="yyyy.MM.dd" />
					</td>
				</tr>
				<tr height="1">
					<td width="331" colspan="2"
						background="${ctx}/homepage/image/main_line.gif"></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</div>
<br>
<h2>
	任课教师
</h2>

<ul>
	<li><img width="80"  style="max-height: 120;max-width: 100;" src="${ctx}/upload/<s:property value="userInfo.photo"/>" />
	</li>	
<li>
		姓名：
		<s:property value="userInfo.name" />
	</li>
	<li>
		职称：
		<s:property value="teacher.position" />
	</li>
	<li>
		电话：
		<s:property value="userInfo.mobile" />
	</li>
	<li>
		Email：
		<s:property value="userInfo.email" />
	</li>

</ul>
<br>
<span id="hits">现在已经有[<s:property value="course.count" />]次点击</span>

