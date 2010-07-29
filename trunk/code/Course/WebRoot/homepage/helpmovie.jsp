<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<script type="text/javascript" src="${ctx}/js/jquery.metadata.v2.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.media.js"></script>
<script type="text/javascript">
	$( function() {
		$('a.media').media();
	});
</script>
<table width="90%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="90%" align="left">
			<s:actionmessage />
		</td>
	</tr>
</table>
<table id="table" width="96%" cellpadding="0" cellspacing="0">
	<tr height="420">
		<td width="704" align="center">
			<a
				class="media {width:500, height:400, params: {controls:'imagewindow,controlpanel'}}"
				href="${ctx}/<s:property value="src"/>"></a>
		</td>
	</tr>
<tr>
							<td align="center">
								<table border="1" cellpadding="0" cellspacing="0" width="700"
									class="table-app" style="line-height: 100%;padding-left: 2px;">
									<tr height="20" >
										<td width="100" align="center">
											<font style="font-size: 14px; font-weight: bold;">观看提示</font>
										</td>
										<td width="600" >
											<p style="line-height: 100%;padding-left: 2px;" >播放时右键点击录像选择"缩放"->"全屏"可在全屏模式下观看。</p>
											<p style="line-height: 100%;padding-left: 2px;" >如果视频只有声音没有图像，请先安装Media Player解码器或<a												href="<s:url action="download"> 
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
								</table>
						</td>
						</tr>
</table>
<div id="Pagination" class="pagination" style="float: right"></div>
