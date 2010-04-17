<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
        <link rel="stylesheet" href="${ctx}/homepage/link.css">
		<script language="javascript">
	function checkPopedom(){
		var user = <%=(String) session.getAttribute("user")%>;
		if(user == null){	
			document.getElementById("myHome").style.display="none";
		}else{	
			document.getElementById("myHome").style.display="block";
		}	
  	}
  	</script><style type="text/css">
	.tda{
		text-align: center;
	}
</style>
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
					<a href="index.htm"><img src="${ctx}/homepage/image/logo.gif"
							border="0"> </a>
				</td>
				<td>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr height="25">
							<td align="right">
								<table border="0" cellpadding="0" cellspacing="0" id="myHome" align="right">
									<tr>
										<td width="80" class="tda" align="center" >
											<a href="<s:url action="myPageAction"></s:url>">我的主页</a>&nbsp;
										</td>
										<td width="4" align="center" >
											<img src="${ctx}/homepage/image/line.gif" border="0">
										</td>
										<td width="80" class="tda"  align="center">
											<a href="<s:url action="logoutAction"></s:url>">退出系统</a>
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<div id="wrapper">
										<div id="menu">
											<ul>
												<li class="current_page_item">
													<a href="<s:url action="homepageNewsAction"> </s:url>">首页</a>
												</li>
												<li>
													<a href="<s:url action="newsAction"> </s:url>">新闻公告</a>
												</li>
												<li>
													<a href="<s:url action="forwardToSearchAction"> </s:url>">搜索课程</a>
												</li>
												<li>
													<a href="<s:url action="achievementAction"> </s:url>">建设成果</a>
												</li>
												<li>
													<a href="<s:url action="schoolCourseAction"> </s:url>">院系课程</a>
												</li>
												<li class="last">
													<a href="<s:url action="lastCourseAction"> </s:url>">最新课程</a>
												</li>
											</ul>
										</div>
									</div>
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