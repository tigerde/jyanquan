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
		<script type="text/javascript" src="jifolder/jquery.jqGrid-4.5.4/js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="jifolder/jquery.jqGrid-4.5.4/js/i18n/grid.locale-cn.js"></script>
		<script type="text/javascript" src="jifolder/jquery.jqGrid-4.5.4/js/jquery.jqGrid.min.js"></script>
		<script type="text/javascript" src="jifolder/jquery-ui/js/jquery-ui1.js"></script>
		<script type="text/javascript" src="jifolder/jquery-ui/js/jquery-ui-timepicker-addon.js"></script>

		<script type="text/javascript" src="jifolder/jquery-ui/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript">
	<%if("1".equals(map.get("muser_show"))){ %>
  	 
  
	 
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
		     <%if("1".equals(map.get("muser_pw"))){ %>
		      ondblClickRow: function(id){ 
		      var rowdata=jQuery("#gridTable").jqGrid('getRowData',id);
			  var emergencySencondMgrId = rowdata["name"];//列名和jGrid定义时候的值一样
			  showrole(id,emergencySencondMgrId);},	
			  <%}%>
		     caption: "用户信息"
		      
		   });
		 //  jQuery("#gridTable").jqGrid('filterToolbar',{searchOperators : false});
		   jQuery("#gridTable").jqGrid('navGrid','#gridPager',{add:<%="1".equals(map.get("muser_add"))%>,edit:<%="1".equals(map.get("muser_edit"))%>,del:<%="1".equals(map.get("muser_del"))%>,search:false,closeAfterAdd: true,
closeAfterEdit:true});
		
		});
		
			<%} %>
		
	/*********************/
	//保存权限ajax
	function ajaxsaverole(roledata){
		$.ajax({
			type:'post',//可选get
			url:'<%=basePath%>role/edituserrole',//这里是接收数据的PHP程序
			data:roledata,//传给PHP的数据，多个参数用&连接
			dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
			success:function(msg){
			if(msg["result"]){
				alert("权限保存成功");
				document.getElementById("checkdiv").style.display="none";
			}else{
				alert("权限保存失败");
			}
			//alert(msg["result"]);
			//这里是ajax提交成功后，PHP程序返回的数据处理函数。msg是返回的数据，数据类型在dataType参数里定义！
			},
			error:function(){
				alert("网络断开或者服务错误");
			//ajax提交失败的处理函数！
			}
			});
		}
	//获取用户权限ajax
	function ajaxgetrole(id){
	
		$.ajax({
			type:'post',//可选get
			url:'<%=basePath%>role/userrole',//这里是接收数据的PHP程序
			data:'id='+id,//传给PHP的数据，多个参数用&连接
			dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
			success:function(msg){
				if(msg["success"]){
					var role=msg["role"];
					for(i=0;i<role.length;i++){
					role[i]["role_name"]
					document.getElementById(role[i]["role_name"]).checked=(role[i]["role_value"]=="1");
					}
					
				}else{
					alert("载入失败！");
				}
				
				
				
			},
			error:function(){
			document.getElementById("checkdiv").style.display="none";
				alert("网络断开或者服务错误");
			//ajax提交失败的处理函数！
			}
			});
		}
	//保存权限
	function saverole(){
			var files = $("#checkdiv").find("input[type='checkbox']");
			var a="[";
			var id=$("#user_id").val();
			if(id==""){
				alert("无效权限，请重新加载！");
				document.getElementById("checkdiv").style.display="";
				return ;
			}
			for(i=0;i<files.length;i++){
				var b="{\"user_id\":\""+id+"\",\"role_name\":\""+files[i].name+"\",\"role_value\":"+document.getElementById(files[i].name).checked+"}";
				if(i>0){
					a=a+","+b;
				}else{
					a=a+b;
				}
			}
			a=a+"]";
			a="id="+id+"&rolestr="+a;
			ajaxsaverole(a);
	}
		
		
	function showrole(id,name){
		if(id=="1"){
			alert("管理员不允许权限更改");
			return ;
		}
		
		$("#user_id").val(id);
		$("#user_name_title").html("用户 "+name+" 权限配置");
		var files = $("#checkdiv").find("input[type='checkbox']");
		for(i=0;i<files.length;i++){
				document.getElementById(files[i].name).checked=false;
			}
		ajaxgetrole(id);
		//显示
		document.getElementById("checkdiv").style.display="";
		/**
		if(document.getElementById("checkdiv").style.display=="none"){
			document.getElementById("checkdiv").style.display="";
		}else{
			document.getElementById("checkdiv").style.display="none";
		}**/
		
	}
	function closerole(){
		
		document.getElementById("checkdiv").style.display="none";
	}
	
	
		
	</script>
	
  </head>
  
  <body>
  <div>
  	<label>欢迎</label>
  	<label><%=session.getAttribute("name").toString()%></label>
  		<%if("1".equals(map.get("muser_show"))){ %>
  	<a href="<%=basePath%>muser/showuser">用户管理</a>
  	<%} %>
  	<a href="<%=basePath%>user/logout"><label>注销</label></a>
  </div>
    <table id="gridTable"></table>
	<div id="gridPager"></div>
	<div id="checkdiv" style="display: none;" >
		<label id="user_name_title">用户权限配置</label>
		<!-- <button>全选</button>  -->	
		<button onclick="saverole();">保存</button>
		<input id="user_id" name="user_id" type="hidden"/>
		<div>查询页面</div>
		<div>
			<input id="driver_show" type="checkbox" name="driver_show" checked="checked"/>查看
			<input id="driver_add" type="checkbox" name="driver_add" />创建
			<input id="driver_edit" type="checkbox" name="driver_edit" />编辑
			<input id="driver_del" type="checkbox" name="driver_del" />删除
		</div>
		<div>分组查询</div>
		<div>
			<input id="select_show" type="checkbox" name="select_show" checked="checked"/>查看
			<input id="select_add" type="checkbox" name="select_add" />创建
			<input id="select_edit" type="checkbox" name="select_edit" />编辑
			<input id="select_del" type="checkbox" name="select_del" />删除
		</div>
		<div>用户管理</div>
		<div>
			<input id="muser_show" type="checkbox" name="muser_show" checked="checked"/>查看
			<input id="muser_add" type="checkbox" name="muser_add" />创建
			<input id="muser_edit" type="checkbox" name="muser_edit" />编辑
			<input id="muser_del" type="checkbox" name="muser_del" />删除
			<input id="muser_pw" type="checkbox" name="muser_pw" />权限编辑
		</div>
		<div>用户详情</div>
		<div >
			<div>
				驾驶员详情
				<input id="driverinfo_edit" type="checkbox" name="driverinfo_edit" />编辑
				<input id="driverinfo_del" type="checkbox" name="driverinfo_del" />删除
			</div>
			<div>
				交通事故
				<input id="accident_show" type="checkbox" name="accident_show" checked="checked"/>查看
				<input id="accident_add" type="checkbox" name="accident_add" />创建
				<input id="accident_edit" type="checkbox" name="accident_edit" />编辑
				<input id="accident_del" type="checkbox" name="accident_del" />删除
			</div>
			<div>
				交通违章
				<input id="violation_show" type="checkbox" name="violation_show" checked="checked"/>查看
				<input id="violation_add" type="checkbox" name="violation_add" />创建
				<input id="violation_edit" type="checkbox" name="violation_edit" />编辑
				<input id="violation_del" type="checkbox" name="violation_del" />删除
			</div>
			<div>
				机械事故
				<input id="mechanical_show" type="checkbox" name="mechanical_show" checked="checked"/>查看
				<input id="mechanical_add" type="checkbox" name="mechanical_add" />创建
				<input id="mechanical_edit" type="checkbox" name="mechanical_edit" />编辑
				<input id="mechanical_del" type="checkbox" name="mechanical_del" />删除
			</div>
			<div>
				良好行为
				<input id="behavior_show" type="checkbox" name="behavior_show" checked="checked"/>查看
				<input id="behavior_add" type="checkbox" name="behavior_add" />创建
				<input id="behavior_edit" type="checkbox" name="behavior_edit" />编辑
				<input id="behavior_del" type="checkbox" name="behavior_del" />删除
			</div>
			<div>
				不良行为
				<input id="badbehavior_show" type="checkbox" name="badbehavior_show" checked="checked"/>查看
				<input id="badbehavior_add" type="checkbox" name="badbehavior_add" />创建
				<input id="badbehavior_edit" type="checkbox" name="badbehavior_edit" />编辑
				<input id="badbehavior_del" type="checkbox" name="badbehavior_del" />删除
			</div>
			<div>
				驾驶员违纪
				<input id="discipline_show" type="checkbox" name="discipline_show" checked="checked"/>查看
				<input id="discipline_add" type="checkbox" name="discipline_add" />创建
				<input id="discipline_edit" type="checkbox" name="discipline_edit" />编辑
				<input id="discipline_del" type="checkbox" name="discipline_del" />删除
			</div>
			<div>
				驾驶员安全里程
				<input id="distance_show" type="checkbox" name="distance_show" checked="checked"/>查看
				<input id="distance_add" type="checkbox" name="distance_add" />创建
				<input id="distance_edit" type="checkbox" name="distance_edit" />编辑
				<input id="distance_del" type="checkbox" name="distance_del" />删除
			</div>
		
		</div>
	</div> 
	
  </body>
</html>
