<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理_查看页面</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" style="margin-top: 20px;">
		用户管理详情查看
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div style="margin-top: 20px;">
		<form id="jangleEditForm" name="jangleEditForm"	class="formJ">
			<div class="form-group" >
				<label for="usrId">usr_id：</label>
				<input type="text" class="form-control" id="usrId" name="usrId" readonly />
			</div>
			<div class="form-group" >
				<label for="usrName">名称：</label>
				<input type="text" class="form-control" id="usrName" name="usrName" readonly />
			</div>
			<div class="form-group" >
				<label for="usrCode">用户名：</label>
				<input type="text" class="form-control" id="usrCode" name="usrCode" readonly />
			</div>
			<div class="form-group" >
				<label for="usrPassword">密码：</label>
				<input type="text" class="form-control" id="usrPassword" name="usrPassword" readonly />
			</div>
			<div class="form-group" >
				<label for="usrStatus">状态：</label>
				<input type="text" class="form-control" id="usrStatus" name="usrStatus" readonly />
			</div>
			<div class="form-group" >
				<label for="extends1">拓展字段1：</label>
				<input type="text" class="form-control" id="extends1" name="extends1" readonly />
			</div>
			<div class="form-group" >
				<label for="extends2">拓展字段2：</label>
				<input type="text" class="form-control" id="extends2" name="extends2" readonly />
			</div>
			<div class="form-group" >
				<label for="createTime">创建时间：</label>
				<input type="text" class="form-control" id="createTime" name="createTime" readonly />
			</div>
			<div class="form-group" >
				<label for="updateTime">更新时间：</label>
				<input type="text" class="form-control" id="updateTime" name="updateTime" readonly />
			</div>
			<input type="hidden" name="id" id="id">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="uuid" id="uuid">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="status" id="status" >	<!-- 状态隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script>
		if (ps["id"])
			$.ajax({
				url : "/bsUserCtrl/selectByPrimaryKey.ctrl",
				dataType : "json",
				cache : false,
				data : {
					"id" : ps["id"]
				},
				error : function(request, textStatus, errorThrown) {
					jangleShowAjaxError(request, textStatus, errorThrown);
				},
				success : function(data) {
					if (data != null && data.code == "10001"
							&& data.model != null) {
						for ( var item in data.model) {
							$("#" + item).val(data.model[item]);
						}
					}
				}
			});
	</script>
</body>
</html>