<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>用户登录</TITLE>
<base href="<%=basePath%>">
<LINK href="jifolder/images/Default.css" type=text/css rel=stylesheet>
<LINK href="jifolder/images/xtree.css" type=text/css rel=stylesheet>
<LINK href="jifolder/images/User_Login.css" type=text/css rel=stylesheet>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
<script src="<%=path%>/jifolder/js/jquery-1.6.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	

	$(function(){
	 $("#IbtnEnter").click(function (){
	 var username=$("#TxtUserName").val();
	 var password=$("#TxtPassword").val();
	 
	 if(username=="")
	 {
	  $("#msg").empty();
	  $("#msg").show();
	  $("#msg").append("填写用户名");
	  return ;
	 }
	 else if(password=="")
	 {
       $("#msg").empty();
        $("#msg").show();
	   $("#msg").append("填写密码");
	   return;
	 }
	 else
	 {
		$.ajax({
			 			 url: "<%=path %>/user/login?username="+username+"&password="+password,
			 			 success:function(data)
			 			 {
			 			      if(data['result']==1)
			 			      {
			 			          window.location.href="<%=path%>/index.jsp";
			 			      }
			 			      else
			 			      {
			 			             $("#msg").empty();
			                         $("#msg").append("用户名或者密码错误");
			 			      }
			 			 }
			});
	 }
	 });
	});
</script>

</HEAD>
<BODY id=userlogin_body>
<DIV></DIV>
<DIV id=user_login>
<DL>
  <DD id=user_top>
  <UL>
    <LI class=user_top_l></LI>
    <LI class=user_top_c></LI>
    <LI class=user_top_r></LI></UL>
  <DD id=user_main>
  <UL>
    <LI class=user_main_l></LI>
    <LI class=user_main_c>
    <DIV class=user_main_box>
    <UL>
      <LI class=user_main_text>用户名： </LI>
      <LI class=user_main_input><INPUT class=TxtUserNameCssClass id="TxtUserName"
      maxLength=20 name=TxtUserName> </LI>
      
      </UL>
    <UL>
      <LI class=user_main_text>密 码： </LI>
      <LI class=user_main_input><INPUT class=TxtPasswordCssClass id="TxtPassword" 
      type=password name=TxtPassword> </LI>
      
      <li><SPAN id="msg"  style="DISPLAY: none; COLOR: red"></SPAN></li>
      </UL>
      <!-- 
    <UL>
      <LI class=user_main_text>Cookie： </LI>
     <LI class=user_main_input><SELECT id=DropExpiration name=DropExpiration> 
        <OPTION value=None selected>不保存</OPTION> <OPTION value=Day>保存一天</OPTION> 
        <OPTION value=Month>保存一月</OPTION> <OPTION 
      value=Year>保存一年</OPTION></SELECT> </LI></UL> 
       -->
      </DIV></LI>
    <LI class=user_main_r>
    <INPUT class="IbtnEnterCssClass" id="IbtnEnter" style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" 
    onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("IbtnEnter", "", true, "", "", false, false))' 
    type="image" src="jifolder/images/user_botton.gif" name="IbtnEnter"> </LI></UL>
  <DD id=user_bottom>
  <UL>
    <LI class=user_bottom_l></LI>
    <LI class=user_bottom_c>
    <SPAN style="MARGIN-TOP: 40px"> 
    <A  href="http://www.wenxinbashi.com">交运集团青岛温馨巴士有限公司</A>版权所有</SPAN> </LI>
    <LI class=user_bottom_r></LI>
    </UL>
    </DD></DL>
 </DIV>
    
    <SPAN id="ValrPassword"  style="DISPLAY: none; COLOR: red"></SPAN>
    <SPAN id="ValrValidateCode"  style="DISPLAY: none; COLOR: red"></SPAN>
<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>

<DIV></DIV>
</BODY></HTML>
