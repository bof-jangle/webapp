/**
 * 初始化附件插件
 * 
 * @param fileInputId
 *            附件input的domId
 * @param url
 *            附件上传的地址，若为空，则使用默认的附件上传地址
 * @param fileInputParam
 *            附件上传时，提供的拓展参数
 * @param extArray
 *            支持的扩展名，若为空，则使用定义的默认扩展名
 * @param maxFileCount
 *            限制上传数量
 * @returns
 */
function initFileInput(fileInputId, url, fileInputParam, extArray, maxFileCount) {
	if (extArray == null || extArray.length == 0) {
		// extArray = [ 'doc', 'docx' ];
		// extArray = [ 'doc',
		// 'docx','xlsx','ppt','pptx','xls','pdf','jpg','png','rar','zip','txt','vsd'
		// ];
		extArray = [ 'tif', 'jpg', 'png', 'gif', 'bmp', 'txt', 'html', 'xml',
				'pdf', 'doc', 'xls', 'ppt', 'docx', 'xlsx', 'pptx', 'zip',
				'rar', 'mp3', 'mov', 'avi', 'mpp' ]
	}
	if (!maxFileCount) {
		maxFileCount = 10;
	}
	if (url == null || url == "") {
		url = "/bsAttachmentCtrl/uploadBatch";
	}
	var control = $('#' + fileInputId);
	control
			.fileinput({
				language : 'zh', // 设置语言
				uploadUrl : url,
				allowedFileExtensions : extArray,// 接收的文件后缀
				maxFilesNum : 5,// 上传最大的文件数量
				// uploadExtraData:function(previewId, index) { return
				// extraParams; },
				uploadAsync : false, // 默认异步上传
				showUpload : false, // 是否显示上传按钮
				showRemove : true, // 显示移除按钮
				showPreview : false, // 是否显示预览
				showCaption : false,// 是否显示标题
				browseClass : "btn btn-primary", // 按钮样式
				dropZoneEnabled : true,// 是否显示拖拽区域
				// minImageWidth: 50, //图片的最小宽度
				// minImageHeight: 50,//图片的最小高度
				// maxImageWidth: 300,//图片的最大宽度
				// maxImageHeight: 200,//图片的最大高度
				maxFileSize : 0,// 单位为kb，如果为0表示不限制文件大小
				// minFileCount: 0,
				maxFileCount : maxFileCount, // 表示允许同时上传的最大文件个数
				enctype : 'multipart/form-data',
				validateInitialCount : true,
				previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
				msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
				uploadExtraData : function(previewId, index) {
					return fileInputParam;
				}
			})
			.on(
					'filepreupload',
					function(event, data, previewId, index) { // 上传中
						var form = data.form, files = data.files, extra = data.extra, response = data.response, reader = data.reader;
						console.log('文件正在上传');
					}).on("fileuploaded",
					function(event, data, previewId, index) { // 一个文件上传成功
						console.log('文件上传成功！' + data.id);
					}).on('fileerror', function(event, data, msg) { // 一个文件上传失败
				console.log('文件上传失败！' + data.id);
			}).on("filebatchuploadsuccess", function(event, data) {
				if (data.response) {
					// 上传成功后执行
					back();
					// success(data.response);
				}
			}).on('fileerror', function(event, data, msg) { // 一个文件上传失败
				alert("上传失败");
			});
}
/**
 * 附件上传
 * 
 * @param fileInputId
 *            附件input的domId
 * @returns
 */
function fileUploadJ(fileInputId) {
	$("#" + fileInputId).fileinput('upload');
}

/**
 * 删除附件
 * 
 * @param attachmentId
 *            附件的主键ID
 * @returns
 */
function deleteAttachmentJ(attachmentId) {
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