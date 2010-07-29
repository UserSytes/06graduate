<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<table width="90%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="90%" align="left">
			<s:actionmessage />
		</td>
	</tr>
</table>
<table id="table" width="96%" cellpadding="0" cellspacing="0" style="margin-top: 50px">
<tr>
							<td align="center">
								<table border="1" cellpadding="0" cellspacing="0" width="700"
									class="table-app" style="line-height: 100%;padding-left: 2px;">
									<tr height="20" >
										<td width="100" align="center">
											<font style="font-size: 14px; font-weight: bold;">帮助中心</font>
										</td>
										<td width="600" >
											<p style="line-height: 100%;padding-left: 2px;" ><a												href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	help/厦门大学课程中心用户手册.doc
                    			</s:param> 
						<s:param name="originalFileName"> 
                       			 	厦门大学课程中心用户手册.doc
                    			</s:param> 
                					</s:url>">
												<font color="green">【点击这里】</font> </a>下载用户手册。</p>
										</td>
									</tr>
								</table>
						</td>
						</tr>
</table>
<div id="Pagination" class="pagination" style="float: right"></div>
