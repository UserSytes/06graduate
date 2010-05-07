<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站——院系课程</title>
		<link rel="stylesheet" href="${ctx}/homepage/link.css">
		<link rel="stylesheet" href="${ctx}/homepage/easyui.css">
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.easyui.min.js"></script>

		<script type="text/javascript">
	$(document).ready( function() {
		$('#tt').tree( {
			animate :true,
			url :'${ctx}/dept_data.properties',
			onClick : function(node) {				
				if(node.id == 2){				
					var url  = "findCourseListBySchoolNameAction.action";
					$('#courseListMain').load(url,{	schoolName :node.text});
				}
				else if(node.id ==3){
					var url = "findCourseListByDeptNameAction.action";
					$('#courseListMain').load(url,{	deptName :node.text});
				}
				
			}
		});
	});
</script>
	</head>
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		width="100%" height="100%"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">
		<s:include value="include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<img src="${ctx}/homepage/image/left_menu_title4.gif"
												border="0">
										</td>
									</tr>
									<tr>
										<td>
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="left">
														<ul id="tt"></ul>
													</td>
													<td width="11" background=""></td>
												</tr>


											</table>
										</td>
									</tr>
									<tr>
										<td>
											<img src="${ctx}/homepage/image/left_menu_bottom.gif"
												border="0">
										</td>
									</tr>
								</table>

							</td>
						</tr>
					</table>
					<!--/left -->
				</td>
				<td width="750" valign="top" align="right">
					<!-- main -->
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- main2 主题图 -->
							<td valign="top">
								<img src="${ctx}/homepage/image/main_img2.jpg" border="0">
							</td>
							<!--/main2 主题图 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr height="27">
							<!-- 主题 -->
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11"></td>
										<td align="left">
											<img src="${ctx}/homepage/image/title_school.gif" border="0"
												alt="">
										</td>
									</tr>
									<tr height="3">
										<td width="11"></td>
										<td bgcolor="#d7d7d7" width="738"></td>
									</tr>
								</table>
							</td>
							<!--/ 主题 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr>
							<td valign="top" align="center">
								<!-- 内容 -->
								<div id="courseListMain">
									<s:include value="courseslist.jsp"></s:include>
								</div>
								<!-- /内容 -->
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