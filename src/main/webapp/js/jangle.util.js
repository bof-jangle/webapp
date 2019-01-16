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