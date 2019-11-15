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
		<span class="label label-info">用户管理-用户申请</span>
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
				<label for="jgName">昵称：</label>
				<input type="text" class="form-control" id="jgName" name="jgName" placeholder="请输入昵称" />
			</div>
			<div class="form-group" >
				<label for="jgCode">用户名：</label>
				<input type="text" class="form-control" id="jgCode" name="jgCode" placeholder="请输入用户名(用于登录" />
			</div>
			<div class="form-group" >
				<label for="jgPassword">密码：</label>
				<input type="text" class="form-control" id="jgPassword" name="jgPassword" placeholder="请输入密码" />
			</div>
			<div class="form-group" >
				<label for="jgApplyReason">申请说明：</label>
				<input type="text" class="form-control" id="jgApplyReason" name="jgApplyReason" placeholder="请输入申请理由" />
			</div>
			<input type="hidden" name="jgApplyIp" id="jgApplyIp">
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script type="text/javascript" src="js/bsUser2Edit.js"></script>
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
				url : "/bsUser2Ctrl/applyUser.ctrl",
				dataType : "json",
				cache:false,
				data : $("#jangleEditForm").serialize(),
				error : function(request, textStatus, errorThrown) {
					jangleShowAjaxError(request, textStatus, errorThrown);
				},
				success : function(data) {
					if (data == null) {
						alert("异常操作，请联系管理员");
						return;
					}
					if (data.code == "10001") {
						alert(data.message);
						parent.window.location.reload();
					} else {
						alert(data.message);
						return;
					}
				}
			});
		}

		// dom加载完成之后
		$(function() {
			$("#jgApplyIp").val(returnCitySN["cip"]+"&"+returnCitySN["cname"]);
		})
	</script>
</body>
</html>