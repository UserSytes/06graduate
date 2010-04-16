<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<link id="cssfile" href="${ctx}/coursepage/style/<s:property value="#session.style"/>/color.css" rel="stylesheet"
			type="text/css" />
		<script src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"
			type="text/javascript"></script>

	</head>
	<script type="text/javascript">
	$( function() {
		$("#main_nav li:has(ul)").hover( function() {
			$(this).children("ul").stop(true, true).slideDown(500);
		}, function() {
			$(this).children("ul").stop(true, true).slideUp("fast");
		});
	})
</script>
	<body>
		<div class="content border_bottom">
			<ul id="sub_nav">
				<li>
					<a href="${ctx}/homepage/index.jsp">首页</a>
				</li>

				<li>
					<a
						href="javascript:window.external.addFavorite('http://www.yoursite.com','<s:property value="course.name" />-厦门大学课程网络平台')">加入收藏</a>
				</li>
				<li class="nobg">
					<a href="#">联系我们</a>
				</li>
			</ul>
			<img src="${ctx}/coursepage/style/green/logo.gif" alt="居然之家"
				name="logo" width="200" height="75" id="logo" />

			<br class="clear" />
		</div>
		<div class="content dgreen-bg">
			<div class="content">
				<ul id="main_nav">
					<li class="nobg">
						<a href="goIndexQueryAction.action">课程首页</a>
					</li>
					<li>
						<a
							href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">申报表格</a>
					</li>
					<li>
						<a href="#">课程简介</a>
						<ul>
							<li>
								<a
									href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程简介</a>
							</li>
							<li>
								<a
									href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	2 
                    			</s:param>
                					</s:url>">教学大纲</a>
							</li>
						</ul>
					</li>
					<li>
						<a
							href="<s:url action="findTeacherTeamAction"> 
                					</s:url>">教师队伍</a>
					</li>
					<li>
						<a href="#">通知公告</a>
						<ul>
							<li>
								<a
									href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	0 
                    			</s:param>
                					</s:url>">课程通知</a>
							</li>
							<li>
								<a
									href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程公告</a>
							</li>
						</ul>
					</li>



					<li>
						<a href="#">课程教案</a>
						<ul>
							<li>
								<a
									href="<s:url action="getAllCoursewareAction"> 
                					</s:url>">课件教案</a>
							</li>
							<li>
								<a
									href="<s:url action="getAllExerciseAction"> 
                					</s:url>">作业习题</a>
							</li>
							<li>
								<a
									href="<s:url action="getAllExperimentAction"> 
                					</s:url>">实验指导</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">课程相关</a>
						<ul>
							<li>
								<a
									href="<s:url action="getCourseMovieListAction"> 
                					</s:url>">教学录像</a>
							</li>
							<li>
								<a
									href="<s:url action="getAllExaminationAction"> 
                					</s:url>">课程试卷</a>
							</li>
							<li>
								<a
									href="<s:url action="getAllBookAction"> 
                					</s:url>">参考书籍</a>
							</li>
						</ul>
					</li>
					<li>
						<a
							href="<s:url action="findAchievementAction"> 
                					</s:url>">教学成果</a>
					</li>
					<li>
						<a
							href="<s:url action="evaluateAction"> 
                					</s:url>">课程评价</a>
					</li>
					<li>
						<a
							href="<s:url action="showTopicsAction"> 
                					</s:url>">师生留言</a>
					</li>



				</ul>
				<br class="clear" />

			</div>
		</div>
		<div class="content" id="top-adv">
			<img src="${ctx}/coursepage/style/green/top-adv.gif" alt="" />
		</div>
	</body>
</html>
