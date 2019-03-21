<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEMO_编辑页面</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" style="margin-top: 20px;">
		DEMO
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="submitForm()"
				id="submitButton">保存</button>
			<button class="btn btn-info btn-sm" onclick="deleteForm()"
				style="display: none;" id="deleteButton">删除</button>
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div style="margin-top: 20px;">
		<form id="jangleEditForm" name="jangleEditForm" class="formJ" >
			<div class="form-group" >
				<label for="dmDesc">描述：</label>
				<input type="text" class="form-control" id="dmDesc" name="dmDesc" placeholder="请输入描述">
			</div>
			<div class="form-group" >
				<label for="dmDesc2">描述2：</label>
				<input type="text" class="form-control" id="dmDesc2" name="dmDesc2" placeholder="请输入描述2">
			</div>
			<div class="form-group" >
				<label for="dmDesc3">描述3：</label>
				<input type="text" class="form-control" id="dmDesc3" name="dmDesc3" placeholder="请输入描述3">
			</div>
			<div class="form-group" >
				<label for="dmDesc4">描述4：</label>
				<input type="text" class="form-control" id="dmDesc4" name="dmDesc4" placeholder="请输入描述4">
			</div>
			<div class="form-group" >
				<label for="dmDesc5">描述5：</label>
				<input type="text" class="form-control" id="dmDesc5" name="dmDesc5" placeholder="请输入描述5">
			</div>
			<div class="form-group" >
				<label for="dmDesc6">描述6：</label>
				<input type="text" class="form-control" id="dmDesc6" name="dmDesc6" placeholder="请输入描述6">
			</div>
			<div class="form-group" >
				<label for="dmDesc7">描述7：</label>
				<input type="text" class="form-control" id="dmDesc7" name="dmDesc7" placeholder="请输入描述7">
			</div>
			<div class="form-group" >
				<label for="dmDesc8">描述8：</label>
				<input type="text" class="form-control" id="dmDesc8" name="dmDesc8" placeholder="请输入描述8">
			</div>
			<input type="hidden" name="id" id="id">	<!-- 主键ID隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script type="text/javascript" src="js/bsDemoEdit.js"></script>
	<script type="text/javascript">
		// 提交表单
		function submitForm() {
			$("#jangleEditForm").data("bootstrapValidator").validate(); //提交验证写法1
			// 			$("#jangleEditForm").bootstrapValidator("validate");		//提交验证写法2
			var valid = $("#jangleEditForm").data("bootstrapValidator")
					.isValid(); //验证通过返回true 不通过false
			if (!valid) {
				alert("请完善信息");
				return;
			}
			$.ajax({
				url : "/bsDemoCtrl/insert.ctrl",
				dataType : "json",
				type : "POST",
				cache:false,
				data : $("#jangleEditForm").serialize(),
				error : function(request, textStatus, errorThrown) {
					jangleShowAjaxError(request, textStatus, errorThrown);
				},
				success : function(data) {
					success(data);
				}
			});
		}
		// 删除记录
		function deleteForm() {
			if (confirm("确定删除此记录吗？")) {
				$.ajax({
					url : "/bsDemoCtrl/deleteByPrimaryKey.ctrl",
					dataType : "json",
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

		// dom加载完成之后
		$(function() {
			if (ps["id"])
				$.ajax({
					url : "/bsDemoCtrl/selectByPrimaryKey.ctrl",
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
							$("#deleteButton").show(); // 显示删除按钮
						}
					}
				});
		})
	</script>
</body>
</html>