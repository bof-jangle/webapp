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
var id = ps["id"];
var uuid = ps["uuid"];

/**
 * ajax调用错误的方法
 * 
 * @param request
 * @param textStatus
 * @param errorThrown
 * @returns
 */
function jangleShowAjaxError(request, textStatus, errorThrown) {
	if (textStatus == 'timeout') {
		alert('请求超时');
	} else if (request.status == 500 || request.status == 400
			|| request.status == 403 || request.status == 404) {
		document.body.innerHTML = request.responseText;
	} else {
		alert(request.responseText);
	}
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

