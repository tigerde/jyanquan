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
	//个人信息
	$(function()
 {
		 $("#driverinfo").jqGrid({
     url:"<%=basePath%>driver/driverinfo?id=<%=request.getParameter("id").toString()%>",
     datatype: "json",
     mtype:"POST",
     colNames:['操作','ID','工号','姓名','驾驶证号','性别','生日','手机','家庭电话','线路','车牌号','准驾车型','取得A3或A1资格时间','所在分公司'],
     colModel:[
     		 {name: 'modify', width:30, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:35, sorttype:"String",editable:false},
             {name:'staffid',index:'staffid', width:30,editable:true},
             {name:'name',index:'name', width:30,editable:true,editrules:{required:true}},
             {name:'idcard',index:'idcard', width:50,editable:true,editrules:{required:true}},
             {name:'sex',index:'sex', width:10,editable:true},
             {name:'birth',index:'birth', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
             {name:'mobile_phone',index:'mobile_phone', width:50,editable:true,editrules:{required:true}},
             {name:'home_phone',index:'home_phone', width:50,editable:true},
             {name:'line_number',index:'line_number', width:30,editable:true,editrules:{required:true}},
             {name:'bus_number',index:'bus_number', width:60,editable:true},
             {name:'driving_type',index:'driving_type', width:50,editable:true,title:false},
             {name:'pass_time',index:'pass_time', width:50,editable:true,title:false,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
             {name:'company',index:'company', width:50,editable:true,title:false,editrules:{required:true}}
               ],
    // sortname:'id',
    // sortorder:'asc',
     viewrecords:true,
     rowNum:20,
     width:1200,
     //autowidth:false,
     //autoheight:true,
     height: 50,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driver/driveredit",
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
     // ondblClickRow: function(id){ alert("You double click row with id: "+id);},	
     caption: "驾驶员详细信息"
      
   });
  // jQuery("#gridTable").jqGrid('navGrid','#gridPager',{edit:true,add:true,del:false,search:true});

});

			// 交通事故  traffic_accident
		$(function()
 {
		 $("#traffic_accident").jqGrid({
     url:"<%=basePath%>driverinfo/trafficaccident?id=<%=request.getParameter("id").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','驾驶员','分公司','线路','事故车号','事故时间','事故地点','事故经过','责任','处理情况','汇报人'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sorttype:"String",editable:false},
             {name:'company',index:'company', width:20,editable:true},
             {name:'line_number',index:'line_number', width:50,sorttype:"String",editable:true,editrules:{required:true}},
             {name:'bus_number',index:'bus_number', width:20,editable:true},
             {name:'accident_date',index:'accident_date', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
             {name:'accident_location',index:'accident_location', width:20,editable:true},
             {name:'accident_summary',index:'accident_summary', width:20,editable:true},
             {name:'accident_liability',index:'accident_liability', width:20,editable:true},
             {name:'result',index:'result', width:20,editable:true},
             {name:'reporter',index:'reporter', width:20,editable:true}
			 ],
     sortname:'id',
     sortorder:'asc',
     viewrecords:true,
     rowNum:20,
     width:1200,
     //autowidth:true,
     autoheight:true,
     //height: 100,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driverinfo/edittrafficaccident?idcard=<%=request.getParameter("id").toString()%>",
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
     pager:"#traffic_accidentPager",
     // ondblClickRow: function(id){ showuserinfo(id);},	
     caption: "交通事故"
      
   });
   jQuery("#traffic_accident").jqGrid('navGrid','#traffic_accidentPager',{edit:true,add:true,del:true,search:false,closeAfterAdd: true,
closeAfterEdit:true});

});
	//驾驶员交通违章信息列表
		$(function()
 {
		 $("#traffic_violation").jqGrid({
     url:"<%=basePath%>driverinfo/trafficviolation?id=<%=request.getParameter("id").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','驾驶员','车牌号','所属公司','违章时间','违章地点','违章原因','扣分','罚款','绩效考核时间'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sorttype:"String",editable:false},
             {name:'company',index:'company', width:20,editable:true},
             {name:'bus_number',index:'bus_number', width:20,editable:true},
             {name:'violation_date',index:'violation_date', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
             {name:'violation_location',index:'violation_location', width:20,editable:true},
             {name:'violation_reason',index:'violation_reason', width:20,editable:true},
             {name:'points',index:'points', width:20,editable:true},
             {name:'fine',index:'fine', width:20,editable:true},
             {name:'assessment_date',index:'assessment_date', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}}
			 ],
     sortname:'id',
     sortorder:'asc',
     viewrecords:true,
     rowNum:20,
     width:1200,
     //autowidth:true,
     autoheight:true,
     //height: 100,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driverinfo/edittrafficviolation?idcard=<%=request.getParameter("id").toString()%>",
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
     pager:"#traffic_violationPager",
     // ondblClickRow: function(id){ showuserinfo(id);},	
     caption: "交通违章"
      
   });
   jQuery("#traffic_violation").jqGrid('navGrid','#traffic_violationPager',{edit:true,add:true,del:true,search:false,closeAfterAdd: true,
closeAfterEdit:true});

});

//驾驶员良好行为列表
		$(function()
 {
		 $("#behavior").jqGrid({
     url:"<%=basePath%>driverinfo/behavior?id=<%=request.getParameter("id").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','驾驶员','地点','时间','经过','结果'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sorttype:"String",editable:false},
            // {name:'incident_date',index:'incident_date', width:20,editable:true},
            {name:'incident_location',index:'incident_location', width:20,editable:true},
             {name:'incident_date',index:'incident_date', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
             
             
             {name:'description',index:'description', width:20,editable:true},
             {name:'result',index:'result', width:20,editable:true}
			 ],
     sortname:'id',
     sortorder:'asc',
     viewrecords:true,
     rowNum:20,
     width:1200,
     //autowidth:true,
     autoheight:true,
     //height: 100,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driverinfo/editbehavior?idcard=<%=request.getParameter("id").toString()%>",
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
     pager:"#behaviorPager",
     // ondblClickRow: function(id){ showuserinfo(id);},	
     caption: "良好行为"
      
   });
   jQuery("#behavior").jqGrid('navGrid','#behaviorPager',{edit:true,add:true,del:true,search:false,closeAfterAdd: true,
closeAfterEdit:true});

});
//驾驶员不良行为列表
		$(function()
 {
		 $("#badbehavior").jqGrid({
     url:"<%=basePath%>driverinfo/badbehavior?id=<%=request.getParameter("id").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','驾驶员','地点','时间','经过','结果'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sorttype:"String",editable:false},
            // {name:'incident_date',index:'incident_date', width:20,editable:true},
            {name:'incident_location',index:'incident_location', width:20,editable:true},
             {name:'incident_date',index:'incident_date', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
             
             
             {name:'description',index:'description', width:20,editable:true},
             {name:'result',index:'result', width:20,editable:true}
			 ],
     sortname:'id',
     sortorder:'asc',
     viewrecords:true,
     rowNum:20,
     width:1200,
     //autowidth:true,
     autoheight:true,
     //height: 100,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driverinfo/editbadbehavior?idcard=<%=request.getParameter("id").toString()%>",
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
     pager:"#badbehaviorPager",
     // ondblClickRow: function(id){ showuserinfo(id);},	
     caption: "不良行为"
      
   });
   jQuery("#badbehavior").jqGrid('navGrid','#badbehaviorPager',{edit:true,add:true,del:true,search:false,closeAfterAdd: true,
closeAfterEdit:true});

});

//驾驶员违章列表
		$(function()
 {
		 $("#discipline").jqGrid({
     url:"<%=basePath%>driverinfo/discipline?id=<%=request.getParameter("id").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','驾驶员','职位','违章违纪时间','事由','处罚依据','罚款单号'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sorttype:"String",editable:false},
             {name:'position',index:'position', width:20,editable:true},
           
             {name:'discipline_date',index:'discipline_date', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
              {name:'description',index:'description', width:20,editable:true},
             
             {name:'gist',index:'gist', width:20,editable:true},
             {name:'fine',index:'fine', width:20,editable:true}
            
			 ],
     sortname:'id',
     sortorder:'asc',
     viewrecords:true,
     rowNum:20,
     width:1200,
     //autowidth:true,
     autoheight:true,
     //height: 100,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driverinfo/editdiscipline?idcard=<%=request.getParameter("id").toString()%>",
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
     pager:"#disciplinePager",
     // ondblClickRow: function(id){ showuserinfo(id);},	
     caption: "驾驶员违章违纪"
      
   });
   jQuery("#discipline").jqGrid('navGrid','#disciplinePager',{edit:true,add:true,del:true,search:false,closeAfterAdd: true,
closeAfterEdit:true});

});
//驾驶员安全里程
		$(function()
 {
		 $("#safetydistance").jqGrid({
     url:"<%=basePath%>driverinfo/safetydistance?id=<%=request.getParameter("id").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','车号','年份','月份','月度安全里程','年度安全里程','累计安全里程'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
             {name:'bus_number',index:'bus_number', width:20,sorttype:"String",editable:true},
             {name:'year',index:'year', width:20,sorttype:"String",editable:true,edittype:"select",editoptions:{value:"2013:2013;2014:2014;2015:2015;2016:2016"}},
             {name:'month',index:'month', width:20,editable:true,edittype:"select",editoptions:{value:"1:1;2:2;3:3;4:4;5:5;6:6;7:7;8:8;9:9;10:10;11:11;12:12;0:年度"}},
           
             {name:'mileage_month',index:'mileage_month', width:30,editable:true},
             {name:'mileage_year',index:'mileage_year', width:20,editable:true},
             {name:'mileage',index:'mileage', width:20,editable:true}
             
			 ],
     sortname:'id',
     sortorder:'asc',
     viewrecords:true,
     rowNum:20,
     width:1200,
     //autowidth:true,
     autoheight:true,
     //height: 100,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driverinfo/editsafetydistance?idcard=<%=request.getParameter("id").toString()%>",
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
     pager:"#safetydistancePager",
     // ondblClickRow: function(id){ showuserinfo(id);},	
     caption: "驾驶员安全里程"
      
   });
   jQuery("#safetydistance").jqGrid('navGrid','#safetydistancePager',{edit:true,add:true,del:true,search:false,closeAfterAdd: true,
closeAfterEdit:true});

});

// 机械事故  traffic_accident
		$(function()
 {
		 $("#mechaccident").jqGrid({
     url:"<%=basePath%>driverinfo/mechaccident?id=<%=request.getParameter("id").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','驾驶员','分公司','线路','事故车号','事故时间','事故地点','事故经过','责任','处理情况','汇报人'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sorttype:"String",editable:false},
             {name:'company',index:'company', width:20,editable:true},
             {name:'line_number',index:'line_number', width:50,sorttype:"String",editable:true,editrules:{required:true}},
             {name:'bus_number',index:'bus_number', width:20,editable:true},
             {name:'accident_date',index:'accident_date', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
             {name:'accident_location',index:'accident_location', width:20,editable:true},
             {name:'accident_summary',index:'accident_summary', width:20,editable:true},
             {name:'accident_liability',index:'accident_liability', width:20,editable:true},
             {name:'result',index:'result', width:20,editable:true},
             {name:'reporter',index:'reporter', width:20,editable:true}
			 ],
     sortname:'id',
     sortorder:'asc',
     viewrecords:true,
     rowNum:20,
     width:1200,
     //autowidth:true,
     //autoheight:true,
     height: 100,
     rowList:[20,30,50],
     editurl:"<%=basePath%>driverinfo/editmechaccident?idcard=<%=request.getParameter("id").toString()%>",
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
     pager:"#mechaccidentPager",
     // ondblClickRow: function(id){ showuserinfo(id);},	
     caption: "机械事故"
      
   });
   jQuery("#mechaccident").jqGrid('navGrid','#mechaccidentPager',{edit:true,add:true,del:true,search:false,closeAfterAdd: true,
closeAfterEdit:true});

});
	</script>
	
  </head>
  
  <body>
  
  	 <div>
  	<label>欢迎</label>
  	<label><%=session.getAttribute("name").toString()%></label>
  	<a href="<%=basePath%>">用户管理</a>
  	<a href="<%=basePath%>user/logout"><label>注销</label></a>
 	</div>
  
  
    <table id="driverinfo"></table>
	<div id="driverinfoPager"></div>
	<!-- 交通事故 -->
    <table id="traffic_accident"></table>
	<div id="traffic_accidentPager"></div>
	<!-- 交通违章 -->
    <table id="traffic_violation"></table>
	<div id="traffic_violationPager"></div>
	<!-- 机械事故 -->
	<table id="mechaccident"></table>
	<div id="mechaccidentPager"></div>
	<!-- 良好行为 -->
    <table id="behavior"></table>
	<div id="behaviorPager"></div>
	<!-- 不良行为 -->
    <table id="badbehavior"></table>
	<div id="badbehaviorPager"></div>

	<!-- 违规行为 -->
    <table id="discipline"></table>
	<div id="disciplinePager"></div>
	
	<!-- 安全里程 -->
    <table id="safetydistance"></table>
	<div id="safetydistancePager"></div>
	
	<!-- 公司 -->
    <table id="company"></table>
	<div id="companyPager"></div>
	


  </body>
</html>
