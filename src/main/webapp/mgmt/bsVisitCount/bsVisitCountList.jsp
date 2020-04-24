<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>访客统计_列表页面</title>
    <jsp:include page="/css/includeCSS.jsp">
    	<jsp:param value="table-out" name="csses"/>
    </jsp:include>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
<!-- 	    <div class="navbar-header"> -->
<!-- 	        <a class="navbar-brand" href="#">查询</a> -->
<!-- 	    </div> -->
	    <div>
	        <form class="navbar-form" role="search" id="searchForm">
	            <div class="form-group">
	            	<span class="jangle-listjsp-remarks-span label label-info" >外来访客统计 </span>
	            </div>
	            <div style="float:right !important;">
				</div>
	        </form>
	    </div>
		</div>
	</nav>
	<div style="width: 100%; padding-top: 8px;" align="left">
			<table id="tablewrap" data-toggle="table" data-locale="zh-CN"
					data-ajax="ajaxRequest" data-side-pagination="server"
					data-striped="true" data-single-select="false"
					data-click-to-select="false" data-pagination="true"
					data-row-style="rowStyle"
					data-pagination-first-text="首页" data-pagination-pre-text="上一页"
					data-pagination-next-text="下一页" data-pagination-last-text="末页"
					class="fline-show-when-ready">
					<thead style="text-align: center;">
						<tr>
							<th data-checkbox="true" data-width="10"></th>
							<th data-formatter="numberAsc" data-width="50">序列</th>
							<th data-field="dmDesc" data-formatter="ipFormatterJ">IP</th>
							<th data-field="dmDesc2" >城市</th>
							<th data-field="visitCount" >访问次数</th>
						</tr>
					</thead>
				</table>
	</div>
    <jsp:include page="/js/includeJS.jsp">
    	<jsp:param value="table-out,listJ" name="jses"/>
    </jsp:include>
	<script type="text/javascript">
		var pathname = window.location.pathname;
		var listPageName = pathname.substring(pathname.lastIndexOf("/")+1);
		var addressPostfix = "&r="+Math.random()+"&back="+listPageName;
		var url = "/bsVisitCountCtrl/selectPage.ctrl";	//获取数据的url地址，需要实现分页功能。
		// 新增按钮 打开新增数据的页面
		function addFormInfo() {
			window.location.href = "bsVisitCountEdit.jsp"
		}
		// 查看详情
		function openDetail(data) {
			window.location.href = "bsVisitCountOpen.jsp?id=" + data.id + addressPostfix;
		}
		// 编辑详情
		function editDetail(data){
			window.location.href = "bsVisitCountEdit.jsp?id=" + data.id + addressPostfix;
		}
		// 行状态色彩格式化
		function rowStyle(row,index){
			// https://v3.bootcss.com/css/#tables-contextual-classes
			return {};
		}
		// IP格式化
		function ipFormatterJ(value){
			if(!value){
				return value;
			}
			var first = value.indexOf(".");
			var last = value.lastIndexOf(".");
			if(first == last){
				return value;
			}
			var firstNum = value.substring(0,first+1);
			var lastNum = value.substring(last);
			return firstNum + "*.*" + lastNum;
		}
		// 复选框的相关功能（当启用复选框时可用）
		function doCheckBoxes(){
			var rows = $("#tablewrap").bootstrapTable("getAllSelections");
			var ids = "";
			if(rows == null || rows.length == 0) {
				alert("请选择");
				return;
			}
			for(var i=0;i<rows.length;i++){
				if(ids == ""){
					ids = ""+rows[i].id;
				}else{
					ids += ","+rows[i].id;
				}
			}
			if (confirm("确定删除勾选的"+rows.length+"条记录吗？")) {
				$.ajax({
					type:"POST",
					url : "/bsVisitCountCtrl/batchDeleteByPrimaryKey.ctrl",
					dataType : "json",
					cache : false,
					data : {
						"ids" : ids
					},
					error : function(request, textStatus, errorThrown) {
						jangleShowAjaxError(request, textStatus, errorThrown);
					},
					success : function(data) {
						successReload(data);
					}
				});
			}
		}
	</script>
</body>
</html>