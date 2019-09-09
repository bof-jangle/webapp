<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>附件上传存放管理_查看页面</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" style="margin-top: 20px;">
		附件上传存放管理详情查看
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div style="margin-top: 20px;">
		<form id="jangleEditForm" name="jangleEditForm"	class="formJ">
			<div class="form-group" >
				<label for="attId">文件表id：</label>
				<input type="text" class="form-control" id="attId" name="attId" readonly />
			</div>
			<div class="form-group" >
				<label for="attCreateUuid">创建人的uuid：</label>
				<input type="text" class="form-control" id="attCreateUuid" name="attCreateUuid" readonly />
			</div>
			<div class="form-group" >
				<label for="attName">文件名：</label>
				<input type="text" class="form-control" id="attName" name="attName" readonly />
			</div>
			<div class="form-group" >
				<label for="attExt">文件类型，扩展名：</label>
				<input type="text" class="form-control" id="attExt" name="attExt" readonly />
			</div>
			<div class="form-group" >
				<label for="attPath">相对路径 年/月/ID/文件：</label>
				<input type="text" class="form-control" id="attPath" name="attPath" readonly />
			</div>
			<div class="form-group" >
				<label for="attAbspath">绝对路径：</label>
				<input type="text" class="form-control" id="attAbspath" name="attAbspath" readonly />
			</div>
			<div class="form-group" >
				<label for="attProtocol">协议：</label>
				<input type="text" class="form-control" id="attProtocol" name="attProtocol" readonly />
			</div>
			<div class="form-group" >
				<label for="attContext">内容，备用：</label>
				<input type="text" class="form-control" id="attContext" name="attContext" readonly />
			</div>
			<div class="form-group" >
				<label for="attSourceType">附件所属业务表名：</label>
				<input type="text" class="form-control" id="attSourceType" name="attSourceType" readonly />
			</div>
			<div class="form-group" >
				<label for="attSourceId">附件所属业务表主键id：</label>
				<input type="text" class="form-control" id="attSourceId" name="attSourceId" readonly />
			</div>
			<div class="form-group" >
				<label for="attSourceUuid">业务源的UUID：</label>
				<input type="text" class="form-control" id="attSourceUuid" name="attSourceUuid" readonly />
			</div>
			<div class="form-group" >
				<label for="attFileType">附件类型：</label>
				<input type="text" class="form-control" id="attFileType" name="attFileType" readonly />
			</div>
			<div class="form-group" >
				<label for="attExtends1">扩展字段1：</label>
				<input type="text" class="form-control" id="attExtends1" name="attExtends1" readonly />
			</div>
			<div class="form-group" >
				<label for="attExtends2">扩展字段2 ：</label>
				<input type="text" class="form-control" id="attExtends2" name="attExtends2" readonly />
			</div>
			<div class="form-group" >
				<label for="attExtends3">扩展字段3：</label>
				<input type="text" class="form-control" id="attExtends3" name="attExtends3" readonly />
			</div>
			<div class="form-group" >
				<label for="dmDesc">描述：</label>
				<input type="text" class="form-control" id="dmDesc" name="dmDesc" readonly />
			</div>
			<input type="hidden" name="id" id="id">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="uuid" id="uuid">	<!-- 主键ID隐藏域 -->
			<input type="hidden" name="status" id="status" >	<!-- 状态隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script>
		if (ps["id"])
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
					}
				}
			});
	</script>
</body>
</html>