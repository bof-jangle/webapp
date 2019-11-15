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
<link href="https://cdn.bootcss.com/bootstrap-fileinput/5.0.4/css/fileinput.min.css" rel="stylesheet">
</head>
<body>
	<div id="bodyTopDiv" style="margin-top: 20px;">
		DEMO
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="testUpload()"
				id="testUploadButton">上传测试</button>
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
			<div class="form-group" >
				<label for="JAttFile">文件</label>
				<span id= "attachments"></span>
				<input type="file" name="jAttFile" id="jAttFile"  multiple="multiple" data-show-caption="true">
			</div>
			<input type="hidden" name="id" id="id">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="status" id="status" value = "1">	<!-- 状态隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script src="https://cdn.bootcss.com/bootstrap-fileinput/5.0.4/js/fileinput.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-fileinput/5.0.4/js/locales/zh.min.js"></script>
	<script type="text/javascript" src="js/bsDemoEdit.js"></script>
	<script type="text/javascript">
		var fileInputParam = {}; //附件上传的拓展参数
		var extArray = null; //扩展名
		var fileInputId = "jAttFile";
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
				url : "/bsDemoCtrl/insert.ctrl",
				dataType : "json",
				cache:false,
				data : $("#jangleEditForm").serialize(),
				error : function(request, textStatus, errorThrown) {
					jangleShowAjaxError(request, textStatus, errorThrown);
				},
				success : function(data) {
// 					success(data);		//执行成功后的判断，操作成功则返回列表页。
					//存在附件时的判断start ************
					if (data == null || data.code == null) {
						hideMask();
						alert("异常操作，请联系管理员");
						return;
					}
					if (data != null && data.code == 10001) {
						var file = $("#"+fileInputId).val();
						if (file == null || file == "") {
							hideMask();
							success(data);
							return;
						}
						//存在附件则上传附件
						fileInputParam["attSourceId"] = data.model.id; //业务主键id
						fileInputParam["attSourceType"] = "bs_demo"; //填业务表名称
						uploadOaFileInput(fileInputId); //上传附件
					} else {
						hideMask();
						alert(data.rm.msg);
						return;
					}
					//存在附件时的判断end ************
				}
			});
		}
		// 删除记录
		function deleteForm() {
			if (confirm("确定删除此记录吗？")) {
				$.ajax({
					type:"POST",
					url : "/bsDemoCtrl/deleteByPrimaryKey.ctrl",
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
		// 附件上传测试
		function testUpload(){
			fileInputParam["attSourceId"] = 1; //业务主键id
			fileInputParam["attSourceType"] = "bs_demo"; //填业务表名称
			console.log(fileInputParam);
			uploadOaFileInput("jAttFile"); //上传附件
		}

		// dom加载完成之后
		$(function() {
			// 初始化附件上传组件
			initOaFileinput(fileInputId, "", fileInputParam, extArray);
			
			//TODO 这里添加其余逻辑
			
			if (!ps["id"]){
				return;
			}
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