<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<HTML>
	<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<TITLE>JFreeChart Demo</TITLE>
		<meta http-equiv='content-type' content='text/html; charset=UTF-8'>
	</HEAD>
	<script type="text/javascript">

 </script>
	<BODY>
	<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程评价-&gt; 评价柱形图 
				</td>
			</tr>
		</table>

		<P align="center">
			<IMG SRC="${ctx}/servlet/ServletChartGenerator" BORDER=1 WIDTH=800
				HEIGHT=600 />

		<table bgcolor="white" class=editTable cellSpacing=1 cellPadding=0
			width="90%" align=center border=0>
			<TR>
				<td bgcolor="white">
					<strong><font color="red" size="3"> 提示</font> </strong>
					<div id="content_note">
						<ul>
							<li>
								对比课程数在10门一下柱形图的可视度最佳。
							</li>
							<li>
								鼠标右键菜单选择“图片另存为”操作，即可保存此柱形图。
							</li>
						</ul>
					</div>
				</td>
			</TR>
		</table>
	</div>
	</BODY>
</HTML>

