<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>	
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'header.jsp' starting page</title>
	<link href="${ctx}/coursepage/style/common/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/coursepage/style/common/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/coursepage/style/common/jquery-1.4.1-and-plugins.min.js" type="text/javascript"></script>

  </head>
  <script type="text/javascript">
$(function(){
	   $("#main_nav li:has(ul)").hover(function(){
			$(this).children("ul").stop(true,true).slideDown(400);
        },function(){
		    $(this).children("ul").stop(true,true).slideUp("fast");
		});
})
</script>
  <body>
    <div class="content border_bottom">
	 <ul id="sub_nav">
		 <li><a href="#">首页</a></li>

		 <li><a href="#">加入收藏</a></li>
		 <li class="nobg"><a href="#">联系我们</a></li>
	 </ul>
	      <img src="${ctx}/coursepage/style/green/logo.gif" alt="居然之家" name="logo" width="200" height="75" id="logo" />
		  
		  <br class="clear" />
</div>
<div class="content dgreen-bg">
     <div class="content">
	 <ul id="main_nav">
		 <li class="nobg"><a href="#">课程首页</a></li>
		 <li><a href="#">申报表格</a></li>		 
		 <li><a href="#">课程简介</a>
 		 <ul>
					 <li><a href="#">课程简介</a></li>
					 <li><a href="#">教学大纲</a></li>					
		</ul>
		 </li>
		 <li><a href="#">教师队伍</a></li>
		 <li><a href="#">通知公告</a>
		<ul>
					 <li><a href="#">课程通知</a></li>
					 <li><a href="#">课程公告</a></li>					
		</ul></li>
		 <li><a href="#">课程教案</a>
		 <ul>
					 <li><a href="#">课件教案</a></li>
					 <li><a href="#">作业习题</a></li>
					 <li><a href="#">实验指导</a></li>
		 </ul></li>
		 <li><a href="#">课程相关</a>
		 <ul>
					 <li><a href="#">教学录像</a></li>
					 <li><a href="#">课程试卷</a></li>
					 <li><a href="#">参考书籍</a></li>
		 </ul></li>
		 <li><a href="#">教学成果</a></li>
		 <li><a href="#">课程评价</a></li>
		 <li><a href="#">师生留言</a></li>



	 </ul><br class="clear" />

	 </div>
</div>
<div class="content" id="top-adv"><img src="${ctx}/coursepage/style/green/top-adv.gif" alt="" /></div>
  </body>
</html>
