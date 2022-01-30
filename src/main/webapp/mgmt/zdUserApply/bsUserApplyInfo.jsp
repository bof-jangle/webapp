<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>用户申请_编辑页面_Jangle生成工具v1.1</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" class="jangle-editjsp-bodytopdiv" >
		<span class="label label-info">用户申请</span>
		<div class="rightbuttonsdiv" >
			<button class="btn btn-info btn-sm" onclick="submitForm()"
				id="submitButton">保存</button>
			<button class="btn btn-info btn-sm" onclick="deleteForm()"
				style="display: none;" id="deleteButton">删除</button>
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div class="jangle-editjsp-formdiv" >
		<form id="jangleEditForm" name="jangleEditForm" class="formJ" >
			<div class="form-group" >
				<label for="zdUserName">昵称：</label>
				<input type="text" class="form-control" id="zdUserName" name="zdUserName" placeholder="请输入昵称" />
			</div>
			<div class="form-group" >
				<label for="zdUserCode">用户名（邮箱）：</label>
				<input type="text" class="form-control" id="zdUserCode" name="zdUserCode" placeholder="请使用邮箱用户名，审批通过将给您发送邮件提醒" />
			</div>
			<div class="form-group" >
				<label for="zdUserApplyReason">申请理由：</label>
				<input type="text" class="form-control" id="zdUserApplyReason" name="zdUserApplyReason" placeholder="请输入申请理由" />
			</div>
			<input type="hidden" name="id" id="id">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="uuid" id="uuid">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="status" id="status" value = "1">	<!-- 状态隐藏域 -->
			<input type="hidden" name="zdUserApplyIp" id="zdUserApplyIp"  >	<!-- 申请人IP地址 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator,utilJ" name="jses"/>
	</jsp:include>
	<script type="text/javascript" src="js/zdUserApplyEdit.js"></script>
	<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
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
				url : "/zdUserApplyCtrl/applyUser.ctrl",
				dataType : "json",
				cache:false,
				data : $("#jangleEditForm").serialize(),
				error : function(request, textStatus, errorThrown) {
					jangleShowAjaxError(request, textStatus, errorThrown);
				},
				success : function(data) {
					successReload4Parent(data);
				}
			});
		}
		// 删除记录
		function deleteForm() {
			if (confirm("确定删除此记录吗？")) {
				$.ajax({
					type:"POST",
					url : "/zdUserApplyCtrl/deleteByPrimaryKey.ctrl",
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
			$("#zdUserApplyIp").val(returnCitySN["cip"]+"&"+returnCitySN["cname"]);
			// TODO 额外的逻辑。
		
			if (!ps["id"]){
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
						$("#deleteButton").show(); // 显示删除按钮
					}
				}
			});
		})
		function back(){
			parent.window.location.href = "/";
		}
	</script>
</body>
</html>