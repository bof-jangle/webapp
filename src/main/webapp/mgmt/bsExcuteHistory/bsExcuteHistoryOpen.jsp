<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- bootstrap依赖 -->
<title>执行记录表_查看页面</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" class="jangle-openjsp-bodytopdiv" style="margin-top: 20px;">
		<span class="label label-info">执行记录表详情查看</span>
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div style="margin-top: 20px;">
		<form id="jangleEditForm" name="jangleEditForm"	class="formJ">
			<div class="form-group" >
				<label for="dmDesc">描述：</label>
				<input type="text" class="form-control" id="dmDesc" name="dmDesc" readonly />
			</div>
			<div class="form-group" >
				<label for="dmDesc2">描述2：</label>
				<input type="text" class="form-control" id="dmDesc2" name="dmDesc2" readonly />
			</div>
			<div class="form-group" >
				<label for="excuteMethod">执行方法：</label>
				<input type="text" class="form-control" id="excuteMethod" name="excuteMethod" readonly />
			</div>
			<div class="form-group" >
				<label for="excuterCode">执行人账户：</label>
				<input type="text" class="form-control" id="excuterCode" name="excuterCode" readonly />
			</div>
			<div class="form-group">
				<label for="input-id">附件：</label>
				<div id="attListJ" style="display:inline-block" ></div>
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
							if(item.lastIndexOf("Time") != -1){
								$("#" + item).val(datetimeFormatterJ(data.model[item]));
							}else{
								$("#" + item).val(data.model[item]);
							}
						}
					}
				}
			});
			// 加载附件
			loadAttachmentJ(ps["id"],"bs_test");
		})
	</script>
</body>
</html>