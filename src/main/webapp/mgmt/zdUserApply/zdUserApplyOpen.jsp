<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>用户申请_查看页面</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" style="margin-top: 20px;">
		用户申请详情查看
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="pass()"
				id="passButton">通过</button>
			<button class="btn btn-info btn-sm" onclick="unPass()"
				id="unPassButton">不通过</button>
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
				<label for="zdUserName">昵称：</label>
				<input type="text" class="form-control" id="zdUserName" name="zdUserName" readonly />
			</div>
			<div class="form-group" >
				<label for="zdUserCode">用户名：</label>
				<input type="text" class="form-control" id="zdUserCode" name="zdUserCode" readonly />
			</div>
			<div class="form-group" >
				<label for="zdUserPassword">密码：</label>
				<input type="text" class="form-control" id="zdUserPassword" name="zdUserPassword" readonly />
			</div>
			<div class="form-group" >
				<label for="zdUserApplyReason">申请理由：</label>
				<input type="text" class="form-control" id="zdUserApplyReason" name="zdUserApplyReason" readonly />
			</div>
			<div class="form-group" >
				<label for="zdUserApplyIp">申请人IP地址：</label>
				<input type="text" class="form-control" id="zdUserApplyIp" name="zdUserApplyIp" readonly />
			</div>
			<input type="hidden" name="id" id="id">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="uuid" id="uuid">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="status" id="status" >	<!-- 状态隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script type="text/javascript">
	
		
		$(function(){
			// TODO 额外的逻辑。
			if(!ps["id"]){
				return;
			}
			$.ajax({
				url : "/zdUserApplyCtrl/selectByPrimaryKey.ctrl",
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
		});
		
		function pass() {
			if (confirm("确定通过吗？")) {
				$.ajax({
					type:"POST",
					url : "/zdUserApplyCtrl/pass.ctrl",
					dataType : "json",
					cache : false,
					data : {
						"id" : $("#id").val()
					},
					error : function(request, textStatus, errorThrown) {
						jangleShowAjaxError(request, textStatus, errorThrown);
					},
					success : function(data) {
						success(data);
					}
				});
			}
		}
		function unPass() {
			if (confirm("确定不通过吗？")) {
				$.ajax({
					type:"POST",
					url : "/zdUserApplyCtrl/unPass.ctrl",
					dataType : "json",
					cache : false,
					data : {
						"id" : $("#id").val()
					},
					error : function(request, textStatus, errorThrown) {
						jangleShowAjaxError(request, textStatus, errorThrown);
					},
					success : function(data) {
						success(data);
					}
				});
			}
		}
	</script>
</body>
</html>