<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>我的课程</title>
	</head>

	<body onload="getCourseByType(3)">
		<script type="text/javascript" src="../js/prototype.js"></script>
		<script language="javascript">
	function getCourseByState() {
		document.getElementById("form").submit();
	}
	function getCourseByType(type) {
		var url = "getMyCourseByStateAction.action?type=" + type;
		new Ajax.Updater('courseListMain', url, {
			onLoading : function() {
			},
			onSuccess : function(request) {
			},
			onFailure : function(request) {
				alert("服务器故障，请稍候重试");
			}
		});
	}
	function deleteCourse(courseId) {
		if (!confirm('确认删除？'))
			return false;
		var url = "deleteCourseAction.action?courseId=" + courseId;
		new Ajax.Updater('courseListMain', url, {
			onLoading : function() {
			},
			onSuccess : function(request) {
			},
			onFailure : function(request) {
				alert("服务器故障，请稍候重试");
			}
		});
	}
</script>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程申报 -&gt; 课程申报
				</td>
			</tr>
		</table>
		<table class=listTable align="center">
			<tr>
				<td>
					请选择查询条件：&nbsp;&nbsp;&nbsp;
					<s:select name="type" list="#{3:'全部课程',2:'审核未通过',1:'己审核',0:'未审核'}"
						listKey="key" listValue="value"
						onchange="javascript:getCourseByType(this.value)" />
				</td>
			</tr>
		</table>
		<div id="courseListMain" align="center">
			<s:include value="courseslist.jsp"></s:include>
		</div>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<div style="border: 1px solid #ccc;">
				<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
				<strong><font color="red" size="3"> 提示</font> </strong>
				<div id="content_note">
					<ul>
						<li>
							申请新的课程后需要等待教学秘书审核通过才能进行上传课件等操作。
						</li>
						<li>
							己审核的课程可以通过选择左边导航菜单中"我的课程"进行相关操作。
						</li>
						<li>
							如果您的课程长时间未审核通过，请向教学秘书反映相关情况。
						</li>
						<li>
							删除某课程会把与该课程所有有关的信息全部删除，请谨慎选择。
						</li>
						<li>
							如果您希望课程不被公开访问，请点击课程详情，选择公开访问为否。
						</li>
					</ul>

				</div>
			</div>
		</table>
	</body>
</html>
