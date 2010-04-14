<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<link href="common/common.css" rel="stylesheet" type="text/css" />
		<link href="common/layout.css" rel="stylesheet" type="text/css" />
		<link href="common/blue.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"
			type="text/javascript"></script>
		<script src="${ctx}/js/jquery.easyui.min.js" type="text/javascript"></script>
		<link rel="stylesheet" href="${ctx}/coursepage/style/common/main.css" />
		<link type="text/css" href="${ctx}/coursepage/style/common/easyui.css"
			rel="stylesheet" />
	</head>

	<script type="text/javascript">
#panel {	
}
.active {
background-position: right 12px;
}
</script>

	<script type="text/javascript">

$(function(){

  var display=true;
  // bind radiobuttons in the form
  var sort = "sort";

  // get the first collection
  var $applications = $('#applications');

  // clone applications to get a second collection
  var $data = $applications.clone();

 

$("#sorttype").click( function() {
   if(!display) return ;
	var $applications = $('#applications');
  // clone applications to get a second collection
  var $data = $applications.clone();
  var $filteredData = $data.find('li');
      var $sortedData = $filteredData.sorted({
        by: function(v) {
          return parseFloat($(v).find('span[data-type=size]').text());
        }
      });

 sort="sort";
   // finally, call quicksand
    $applications.quicksand($sortedData, {
      duration: 800,
      easing: 'easeInOutQuad'
    });
 });


$("#allcon").click( function() {

   if(!display) return ;
  var $filteredData = $data.find('li');
    if (sort== "sort") {
      var $sortedData = $filteredData.sorted({
        by: function(v) {
          return parseFloat($(v).find('span[data-type=size]').text());
        }
      });
    } else {
      // if sorted by name
      var $sortedData = $filteredData.sorted({
        by: function(v) {
          return $(v).find('span[data-type=name]').text().toLowerCase();

        }
      });
    }  

   // finally, call quicksand
    $applications.quicksand($sortedData, {
      duration: 800,
      easing: 'easeInOutQuad'
    });
 });

$("#app").click( function() {

   if(!display) return ;
    var $filteredData = $data.find('li[data-type="app"]');

    if (sort== "sort") {
      var $sortedData = $filteredData.sorted({
        by: function(v) {
          return parseFloat($(v).find('span[data-type=size]').text());
        }
      });
    } else {
      // if sorted by name
      var $sortedData = $filteredData.sorted({
        by: function(v) {
         return $(v).find('span[data-type=name]').text().toLowerCase();

        }
      });
    }  

   // finally, call quicksand
    $applications.quicksand($sortedData, {
      duration: 800,
      easing: 'easeInOutQuad'
    });
 });

$("#util").click( function() {

   if(!display) return ;
    var $filteredData = $data.find('li[data-type="util"]');

    if (sort== "sort") {
      var $sortedData = $filteredData.sorted({
        by: function(v) {
          return parseFloat($(v).find('span[data-type=size]').text());
        }
      });
    } else {
      // if sorted by name
      var $sortedData = $filteredData.sorted({
        by: function(v) {
          return $(v).find('span[data-type=name]').text().toLowerCase();
        }
      });
    }  

   // finally, call quicksand
    $applications.quicksand($sortedData, {
      duration: 800,
      easing: 'easeInOutQuad'
    });
 });


$("#sortname").click( function() {

   if(!display) return ;
  var $applications = $('#applications');
  // clone applications to get a second collection
  var $data = $applications.clone();
  var $filteredData = $data.find('li');

      var $sortedData = $filteredData.sorted({
        by: function(v) {         
           return $(v).find('span[data-type=name]').text().toLowerCase();

        }
      });
 sort="name";
   // finally, call quicksand
    $applications.quicksand($sortedData, {
      duration: 800,
      easing: 'easeInOutQuad'
    });
 });


$("#slide").click( function() {
 $("#panel").slideToggle("slow");
			$(this).toggleClass("active");
			if(display) display = false;
else display = true;
      });
})
</script>



	<script type="text/javascript">
// Custom sorting plugin
(function($) {
  $.fn.sorted = function(customOptions) {
    var options = {
      reversed: false,
      by: function(a) { return a.text(); }
    };
    $.extend(options, customOptions);
    $data = $(this);
    arr = $data.get();
    arr.sort(function(a, b) {
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
			<img src="${ctx}/coursepage/style/blue/logo.gif" alt="居然之家"
				name="logo" width="200" height="75" id="logo" />
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
								src="${ctx}/coursepage/style/blue/form.gif" width="88"
								height="88" alt="" /> </a>
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
								src="${ctx}/coursepage/style/blue/info.png" width="88"
								height="88" alt="" /> </a>
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
								src="${ctx}/coursepage/style/blue/outline.png" width="88"
								height="88" alt="" /> </a>
						<strong>教学大纲</strong>
						<span data-type="size">3</span>
						<span data-type="name">j</span>

					</li>
					<li data-id="id-3" data-type="util">
						<a
							href="<s:url action="findTeacherTeamAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/teateam.png" width="88"
								height="88" alt="" /> </a>
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
								src="${ctx}/coursepage/style/blue/notice.png" width="88"
								height="88" alt="" /> </a>
						<strong>通知公告</strong>
						<span data-type="size">5</span>
						<span data-type="name">t</span>
					</li>
					<li data-id="id-4" data-type="app">
						<a
							href="<s:url action="getAllCoursewareAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/ppt.png" width="88"
								height="88" alt="" /> </a>
						<strong>课程教案</strong>
						<span data-type="size">6</span>
						<span data-type="name">k</span>
					</li>
					<li data-id="id-8" data-type="app">
						<a
							href="<s:url action="getAllExerciseAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/exercise.png" width="88"
								height="88" alt="" /> </a>
						<strong>作业习题</strong>
						<span data-type="size">7</span>
						<span data-type="name">z</span>
					</li>
					<li data-id="id-1" data-type="app">
						<a
							href="<s:url action="getAllExperimentAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/lab.png" width="88"
								height="88" alt="" /> </a><strong>实验指导</strong>
						<span data-type="size">8</span>
						<span data-type="name">s</span>
					</li>
					<li data-id="id-9" data-type="app">
						<a
							href="<s:url action="getCourseMovieListAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/ituna.png" width="88"
								height="88" alt="" /> </a>
						<strong>课程录像</strong>
						<span data-type="size">9</span>
						<span data-type="name">m</span>
					</li>
					<li data-id="id-13" data-type="app">
						<a
							href="<s:url action="getAllExaminationAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/textedit.png" width="88"
								height="88" alt="" /> </a>
						<strong>课程试卷</strong>
						<span data-type="size">10</span>
						<span data-type="name">n</span>
					</li>
					<li data-id="id-2" data-type="app">
						<a
							href="<s:url action="getAllBookAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/book.png" width="88"
								height="88" alt="" /> </a>
						<strong>参考书籍</strong>
						<span data-type="size">11</span>
						<span data-type="name">c</span>
					</li>
					<li data-id="id-11" data-type="util">
						<a
							href="<s:url action="findAchievementAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/achievement.png" width="88"
								height="88" alt="" /> </a>
						<strong>教学成果</strong>
						<span data-type="size">12</span>
						<span data-type="name">g</span>
					</li>
					<li data-id="id-6" data-type="util">
						<a
							href="<s:url action="evaluateAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/evaluation.png" width="88"
								height="88" alt="" /> </a>
						<strong>专家评价</strong>
						<span data-type="size">13</span>
						<span data-type="name">y</span>
					</li>
					<li data-id="id-7" data-type="util">
						<a
							href="<s:url action="showTopicsAction"> 
                					</s:url>"><img
								src="${ctx}/coursepage/style/blue/message.png" width="88"
								height="88" alt="" /> </a>
						<strong>留言板</strong>
						<span data-type="size">14</span>
						<span data-type="name">o</span>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>
