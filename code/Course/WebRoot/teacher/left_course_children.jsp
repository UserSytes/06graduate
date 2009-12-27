<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<table id="submenu3" width="145" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<s:iterator value="myCoursesList" status="course">
		<tr>
			<td>
				<table width="130" border="0" align="center" cellpadding="0"
					cellspacing="0">

					<tr>
						<td width="41" height="35">
							<div align="center">
								<img src="images/left_3.gif" width="31" height="31">
							</div>
						</td>
						<td height="35">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="23" style="cursor: hand"
										onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
										onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
										<span class="STYLE2">&nbsp;<span class="STYLE2">&nbsp;<a
											target=I2	href="<s:url action="saveCurrentCourseAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
												<s:property value="name"/> </a> </span>
									</td>
								</tr>
							</table>
						</td>
					</tr>

				</table>
			</td>
		</tr>
	</s:iterator>
</table>
