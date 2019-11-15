<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>用户表V2_编辑页面_Jangle生成工具v1.1</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" class="jangle-editjsp-bodytopdiv" >
		用户表V2-内容编辑
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
				<label for="dmDesc">描述：</label>
				<input type="text" class="form-control" id="dmDesc" name="dmDesc" placeholder="请输入描述" />
			</div>
			<div class="form-group" >
				<label for="dmDesc2">描述2：</label>
				<input type="text" class="form-control" id="dmDesc2" name="dmDesc2" placeholder="请输入描述2" />
			</div>
			<div class="form-group" >
				<label for="jgName">用户中文名称：</label>
				<input type="text" class="form-control" id="jgName" name="jgName" placeholder="请输入用户中文名称" />
			</div>
			<div class="form-group" >
				<label for="jgCode">英文账号：</label>
				<input type="text" class="form-control" id="jgCode" name="jgCode" placeholder="请输入英文账号" />
			</div>
			<div class="form-group" >
				<label for="jgPassword">密码：</label>
				<input type="text" class="form-control" id="jgPassword" name="jgPassword" placeholder="请输入密码" />
			</div>
			<div class="form-group" >
				<label for="status">状态：</label>
				<select id="status" name="status">
					<option value="0">禁用</option>
					<option value="1">启用</option>
				</select>
			</div>
<!-- 			<div class="form-group" > -->
<!-- 				<label for="jgApplyIp">申请人IP：</label> -->
<!-- 				<input type="text" class="form-control" id="jgApplyIp" name="jgApplyIp" placeholder="请输入申请人IP" /> -->
<!-- 			</div> -->
<!-- 			<div class="form-group" > -->
<!-- 				<label for="jgApplyReason">申请理由：</label> -->
<!-- 				<input type="text" class="form-control" id="jgApplyReason" name="jgApplyReason" placeholder="请输入申请理由" /> -->
<!-- 			</div> -->
			<input type="hidden" name="id" id="id">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="uuid" id="uuid">	<!-- 主键ID隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script type="text/javascript" src="js/bsUser2Edit.js"></script>
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
				url : "/bsUser2Ctrl/insert.ctrl",
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
					url : "/bsUser2Ctrl/deleteByPrimaryKey.ctrl",
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
		
		function pass() {
			if (confirm("确定通过吗？")) {
				$.ajax({
					type:"POST",
					url : "/bsUser2Ctrl/passApply.ctrl",
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
		function noPass() {
			if (confirm("确定不通过吗？")) {
				$.ajax({
					type:"POST",
					url : "/bsUser2Ctrl/noPassApply.ctrl",
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

		// dom加载完成之后
		$(function() {
			
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