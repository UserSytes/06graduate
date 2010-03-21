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
		<title>学生列表</title>
<script language="javascript">
	function getNoticeByCourse(courseId) {
	   window.location.href="getNoticeListByCourseAction.action?courseId="+courseId;
	}
	function goAddNotice() {
	   window.location.href="goAddNoticeAction.action";
	}
</script>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程通知管理 -&gt; 通知列表
				</td>
			</tr>
		</table>

      <table class=listTable align="center">
			<tr>
				<td>
					请选择要查询的课程：&nbsp;&nbsp;&nbsp;
					<s:select id="courseId" name="courseId" list="courseList"
							listKey="id" listValue="name" headerValue="全部"
							headerKey="-1" onchange="getNoticeByCourse(this.value)"/>

				</td><td><div align="right">
						<input type="button" onclick="goAddNotice()" value="添加课程通知" />
					</div></td>
			</tr>
		</table>
		<div align="center">		
				<table class="listTable">
					<tr class="listHeaderTr"
						<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
						<th>
							序号
						</th>	
						<th>
							标题
						</th>
						<th>
							类别
						</th>
						<th>
							所属课程
						</th>
						<th>
							发布时间
						</th>			
						<th>
							操作
						</th>
					</tr>
					<s:iterator value="noticeList" status="notice">
						<tr class="listTr">
							<td width="5%">
								<s:property value="#notice.count" />
							</td>
							<td width="30%">
								<s:property value="title" />
							</td>
							<td width="10%">
								<s:if test="sort==1">公告</s:if>
								<s:if test="sort==0">通知</s:if>
							<td width="15%">
								<s:property value="course.name" />
							</td>
							<td width="25%">
								<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />
							</td>							
							<td width="15%">
								<a
									href="<s:url action="goEditNoticeAction"> 
                     			<s:param name="noticeId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
									<font color="green">【编辑】</font> </a>
								<a
									href="<s:url action="deleteNoticeAction"> 
                     			<s:param name="noticeId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
									onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
									<font color="red">【删除】</font> </a>
							</td>
						</tr>
					</s:iterator>
				</table>
		</div>
	</body>
</html>