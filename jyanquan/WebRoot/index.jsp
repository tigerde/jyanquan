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
	$(function()
 {
		 $("#gridTable").jqGrid({
     url:"<%=basePath%>driver/all",
     datatype: "json",
     mtype:"POST",
     colNames:['ID','姓名', '性别', '驾驶证号','手机号码','线路', '所在分公司'],
     colModel:[
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sorttype:"String",editable:true,editrules:{required:true},searchoptions:{sopt:['cn']}},
             {name:'sex',index:'sex', width:20,editable:true,searchoptions:{sopt:['cn']}},
             {name:'idcard',index:'idcard', width:50,sorttype:"String",editable:true,editrules:{required:true},searchoptions:{sopt:['cn']}},
             {name:'mobile_phone',index:'mobile_phone', width:20,editable:true,searchoptions:{sopt:['cn']}},
             {name:'line_number',index:'line_number', width:20,editable:true,searchoptions:{sopt:['cn']}},
             {name:'company',index:'company', width:20,editable:true,searchoptions:{sopt:['cn']}},
			   ],
     sortname:'id',
     sortorder:'asc',
     viewrecords:true,
     closeAfterAdd: true,
     rowNum:20,
     autowidth:true,
     //autoheight:true,
     height: 600,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driver/driversimpleedit",
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
     caption: "驾驶员信息"
      
   });
   jQuery("#gridTable").jqGrid('filterToolbar',{searchOperators : true});
   jQuery("#gridTable").jqGrid('navGrid','#gridPager',{edit:true,add:true,del:true,search:false});

});

	function showuserinfo(id){
			window.open("driver/showinfo?id="+id);
		}

	
	</script>
	
  </head>
  
  <body>
    <table id="gridTable"></table>
	<div id="gridPager"></div>
	


  </body>
</html>
