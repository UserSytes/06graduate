<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<% if(request.getAttribute("T_flag")==null) { response.sendRedirect("homepageNewsAction.action");    }  %> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站</title>
		<link rel="stylesheet" href="link.css">
	</head>
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" width="100%" background="image/back_img.gif">
<s:include value="include/header.jsp"></s:include>

<table border="0" cellpadding="0" cellspacing="0" width="950" align="center">
<tr height="100%">
	<td width="200" align="center" valign="top">
	<!-- 왼쪽부분 -->
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top">
			<!-- 로그인부분 -->
				<table border="0" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td><img src="image/login_title.gif" border="0" alt=""></td></tr>
				<tr height="11">
					<td>
					<!-- 로그인 웃부분 여백 -->
						<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
						<tr>
							<td width="2" bgcolor="#e7e7e7"></td>
							<td width="190"></td>
							<td width="2" bgcolor="#e7e7e7"></td>
						</tr>
						</table>
					<!--/ 로그인 웃부분 여백 -->
					</td>
				</tr>
				<tr>
					<td width="194">
					<!-- 登录 -->
					<s:form action="loginFromHomePageAction" method="post">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr height="29">
							<td width="2" bgcolor="#e7e7e7" valign="top"></td>
							<td width="16" valign="top"></td>
							<td valign="top">帐号：</td>
							<td width="4" valign="top"></td>
							<td valign="top"><s:textfield name="userName"></s:textfield></td>
							<td width="7" valign="top"></td>
							<td width="9" valign="top"></td>
							<td width="2" bgcolor="#e7e7e7" valign="top"></td>
						</tr>
						<tr>
							<td width="2" bgcolor="#e7e7e7"></td>
							<td width="16"></td>
							<td>密码：<br></td>
							<td width="4"></td>
							<td><s:password name="password"></s:password></td>
							<td width="7"></td>
							<td width="9"></td>
							<td width="2" bgcolor="#e7e7e7"></td>
						</tr>
						<tr>
							<td width="2" bgcolor="#e7e7e7"></td>
							<td width="16"></td>
							<td>角色：<br></td>
							<td width="4"></td>
							<td><s:select name="flag" list="# {'0':'老師','1':'學生'}"
																	headerKey="-1" headerValue="请选择" /></td>
							<td width="7"></td>
							<td width="9"></td>
							<td width="2" bgcolor="#e7e7e7"></td>
						</tr>
						<tr >
							<td width="2" bgcolor="#e7e7e7"></td>
							<td colspan="5" align="center" >
							<input type="submit" name="submit" style="background: url(${ctx}/homepage/images/login_5.gif) no-repeat" value=" 登  陆 ">
							<input type="reset" name="Submit" style="background: url(${ctx}/homepage/images/login_5.gif) no-repeat" value=" 取  消 ">
							</td>
							<td width="2" bgcolor="#e7e7e7"></td>
						<tr>
						</table>
</s:form>
					<!--/ 登录 -->
					</td>
				</tr>
				<tr height="16">
					<td>
					<!-- 로그인 아래부분 여백 -->
						<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
						<tr>
							<td width="2" bgcolor="#e7e7e7"></td>
							<td width="190"></td>
							<td width="2" bgcolor="#e7e7e7"></td>
						</tr>
						</table>
					<!--/ 로그인 아래부분 여백 -->
					</td>
				</tr>
				<tr>
					<td>
					<!-- 회원가입 및 id/pw찾기 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="2" bgcolor="#e7e7e7"></td>
							<td width="13"></td>
							
							<td width="2" bgcolor="#e7e7e7"></td>
						</tr>
						</table>
					<!--/ 회원가입 및 id/pw찾기 -->
					</td>
				</tr>
				<tr><td><img src="image/login_bottom.gif" border="0" alt=""></td></tr>
				</table>
			
							
			<!-- 리스트 -->
			</td>
		</tr>
		<tr><td height="7"></td></td></tr>
		<tr>
			<!-- 우리구청 돌아보기-->
			<td><img src="image/view_ward.gif" border="0" alt=""></td>
			<!--/ 우리구청 돌아보기-->
		</tr>
		<tr>
			<td valign="top" width="194">
			<!-- 精品课程展示 -->
				
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><img src="image/left_menu_title.gif" border="0" alt=""></td>
				</tr>		
				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0">
						<tr  height="28">
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">1、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						<tr  height="28">
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">2、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						<tr  height="28">
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">3、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						<tr height="28">
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">4、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						<tr height="28" >
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">5、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						</table>
					</td>
				</tr>
				<br>
				<tr>
					<td><img src="image/left_menu_bottom.gif" border="0" alt=""></td>
				</tr>		
				<tr height="6"><td></td></tr>
			  </table>				
			</td>
		</tr>
		<tr><td height="4"></td></td></tr>
		
		<tr>
			<td valign="top" width="194">
		<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><img src="image/left_menu_title2.gif" border="0" alt=""></td>
				</tr>		
				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0">
						<tr  height="28">
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">1、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						<tr  height="28">
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">2、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						<tr  height="28">
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">3、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						<tr height="28">
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">4、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						<tr height="28" >
							<td width="11" ></td>
							<td width="162" align="center"><img src="image/left_bg1.gif" border="0" ><a href="#">5、软件工程[林坤辉]</a></td>
							<td width="11" ></td>
						</tr>
						<tr height="2"><td width="11" ></td>
							<td width="135"  background="image/left_bg2.gif"></td>
							<td width="11" ></td>
						</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td><img src="image/left_menu_bottom2.gif" border="0" alt=""></td>
				</tr>		
				<tr height="6"><td></td></tr>
				</table>
		</td>
				</tr>
		
		<tr><td height="4"></td></td></tr>
		<tr>
			<td valign="top" width="194">
			<!-- 주민자치쎈터 1 --><!--/ 주민자치쎈터 1 -->				
			<br></td>
		</tr>
		<tr><td height="4"></td></td></tr>
		<tr>
			<td valign="top" width="194">
			
			<!--/ 주민자치쎈터 2 -->				
			</td>
		</tr>
		<tr><td height="7"></td></td></tr>
		
		<tr><td height="3"></td></td></tr>
		
		
		
		</table>
	<!-- 왼쪽부분 -->
	</td>
	<td width="754" valign="top">
	<!-- 오른쪽부분 -->
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top">
			<!-- main -->
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td valign="top">
					<!-- main -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td align="center"><img src="image/main_img.jpg" border="0" alt=""></td>
							<td width="5"></td>
							<td valign="top" width="358">
							<!-- 내용부분-->
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top">
									<!-- 게시판 -->
									
										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td><img src="image/tab01.gif" border="0" alt=""></td>											
											<td><a href="<s:url action="newsAction"> </s:url>"><img src="image/tab06.gif" border="0"></a></td>
										</tr>
										<tr><td  colspan="6" height="9"></td></tr>
										<tr>
											<td width="358" align="center" colspan="6">
											<!-- news -->
											<div id="demo" style="overflow:hidden;height:232px;width:358px; border:0px solid #dde5bc;">
	<div id="demo1"> 
												<table border="0" cellpadding="0" cellspacing="0">
												<s:iterator value="newsList" status="new">			
												<tr height="25">
													<td width="266">&nbsp;&nbsp;<img src="image/but.jpg" border="0" alt="">&nbsp;&nbsp;
													<a href="<s:url action="enterNewsAction"> <s:param name="newsId"> 
	                       			 									<s:property value="id"/> </s:param> </s:url>">
																			<s:property value="title" /></a>
													&nbsp;&nbsp;</td>
													<td width="65">[<s:date name="time" format="yy.MM.dd" /> ]</td>
												</tr>
												<tr height="1">
													<td width="331" colspan="2" background="image/main_line.gif"></td>
												</tr>
												</s:iterator>
												</table>
											  </div>
	<div id="demo2"></div>
</div>
<script>
var speed=40
var demo=document.getElementById("demo");
var demo2=document.getElementById("demo2");
var demo1=document.getElementById("demo1");
demo2.innerHTML=demo1.innerHTML
function Marquee(){
	if(demo2.offsetTop-demo.scrollTop<=0)
		demo.scrollTop-=demo1.offsetHeight
	else{
		demo.scrollTop++
	}
}
var MyMar=setInterval(Marquee,speed)
demo.onmouseover=function() {clearInterval(MyMar)}
demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
</script>
											<!--/new -->
											</td>
										</tr>
										</table>
									<!--/精品课程展示 -->
									</td>
								</tr>
								<tr><td height="8"></td></tr>
								<tr>
									<td align="center">
										<table border="0" cellpadding="0" cellspacing="0" bgcolor="#f7f7f0">
										<tr>
											<td colspan="3">&nbsp;</td>
										</tr>
										<tr>
											<td width="1" bgcolor="#e4e3de"></td>
											<td><img src="image/issue_title.gif" border="0" alt=""></td>
											<td width="1" bgcolor="#e4e3de"></td>
										</tr>
										<tr height="13">
											<td width="1" bgcolor="#e4e3de"></td>
											<td width="346"></td>
											<td width="1" bgcolor="#e4e3de"></td>
										</tr>
										<tr>
											<td width="1" bgcolor="#e4e3de"></td>
											<td width="346">
												<table border="0" cellpadding="0" cellspacing="0" width="100%">
												<tr>
													<td width="23"></td>
													<td width="135"><img src="image/issue_cont.gif" alt="" height="84" border="0"></td>
													<td width="185">厦门大学优秀课程</td>
												</tr>
												</table>
											</td>
											<td width="1" bgcolor="#e4e3de"></td>
										</tr>
										<tr height="18">
											<td width="1" bgcolor="#e4e3de"></td>
											<td width="346"></td>
											<td width="1" bgcolor="#e4e3de"></td>
										</tr>
										<tr>
											<td width="1" bgcolor="#e4e3de"></td>
											<td width="346" align="center">
											<!-- 国家级精品课程-->
												<table border="0" cellpadding="0" cellspacing="0">
												<tr height="25">
													<td width="23"></td>
													<td width="224">&nbsp;&nbsp;<a href="<s:url action="achievementAction">  <s:param name="level"> 
                                                                   country</s:param></s:url>">国家级精品课程</a></td>
													<td width="78">[<s:property value="country"/>&nbsp;门  ]</td>
													<td width="31"></td>
												</tr>
												<tr><td width="23"></td>
													<td width="346" colspan="2" background="image/main_line.gif" align="center"></td>
												</tr>
												<tr height="25">
													<td width="23"></td>
													<td width="224">&nbsp;&nbsp;<a href="<s:url action="achievementAction">  <s:param name="level"> 
                                                                   country</s:param></s:url>">省级精品课程</a></td>
													<td width="78">[<s:property value="province"/>&nbsp;门  ]</td>
													<td width="31"></td>
												</tr>
												<tr><td width="23"></td>
													<td width="346" colspan="2" background="image/main_line.gif" align="center"></td>
												</tr>
												</tr>
												<tr height="25">
													<td width="23"></td>
													<td width="224">&nbsp;&nbsp;<a href="<s:url action="achievementAction">  <s:param name="level"> 
                                                                   country</s:param></s:url>">校级精品课程</a></td>
													<td width="78">[<s:property value="school"/>&nbsp;门  ]</td>
													<td width="31"></td>
												</tr>
												
												</table>
											<!--/ 리스트 -->
											</td>
											<td width="1" bgcolor="#e4e3de"></td>
										</tr>
										<tr>
											<td colspan="3">&nbsp;</td>
										</tr>
										</table>
									<!--/ 오늘의 발행물 -->
									</td>
								</tr>
								<tr><td height="11"></td></tr>
								<tr>
									<td>
									
									<!--/ 포커스 및 지도검색 -->
									</td>
								</tr>
								</table>
							<!--/ 내용부분 -->
							</td>
						</tr>
						</table>
					<!--/ 이미지 및 게시판 -->
					</td>					
				</tr>

				<tr><td height="10"></td></tr>
				<tr>
					<td align="center" width="750">
					
						
					<!--/ 链接-->
					</td>
				</tr>
				<tr><td height="9"></td></tr>
				<tr>
					<td colspan="2" valign="top" width="800">
					<!-- 소개부분 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="484">
							<!-- 분야별 프로그램 -->
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td><img src="image/utility_title.gif" border="0" alt=""></td>
								</tr>
								<tr>
									<td>
									<!-- 분야별 프로그램 -->
										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td width="96" align="right"><img src="image/utility_cont1.gif" alt=""></td>
											<td width="97" align="right"><img src="image/utility_cont2.gif" alt=""></td>
											<td width="97" align="right"><img src="image/utility_cont3.gif" alt=""></td>
											<td width="97" align="right"><img src="image/utility_cont4.gif" alt=""></td>
											<td width="97" align="right"><img src="image/utility_cont5.gif" alt=""></td>
										</tr>
										</table>
									<!--/ 분야별 프로그램 -->
									</td>
								</tr>
								</table>
								<!--/ 분야별 프로그램 -->
							</td>
							<td width="19"></td>
							<td><img src="image/open_yard.gif" border="0" alt=""></td>
						</tr>
						</table>
					<!--/ 소개부분 -->
					</td>
				</tr>
				<tr><td height="13"></td></tr>
				</table>
			<!--/ 메인부분 -->
			</td>
		</tr>
		</table>
	<!--/ 오른쪽부분 -->
	</td>
</tr>
</table>

<!-- 底部 -->
<s:include value="include/bottom.jsp"></s:include>
</body>
</html>