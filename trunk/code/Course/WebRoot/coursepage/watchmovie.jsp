<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><s:property value="courseMovie.title" />-教学录像-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />

	</head>
	<body>
		<!-- 头部 -->
		<s:include value="style/%{#session.header}"></s:include>
		<script type="text/javascript" src="${ctx}/js/jquery.metadata.v2.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.media.js"></script>
		<script type="text/javascript">
	$( function() {
		$('a.media').media();
	});
</script>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="style/left.jsp"></s:include>
			<div id="right-cnt">
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="getCourseMovieListAction"> 
                					</s:url>">教学录像</a>&gt;详细浏览
					</h2>
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table-info">
						<tr height="29">
							<td align="center">
								<font style="font-size: 16px; font-weight: bold"><s:property
										value="courseMovie.title" /> </font>
							</td>
						</tr>
						<tr height="19">
							<td>
								<font class="timefont">发布者：<s:property
										value="courseMovie.author" /> &nbsp;| &nbsp;职称：<s:property
										value="courseMovie.position" /> &nbsp;| &nbsp; 发布时间：<s:date
										name="courseMovie.time" format="yyyy-MM-dd" /> </font>
							</td>
						</tr>
						<tr height="1" class="tr-title">
							<td width="680" valign="top" style="padding-left: 10px"></td>
						</tr>
						<tr height="420">
							<td width="704" align="center">
										<s:if test="courseMovie.src==''">
															<a class="media {width:500, height:400, params: {controls:'imagewindow,controlpanel'}}"
												href="${ctx}/upload/<s:property value="courseMovie.fileLink"/>"></a></s:if>
														<s:else>
										<a class="media {width:500, height:400, params: {controls:'imagewindow,controlpanel'}}"
												href="<s:property value="courseMovie.src"/>"></a></s:else>

									
							</td>
						</tr>
						<tr>
							<td align="center">
								<table border="1" cellpadding="0" cellspacing="0" width="700"
									class="table-app" style="line-height: 150%;padding: 2px;">
									<tr height="34">
										<td width="100">
											<font style="font-size: 14px; font-weight: bold;">视频简介</font>
										</td>
										<td width="600">
											<s:property value="courseMovie.content" />
										</td>
									</tr>
									<tr height="34" >
										<td width="100">
											<font style="font-size: 14px; font-weight: bold;">观看提示</font>
										</td>
										<td width="600" >
											<p style="line-height: 150%;padding: 2px;" >观看视频前请确保您的电脑已经安装Real Player插件，否则无法正常观看。</p>
											<p style="line-height: 150%;padding: 2px;" >如果视频只有声音没有图像，请先安装Media Player解码器或<a												href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	util/xvid.exe
                    			</s:param> 
						<s:param name="originalFileName"> 
                       			 	xvid.exe
                    			</s:param> 
                					</s:url>">
												<font color="green">【点击这里】</font> </a>下载安装。</p>
										</td>
									</tr>
									<tr height="34">
										<td width="100">
											<font style="font-size: 14px; font-weight: bold;">下载链接</font>
										</td>
										<td width="600">
											<a
												href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="courseMovie.fileLink"/> 
                    			</s:param> 
						<s:param name="originalFileName"> 
                       			 	<s:property value="courseMovie.filename"/> 
                    			</s:param> 
                					</s:url>">
												<font color="red"><s:property
														value="courseMovie.filename" />
											</font> </a>
										</td>
									</tr>
								</table>
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
