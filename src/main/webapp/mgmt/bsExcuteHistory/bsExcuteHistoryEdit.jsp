<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>执行记录表_编辑页面_Jangle生成工具v1.1</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,fileinput,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" class="jangle-editjsp-bodytopdiv" >
		<span class="label label-info">执行记录表-内容编辑</span>
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
				<label for="dmDesc">描述：</label>
				<input type="text" class="form-control" id="dmDesc" name="dmDesc" placeholder="请输入描述" />
			</div>
			<div class="form-group" >
				<label for="dmDesc2">描述2：</label>
				<input type="text" class="form-control" id="dmDesc2" name="dmDesc2" placeholder="请输入描述2" />
			</div>
			<div class="form-group" >
				<label for="excuteMethod">执行方法：</label>
				<input type="text" class="form-control" id="excuteMethod" name="excuteMethod" placeholder="请输入执行方法" />
			</div>
			<div class="form-group" >
				<label for="excuterCode">执行人账户：</label>
				<input type="text" class="form-control" id="excuterCode" name="excuterCode" placeholder="请输入执行人账户" />
			</div>
			<div>
				<div class="panel panel-primary">
					<div class="panel-body" style="padding-top: 0px;padding-top: 0px;padding-right: 0px;">
						<div>
							<input id="input-id" name="file" multiple type="file" data-show-caption="true">
						</div>
					</div>
				</div>
			</div>
			<input type="hidden" name="id" id="id">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="uuid" id="uuid">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="status" id="status" value = "1">	<!-- 状态隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,fileinput,utilJ" name="jses"/>
	</jsp:include>
	<script type="text/javascript" src="js/bsExcuteHistoryEdit.js"></script>
	<script type="text/javascript">
		var fileInputParam = {};	//附件所需的参数
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
				url : "/bsExcuteHistoryCtrl/insert.ctrl",
				dataType : "json",
				cache:false,
				data : $("#jangleEditForm").serialize(),
				error : function(request, textStatus, errorThrown) {
					jangleShowAjaxError(request, textStatus, errorThrown);
				},
				success : function(data) {
					//success(data);
					// *** 存在附件的判断。
					if (data == null) {
						alert("异常操作，请联系管理员");
						return;
					}
					if (data.code == "10001") {
						// 操作成功
						var file = $("#input-id").val();
						if (file == null || file == "") {
							alert(data.message);
							back();
							return;
						}
						//存在附件则上传附件
						fileInputParam["attSourceId"] = data.model.id; //业务主键id
						fileInputParam["attSourceType"] = "bs_excute_history"; //填业务表名称
						fileUploadJ("input-id");
						return;
					} else {
						alert(data.message);
						return;
					}
				}
			});
		}
		// 删除记录
		function deleteForm() {
			if (confirm("确定删除此记录吗？")) {
				$.ajax({
					type:"POST",
					url : "/bsExcuteHistoryCtrl/deleteByPrimaryKey.ctrl",
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
			initFileInput("input-id",null,fileInputParam);		//初始化附件

			// TODO 额外的逻辑。

			if (!ps["id"]){
				return;
			}
			$.ajax({
				url : "/bsExcuteHistoryCtrl/selectByPrimaryKey.ctrl",
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