<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" media="screen"
			href="jifolder/jquery.jqGrid-4.5.4/css/ui.jqgrid.css" />
		<link rel="stylesheet" type="text/css" media="screen"
			href="jifolder/jquery-ui/themes/redmond/jquery-ui1.css" />
			
			<!-- 引入jQuery -->
		<script src="jifolder/jquery.jqGrid-4.5.4/js/jquery-1.9.0.min.js"
			type="text/javascript"></script>
		<script type="text/javascript"
			src="jifolder/jquery.jqGrid-4.5.4/js/i18n/grid.locale-cn.js"></script>
		<script type="text/javascript"
			src="jifolder/jquery.jqGrid-4.5.4/js/jquery.jqGrid.min.js"></script>
		<script type="text/javascript" src="jifolder/jquery-ui/js/jquery-ui1.js"></script>
		<script type="text/javascript"
			src="jifolder/jquery-ui/js/jquery-ui-timepicker-addon.js"></script>

		<script type="text/javascript"
			src="jifolder/jquery-ui/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript">
	
	 
	$(function(){
				 $("#gridTable").jqGrid({
		     url:"<%=basePath%>muser/user",
		     datatype: "json",
		     mtype:"POST",
		     colNames:['ID','登录名', '昵称', '密码','创建时间','修改时间'],
		     colModel:[
		             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
		             {name:'user_id',index:'user_id', width:20,sorttype:"String",editable:true},
		             {name:'name',index:'name', width:20,editable:true},
		             {name:'password',index:'password', width:50,sorttype:"String",editable:true},
		             {name:'modifi_datetime',index:'modifi_datetime', width:20,editable:false},
		             {name:'create_datetime',index:'create_datetime', width:20,editable:false}
					   ],
		     sortname:'id',
		     sortorder:'asc',
		     viewrecords:true,
		     closeAfterAdd: true,
		     rowNum:20,
		     autowidth:true,
		     autoheight:true,
		     height: 260,
		     rowList:[10,15,20],
		     editurl:"<%=basePath%>muser/edituser",
		     jsonReader: {
		     root:"account",               // 数据行（默认为：rows）
		     page: "pageNo",          // 当前页
		     total: "pageCount",        // 总页数
		     records: "dataCount",      // 总记录数
		     repeatitems : false        // 设置成false，在后台设置值的时候，可以乱序。且并非每个值都得设
		     },
		    prmNames:{
		        rows:"pageSize",
		        page:"pageNo"
		         },	  
		     pager:"#gridPager",
		      ondblClickRow: function(id){ showuserinfo(id);},	
		     caption: "用户信息"
		      
		   });
		 //  jQuery("#gridTable").jqGrid('filterToolbar',{searchOperators : false});
		   jQuery("#gridTable").jqGrid('navGrid','#gridPager',{edit:true,add:true,del:true,search:false,closeAfterAdd: true,
closeAfterEdit:true});
		
		});
	</script>
	
  </head>
  
  <body>
  <div>
  	<label>欢迎</label>
  	<label><%=session.getAttribute("name").toString()%></label>
  	<a href="<%=basePath%>muser/showuser">用户管理</a>
  	<a href="<%=basePath%>user/logout"><label>注销</label></a>
  </div>
    <table id="gridTable"></table>
	<div id="gridPager"></div>
	
	<div id="selectdiv">
		<table id="selectTable"></table>
		<div id="selectPager"></div>
	</div>
	
  </body>
</html>
