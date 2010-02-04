<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>厦门大学精品课程</title>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="../${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="menu">
	<ul>
		<li><a href="<s:url action="enterCourseAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												首页
											</a></li>
		<li><a href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程简介</a></li>
		<li><a href="<s:url action="findTeacherTeamAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												师资队伍
											</a></li>
<li><a href="<s:url action="findAchievementAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												成果展示
											</a></li>
		<li> <a href="<s:url action="findChapterAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="flag"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程教案</a></li>
		<li><a href="<s:url action="findChapterAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="flag"> 
                       			 	2 
                    			</s:param>
                					</s:url>">实验指导</a></li>
		<li><a href="<s:url action="findChapterAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="flag"> 
                       			 	3 
                    			</s:param>
                					</s:url>">习题试卷</a></li>
		<li><a href="<s:url action="getCourseMovieListAction"> 
                					</s:url>">
												教学录像
											</a></li>
		<li><a href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												申报表格
											</a> </li>
		<li><a href="<s:url action="findTeacherTeamAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												课程评价
											</a>     </li>
		<li><a href="<s:url action="showTopicsAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												留言板
											</a>     </li>
	</ul>
</div>
</body>
</html>