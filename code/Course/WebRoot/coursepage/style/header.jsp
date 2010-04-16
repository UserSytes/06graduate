<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<link type="text/css" href="${ctx}/coursepage/style/common/easyui.css"
			rel="stylesheet" />
		<link id="cssfile"
			href="${ctx}/coursepage/style/<s:property value="#session.style"/>/color.css"
			rel="stylesheet" type="text/css" />
		<script src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"
			type="text/javascript"></script>
		<script src="${ctx}/js/jquery.easyui.min.js" type="text/javascript"></script>


	</head>
	<script type="text/javascript">
	$( function() {
		$("#main_nav li:has(ul)").hover( function() {
			$(this).children("ul").stop(true, true).slideDown(500);
		}, function() {
			$(this).children("ul").stop(true, true).slideUp("fast");
		});
		
		$("#blue").click( function() {
			$.post("changeColorAction.action", {
				color :'blue'
			}, callBack, "json");
		});
		$("#green").click( function() {
			$.post("changeColorAction.action", {
				color :'green'
			}, callBack, "json");
		});
		$("#orange").click( function() {
			$.post("changeColorAction.action", {
				color :'orange'
			}, callBack, "json");
		});
		$("#white").click( function() {
			$.post("changeColorAction.action", {
				color :'white'
			}, callBack, "json");
		});
		$("#red").click( function() {
			$.post("changeColorAction.action", {
				color :'red'
			}, callBack, "json");
		});
		$("#purple").click( function() {
			$.post("changeColorAction.action", {
				color :'purple'
			}, callBack, "json");
		});
		$("#gray").click( function() {
			$.post("changeColorAction.action", {
				color :'gray'
			}, callBack, "json");
		});
		$("#pink").click( function() {
			$.post("changeColorAction.action", {
				color :'pink'
			}, callBack, "json");
		});

		function callBack(data) {
			if (data == null)
				return;			
			$("#cssfile").attr("href",
					"${ctx}/coursepage/style/" + data + "/color.css"); //设置不同皮肤		
			$("#logo").attr("src",
					"${ctx}/coursepage/style/" + data + "/logo.gif");
		}
	})
</script>

	<script type="text/javascript">
	function changeHeader(header) {
		window.location.href = "changeHeaderAction.action?header=" + header;
	}
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
				<li>
					<a href="#" style="margin-top: -5px" id="mb1"
						class="easyui-menubutton" menu="#mm1">风格设置</a>
				</li>
			</ul>
			<img src="${ctx}/coursepage/style/green/logo.gif" alt="居然之家"
				name="logo" width="200" height="75" id="logo" />

			<br class="clear" />

			<div id="mm1" style="width: 100px;">
				<div>
					<span>风格</span>
					<div style="width: 100px;">
						<div id="blue">
							蓝色
						</div>
						<div id="green">
							绿色
						</div>
						<div id="white">
							白色
						</div>
						<div id="gray">
							灰色
						</div>
						<div id="orange">
							橙色
						</div>
						<div id="pink">
							粉色
						</div>
						<div id="purple">
							紫色
						</div>
						<div id="red">
							红色
						</div>
					</div>
				</div>
				<div>
					<span>导航菜单</span>
					<div style="width: 100px;">
						<div id="trad" onclick="changeHeader('header.jsp')">
							导航一
						</div>
						<div id="dock" onclick="changeHeader('header_dock.jsp')">
							导航二
						</div>
						<div id="sand" onclick="changeHeader('header_sand.jsp')">
							导航三
						</div>
					</div>
				</div>
			</div>
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
