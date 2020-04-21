var id = 0;
var param = window.location.search;
if(param){
	param = param.substring(1);
}
var arr = param.split("&");
var ps = new Object();
for(var i=0;i<arr.length;i++){
	var p = arr[i].split("=");
	ps[p[0]] = p[1];
}
if(ps["id"]){
	id = ps["id"];
}
var uuid = ps["uuid"];


//TODO 这里添加新内容


/**
 * ajax调用错误的方法
 * 
 * @param request
 * @param textStatus
 * @param errorThrown
 * @returns
 */
function jangleShowAjaxError(request, textStatus, errorThrown) {
	console.log(request);
	if (textStatus == 'timeout') {
		alert('请求超时');
	} else if (request.status == 500 || request.status == 400
			|| request.status == 403 || request.status == 404 || request.status == 200) {
		document.body.innerHTML = request.responseText;
	} else {
		alert("操作异常，请提供确认后的信息给系统管理员");
		document.body.innerHTML = request.responseText;
	}
}

/**
 * 关闭遮罩层
 * @returns
 */
function hideMask(){
	
}

/**
 * 打开遮罩层
 * @returns
 */
function showMask(){
	
}

/**
 * 加载附件
 * @param attachmentId	业务主键
 * @param sourceType	业务表
 * @param canRemove	能否被移除
 * @param targetDomId 输出目标的DomId
 * @returns
 */
function loadAttachmentJ(attachmentId,sourceType,canRemove,targetDomId){
	$.ajax({
		url:"../../bsAttachmentCtrl/selectPage.ctrl",
		dataType:"json",
		cache:false,
		data:{
			"attSourceId":attachmentId,
			"attSourceType":sourceType,
			"status":"1"
		},
		error : function(request, textStatus, errorThrown) {
			jangleShowAjaxError(request, textStatus, errorThrown);
		},
		success:function(data){
			if(data == null || data.code != "10001"){
				return;
			}
			var target = "attListJ";
			if(targetDomId){
				target = targetDomId;
			}
			var str = "";
			var list = data.list;
			for(var i in list){
				if(canRemove){
					str += '<div><a href="../../bsAttachmentCtrl/downLoadById.ctrl?id='+list[i].id+'">'+list[i].attName+'</a> <button class="btn btn-info btn-att-remove" onclick="deleteAttachmentJ('+list[i].id+',this)">删 除</button></div>';
				}else{
					str += '<div><a href="../../bsAttachmentCtrl/downLoadById.ctrl?id='+list[i].id+'">'+list[i].attName+'</a> </div>';
				}
			}
			$("#"+target).html(str);
		}
	});
}

/**
 * 对日期进行格式化
 * @param value 日期
 * @returns yyyy-MM-dd 格式时间 或者原来的值
 */
function dateFormatterJ(value){
	var datetime = datetimeFormatterJ(value);
	if(datetime && datetime.length > 10){
		return datetime.substring(0,10);
	}
	return datetime;
}

/**
 * 对时间进行格式化
 * @param value 日期
 * @returns yyyy-MM-dd hh:mm:ss 格式时间 或者原来的值
 */
function datetimeFormatterJ(value){
	if(value){
		return getdateJ(new Date(value));
	}
	return value;
}

/**
 * 对日期进行格式化 
 * @param now 入参为日期格式  new Date();
 * @returns yyyy-MM-dd hh:mm:ss 格式时间
 */
function getdateJ(now) {
//	var now = new Date();
    var y = now.getFullYear(),
    m = now.getMonth() + 1,
    d = now.getDate();
    return y + "-" + (m < 10 ? "0" + m : m) + "-" + (d < 10 ? "0" + d : d) + " " + now.toTimeString().substr(0, 8);
}

/**
 * 表单页面ajax执行成功回调函数
 * 
 * @param data
 * @returns
 */
function success(data) {
	if (data == null) {
		alert("异常操作，请联系管理员");
		return;
	}
	if (data.code == "10001") {
		alert(data.message);
	} else {
		alert(data.message);
		return;
	}
	back();
}
/**
 * ajax执行成功回调函数 刷新页面
 * @param data
 * @returns
 */
function successReload(data) {
	if (data == null) {
		alert("异常操作，请联系管理员");
		return;
	}
	if (data.code == "10001") {
		alert(data.message);
	} else {
		alert(data.message);
		return;
	}
	window.location.reload();
}
function successReload4Parent(data) {
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

/**
 * 关闭表单页面
 * @returns
 */
function back() {
	if (ps["back"]) {
		window.location.href = ps["back"];
	} else {
		window.location.href = document.referrer;
	}
}

$(function(){
	// 统一的日期格式化
	if(typeof $("#jTestDatetimepicker").datetimepicker === "function"){
		$('.j-form_date').datetimepicker({
			format: "yyyy-mm-dd 00:00:00",
			language : 'zh-CN',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
	}
})
