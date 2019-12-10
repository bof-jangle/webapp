<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>邮件发送记录表_查看页面</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" style="margin-top: 20px;">
		邮件发送记录表详情查看
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div style="margin-top: 20px;">
		<form id="jangleEditForm" name="jangleEditForm"	class="formJ">
			<div class="form-group" >
				<label for="toEmail">邮箱收件人：</label>
				<input type="text" class="form-control" id="toEmail" name="toEmail" readonly />
			</div>
			<div class="form-group" >
				<label for="mailSubject">邮件标题：</label>
				<input type="text" class="form-control" id="mailSubject" name="mailSubject" readonly />
			</div>
			<div class="form-group" >
				<label for="mailContent">邮件内容：</label>
				<input type="text" class="form-control" id="mailContent" name="mailContent" readonly />
			</div>
			<div class="form-group" >
				<label for="mailType">邮件类型：1、密码邮件 2、手动录入：</label>
				<input type="text" class="form-control" id="mailType" name="mailType" readonly />
			</div>
			<div class="form-group" >
				<label for="mailResult">发送结果（失败原因）：</label>
				<input type="text" class="form-control" id="mailResult" name="mailResult" readonly />
			</div>
			<div class="form-group" >
				<label for="dmDesc">描述：</label>
				<input type="text" class="form-control" id="dmDesc" name="dmDesc" readonly />
			</div>
			<div class="form-group" >
				<label for="dmDesc2">描述2：</label>
				<input type="text" class="form-control" id="dmDesc2" name="dmDesc2" readonly />
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
		$(function(){
			// TODO 额外的逻辑。
	
			if (!ps["id"]){
				return;
			}
			$.ajax({
				url : "/bsMailCtrl/selectByPrimaryKey.ctrl",
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
		})
	</script>
</body>
</html>