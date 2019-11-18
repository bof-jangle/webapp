<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>用户表V2_查看页面</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" style="margin-top: 20px;">
		用户表V2详情查看
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div style="margin-top: 20px;">
		<form id="jangleEditForm" name="jangleEditForm"	class="formJ">
			<div class="form-group" >
				<label for="dmDesc">描述：</label>
				<input type="text" class="form-control" id="dmDesc" name="dmDesc" readonly />
			</div>
			<div class="form-group" >
				<label for="dmDesc2">描述2：</label>
				<input type="text" class="form-control" id="dmDesc2" name="dmDesc2" readonly />
			</div>
			<div class="form-group" >
				<label for="jgName">用户中文名称：</label>
				<input type="text" class="form-control" id="jgName" name="jgName" readonly />
			</div>
			<div class="form-group" >
				<label for="jgCode">英文账号：</label>
				<input type="text" class="form-control" id="jgCode" name="jgCode" readonly />
			</div>
			<div class="form-group" >
				<label for="jgPassword">密码：</label>
				<input type="text" class="form-control" id="jgPassword" name="jgPassword" readonly />
			</div>
			<div class="form-group" >
				<label for="jgApplyIp">申请人IP：</label>
				<input type="text" class="form-control" id="jgApplyIp" name="jgApplyIp" readonly />
			</div>
			<div class="form-group" >
				<label for="jgApplyReason">申请理由：</label>
				<input type="text" class="form-control" id="jgApplyReason" name="jgApplyReason" readonly />
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
		$(function(){
			// TODO 额外的逻辑。
			if (!ps["id"]){
				return;
			}
			$.ajax({
				url : "/bsUser2Ctrl/selectByPrimaryKey.ctrl",
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
		})
	</script>
</body>
</html>