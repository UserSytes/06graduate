<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<style type="text/css">
body{
font-family:Arial, Helvetica, sans-serif;
}
ul,li{
margin:0px;
padding:0px;
}
li{
display:inline;
list-style:none;
list-style-position:outside;
text-align:center;
font-weight:bold;
float:left;
}

#nav{
width:750px;
height:50px;
border-bottom:0px;
padding:0px 0px;
position:absolute;
z-index:1;
left: 198px;
top: 25px;
}
.list{
line-height:30px;
text-align:left;
padding:4px;
font-weight:normal;
}
.menu1{
width:75px;
height:auto;
margin:6px 4px 0px 0px;
border:1px solid #9CDD75;
background-color:#F1FBEC;
color:#336601;
padding:6px 0px 0px 0px;
cursor:hand;
overflow-y:hidden;
filter:Alpha(opacity=70);
-moz-opacity:0.7;
}
.menu2{
width:75px;
height:30px;
margin:0px 4px 0px 0px;
background-color:#F5F5F5;
color:#999999;
border:1px solid #EEE8DD;
padding:6px 0px 0px 0px;
overflow-y:hidden;
cursor:hand;
}
</style>
<body>
<div id="nav" style="top: 162px; left: 276px;"> 
    <ul> 
    <li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'"><a href="<s:url action="enterCourseAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												首页
											</a>     
    </li> 
    <li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'">大纲信息  
    <div class="list"> 
        <a
												href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程简介</a><br /> 
       <a href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="sort"> 
                       			 	2 
                    			</s:param>
                					</s:url>">教学大纲</a><br />
    </div> 
    </li> 
    <li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'"><a
												href="<s:url action="findTeacherTeamAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												师资队伍
											</a>     
    </li> 
    <li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'"><a
												href="<s:url action="findAchievementAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												成果展示
											</a>   
    </li> 
<li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'">文档中心
    <div class="list"> 
        <a
												href="<s:url action="findChapterAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="flag"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程教案</a><br /> 
       <a href="<s:url action="findChapterAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="flag"> 
                       			 	2 
                    			</s:param>
                					</s:url>">实验指导</a><br />
       <a href="<s:url action="findChapterAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                     			<s:param name="flag"> 
                       			 	3 
                    			</s:param>
                					</s:url>">习题试卷</a><br />
    </div> 
    </li> 
<li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'"><a
												href="<s:url action="findTeacherTeamAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												教学录像
											</a>     
    </li> 
<li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'"><a
												href="<s:url action="findTeacherTeamAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												课程评价
											</a>     
    </li> 
<li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'"><a
												href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												申报表格
											</a>     
    </li> 
<li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'"><a
												href="<s:url action="findTeacherTeamAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												留言板
											</a>     
    </li> 
    </ul> 
</div>
</body>
</html>