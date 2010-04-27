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
		<link type="text/css" href="${ctx}/coursepage/style/common/menu.css"
			rel="stylesheet" />
		<link type="text/css" href="${ctx}/coursepage/style/common/easyui.css"
			rel="stylesheet" />
		<script src="${ctx}/js/jquery.easyui.min.js" type="text/javascript"></script>
		<script type="text/javascript"
			src="${ctx}/coursepage/style/common/fisheye-iutil.min.js"></script>
		<script type="text/javascript"
			src="${ctx}/coursepage/style/common/jquery.jqDock.min.js"></script>
		<link id="cssfile"
			href="${ctx}/coursepage/style/<s:property value="#session.style"/>/color.css"
			rel="stylesheet" type="text/css" />
	</head>

	<style type="text/css">
#corner {
	background: transparent url(${ctx}/coursepage/style/common/2x.png)
		no-repeat top right;
	position: absolute;
	top: 0px;
	right: 0px;
	z-index: 9999;
}

#corner img {
	border: 0;
	width: 80px;
	height: 80px;
	-ms-interpolation-mode: bicubic;
}
</style>

	<script type="text/javascript">
	$( function() {
		var de = document.documentElement;
		var db = document.body;
		var viewW = de.clientWidth == 0 ? db.clientWidth : de.clientWidth;
		var viewH = de.clientHeight == 0 ? db.clientHeight : de.clientHeight;

		$('#dock').Fisheye( {
			maxWidth :45,
			items :'a',
			itemsText :'span',
			container :'.dock-container',
			itemWidth :50,
			proximity :60,
			alignment :'left',
			valign :'bottom',
			halign :'center'
		});
		var jqDockOpts = {
			align :'left',
			duration :200,
			labels :'tc',
			size :48,
			distance :85
		};
		$('#jqDock').jqDock(jqDockOpts);
		$('#header').bind('contextmenu', function(e) {
			$('#mm').menu('show', {
				left :e.pageX,
				top :e.pageY
			});
			return false;
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
		$("#trad").click( function() {
			changeHeader('header.jsp');
		});
		$("#dockheader").click( function() {
			changeHeader('header_dock.jsp');
		});
		$("#sand").click( function() {
			changeHeader('header_sand.jsp');
		});
		var hovermouse = function() {
			$('#corner img').stop().animate( {
				width :'200px',
				height :'200px'
			});
		}
		var mourseout = function() {
			$('#corner img').stop().animate( {
				width :'80px',
				height :'80px'
			});
		}

		$('#corner img').bind("mouseover", hovermouse);
		$('#corner img').bind("mouseout", mourseout);

		$('#corner img').click( function() {
			$(this).animate( {
				width :viewW,
				height :viewH
			}, 800, function() {					  
				window.location.href = "changeHeaderAction.action?header=header_sand.jsp";
				
			});
		});
		
		function callBack(data) {
		if(data == null) return;
			$('#corner img').unbind("mouseover", hovermouse);
			$('#corner img').unbind("mouseout", mourseout);
			$('#corner img').animate( {
				width :viewW,
				height :viewH
			}, 800, function() {
				$('#corner img').width("80px");
				$('#corner img').height("80px");
				$('#corner img').bind("mouseover", hovermouse);
				$('#corner img').bind("mouseout", mourseout);
			});
			$('#dock-container').find('img')
					.each(
							function() {
								var imgId = $(this).attr("id");
								var imgsrc = data + "/"
										+ imgId.substring(0, imgId.length - 4)
										+ ".png";
								$(this).attr("src",
										"${ctx}/coursepage/style/" + imgsrc);
							});
			$("#cssfile").attr("href",
					"${ctx}/coursepage/style/" + data + "/color.css"); //设置不同皮肤

		}
				
		function changeHeader(header) {
			$('#corner img').unbind("mouseover", hovermouse);
			$('#corner img').unbind("mouseout", mourseout);
			$('#corner img').animate( {
				width :viewW,
				height :viewH
			}, 800, function() {				
				window.location.href = "changeHeaderAction.action?header=" + header;		
				$('#corner img').width("80px");
				$('#corner img').height("80px");
				$('#corner img').bind("mouseover", hovermouse);
				$('#corner img').bind("mouseout", mourseout);	
			});
			
		}
	})
</script>

	<body>
		<a id="corner" href="#"><img
				src="${ctx}/coursepage/style/common/corner.png" /> </a>
		<div id="mm" class="easyui-menu" style="width: 100px;">
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
					<div id="trad">
						导航一
					</div>
					<div id="dockheader">
						导航二
					</div>
					<div id="sand">
						导航三
					</div>
				</div>
			</div>
			<div id="goindex">
				返回首页
			</div>
		</div>
		<div id="header">
			<div class="dock" id="dock">
				<div class="dock-container" id="dock-container">
					<a class="dock-item" href="${ctx}/homepage/index.jsp"><img
							id="home-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/home.png"
							alt="首页" /><span>首页</span> </a>
					<a class="dock-item"
						href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>"><img
							id="form-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/form.png"
							alt="申报表格" /><span>申报表格</span> </a>
					<a class="dock-item"
						href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>"><img
							id="info-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/info.png"
							alt="课程简介" /><span>课程简介</span> </a>
					<a class="dock-item"
						href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	2 
                    			</s:param>
                					</s:url>"><img
							id="outline-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/outline.png"
							alt="教学大纲" /><span>教学大纲</span> </a>
					<a class="dock-item"
						href="<s:url action="findTeacherTeamAction"> 
                					</s:url>"><img
							id="teateam-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/teateam.png"
							alt="教师队伍" /><span>教师队伍</span> </a>
					<a class="dock-item"
						href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	0 
                    			</s:param>
                					</s:url>"><img
							id="notice-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/notice.png"
							alt="通知公告" /><span>通知公告</span> </a>
					<a class="dock-item"
						href="<s:url action="getAllCoursewareAction"> 
                					</s:url>"><img
							id="ppt-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/ppt.png"
							alt="课程教案" /><span>课程教案</span> </a>
					<a class="dock-item"
						href="<s:url action="getAllExerciseAction"> 
                					</s:url>"><img
							id="exercise-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/exercise.png"
							alt="作业习题" /><span>作业习题</span> </a>
					<a class="dock-item"
						href="<s:url action="getAllExperimentAction"> 
                					</s:url>"><img
							id="lab-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/lab.png"
							alt="实验指导" /><span>实验指导</span> </a>
					<a class="dock-item"
						href="<s:url action="getCourseMovieListAction"> 
                					</s:url>"><img
							id="ituna-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/ituna.png"
							alt="教学录像" /><span>教学录像</span> </a>
					<a class="dock-item"
						href="<s:url action="getAllExaminationAction"> 
                					</s:url>"><img
							id="textedit-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/textedit.png"
							alt="课程试卷" /><span>课程试卷</span> </a>
					<a class="dock-item"
						href="<s:url action="getAllBookAction"> 
                					</s:url>"><img
							id="book-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/book.png"
							alt="参考书籍" /><span>参考书籍</span> </a>
					<a class="dock-item"
						href="<s:url action="findAchievementAction"> 
                					</s:url>"><img
							id="achievement-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/achievement.png"
							alt="教学成果" /><span>教学成果</span> </a>
					<a class="dock-item"
						href="<s:url action="evaluateAction"> 
                					</s:url>"><img
							id="evaluation-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/evaluation.png"
							alt="课程评价" /><span>课程评价</span> </a>
					<a class="dock-item"
						href="<s:url action="showTopicsAction"> 
                					</s:url>"><img
							id="message-img"
							src="${ctx}/coursepage/style/<s:property value="#session.style"/>/message.png"
							alt="留言板" /><span>留言板</span> </a>
				</div>
			</div>

			<div class="content border_bottom">

				<img
					src="${ctx}/coursepage/style/<s:property value="#session.style"/>/logo.gif"
					alt="居然之家" name="logo" width="200" height="75" id="logo" />

				<br class="clear" />
			</div>
			<div class="content" id="top-adv">
				<img src="${ctx}/coursepage/style/green/top-adv.gif" alt="" />
			</div>
		</div>
	</body>
</html>
