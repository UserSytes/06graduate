<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><s:if test="sort==0">
课程通知</s:if> <s:else>课程公告</s:else>-厦门大学课程网络平台</title>

		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<style type="text/css" title="currentStyle">
@import "${ctx}/css/demo_page.css";

@import "${ctx}/css/demo_table_jui.css";

@import "${ctx}/css/jquery-ui-1.7.2.custom.css";
</style>
	</head>

	<body id="dt_example">
		<!-- 头部 -->
		<s:include value="style/%{#session.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<script type="text/javascript" language="javascript"
				src="${ctx}/js/jquery.dataTables.js" charset="gb2312"></script>
			<script type="text/javascript" charset="utf-8">
	$(document).ready( function() {
		oTable = $('#example').dataTable( {
			"bJQueryUI" :true,
			"sPaginationType" :"full_numbers"
		});
	});
</script>
			<s:include value="style/left.jsp"></s:include>
			<div id="right-cnt">
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	<s:property value="sort" /> 
                    			</s:param>
                					</s:url>"><s:if
								test="sort==0">课程通知</s:if> <s:else>课程公告</s:else> </a>&gt;列表浏览
					</h2>
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="724" align="center">
								<!--게시판 -->
								<div class="demo_jui">
									<table border="0" cellpadding="0" cellspacing="0" width="684"
										class="display" id="example">
										<thead>
											<tr>
												<th width="60">
													
												</th>
												<th width="464">
													标题
												</th>
												<th width="60">
													类别
												</th>
												<th width="100">
													发布时间
												</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="noticeList" status="notice">
												<tr height="33" class="tr-content">
													<td style="text-align: left;" width="60">
														&nbsp;<s:property value="#notice.count" />
													</td>
													<td width="464" align="center" style="font-weight: bold">
														<a class="titlea"
															href="<s:url action="viewNoticeAction"> 
											                     			<s:param name="noticeId"> 
											                       			 	<s:property value="id"/> 
											                    			</s:param>
																			<s:param name="sort"> 
											                       			 	<s:property value="sort"/>
											                    			</s:param>
											                					</s:url>"><s:property
																value="title" /> </a>
													</td>
													<td width="60">
														<s:if test="sort==0">
															课程通知</s:if>
														<s:else>课程公告</s:else>
													</td>
													<td width="100" align="center">
														<s:date name="time" format="yyyy-MM-dd hh:mm" />
													</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
								<!--/게시판 -->
							</td>
						</tr>
					</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="style/bottom.jsp"></s:include>
	</body>
</html>
