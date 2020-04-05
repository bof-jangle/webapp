<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>附件上传存放管理_编辑页面_Jangle生成工具v1.1</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,fileinput,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" class="jangle-editjsp-bodytopdiv" >
		<span class="label label-info">附件上传存放管理-内容编辑</span>
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
				<label for="attId">文件表id：</label>
				<input type="text" class="form-control" id="attId" name="attId" placeholder="请输入文件表id" />
			</div>
			<div class="form-group" >
				<label for="attCreateUuid">创建人的uuid：</label>
				<input type="text" class="form-control" id="attCreateUuid" name="attCreateUuid" placeholder="请输入创建人的uuid" />
			</div>
			<div class="form-group" >
				<label for="attName">文件名：</label>
				<input type="text" class="form-control" id="attName" name="attName" placeholder="请输入文件名" />
			</div>
			<div class="form-group" >
				<label for="attExt">文件类型，扩展名：</label>
				<input type="text" class="form-control" id="attExt" name="attExt" placeholder="请输入文件类型，扩展名" />
			</div>
			<div class="form-group" >
				<label for="attPath">相对路径 年/月/ID/文件：</label>
				<input type="text" class="form-control" id="attPath" name="attPath" placeholder="请输入相对路径 年/月/ID/文件" />
			</div>
			<div class="form-group" >
				<label for="attAbspath">绝对路径：</label>
				<input type="text" class="form-control" id="attAbspath" name="attAbspath" placeholder="请输入绝对路径" />
			</div>
			<div class="form-group" >
				<label for="attProtocol">协议：</label>
				<input type="text" class="form-control" id="attProtocol" name="attProtocol" placeholder="请输入协议" />
			</div>
			<div class="form-group" >
				<label for="attContext">内容，备用：</label>
				<input type="text" class="form-control" id="attContext" name="attContext" placeholder="请输入内容，备用" />
			</div>
			<div class="form-group" >
				<label for="attSourceType">附件所属业务表名：</label>
				<input type="text" class="form-control" id="attSourceType" name="attSourceType" placeholder="请输入附件所属业务表名" />
			</div>
			<div class="form-group" >
				<label for="attSourceId">附件所属业务表主键id：</label>
				<input type="text" class="form-control" id="attSourceId" name="attSourceId" placeholder="请输入附件所属业务表主键id" />
			</div>
			<div class="form-group" >
				<label for="attSourceUuid">业务源的UUID：</label>
				<input type="text" class="form-control" id="attSourceUuid" name="attSourceUuid" placeholder="请输入业务源的UUID" />
			</div>
			<div class="form-group" >
				<label for="attFileType">附件类型：</label>
				<input type="text" class="form-control" id="attFileType" name="attFileType" placeholder="请输入附件类型" />
			</div>
			<div class="form-group" >
				<label for="attExtends1">扩展字段1：</label>
				<input type="text" class="form-control" id="attExtends1" name="attExtends1" placeholder="请输入扩展字段1" />
			</div>
			<div class="form-group" >
				<label for="attExtends2">扩展字段2 ：</label>
				<input type="text" class="form-control" id="attExtends2" name="attExtends2" placeholder="请输入扩展字段2 " />
			</div>
			<div class="form-group" >
				<label for="attExtends3">扩展字段3：</label>
				<input type="text" class="form-control" id="attExtends3" name="attExtends3" placeholder="请输入扩展字段3" />
			</div>
			<div class="form-group" >
				<label for="dmDesc">描述：</label>
				<input type="text" class="form-control" id="dmDesc" name="dmDesc" placeholder="请输入描述" />
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
	<script type="text/javascript" src="js/bsAttachmentEdit.js"></script>
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
				url : "/bsAttachmentCtrl/insert.ctrl",
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
						fileInputParam["attSourceType"] = "bs_attachment"; //填业务表名称
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
					url : "/bsAttachmentCtrl/deleteByPrimaryKey.ctrl",
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
				url : "/bsAttachmentCtrl/selectByPrimaryKey.ctrl",
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