<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEMO查看页面</title>
<jsp:include page="/css/includeCSS.jsp">
	<jsp:param value="validator-out,formJ" name="csses"/>
</jsp:include>
</head>
<body>
	<div id="bodyTopDiv" style="margin-top: 20px;">
		DEMO
		<div style="padding: 0px 1% 15px; float: right;">
			<button class="btn btn-info btn-sm" onclick="back()" id="backButton">关闭</button>
		</div>
	</div>
	<div style="margin-top: 20px;">
		<form id="jangleEditForm" name="jangleEditForm"
			style="margin-top: 20px;">
			<div class="form-group" style="padding-left: 15%;">
				<label for="dmDesc">描述：</label>
				<input type="text"	class="form-control" readonly id="dmDesc" name="dmDesc">
			</div>
			<input type="hidden" name="id" id="id">
			<!-- 主键ID隐藏域 -->
		</form>
	</div>
	<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
	</jsp:include>
	<script>
		if (ps["id"])
			$.ajax({
				url : "/bsDemoAction/selectByPrimaryKey.action",
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