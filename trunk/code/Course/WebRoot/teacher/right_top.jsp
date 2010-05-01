<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	color: #FFFFFF;
}

-->
a:link {
	font-size: 12px;
	text-decoration: none;
	color: #000000;
}

a:visited {
	font-size: 12px;
	text-decoration: none;
	color: #000000;
}

a:hover {
	font-size: 12px;
	text-decoration: none;
	color: #FF0000;
}

a.v1:link {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}

a.v1:visited {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}
</style>
	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="table-layout: fixed;">
			<tr>
				<td height="28" valign="bottom" background="images/right_03.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="1%" height="26" style="width: 5px;">
								&nbsp;
							</td>
							<td width="99%" valign="bottom">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="75" height="26" valign="bottom">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">
															<span class="STYLE1"><A
																href="getCurrentCourseAction.action" target=mainFrame
																class="v1">申报表格</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width=73 border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="findCurrentCourseInfoAction.action"
																target=mainFrame class="v1">课程信息</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width=73 border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="findCurrentCourseOutlineAction.action"
																target=mainFrame class="v1">教学大纲</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">
															<span class="STYLE1"><A
																href="getTeacherTeamByCourseAction.action"
																target=mainFrame class="v1">教师队伍</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getChapterListByCourseAction.action"
																target=mainFrame class="v1">章节目录</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getCoursewareListByChapterAction.action"
																target=mainFrame class="v1">课件教案</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getExerciseListByChapterAction.action"
																target=mainFrame class="v1">作业习题</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getExperimentListByChapterAction.action"
																target=mainFrame class="v1">实验指导</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getCourseMovieListByCourseAction.action"
																target=mainFrame class="v1">教学录像</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getExaminationListByCourseAction.action"
																target=mainFrame class="v1">课程试卷</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getBookListByCourseAction.action" target=mainFrame
																class="v1">参考书籍</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getAchievementListByCourseAction.action"
																target=mainFrame class="v1">教学成果</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="75">
											<table width="73" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="25"
														style="background: url(images/right_06.gif); border-left: solid 1px #10637b; border-top: solid 1px #10637b; border-right: solid 1px #10637b;">
														<div align="center">

															<span class="STYLE1"><A
																href="getEvaluationResultByCourseAction.action"
																target=mainFrame class="v1">课程评价</A> </span>
														</div>
													</td>
												</tr>
											</table>
										</td><td>&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>

			</tr>
			<tr>
				<td background="images/right_09.gif" style="line-height: 5px;">
					&nbsp;
				</td>
			</tr>
		</table>
	</body>
</html>
