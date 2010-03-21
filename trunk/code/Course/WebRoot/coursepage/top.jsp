<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" />
<link href="../${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" />
<title> Drop Down Menu </title>
<style type="text/css">
body {font-size: 12px; color:#fff;} /*get rid of the IE bug that prints the the end of the !doctype */
.menu {display:none;}
.holder {color:#fff; width:60px; height:20px; display:block; background:#60B7DE; margin-right:1px; text-align:center; float:left; text-decoration:none; font-family:tahoma, vardana, arial, sans-serif; font-size:12px; line-height:18px; overflow:hidden;  font-weight:bold;}
.holder:hover {height:auto; cursor:pointer;color:#fff; background:#dca;}
a.inner, a.inner:visited {display:block; width:59px; height:20px; border-bottom:1px solid #000; text-decoration:none; color:#60B7DE; background:#eee;}
a.inner:hover {background:#add;}
p { color:#000; font-size:16px;}
</style>
<!--[if IE]>
<style type="text/css">
/*<![CDATA[*/
.holder {display:none;}
.menu {display:block;}
a.outer, a.outer:visited {color:#fff; width:60px; height:20px; display:block; background:#60B7DE; margin-right:1px; text-align:center; float:left; text-decoration:none; font-family:tahoma, vardana, arial, sans-serif; font-size:12px; line-height:18px; overflow:hidden;  font-weight:bold;}
a.outer:hover {color:#fff; background:#dca; overflow:visible;}
a.outer:hover table {display:block; background:#60B7DE; border-collapse:collapse;}
a.inner, a.inner:visited {display:block; width:59px; height:20px; border-bottom:1px solid #000; text-decoration:none; color:#60B7DE;font-family:tahoma, vardana, arial, sans-serif; font-size:12px; text-align:left;}
a.inner:hover {background:#add;}
/*]]>*/
</style>
<![endif]-->
</head>
<body>
<div class="menu" align="center">
<a class="outer" href="goCourseIndexAction.action">首页
</a>
<a class="outer" href="#">课程信息
<table><tr><td>
<a class="inner" href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程简介</a>
<a class="inner" href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	2 
                    			</s:param>
                					</s:url>">教学大纲</a>
</td></tr></table>
</a>
<a class="outer" href="<s:url action="findTeacherTeamAction"> 
                					</s:url>">师资队伍
</a>
<a class="outer" href="<s:url action="findAchievementAction"> 
                					</s:url>">成果展示
</a>
<a class="outer" href="<s:url action="getAllCoursewareAction"> 
                					</s:url>">课程教案
</a>
<a class="outer" href="#">习题试卷
<table><tr><td>
<a class="inner" href="<s:url action="getAllExaminationAction"> 
                					</s:url>">课程试卷</a>
<a class="inner" href="<s:url action="getAllExerciseAction"> 
                					</s:url>">作业习题</a>
</td></tr></table>
</a>
<a class="outer" href="<s:url action="getAllExperimentAction"> 
                					</s:url>">实验指导
</a>
<a class="outer" href="<s:url action="getAllBookAction"> 
                					</s:url>">参考书籍
</a>
<a class="outer" href="<s:url action="getCourseMovieListAction"> 
                					</s:url>">教学录像
</a>
<a class="outer" href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">申报表格
</a>
<a class="outer" href="<s:url action="evaluateAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">课程评价
</a>
<a class="outer" href="<s:url action="showTopicsAction"> 
                					</s:url>">留言板
</a>
</div>
<div class="holder">
首页<br />
</div>
<div class="holder">
课程信息<br />
<a class="inner" href="page2a.html">课程简介</a>
<a class="inner" href="page2b.html">教学大纲</a>
</div>
<div class="holder">
师资队伍<br />
</div>
<div class="holder">
成果展示<br />
</div>
<div class="holder">
课程教案<br />
</div>
<div class="holder">
习题试卷<br />
<a class="inner" href="page2a.html">作业习题</a>
<a class="inner" href="page2b.html">课程试卷</a>
</div>
<div class="holder">
实验指导<br />
</div>
<div class="holder">
参考书籍<br />
</div>
<div class="holder">
教学录像<br />
</div>
<div class="holder">
申报表格<br />
</div>
<div class="holder">
课程评价<br />
</div><div class="holder">
留言板<br />
</div>
</body>
</html>