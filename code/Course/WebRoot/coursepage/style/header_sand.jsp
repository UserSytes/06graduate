<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<script src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"
			type="text/javascript"></script>
		<script src="${ctx}/js/jquery.easyui.min.js" type="text/javascript"></script>
		<link rel="stylesheet" href="${ctx}/coursepage/style/common/main.css" />
		<link type="text/css" href="${ctx}/coursepage/style/common/easyui.css"
			rel="stylesheet" />
		<link id="cssfile"
			href="${ctx}/coursepage/style/<s:property value="#session.style"/>/color.css"
			rel="stylesheet" type="text/css" />
		<style type="text/css">
.active {
	background-position: right 12px;
}
</style>


		<script type="text/javascript">
	$( function() {
		var display = true;
		// get the first collection
		var $applications = $('#applications');
		// clone applications to get a second collection
		var $data = $applications.clone();
		$applications.quicksand("", {
			duration :0,
			easing :'easeInOutQuad'
		});
		$.post("sortSandAction.action", {}, sortSand2, "json");
		function sortSand2(data) {
			var result = eval("(" + data + ")");
			var $filteredData;
			if (result.filtercon == "util")
				$filteredData = $data.find('li[data-type="util"]');
			else if (result.filtercon == "app")
				$filteredData = $data.find('li[data-type="app"]');
			else
				$filteredData = $data.find('li');
			if (result.sort == "sorttype") {
				var $sortedData = $filteredData.sorted( {
					by : function(v) {
						return parseFloat($(v).find('span[data-type=size]')
								.text());
					}
				});
			} else {// if sorted by name
				var $sortedData = $filteredData.sorted( {
					by : function(v) {
						return $(v).find('span[data-type=name]').text()
								.toLowerCase();
					}
				});
			}
			// finally, call quicksand
			$applications.quicksand($sortedData, {
				duration :0,
				easing :'easeInOutQuad'
			});
		}

		$("#sortname").click( function() {
			if (!display)
				return;
			$.post("sortSandAction.action", {
				sortname :"sortname"
			}, sortSand, "json");
		});

		$("#sorttype").click( function() {
			if (!display)
				return;
			$.post("sortSandAction.action", {
				sortname :"sorttype"
			}, sortSand, "json");
		});

		$("#allcon").click( function() {
			if (!display)
				return;
			$.post("sortSandAction.action", {
				filtercon :"allcon"
			}, sortSand, "json");
		});

		$("#app").click( function() {
			if (!display)
				return;
			$.post("sortSandAction.action", {
				filtercon :"app"
			}, sortSand, "json");
		});

		$("#util").click( function() {
			if (!display)
				return;
			$.post("sortSandAction.action", {
				filtercon :"util"
			}, sortSand, "json");
		});
		function sortSand(data) {
			var result = eval("(" + data + ")");
			var $filteredData;
			if (result.filtercon == "util")
				$filteredData = $data.find('li[data-type="util"]');
			else if (result.filtercon == "app")
				$filteredData = $data.find('li[data-type="app"]');
			else
				$filteredData = $data.find('li');
			if (result.sort == "sorttype") {
				var $sortedData = $filteredData.sorted( {
					by : function(v) {
						return parseFloat($(v).find('span[data-type=size]')
								.text());
					}
				});
			} else {// if sorted by name
				var $sortedData = $filteredData.sorted( {
					by : function(v) {
						return $(v).find('span[data-type=name]').text()
								.toLowerCase();
					}
				});
			}
			// finally, call quicksand
			$applications.quicksand($sortedData, {
				duration :800,
				easing :'easeInOutQuad'
			});
		}

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
			$data.find('img')
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
			$("#logo").attr("src",
					"${ctx}/coursepage/style/" + data + "/logo.gif");
			$("#form-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/form.png");
			$("#info-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/info.png");
			$("#outline-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/outline.png");
			$("#teateam-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/teateam.png");
			$("#notice-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/notice.png");
			$("#ppt-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/ppt.png");
			$("#exercise-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/exercise.png");
			$("#lab-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/lab.png");
			$("#ituna-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/ituna.png");
			$("#textedit-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/textedit.png");
			$("#book-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/book.png");
			$("#achievement-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/achievement.png");
			$("#evaluation-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/evaluation.png");
			$("#message-img").attr("src",
					"${ctx}/coursepage/style/" + data + "/message.png");
		}

		$("#slide").click( function() {
			$("#panel").slideToggle("slow");
			$(this).toggleClass("active");
			if (display)
				display = false;
			else
				display = true;
		});
	})
</script>
		<script type="text/javascript">
	function changeHeader(header) {
		window.location.href = "changeHeaderAction.action?header=" + header;
	}
	// Custom sorting plugin
	( function($) {
		$.fn.sorted = function(customOptions) {
			var options = {
				reversed :false,
				by : function(a) {
					return a.text();
				}
			};
			$.extend(options, customOptions);
			$data = $(this);
			arr = $data.get();
			arr.sort( function(a, b) {
				var valA = options.by($(a));
				var valB = options.by($(b));
				if (options.reversed) {
					return (valA < valB) ? 1 : (valA > valB) ? -1 : 0;
				} else {
					return (valA < valB) ? -1 : (valA > valB) ? 1 : 0;
				}
			});
			return $(arr);
		};
	})(jQuery);
	// DOMContentLoaded
</script>
	</head>
	<body>

		<div class="content border_bottom">
			<ul id="sub_nav">
				<li>
					<a href="#">首页</a>
				</li>

				<li>
					<a href="#">加入收藏</a>
				</li>
				<li>
					<a href="#" style="margin-top: -5px" id="mb1"
						class="easyui-menubutton" menu="#mm1">导航设置</a>

				</li>
			</ul>
			<img
				src="${ctx}/coursepage/style/<s:property value="#session.style"/>/logo.gif"
				alt="居然之家" name="logo" width="200" height="75" id="logo" />
			<br class="clear" />

		</div>
		<div id="mm1" style="width: 100px;">
			<div>
				<span>排列</span>
				<div style="width: 100px;">
					<div id="sorttype">
						类别
					</div>
					<div id="sortname">
						名字
					</div>
				</div>
			</div>
			<div>
				<span>过滤</span>
				<div style="width: 100px;">
					<div id="allcon">
						全部
					</div>
					<div id="app">
						课程内容
					</div>
					<div id="util">
						课程相关
					</div>
				</div>
			</div>
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
					<div id="purple" >
						紫色
					</div>
					<div id="red" >
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
			<div id="slide">
				收起/展开
			</div>

		</div>
		<div id="site">

			<div class="demo" id="panel">
				<ul id="applications" class="image-grid">
					<li data-id="id-10" data-type="util">
						<a
							href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>"><img
								id="form-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/form.png"
								width="88" height="88" alt="" /> </a>
						<strong>申报表格</strong>
						<span data-type="size">1</span>
						<span data-type="name">r</span>
					</li>
					<li data-id="id-5" data-type="util">
						<a
							href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>"><img
								id="info-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/info.png"
								width="88" height="88" alt="" /> </a>
						<strong>课程简介</strong>
						<span data-type="size">2</span>
						<span data-type="name">l</span>
					</li>
					<li data-id="id-14" data-type="util">
						<a
							href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	2 
                    			</s:param>
                					</s:url>"><img
								id="outline-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/outline.png"
								width="88" height="88" alt="" /> </a>
						<strong>教学大纲</strong>
						<span data-type="size">3</span>
						<span data-type="name">j</span>

					</li>
					<li data-id="id-3" data-type="util">
						<a
							href="<s:url action="findTeacherTeamAction"> 
                					</s:url>"><img
								id="teateam-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/teateam.png"
								width="88" height="88" alt="" /> </a>
						<strong>教师队伍</strong>
						<span data-type="size">4</span>
						<span data-type="name">d</span>
					</li>
					<li data-id="id-12" data-type="app">
						<a
							href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	0 
                    			</s:param>
                					</s:url>"><img
								id="notice-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/notice.png"
								width="88" height="88" alt="" /> </a>
						<strong>通知公告</strong>
						<span data-type="size">5</span>
						<span data-type="name">t</span>
					</li>
					<li data-id="id-4" data-type="app">
						<a
							href="<s:url action="getAllCoursewareAction"> 
                					</s:url>"><img
								id="ppt-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/ppt.png"
								width="88" height="88" alt="" /> </a>
						<strong>课程教案</strong>
						<span data-type="size">6</span>
						<span data-type="name">k</span>
					</li>
					<li data-id="id-8" data-type="app">
						<a
							href="<s:url action="getAllExerciseAction"> 
                					</s:url>"><img
								id="exercise-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/exercise.png"
								width="88" height="88" alt="" /> </a>
						<strong>作业习题</strong>
						<span data-type="size">7</span>
						<span data-type="name">z</span>
					</li>
					<li data-id="id-1" data-type="app">
						<a
							href="<s:url action="getAllExperimentAction"> 
                					</s:url>"><img
								id="lab-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/lab.png"
								width="88" height="88" alt="" /> </a><strong>实验指导</strong>
						<span data-type="size">8</span>
						<span data-type="name">s</span>
					</li>
					<li data-id="id-9" data-type="app">
						<a
							href="<s:url action="getCourseMovieListAction"> 
                					</s:url>"><img
								id="ituna-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/ituna.png"
								width="88" height="88" alt="" /> </a>
						<strong>课程录像</strong>
						<span data-type="size">9</span>
						<span data-type="name">m</span>
					</li>
					<li data-id="id-13" data-type="app">
						<a
							href="<s:url action="getAllExaminationAction"> 
                					</s:url>"><img
								id="textedit-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/textedit.png"
								width="88" height="88" alt="" /> </a>
						<strong>课程试卷</strong>
						<span data-type="size">10</span>
						<span data-type="name">n</span>
					</li>
					<li data-id="id-2" data-type="app">
						<a
							href="<s:url action="getAllBookAction"> 
                					</s:url>"><img
								id="book-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/book.png"
								width="88" height="88" alt="" /> </a>
						<strong>参考书籍</strong>
						<span data-type="size">11</span>
						<span data-type="name">c</span>
					</li>
					<li data-id="id-11" data-type="util">
						<a
							href="<s:url action="findAchievementAction"> 
                					</s:url>"><img
								id="achievement-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/achievement.png"
								width="88" height="88" alt="" /> </a>
						<strong>教学成果</strong>
						<span data-type="size">12</span>
						<span data-type="name">g</span>
					</li>
					<li data-id="id-6" data-type="util">
						<a
							href="<s:url action="evaluateAction"> 
                					</s:url>"><img
								id="evaluation-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/evaluation.png"
								width="88" height="88" alt="" /> </a>
						<strong>专家评价</strong>
						<span data-type="size">13</span>
						<span data-type="name">y</span>
					</li>
					<li data-id="id-7" data-type="util">
						<a
							href="<s:url action="showTopicsAction"> 
                					</s:url>"><img
								id="message-img"
								src="${ctx}/coursepage/style/<s:property value="#session.style"/>/message.png"
								width="88" height="88" alt="" /> </a>
						<strong>留言板</strong>
						<span data-type="size">14</span>
						<span data-type="name">o</span>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>
