<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
<script language="javascript">
	function checkPopedom(){
		var user = <%=(String) session.getAttribute("user")%>;
		if(user == null){	
			document.getElementById("myHome").style.display="none";
		}else{	
			document.getElementById("myHome").style.display="block";
		}	
  	}
  	</script>
	</head>
	<body>

		<!-- 权限导航 -->
<table border="0" cellpadding="0" cellspacing="0" width="950" height="30" background="${ctx}/coursepage/classical/image/topmenubg.gif" style="background-repeat:no-repeat" align="center">
<tr>
	<td width="541"></td>
	<td width="35"><a href="${ctx}/homepage/index.jsp"><img src="${ctx}/coursepage/classical/image/home.gif" border="0"></a></td>
	<td width="32"><img src="${ctx}/coursepage/classical/image/topmenu_dot.gif" border="0"></td>
	<td width="39"><a href="#"><img src="${ctx}/coursepage/classical/image/login.gif" border="0"></a></td>
	<td width="32"><img src="${ctx}/coursepage/classical/image/topmenu_dot.gif" border="0"></td>
	<td width="51"><a href="#"><img src="${ctx}/coursepage/classical/image/sitemap.gif" border="0"></a></td>
	<td width="32"><img src="${ctx}/coursepage/classical/image/topmenu_dot.gif" border="0"></td>
	<td width="34"><a href="#"><img src="${ctx}/coursepage/classical/image/FAQ.gif" border="0"></a></td>
	<td width="24"><img src="${ctx}/coursepage/classical/image/topmenu_dot.gif" border="0"></td>
	<td width="71"><a href="#"><img src="${ctx}/coursepage/classical/image/contactus.gif" border="0"></a></td>
	<td width="59"></td>
</tr>
</table>
<!--/权限导航->

<!-- 课程导航-->
<table width="950" border="0" cellpadding="0" cellspacing="0" align="center">
<tr>
	<td>
		<!-- 标题 -->
		<table >
		<tr>
			<td valign="top"><img src="${ctx}/coursepage/classical/image/logo.gif" width="204" border="0"></td>
			
		</tr>
	  </table></td>
		<!--/标题 -->
	<td>
		<!-- 正式导航 -->
		<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#42874f" height="49">
		<tr>
			<td><a href="goIndexQueryAction.action"><img src="${ctx}/coursepage/classical/image/menu4.gif" width="75" height="110" border="0"></a></td>
<td><a href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	2 
                    			</s:param>
                					</s:url>"><img src="${ctx}/coursepage/classical/image/menu1.gif"  width="75" height="110" border="0"></a></td>
<td><a href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	0 
                    			</s:param>
                					</s:url>"><img src="${ctx}/coursepage/classical/image/menu2.gif" width="75" height="110" border="0"></a></td>
			<td><a href="<s:url action="findTeacherTeamAction"></s:url>"><img src="${ctx}/coursepage/classical/image/menu3.gif" width="75" height="110" border="0"></a></td>
			<td><a href="<s:url action="findAchievementAction"></s:url>"><img src="${ctx}/coursepage/classical/image/menu5.gif" width="75" height="110" border="0"></a></td>
			<td><a href="<s:url action="getAllCoursewareAction"></s:url>"><img src="${ctx}/coursepage/classical/image/menu6.gif" width="75" height="110" border="0"></a></td>
			<td><a href="<s:url action="getAllExaminationAction"></s:url>"><img src="${ctx}/coursepage/classical/image/menu7.gif" width="75" height="110" border="0"></a><a href="medical clinic/index.htm"></a></td>
			<td><a href="<s:url action="getAllBookAction"></s:url>"><img src="${ctx}/coursepage/classical/image/menu8.gif" width="75" height="110" border="0"></a><a href="reservation/index.htm"></a></td>
			<td><a href="<s:url action="getCourseMovieListAction"></s:url>"><img src="${ctx}/coursepage/classical/image/menu9.gif" width="75" height="110" border="0"></a></td>
			<td><a href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>"><img src="${ctx}/coursepage/classical/image/menu10.gif" width="75" height="110" border="0"></a></td>
		</tr>
		</table>
		<!-- /正式导航 -->
	</td></tr>
</table>
<!-- /课程导航 -->
	</body>
</html>