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
