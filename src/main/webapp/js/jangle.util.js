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
 * bootstrap文件上传初始化 ,需引用bootstrap-fileinput插件
 * @param fileInputId 附件input的domId
 * @param url	附件上传的地址，若为空，则使用默认的附件上传地址
 * @param fileInputParam 附件上传时，提供的拓展参数
 * @param extArray	支持的扩展名，若为空，则使用定义的默认扩展名
 * @param maxFileCount 限制上传数量
 * @returns
 */ 
function initOaFileinput(fileInputId, url, fileInputParam, extArray,
		maxFileCount) {
	if (extArray == null || extArray.length == 0) {
//		extArray = [ 'doc', 'docx' ];
		extArray = [ 'doc', 'docx','xlsx','ppt','pptx','xls','pdf','jpg','png','rar','zip','txt','vsd' ];
	}
	if (!maxFileCount) {
		maxFileCount = 10;
	}
	if (url == null || url == "") {
		url = "/bsAttachmentCtrl/insert.ctrl";
	}
	$("#" + fileInputId).fileinput({
		language : 'zh',
		showUpload : false,
		showRemove : true,
		showPreview : false,	// 预览功能
		showCaption : false,
		dropZoneEnabled : false,
		uploadUrl : url,
		allowedFileExtensions : extArray, // 扩展名
		uploadAsync : false,
		autoReplace : false,
		maxFileSize:10240,				//文件大小限制10M
		maxFileCount : maxFileCount, // 表示允许同时上传的最大文件个数
		msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		layoutTemplates:{
			actionUpload:''
		},
		uploadExtraData : function() {
			return fileInputParam;
		}
	});
	$("#" + fileInputId).on("filebatchuploadsuccess", function(event, data) {
		if (data.response) {
			$("#popWindow").hide();
			success(data.response);
		}
	}).on('fileerror', function(event, data, msg) { // 一个文件上传失败
		alert("上传失败");
	});
}

/**
 *  附件上传
 * @param fileInputId 附件input的domId
 * @returns
 */
function uploadOaFileInput(fileInputId) {
	$("#" + fileInputId).fileinput('upload'); // 上传操作
}

/**
 * 删除附件
 * @param attachmentId 附件的主键ID
 * @returns
 */
function deleteOaAttachment(attachmentId) {
	$.ajax({
		url : "../../bsAttachmentCtrl/deleteByPrimaryKey.ctrl",
		dataType : "json",
		data : {
			"id" : attachmentId
		},
		error : function(request, textStatus, errorThrown) {
			alert("删除附件时出错");
			jangleShowAjaxError(request, textStatus, errorThrown);
		},
		success : function(data) {
			alert("删除成功");
			location.reload();
		}
	});
};

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
