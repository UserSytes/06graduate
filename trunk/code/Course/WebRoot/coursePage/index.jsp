<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<<<<<<< .mine
<head>
<title>厦门大学精品课程</title>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="../${ctx}/coursePage/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <h1>XXX精品课程<br />
	<span class="text1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Xiamen University</span></h1>
=======
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
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					&nbsp;
				</td>
				<td width="711" align="left" valign="top">
					<table width="711" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="107" align="left" valign="top">
								<table width="100%" height="107" border="0" cellpadding="0"
									cellspacing="0">
									<tr align="left" valign="top">
										<td width="468">
											<div style="padding-left: 22px; padding-top: 43px">
												<a href="index.jsp"><img
														src="coursePage/images/logo.jpg" width="248" height="38"
														border="0">
												</a>
											</div>
										</td>
										<td>
											<div style="padding-left: 0px; padding-top: 68px">
												<table width="225" border="0" cellspacing="0"
													cellpadding="0">
													<tr align="left" valign="middle">
														<td width="45">
															<a href="#" class="style1">Account</a>
														</td>
														<td width="2">
															<img src="coursePage/images/p_1.jpg" width="2" height="2">
														</td>
														<td width="58" align="center">
															<a href="#" class="style1">View cart</a>
														</td>
														<td width="2" align="center">
															<img src="coursePage/images/p_1.jpg" width="2" height="2">
														</td>
														<td width="52" align="center">
															<a href="#" class="style1">Wish list</a>
														</td>
														<td width="2">
															<img src="coursePage/images/p_1.jpg" width="2" height="2">
														</td>
														<td align="right">
															<a href="#" class="style1">返回精品课程主站</a>
														</td>
													</tr>
												</table>
											</div>
<br>
										</td>
									</tr>
								</table>
<br>
							</td>
						</tr>
						<tr>
							<td align="center">	
<div id="nav"> 
    <ul> 
    <li class="menu2" onMouseOver="this.className='menu1'" onMouseOut="this.className='menu2'"><a
												href="<s:url action="enterCourseAction"> 
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
>>>>>>> .r270
</div>
<jsp:include page="top.jsp"></jsp:include>
<div id="content">
	<div id="right">
		<h2>欢迎来到精品课程网站</h2>
		<p><img src="coursePage/images/img03.jpg" alt="" width="155" height="120" class="img1" />CORPORATE is a free template from <a href="http://www.freecsstemplates.org/">Free CSS Templates</a> released under a <a href="http://creativecommons.org/licenses/by/2.5/">Creative Commons Attribution 2.5 License</a>. You're free to use it for both commercial or personal use. I only ask that you link back to <a href="http://www.freecsstemplates.org/">my site</a> in some way. Enjoy :)</p>
		<p>&nbsp;</p>
		<p>Aliquam gravida	 massa eu arcu. Fusce mollis tristique sem. Sed eu eros imperdiet eros interdum blandit. Vivamus sagittis bibendum erat. Curabitur malesuada turpis nec ante. Suspendisse quis felis. Suspendisse potenti. Nullam et orci in erat viverra ornare. Nunc pellentesque. Sed vestibulum blandit nisl. Quisque elementum convallis purus.</p>
		<hr id="border-top" />
		<div id="colA">
			<p><strong>Fusce mollis tristique sem</strong><br />
			Nullam et orci in erat viverra ornare. Nunc pellentesque. Sed vestibulum blandit nisl. Quisque elementum convallis purus. Nunc pellentesque. Sed vestibulum blandit nisl. </p>
			<ul>
				<li><a href="#">Sagittis Bibendum Erat</a></li>
				<li><a href="#">Malesuada Turpis</a></li>
				<li><a href="#">Quis Gravida Massa</a></li>
				<li><a href="#">Inerat Viverra Ornar</a></li>
			</ul>
		</div>
		<div id="colB">
			<p><strong>Fusce mollis tristique sem</strong><br />
			Nullam et orci in erat viverra ornare. Nunc pellentesque. Sed vestibulum blandit nisl. Quisque elementum convallis purus. Nunc pellentesque. Sed vestibulum blandit nisl.</p>
			<ul>
				<li><a href="#">Sagittis Bibendum Erat</a></li>
				<li><a href="#">Malesuada Turpis</a></li>
				<li><a href="#">Quis Gravida Massa</a></li>
				<li><a href="#">Inerat Viverra Ornar</a></li>
			</ul>
		</div>
	</div>

	<div id="left">
		<h2>Recent Updates</h2>
		<p><strong>[06/09/2006]</strong> Etiam odio mi, suscipit et, rhoncus ac, lacinia, nisl. Aliquam gravida massa eu arcu. <a href="#">More&#8230;</a></p>
		<p><strong>[06/06/2006]</strong> Fusce mollis tristique sem. Sed eu eros imperdiet eros interdum blandit. Vivamus sagittis bibendum erat. Curabitur malesuada. <a href="#">More&#8230;</a></p>
		<p><strong>[06/03/2006]</strong> Nunc pellentesque. Sed vestibulum blandit nisl. Quisque elementum convallis purus. Suspendisse potenti. Donec nulla est, laoreet quis, pellentesque in. <a href="#">More&#8230;</a></p>
		<h2>Ipsum Dolorem</h2>
		<ul>
			<li><a href="#">Sagittis Bibendum Erat</a></li>
			<li><a href="#">Malesuada Turpis</a></li>
			<li><a href="#">Quis Gravida Massa</a></li>
			<li><a href="#">Inerat Viverra Ornare</a></li>
		</ul>
	</div>
</div>
<div id="footer">
	<p>Copyright &copy; 2006 Sitename.com. Designed by <a href="http://www.freecsstemplates.org" class="link1">Free CSS Templates</a></p>
</div>
</body>
</html>