<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理_编辑页面_Jangle生成工具v1.1</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" class="jangle-editjsp-bodytopdiv" >
		用户管理-内容编辑
		<div class="rightbuttonsdiv" >
			<button class="btn btn-info btn-sm" onclick="submitForm()"
				id="submitButton">保存</button>
			<button class="btn btn-info btn-sm" onclick="noPass()"
				style="display: none;" id="noPassButton">不同意</button>
			<button class="btn btn-info btn-sm" onclick="pass()"
				style="display: none;" id="passButton">同意</button>
			<button class="btn btn-info btn-sm" onclick="deleteForm()"
				style="display: none;" id="deleteButton">删除</button>
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div class="jangle-editjsp-formdiv" >
		<form id="jangleEditForm" name="jangleEditForm" class="formJ" >
			<div class="form-group" >
				<label for="usrName">名称：</label>
				<input type="text" class="form-control" id="usrName" name="usrName" placeholder="请输入名称" />
			</div>
			<div class="form-group" >
				<label for="usrCode">用户名：</label>
				<input type="text" class="form-control" id="usrCode" name="usrCode" placeholder="请输入用户名" />
			</div>
			<div class="form-group" >
				<label for="usrPassword">密码：</label>
				<input type="text" class="form-control" id="usrPassword" name="usrPassword" placeholder="请输入密码" />
			</div>
			<div class="form-group" >
				<label for="usrStatus">状态：</label>
				<select id="usrStatus" name="usrStatus" class="form-control">
					<option value="0">禁用</option>
					<option value="1">启用</option>
				</select>
			</div>
			<div class="form-group" >
				<label for="extends1">拓展字段1：</label>
				<input type="text" class="form-control" id="extends1" name="extends1" placeholder="请输入拓展字段1" />
			</div>
			<div class="form-group" >
				<label for="extends2">拓展字段2：</label>
				<input type="text" class="form-control" id="extends2" name="extends2" placeholder="请输入拓展字段2" />
			</div>
			<input type="hidden" name="usrId" id="usrId">	<!-- 主键ID隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script type="text/javascript" src="js/bsUserEdit.js"></script>
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
				type:"POST",
				url : "/bsUserCtrl/insert.ctrl",
				dataType : "json",
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
					type:"POST",
					url : "/bsUserCtrl/deleteByPrimaryKey.ctrl",
					dataType : "json",
					cache : false,
					data : {
						"id" : $("#usrId").val()
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
		function pass() {
			if (confirm("确定通过吗？")) {
				$.ajax({
					type:"POST",
					url : "/bsUserCtrl/passApply.ctrl",
					dataType : "json",
					cache : false,
					data : {
						"id" : $("#usrId").val()
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
		function noPass() {
			if (confirm("确定不通过吗？")) {
				$.ajax({
					type:"POST",
					url : "/bsUserCtrl/noPassApply.ctrl",
					dataType : "json",
					cache : false,
					data : {
						"id" : $("#usrId").val()
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
							$("#deleteButton").show(); // 显示删除按钮
							$("#passButton").show(); 
							$("#noPassButton").show();
						}
					}
				});
		})
	</script>
</body>
</html>