<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>管理系统</title>
		<link href="Images/css1/left_css.css" rel="stylesheet" type="text/css">
	</head>
	<SCRIPT language=JavaScript>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
</SCRIPT>
	<body bgcolor="16ACFF">
		<table width="98%" border="0" cellpadding="0" cellspacing="0"
			background="Images/tablemde.jpg">
			<tr>
				<td height="5" background="Images/tableline_top.jpg"
					bgcolor="#16ACFF"></td>
			</tr>
			<tr>
				<td>
					<TABLE width="97%" border=0 align=right cellPadding=0 cellSpacing=0
						class=leftframetable>
						<TBODY>
							<TR>
								<TD height="25"
									style="background: url(Images/left_tt.gif) no-repeat">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<TD width="20"></TD>
											<TD class=STYLE1 style="CURSOR: hand" onclick=showsubmenu(1);
												height=25>
												新闻政策管理
											</TD>
										</tr>
									</table>
								</TD>
							</TR>
							<TR>
								<TD>
									<TABLE id=submenu1 cellSpacing=0 cellPadding=0 width="100%"
										border=0>
										<TBODY>
											<TR>
												<TD width="2%">
													<IMG src="Images/closed.gif">
												</TD>
												<TD height=23>
													<A href="System_Admin.asp" target=main>新闻政策列表</A>
												</TD>
											</TR>
											<TR>
												<TD>
													<IMG src="Images/closed.gif">
												</TD>
												<TD height=23>
													<A href="Log_Admin.asp" target=main>发布新闻政策</A>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</td>
			</tr>
			<tr>
				<td height="5" background="Images/tableline_bottom.jpg"
					bgcolor="#9BC2ED"></td>
			</tr>
			<tr>
				<td height="5" background="Images/tableline_top.jpg"
					bgcolor="#9BC2ED"></td>
			</tr>
			<tr>
				<td>
					<table class="leftframetable" cellspacing="0" cellpadding="0"
						width="97%" align="right" border="0">
						<tbody>
							<tr>
								<td height="25"
									style="background: url(Images/left_tt.gif) no-repeat">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="20"></td>
											<td height="25" class="titledaohang" style="CURSOR: hand"
												onClick="showsubmenu(2);">
												<span class="STYLE1">院系管理</span>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table id="submenu2" cellspacing="0" cellpadding="0"
										width="100%" border="0">
										<tbody>
											<tr>
												<td width="2%">
													<img src="Images/closed.gif" />
												</td>
												<td height="23">
													<a href="<s:url action='findAllSchoolsAction'> </s:url>"
														target="main"> 学院列表</a>┆
													<a href="schoolmanage/addschool.jsp" target="main">添加学院</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="Images/closed.gif" />
												</td>
												<td height="23">
													<a href="<s:url action='allAdminAction'> </s:url>"
														target="main"> 学院管理员列表</a>
												</td>
											</tr>
											<tr>
												<td>
													<img src="Images/closed.gif" />
												</td>
												<td height="23">
													<a href="<s:url action='goAddAdminAction'> </s:url>"
														target="main"> 添加学院管理员</a>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td height="5" background="Images/tableline_bottom.jpg"
					bgcolor="#9BC2ED"></td>
			</tr>
			<tr>
				<td height="5" background="Images/tableline_top.jpg"
					bgcolor="#9BC2ED"></td>
			</tr>
			<tr>
				<td>
					<TABLE class=leftframetable cellSpacing=0 cellPadding=0 width="97%"
						align=right border=0>
						<TBODY>
							<TR>
								<TD height="25"
									style="background: url(Images/left_tt.gif) no-repeat">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<TD width="20"></TD>
											<TD class=STYLE1 style="CURSOR: hand" onclick=showsubmenu(4);
												height=25>
												年级管理
											</TD>
										</tr>
									</table>
								</TD>
							</TR>
							<TR>
								<TD>
									<TABLE id=submenu4 cellSpacing=0 cellPadding=0 width="100%"
										border=0>
										<TBODY>
											<TR>
												<TD width="2%">
													<IMG src="Images/closed.gif">
												</TD>
												<TD height=23>
													<a href="<s:url action='allGradeAction'> </s:url>"
														target="main">年级列表</A>
												</TD>
											</TR>
											<TR>
												<TD>
													<IMG src="Images/closed.gif">
												</TD>
												<TD height=23>
													<A href="schoolmanage/addgrade.jsp" target=main>添加年级</A>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</td>
			</tr>
			<tr>
				<td height="5" background="Images/tableline_bottom.jpg"
					bgcolor="#9BC2ED"></td>
			</tr>
			<tr>
				<td height="5" background="Images/tableline_top.jpg"
					bgcolor="#9BC2ED"></td>
			</tr>
			<tr>
				<td height="8">

					<TABLE class=leftframetable cellSpacing=1 cellPadding=1 width="97%"
						align=right border=0>
						<TBODY>
							<TR>
								<TD height="25"
									style="background: url(Images/left_tt.gif) no-repeat">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<TD width="20"></TD>
											<TD class=STYLE1 height=25>
												系统信息
											</TD>
										</tr>
									</table>
								</TD>
							</TR>
							<TR>
								<TD height=105>
									<span class="STYLE2"><IMG src="Images/closed.gif">版权所有：865171<br>
										<IMG src="Images/closed.gif">设计制作：865171<br> <IMG
											src="Images/closed.gif">技术支持：<a
										href="http://www.865171.cn" target="_blank">865171</a> <br>
										<IMG src="Images/closed.gif">帮助中心：<a
										href="http://www.865171.cn" target="_blank">865171</a> <br>
										<IMG src="Images/closed.gif">系统版本：1.0</span>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</td>
			</tr>
			<tr>
				<td height="5" background="Images/tableline_bottom.jpg"></td>
			</tr>
		</table>
	</body>
</html>