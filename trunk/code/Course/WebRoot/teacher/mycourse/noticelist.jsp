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
		<title>通知公告列表</title>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" language="javascript"
			src="${ctx}/js/jquery.dataTables.js" charset="gb2312"></script>
		<script type="text/javascript">
$(document).ready(function(){
oTable = $('#example').dataTable( {
			"bJQueryUI" :true,
			"sPaginationType" :"full_numbers",
			"aoColumns": [
			{ "sSortDataType": "dom-text", "sType": "numeric" },
			null,
			null,
			null,
			null,
			null]	
		});	

});
</script>
		<script language="javascript">
	function getNoticeByCourse(courseId) {
	   window.location.href="getNoticeListByCourseAction.action?courseId="+courseId;
	}
	function goAddNotice() {
	   window.location.href="goAddNoticeAction.action";
	}
</script>
		<style type="text/css" title="currentStyle">
@import "${ctx}/css/demo_page.css";

@import "${ctx}/css/demo_table_jui.css";

@import "${ctx}/css/jquery-ui-1.7.2.custom.css";

div,span,p,ul,li {
	text-align: left;
}

a {
	text-decoration: none;
}

a,a:link,a:visited {
	color: #036;
}

a:hover {
	color: #0000cd;
}

.tr-content td {
	color: #036;
}
</style>
	</head>
	<body id="dt_example">
		<div align="center"
			style="padding-left: 5px; padding-right: 5px; width: 98%">
			<table cellSpacing=1 cellPadding=0 width="100%"
				style="margin: 20px 0 20px 0; color: #000; BACKGROUND-COLOR: #87ceeb; border: 1px solid #666;"
				align=center border=0>
				<tr bgcolor="#B0E0E6" height="25">
					<td>
						当前位置: 课程通知管理 -&gt; 通知列表
					</td>
					<td width="300">
						请选择要查询的课程：&nbsp;&nbsp;&nbsp;
						<s:select id="courseId" name="courseId" list="courseList"
							listKey="id" listValue="name" headerValue="全部" headerKey="-1"
							onchange="getNoticeByCourse(this.value)" />

					</td>
					<td width="50">
						<input type="button" onclick="goAddNotice()" value="添加课程通知" />
					</td>
				</tr>
			</table>

			<div class="demo_jui" style="margin-top: 10px;">
				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					class="display" id="example">
					<thead>
						<tr>
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
					</thead>
					<s:iterator value="noticeList" status="notice">
						<tr class="tr-content" height="33">
							<td width="5%">
								<s:property value="#notice.count" />
							</td>
							<td width="40%">
								<s:property value="title" />
							</td>
							<td width="10%">
								<s:if test="sort==1">公告</s:if>
								<s:if test="sort==0">通知</s:if>
							<td width="15%">
								<s:property value="course.name" />
							</td>
							<td width="15%">
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
		</div>
	</body>
</html>