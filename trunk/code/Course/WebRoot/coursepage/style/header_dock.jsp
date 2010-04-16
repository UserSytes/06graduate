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
		<link id="cssfile"
			href="${ctx}/coursepage/style/<s:property value="#session.style"/>/color.css"
			rel="stylesheet" type="text/css" />
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
				<a class="dock-item" href="${ctx}/homepage/index.jsp"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/home.png" alt="首页" /><span>首页</span>
				</a>
				<a class="dock-item"
					href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/form.png" alt="申报表格" /><span>申报表格</span>
				</a>
				<a class="dock-item"
					href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/info.png" alt="课程简介" /><span>课程简介</span>
				</a>
				<a class="dock-item"
					href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	2 
                    			</s:param>
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/outline.png" alt="教学大纲" /><span>教学大纲</span>
				</a>
				<a class="dock-item"
					href="<s:url action="findTeacherTeamAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/teateam.png" alt="教师队伍" /><span>教师队伍</span>
				</a>
				<a class="dock-item"
					href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	0 
                    			</s:param>
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/notice.png" alt="通知公告" /><span>通知公告</span>
				</a>
				<a class="dock-item"
					href="<s:url action="getAllCoursewareAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/ppt.png" alt="课程教案" /><span>课程教案</span>
				</a>
				<a class="dock-item"
					href="<s:url action="getAllExerciseAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/exercise.png" alt="作业习题" /><span>作业习题</span>
				</a>
				<a class="dock-item"
					href="<s:url action="getAllExperimentAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/lab.png" alt="实验指导" /><span>实验指导</span>
				</a>
				<a class="dock-item"
					href="<s:url action="getCourseMovieListAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/ituna.png" alt="教学录像" /><span>教学录像</span>
				</a>
				<a class="dock-item"
					href="<s:url action="getAllExaminationAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/textedit.png" alt="课程试卷" /><span>课程试卷</span>
				</a>
				<a class="dock-item"
					href="<s:url action="getAllBookAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/book.png" alt="参考书籍" /><span>参考书籍</span>
				</a>
				<a class="dock-item"
					href="<s:url action="findAchievementAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/achievement.png" alt="教学成果" /><span>教学成果</span>
				</a>
				<a class="dock-item"
					href="<s:url action="evaluateAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/evaluation.png" alt="课程评价" /><span>课程评价</span>
				</a>
				<a class="dock-item"
					href="<s:url action="showTopicsAction"> 
                					</s:url>"><img
						src="${ctx}/coursepage/style/<s:property value="#session.style"/>/message.png" alt="留言板" /><span>留言板</span>
				</a>
			</div>
		</div>

		<div class="content border_bottom">

			<img src="${ctx}/coursepage/style/<s:property value="#session.style"/>/logo.gif" alt="居然之家"
				name="logo" width="200" height="75" id="logo" />

			<br class="clear" />
		</div>
		<div class="content" id="top-adv">
			<img src="${ctx}/coursepage/style/green/top-adv.gif" alt="" />
		</div>
	</body>
</html>
