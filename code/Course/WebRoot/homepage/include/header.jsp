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
	<body onload="checkPopedom()">

		<table border="0" cellpadding="0" cellspacing="0" width="950"
			height="100" align="center">
			<tr height="28">
				<td></td>
			</tr>
			<tr>
				<td width="880" valign="top">
					&nbsp;
					<a href="index.htm"><img src="${ctx}/homepage/image/logo.gif" border="0">
					</a>
				</td>
				<td>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td  align="right">
								<table border="0" cellpadding="0" cellspacing="0" id="myHome">
									<tr>
										<td width="80">
											<a href="<s:url action="myPageAction"></s:url>">我的主页</a>&nbsp;
										</td>
										<td width="80">
											<a href="<s:url action=""></s:url>">站内信（0）</a>&nbsp;
										</td>
										<td width="80">
											<a href="<s:url action="logoutAction"></s:url>">退出系统</a> &nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
									codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
									width="753" height="55">
									<param name="movie" value="${ctx}/homepage/flash/menu_v7.swf?button=1" />
									<param name="quality" value="high" />
									<param name="menu" value="false" />
									<param name="wmode" value="transparent" />
									<!--[if !IE]> <-->
									<object data="flash/menu_v7.swf?button=1" width="753"
										height="55" type="application/x-shockwave-flash">
										<param name="quality" value="high" />
										<param name="menu" value="false" />
										<param name="wmode" value="transparent" />
										<param name="pluginurl"
											value="http://www.macromedia.com/go/getflashplayer" />
										FAIL (the browser should render some flash content, not this).
									</object>
									<!--> <![endif]-->
								</object>
							</td>
						</tr>
						<tr>
							<td height="20"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>