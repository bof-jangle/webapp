/** bootstrap-table 列表页面通用 js*/
var pageNum = 1; // 页码
var pageSize = 10; // 页宽
var count; // 数据量
var index = 1; // 序号
// 数据获取
function ajaxRequest(params) {
	pageSize = params.data.limit;
	pageNum = params.data.offset / pageSize + 1;
	index = params.data.offset + 1;
	var dataStr = $('#searchForm').serialize() + '&pageNum=' + pageNum
			+ '&pageSize=' + pageSize;
	$.ajax({
		// url : "../../data/bootstrap-table-data.json",
		url : "/user/selectUsers", // 这里的请求需要提供分页查询的功能。
		data : dataStr,// 这里添加分页参数与查询条件。
		dataType : 'json',
		error : function(request, textStatus, errorThrown) {
			fxShowAjaxError(request, textStatus, errorThrown);
		},
		success : function(data) {
			console.log(data);
			if (data.code != "10001") {
				alert(data.message);
				return;
			}
			data = data.list;
			if (data) {
				applies = data ? data : [];
			}
			console.log(applies);
			count = data.length;
			params.success({
				total : count,
				rows : applies
			});
			params.complete();
		}
	});
}
// 查询
function search() {
	$('#tablewrap').bootstrapTable('selectPage', 1);
	var param = {
		silent : true
	};
	$('#tablewrap').bootstrapTable('refresh', param);
};
// 自增序号
function numberAsc() {
	return index++; // index在ajaxRequest函数中被再次初始化
}
// 名称格式化
function nameFormat(name) {
	if (name.length > 20)
		return name.substring(0, 20) + "...";
	else
		return name;
}