<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="../commons/taglibs.jsp"%>
<html>
  <head> 
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>厦门大学课程中心-评价登录</title>
	<SCRIPT language=javascript>
	function check(form) {
		if (form.userName.value == "") {
			alert("账号不能为空！");
			return false;
		}
		if (form.password.value == "") {
			alert("密码不能为空！");
			return false;
		}
		if (form.flag.value == -1) {
			alert("请选择权限！");
			return false;
		}
		return true;
	}
</SCRIPT>
</head>
<body bgcolor="#9CDCF9">
<table width="681" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:120px">
  <tr>
    <td width="353" height="259" align="center" valign="bottom" background="${ctx}/admin/Images/login_1.gif"><table width="90%" border="0" cellspacing="3" cellpadding="0">
      
    </table></td>
    <td width="195" background="${ctx}/admin/Images/login_2.gif">
	<table width="190" height="106" border="0" align="center" cellpadding="2" cellspacing="0">
      <s:form action="evaluationLoginAction" method="post" onsubmit="return check(this);" name="NETSJ_Login">
            <tr>
              <td height="50" colspan="4" align="left">&nbsp;</td>
            </tr>
            <tr>
              <td width="60" height="30" ><strong><font size="2" face="宋体" color="gray">账号</font></strong></td>
              <td><s:textfield name="userName" size="19" label="帐号"></s:textfield>
			 </td> 
            </tr>
            <tr>
              <td height="30" width="60"><strong><font size="2" face="宋体" color="gray">密码</font></strong></td>
              <td><s:password size="19" name="password"></s:password></td>
            </tr>
            <tr>
              <td height="30"><strong><font size="2" face="宋体" color="gray"> 权限</font></strong> </td>
			  <td><s:select name="flag" list="# {'0':'专家','1':'同行'}"
							headerKey="-1" headerValue="请选择"/>
		      </td>
            </tr>
            <tr>
              <td height="40" colspan="2" align="center">
						<font size="2" color="red"><s:actionerror /></font></td>
          <tr>
              <td colspan="2" align="center"><input type="submit" name="submit"  value=" 登  陆 "> 
			  <input type="reset" name="Submit"  value=" 取  消 "></td>
            <tr>
              <td height="5" colspan="2"></td>
        </s:form>
    </table></td>
    <td width="133" background="${ctx}/admin/Images/login_3.gif">&nbsp;</td>
  </tr>
  <tr>
    <td height="161" colspan="3" background="${ctx}/admin/Images/login_4.gif"></td>
  </tr>
</table>
</body>    
</html>
