<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<script src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"
			type="text/javascript"></script>
		<link href="${ctx}/coursepage/style/common/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="${ctx}/coursepage/style/common/interface.js"></script>
	</head>
	<style type="text/css">
div,img {
	behavior: url(${ctx}/coursepage/style/common/iepngfix.htc)
}
</style>
	<script type="text/javascript">
	$(document).ready( function() {
		$('#dock').Fisheye( {
			maxWidth :55,
			items :'a',
			itemsText :'span',
			container :'.dock-container',
			itemWidth :45,
			proximity :90,
			halign :'center'
		})
	});
</script>

	<body>


		<div class="dock" id="dock">
			<div class="dock-container">
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/home.png" alt="首页" /><span>首页</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/form.gif" alt="申报表格" /><span>申报表格</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/info.png" alt="课程简介" /><span>课程简介</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/outline.png" alt="教学大纲" /><span>教学大纲</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/teateam.png" alt="教师队伍" /><span>教师队伍</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/notice.png" alt="通知公告" /><span>通知公告</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/ppt.png" alt="课程教案" /><span>课程教案</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/exercise.png" alt="作业习题" /><span>作业习题</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/lab.png" alt="实验指导" /><span>实验指导</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/ituna.png" alt="教学录像" /><span>教学录像</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/textedit.png" alt="课程试卷" /><span>课程试卷</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/book.png" alt="参考书籍" /><span>参考书籍</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/achievement.png" alt="教学成果" /><span>教学成果</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/evaluation.png" alt="课程评价" /><span>课程评价</span>
				</a>
				<a class="dock-item" href="#"><img
						src="${ctx}/coursepage/style/blue/message.png" alt="留言板" /><span>留言板</span>
				</a>
			</div>
		</div>

		<div class="content border_bottom">

			<img src="${ctx}/coursepage/style/blue/logo.gif" alt="居然之家"
				name="logo" width="200" height="75" id="logo" />

			<br class="clear" />
		</div>
		<div class="content" id="top-adv">
			<img src="${ctx}/coursepage/style/green/top-adv.gif" alt="" />
		</div>
	</body>
</html>
