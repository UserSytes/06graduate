<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<script>jQuery.noConflict();</script>
		<title>修改图片</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.upload.value == "")
				{
					alert("上传头像不能为空！");
					return false;
				}
				form.submit.disabled = true;	
			}
		</SCRIPT>
		<style type="text/css">
TABLE.editTable {
	FONT-SIZE: 12px;
	LINE-HEIGHT: 150%;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif";
	border: 1px solid #666;
	WIDTH: 98%;
	COLOR: #000;
	BACKGROUND-COLOR: #87ceeb
}

TR.position {
	HEIGHT: 25px;
	BACKGROUND-COLOR: #b0e0e6
}
</style>
	</head>

	<body>

		<table class=editTable style="margin: 20px 0 20px 0; color: #000"
			cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
			<tr class=position bgcolor="#22cc77">
				<td style="color: #000">
					当前位置: 个人资料 -&gt; 修改头像
				</td>
			</tr>
		</table>

		<s:form action="changePhotoAction" onsubmit="return check(this);"
			method="post" enctype="multipart/form-data">
			<table width="95%" border="3" cellpadding="0" cellspacing="0"
				bordercolor="#e7e7d7">
				<s:hidden name="userInfo.id"></s:hidden>
				<tr height="300">
					<td width="240">
						<table>
							<tr height="30">
								<td align="left" width="200">
									<strong>&nbsp;&nbsp;&nbsp;&nbsp;当前头像</strong>
								</td>
							</tr>
							<tr height="2">
								<td align="center" bgcolor="#d7d7d7" width="200"></td>
							</tr>
							<tr>
								<td align="center">
									<strong><a
										href="${ctx}/upload/<s:property value="userInfo.photo"/>"
										title="" class="thickbox"><img width="180" border="0"
												src="${ctx}/upload/<s:property value="userInfo.photo"/>" />
									</a> </strong>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table height="100%" width="100%">
							<tr height="38">
								<td align="left">
									<strong>设置新头像</strong>
								</td>
							</tr>
							<tr height="2">
								<td bgcolor="#d7d7d7" width="95%"></td>
							</tr>
							<tr height="30">
								<td align="left">
									支持JPG、JPEG、GIF、BMP和PNG文件，最大1M。
								</td>
							</tr>
							<tr height="30">
								<td align="left">
									<s:file id="upload" name="upload"></s:file>
								</td>
							</tr>
							<tr height="30">
								<td align="left">
									<s:submit id="submit" cssClass="label" value="确认" />
									<s:reset cssClass="label" value="取消" />
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
