/**
 * 附件的回显
 * @param tableName 表名称，作为sourceType
 * @param allowRemove 是否允许删除，若为空，则按照后台的逻辑，谁上传，谁可删。
 * @param attachmentDomId 回显的目标domId。若为空，则默认使用id为 attachments的DOM元素 
 * @returns
 */
function findAttachmentsBySourceForDomId(tableName, allowRemove,attachmentDomId,attSourceId) {
	if(!attachmentDomId){
		attachmentDomId = "attachments";
	}
	if(!attSourceId){
		attSourceId = id;
	}
	$
			.ajax({
				url : "../../oaAttachmentAction!findBySource.action",
				dataType : "json",
				data : {
					"attSourceId" : attSourceId,
					"attSourceType" : tableName,
					"r" : Math.random()
				},
				error : function(request, textStatus, errorThrown) {
					alert("获取附件时异常");
					jangleShowAjaxError(request, textStatus, errorThrown);
				},
				success : function(data) {
					// 展示上传文件
					var atts = data.result;
					if (atts != null && atts != "") {
						$("#"+attachmentDomId+">a").remove();
						$("#"+attachmentDomId+">span").remove();
						$("#"+attachmentDomId+">br").remove();
						var attStr = "";
						// var isEdit = window.location.href.indexOf("Edit") !=
						// -1;
						for (var i = 0; i < atts.length; i++) {
							if (allowRemove == undefined || allowRemove == null) {
								if (atts[i].allowRemove) {
									attStr += "<a href=\"../../oaAttachmentAction!downloadById.action?id="
											+ atts[i].id
											+ "\">"
											+ atts[i].attName
											+ "</a >&nbsp;<span>——</span><a onclick=\"deleteOaAttachment('"
											+ atts[i].id
											+ "')\">删除该附件</a><br/>";
								} else {
									attStr += "<a href=\"../../oaAttachmentAction!downloadById.action?id="
											+ atts[i].id
											+ "\">"
											+ atts[i].attName + "</a ><br/>";
								}
							} else if (allowRemove) {
								attStr += "<a href=\"../../oaAttachmentAction!downloadById.action?id="
										+ atts[i].id
										+ "\">"
										+ atts[i].attName
										+ "</a >&nbsp;<span>——</span><a onclick=\"deleteOaAttachment('"
										+ atts[i].id + "')\">删除该附件</a><br/>";
							} else {
								attStr += "<a href=\"../../oaAttachmentAction!downloadById.action?id="
										+ atts[i].id
										+ "\">"
										+ atts[i].attName
										+ "</a ><br/>";
							}
						}
						$("#"+attachmentDomId+"").prepend(attStr);
					}
				}
			});
}
/**
 * bootstrap文件上传初始化 ,PageletJS.jsp和PageletCSS.jsp中需引用fileinput
 * @param fileInputId 附件input的domId
 * @param url	附件上传的地址，若为空，则使用默认的附件上传地址
 * @param oaFileInputParam 附件上传时，提供的拓展参数
 * @param extArray	支持的扩展名，若为空，则使用定义的默认扩展名
 * @param maxFileCount 限制上传数量
 * @returns
 */ 
function initOaFileinput(fileInputId, url, oaFileInputParam, extArray,
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
		showUpload : false,	//是否显示上传按钮  
		showRemove : true,	//显示移除按钮  
		showPreview : false,	// 预览功能
		showCaption : false,	//是否显示标题  
		dropZoneEnabled : false,	//是否显示拖拽区域  
		uploadUrl : url,
		allowedFileExtensions : extArray, // 扩展名
		uploadAsync : false,	//默认异步上传  
		autoReplace : false,
		maxFileSize:10240,				//文件大小限制10M
		maxFileCount : maxFileCount, // 表示允许同时上传的最大文件个数
		msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		layoutTemplates:{
			actionUpload:''
		},
		uploadExtraData : function() {
			return oaFileInputParam;
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
		url : "../../oaAttachmentAction!removeOaAttachment.action",
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