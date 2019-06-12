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
				<label for="usrName">昵称：</label>
				<input type="text" class="form-control" id="usrName" name="usrName" placeholder="请输入昵称" />
			</div>
			<div class="form-group" >
				<label for="usrCode">用户名：</label>
				<input type="text" class="form-control" id="usrCode" name="usrCode" placeholder="请输入用户名(用于登录" />
			</div>
			<div class="form-group" >
				<label for="usrPassword">密码：</label>
				<input type="text" class="form-control" id="usrPassword" name="usrPassword" placeholder="请输入密码" />
			</div>
			<div class="form-group" >
				<label for="usrCode">申请说明：</label>
				<input type="text" class="form-control" id="extends2" name="extends2" placeholder="请输入申请理由" />
			</div>
			<input type="hidden" name="extends1" id="extends1">
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script type="text/javascript" src="js/bsUserEdit.js"></script>
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
				url : "/bsUserCtrl/applyUser.ctrl",
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
			$("#extends1").val(returnCitySN["cip"]+"&"+returnCitySN["cname"]);
		})
	</script>
</body>
</html>