/** bootstrap-table 列表页面通用 js*/
var pageNum = 1; // 页码
var pageSize = 10; // 页宽
var count; // 数据量
var index = 1; // 序号
// 数据获取
function ajaxRequest(params) {
	pageSize = params.data.limit;
	pageNum = params.data.offset / pageSize + 1;
	pageStart = params.data.offset;
	index = params.data.offset + 1;
	var dataStr = $('#searchForm').serialize() + '&pageStart=' + pageStart + '&pageNum=' + pageNum
			+ '&pageSize=' + pageSize;
	$.ajax({
		// url : "../../data/bootstrap-table-data.json",
		url : url, // 这里的请求需要提供分页查询的功能。
		data : dataStr,// 这里添加分页参数与查询条件。
		dataType : 'json',
		error : function(request, textStatus, errorThrown) {
			jangleShowAjaxError(request, textStatus, errorThrown);
		},
		success : function(data) {
			console.log(data);
			if (data.code != "10001") {
				alert(data.message);
				return;
			}
			list = data.list;
			if (data) {
				applies = list ? list : [];
			}
//			console.log(applies);
			count = data.count;
			if(!count){
				count = list.length;
			}
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
//	var param = {
//		silent : true
//	};
//	$('#tablewrap').bootstrapTable('refresh', param);
};
// 自增序号
function numberAsc() {
	return index++; // index在ajaxRequest函数中被再次初始化
}
// 名称格式化
function nameFormat(name) {
	if(!name){
		return name;
	}
	if (name.length > 20)
		return name.substring(0, 20) + "...";
	else
		return name;
}
//查看按钮格式化
function operateFormat(value, row) {
	return '<button class="btn btn-xs btn-info" onclick="openDetail('
			+ JSON.stringify(row).replace(/\"/g, "'")
			+ ')">查看</button>'
			+ '<button class="btn btn-xs btn-info" style="margin-left:5px;" onclick="editDetail('
			+ JSON.stringify(row).replace(/\"/g, "'")
			+ ')">编辑</button>';
};