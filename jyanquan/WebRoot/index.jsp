<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map<String,String> map=(Map<String,String>)session.getAttribute("rolemap");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>"/>
    
     <title>温馨巴士 安全信息查询</title>
    <link rel="shortcut icon" href="jifolder/images/jywx.ico"/>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<style type="text/css">
	<!--
	body {
		background-image: url(jifolder/images/background.jpg);
		background-repeat: repeat;	
	
	}
	-->
	</style>
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
		     width:1200,
		     //autoheight:true,
		     height: 460,
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
		   jQuery("#gridTable").jqGrid('navGrid','#gridPager',{edit:<%="1".equals(map.get("driver_edit"))%>,add:<%="1".equals(map.get("driver_add"))%>,del:<%="1".equals(map.get("driver_del"))%>,search:false});
		
		});
		 
		
	$(function(){
		//获取当前日期
		var mydate=new Date();
		//mydate.getFullYear();    //获取完整的年份(4位,1970-????)
		//mydate.getMonth();       //获取当前月份(0-11,0代表1月)
		//mydate.getDate();			//获取当前月份(0-11,0代表1月)
		var starttime=mydate.getFullYear()+"-"+(mydate.getMonth()+1)+"-"+mydate.getDate();
		var status="<%=basePath%>select.jsp?"+"type=traffic_accident&starttime="+starttime+"&endtime="+starttime;
		$("#starttime").val(starttime);
		$("#endtime").val(starttime);
		$("#selectframe").attr("src",status);
		//selecttype(status);//载入默认值
	});	
		
		
	//打开函数
	function showuserinfo(id){
			window.open("driver/showinfo?id="+id);
		}

		
	//开启日期控件
	$(document).ready(function() {
	 //$("#starttime").disabled="disabled";
	
	 
    	$("#starttime").datepicker();
    	$("#endtime").datepicker();
    	
    	
    	$("#selectall").click(function(){
    		//alert("test");
			var selecttype=$("#selecttype").val();
			var starttime=$("#starttime").val();
			var endtime=$("#endtime").val();
			var status="<%=basePath%>select.jsp?"+"type="+selecttype+"&starttime="+starttime+"&endtime="+endtime;
			//$("#selectdiv").html("<table id=\"selectTable\"></table><div id=\"selectPager\"></div>");
  			$("#selectframe").attr("src",status);
		});
    	
  });
  
  
  function iFrameHeight() {   
	var ifm= document.getElementById("selectframe");   
	var subWeb = document.frames ? document.frames["selectframe"].document : ifm.contentDocument;   
	if(ifm != null && subWeb != null) {
  	 ifm.height = subWeb.body.scrollHeight;
	}   
	}   
  
  
	</script>
	
  </head>
  
  <body>
  <div align="center">
  <div >
  	<label>欢迎</label>
  	<label><%=session.getAttribute("name").toString()%></label>
  	<%if("1".equals(map.get("muser_show"))){ %>
  	<a href="<%=basePath%>muser/showuser">用户管理</a>
  	<%} %>
  	<a href="<%=basePath%>user/logout">注销</a>
  </div>
  	<div align="center">
    <table id="gridTable"></table>
	<div id="gridPager"></div>
	</div>
	<%if("1".equals(map.get("select_show"))){ %>
	<div>
		<label>查询类型</label>
		<!-- 查询类型 -->
		<select id="selecttype" name="查询类型">
			<option value="traffic_accident" selected="selected">交通事故</option>
			<option value="traffic_violation" >交通违章</option>
			<option value="mechaccident" >机械事故</option>
			<option value="behavior" >良好行为</option>
			<option value="badbehavior" >不良行为</option>
			<option value="discipline" >违规行为</option>
		</select>
		<label>开始时间</label>
		<input type="text" id="starttime" value="2013-12-14"/>
		<label>结束时间</label>
		<input type="text" id="endtime" value="2013-12-14"/>
		<button id="selectall"  >查询</button>
	</div>
	<div align="center">
	<iframe id="selectframe" src="" frameBorder=0 scrolling=no width="100%" height="500" align="center">
	
	</iframe>
	</div>
	<%} %>
	</div>
  </body>
</html>
