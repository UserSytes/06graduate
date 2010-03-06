<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title><s:text name="">${topic.name}</s:text>
		</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 留言管理 -&gt; 浏览留言贴
				</td>
			</tr>
		</table>

		<div align="center">
			<table class="listTable" >
				<tr class="listHeaderTr">
					<td class=editHeaderTd colSpan=10>
						<s:text name="">${topic.name}</s:text>
					</td>
				</tr>
				<s:iterator value="messageList" status="message">
					<tr class="listTr">
						<td width="20%">
							<table style="border:0px solid #ffffff;" width="100%">
								<tr>
									<td align="left">
										<s:property value="grade" />
										楼
									</td>
								</tr>
								<tr>
									<td><div align="center">
										<s:property value="userInfo.name" /></div>
									</td>
								</tr>
							</table>
						</td>
						<td width="80%">
							<table style="border:0px solid #ffffff;" width="100%">
								<tr>
									<td>
										<s:property value="content" />
									</td>
								</tr>
								<tr>
									<td><div align="right">
										<s:property value="time" />
										<a
											href="<s:url action="deleteMessageAction"> 
                     			<s:param name="messageId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
											onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
											<font color="red">【删除】</font> </a>
									</div></td>
								</tr>
							</table>
						</td>

					</tr>
				</s:iterator>
				<tr class="listFooterTr">
				</tr>
			</table>
		</div>
	</body>
</html>