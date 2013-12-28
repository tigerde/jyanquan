<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type=request.getParameter("type").toString();
Map<String,String> map=(Map<String,String>)session.getAttribute("rolemap");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>温馨巴士 安全信息查询</title>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	<style type="text/css">
	<!--
	body {
		background-image: url(jifolder/images/background.jpg);
		background-repeat: repeat;	
	
	}
	-->
	</style>
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
	 /**
		// 交通事故  traffic_accident
		$(function()
		{
		 	 
				 $("#selectTable").jqGrid({
		     url:"<%=basePath%>selectall/accidents?type=<%=request.getParameter("type").toString()%>&starttime=<%=request.getParameter("starttime").toString()%>&endtime=<%=request.getParameter("endtime").toString()%>",
		     datatype: "json",
		     mtype:"POST",
		     
		     colNames:['ID','事故类型','驾驶员','分公司','线路','事故车号','事故时间','事故地点','事故经过','责任','处理情况','汇报人'],
		     colModel:[
		    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
		             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
		            {name:'idcard',index:'idcard',hidden: false, width:15, sorttype:"String",editable:false,search: false},
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
		     editurl:"<%=basePath%>",
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
		     pager:"#selectPager",
		      ondblClickRow: function(idcard){ showuserinfo(idcard);},	
		     caption: "事故查询"
		      
		   });
		   jQuery("#selectTable").jqGrid('navGrid','#selectPager',{edit:<%="1".equals(map.get("select_edit"))%>,add:false,del:<%="1".equals(map.get("select_edit"))%>,search:false,closeAfterAdd: true,closeAfterEdit:true});
		});
		
		**/
		<%
		if(type.equals("traffic_accident")){
		%>
		
			// 交通事故  traffic_accident
		$(function()
 {
		 $("#select").jqGrid({
     url:"<%=basePath%>driverinfo/trafficaccident?starttime=<%=request.getParameter("starttime").toString()%>&endtime=<%=request.getParameter("endtime").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','idcard','驾驶员','分公司','线路','事故车号','事故时间','事故地点','事故经过','责任','处理情况','汇报人'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
              {name:'idcard',index:'idcard',hidden: true, width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sortable:false,editable:false},
             {name:'company',index:'company',sortable:false, width:20,editable:false},
             {name:'line_number',index:'line_number', width:50,sorttype:"String",editable:true,editrules:{required:true}},
             {name:'bus_number',index:'bus_number', width:20,editable:true},
             {name:'accident_date',index:'accident_date', width:30,editable:true,editoptions:{size:20, dataInit:function(e1){ $(e1).datepicker({
      		           changeYear: true,
            		   changeMonth: true});}}},
             {name:'accident_location',index:'accident_location', width:20,editable:true},
             {name:'accident_summary',index:'accident_summary', width:20,edittype:'textarea',editoptions:{size:100,maxlength:100},editable:true},
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
     editurl:"<%=basePath%>driverinfo/edittrafficaccident",
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
     pager:"#selectPager",
     ondblClickRow: function(idcard){ 
    	 var rowdata=jQuery("#select").jqGrid('getRowData',idcard);
		 var emergencySencondMgrId = rowdata["idcard"];//列名和jGrid定义时候的值一样
     	showuserinfo(emergencySencondMgrId);},
     caption: "交通事故"
      
   });
   jQuery("#select").jqGrid('navGrid','#selectPager',{edit:<%="1".equals(map.get("select_edit"))%>,add:false,del:<%="1".equals(map.get("select_edit"))%>,search:false,closeAfterAdd: true,closeAfterEdit:true});

});
	<%
	}else if(type.equals("traffic_violation")){
	%>

	//驾驶员交通违章信息列表
		$(function()
 {
		 $("#select").jqGrid({
     url:"<%=basePath%>driverinfo/trafficviolation?starttime=<%=request.getParameter("starttime").toString()%>&endtime=<%=request.getParameter("endtime").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','idcard','驾驶员','所属公司','车牌号','违章时间','违章地点','违章原因','扣分','罚款','绩效考核时间'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
              {name:'idcard',index:'idcard',hidden: true, width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sortable:false,editable:false},
             {name:'company',index:'company', width:20,sortable:false,editable:false},
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
     editurl:"<%=basePath%>driverinfo/edittrafficviolation",
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
     pager:"#selectPager",
      ondblClickRow: function(idcard){ 
    	 var rowdata=jQuery("#select").jqGrid('getRowData',idcard);
		 var emergencySencondMgrId = rowdata["idcard"];//列名和jGrid定义时候的值一样
     	showuserinfo(emergencySencondMgrId);},	
     caption: "交通违章"
      
   });
   jQuery("#select").jqGrid('navGrid','#selectPager',{edit:<%="1".equals(map.get("select_edit"))%>,add:false,del:<%="1".equals(map.get("select_edit"))%>,search:false,closeAfterAdd: true,closeAfterEdit:true});

});

<%
}else if(type.equals("behavior")){
%>

//驾驶员行为列表
		$(function()
 {
		 $("#select").jqGrid({
     url:"<%=basePath%>driverinfo/behavior?starttime=<%=request.getParameter("starttime").toString()%>&endtime=<%=request.getParameter("endtime").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','idcard','驾驶员','地点','时间','经过','结果'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
              {name:'idcard',index:'idcard',hidden: true, width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sortable:false,editable:false},
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
     editurl:"<%=basePath%>driverinfo/editbehavior",
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
     pager:"#selectPager",
      ondblClickRow: function(idcard){ 
    	 var rowdata=jQuery("#select").jqGrid('getRowData',idcard);
		 var emergencySencondMgrId = rowdata["idcard"];//列名和jGrid定义时候的值一样
     	showuserinfo(emergencySencondMgrId);},
     caption: "行为"
      
   });
    jQuery("#select").jqGrid('navGrid','#selectPager',{edit:<%="1".equals(map.get("select_edit"))%>,add:false,del:<%="1".equals(map.get("select_edit"))%>,search:false,closeAfterAdd: true,closeAfterEdit:true});

});

<%
}else if(type.equals("badbehavior")){
%>

//驾驶员不良行为列表
		$(function()
 {
		 $("#select").jqGrid({
     url:"<%=basePath%>driverinfo/badbehavior?starttime=<%=request.getParameter("starttime").toString()%>&endtime=<%=request.getParameter("endtime").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','idcard','驾驶员','地点','时间','经过','结果'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
              {name:'idcard',index:'idcard',hidden: true, width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sortable:false,editable:false},
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
     editurl:"<%=basePath%>driverinfo/editbadbehavior",
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
     pager:"#selectPager",
      ondblClickRow: function(idcard){ 
    	 var rowdata=jQuery("#select").jqGrid('getRowData',idcard);
		 var emergencySencondMgrId = rowdata["idcard"];//列名和jGrid定义时候的值一样
     	showuserinfo(emergencySencondMgrId);},	
     caption: "不良行为"
      
   });
   jQuery("#select").jqGrid('navGrid','#selectPager',{edit:<%="1".equals(map.get("select_edit"))%>,add:false,del:<%="1".equals(map.get("select_edit"))%>,search:false,closeAfterAdd: true,closeAfterEdit:true});

});

<%
}else if(type.equals("discipline")){
%>

//驾驶员违章列表
		$(function()
 {
		 $("#select").jqGrid({
     url:"<%=basePath%>driverinfo/discipline?starttime=<%=request.getParameter("starttime").toString()%>&endtime=<%=request.getParameter("endtime").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','idcard','驾驶员','职位','违章违纪时间','事由','处罚依据','罚款单号'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
              {name:'idcard',index:'idcard',hidden: true, width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sortable:false,editable:false},
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
     editurl:"<%=basePath%>driverinfo/editdiscipline",
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
     pager:"#selectPager",
      ondblClickRow: function(idcard){ 
    	 var rowdata=jQuery("#select").jqGrid('getRowData',idcard);
		 var emergencySencondMgrId = rowdata["idcard"];//列名和jGrid定义时候的值一样
     	showuserinfo(emergencySencondMgrId);},
     caption: "驾驶员违章违纪"
      
   });
    jQuery("#select").jqGrid('navGrid','#selectPager',{edit:<%="1".equals(map.get("select_edit"))%>,add:false,del:<%="1".equals(map.get("select_edit"))%>,search:false,closeAfterAdd: true,closeAfterEdit:true});

});

<%
}else if(type.equals("mechaccident")){
%>
 
// 机械事故  traffic_accident
		$(function()
 {
		 $("#select").jqGrid({
     url:"<%=basePath%>driverinfo/mechaccident?starttime=<%=request.getParameter("starttime").toString()%>&endtime=<%=request.getParameter("endtime").toString()%>",
     datatype: "json",
     mtype:"POST",
     
     colNames:['ID','idcard','驾驶员','分公司','线路','事故车号','事故时间','事故地点','事故经过','责任','处理情况','汇报人'],
     colModel:[
    		// {name: 'modify', width:20, fixed:false, resize:false, formatter:'actions',formatoptions:{keys:true}},
             {name:'id',index:'id', width:15, sorttype:"String",editable:false,search: false},
              {name:'idcard',index:'idcard',hidden: true, width:15, sorttype:"String",editable:false,search: false},
             {name:'name',index:'name', width:20,sortable:false,editable:false},
             {name:'company',index:'company',sortable:false, width:20,editable:false},
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
     editurl:"<%=basePath%>driverinfo/editmechaccident",
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
     pager:"#selectPager",
      ondblClickRow: function(idcard){ 
    	 var rowdata=jQuery("#select").jqGrid('getRowData',idcard);
		 var emergencySencondMgrId = rowdata["idcard"];//列名和jGrid定义时候的值一样
     	showuserinfo(emergencySencondMgrId);},
     caption: "机械事故"
      
   });
   jQuery("#select").jqGrid('navGrid','#selectPager',{edit:<%="1".equals(map.get("select_edit"))%>,add:false,del:<%="1".equals(map.get("select_edit"))%>,search:false,closeAfterAdd: true,closeAfterEdit:true});

});
	<%}%>	
		 
		function  showuserinfo(idcard){
		 	window.open("<%=basePath%>driver/showinfo?id="+idcard);
		 }
	</script>
	
  </head>
  
  <body>
    <div align="center">
		<table id="select"></table>
		<div id="selectPager"></div>
  	</div>
  </body>
</html>
