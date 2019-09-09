<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<html>    
<head>    
<title>文件批量上传</title>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<link rel="stylesheet" href="css/bootstrap.min.css">    
<link rel="stylesheet" href="css/fileinput.min.css" />  
<script src="js/jquery-3.2.1.min.js"></script>    

<script type="text/javascript" src="js/fileinput.min.js"></script>  
<script type="text/javascript" src="js/zh.js"></script> 
<script type="text/javascript" src="js/fileinput_locale_zh.js"></script>   
<script src="js/bootstrap.min.js"></script>  
  
</head>  
<body>  
<div class="container-fluid">  
    <form id="form" action="" method="post" enctype="multipart/form-data">  
      <div >  
         <div class="panel panel-primary">  
           <div align="right" >  
		     <!--添加手动关闭，根据决堤项目设计的，也可以不要-->
             <button class="btn btn-default" id="colseid" type="button" tabindex="500" style="text-align: center;font-size: 15px;" >关闭</<button> 
           </div>  
         <div class="panel-body" style="padding-top: 0px;padding-top: 0px;padding-right: 0px;">  
           <div >  
              <input id="input-id" name="file" multiple type="file" data-show-caption="true">  
           </div>  
         </div>  
        </div>  
      </div>  
    </form>  
</div>  
 <script type="text/javascript">  
        $(function () {  
            initFileInput("input-id");  
            var win_id = '1';
            $("#colseid").click(function() {
            	if(win_id){
            		parent.Ext.getCmp(win_id).close();
				}
            });
        })  
  		       
        function initFileInput(ctrlName) {  
            var control = $('#' + ctrlName); 
            var businesscode = 'businesscode';
            var businessobjectid = 'businessobjectid';
            var handletype = 'handletype';
            var version = 'version';
            var SRM_CONTEXT = 'SRM_CONTEXT';
            //var extraParams = {"businesscode":businesscode,"businessobjectid"：businessobjectid,"handletype":handletype,"version":version};
//             var url = SRM_CONTEXT + "/icore/upload/uploadBatch?businesscode="+businesscode+"&businessobjectid="+businessobjectid+"&handletype="+handletype+"&version="+version;
			var url = "/bsAttachmentCtrl/uploadBatch";
            var version = '1';  control.fileinput({  
                language: 'zh', //设置语言  
                uploadUrl: url,  
                allowedFileExtensions: ['tif','jpg','png','gif','bmp','txt','html','xml','pdf','doc','xls','ppt','docx','xlsx','pptx','zip','rar','mp3','mov','avi','mpp'],//接收的文件后缀  
                maxFilesNum : 5,//上传最大的文件数量  
                //uploadExtraData:function(previewId, index) { return extraParams; }, 
                uploadAsync: false, //默认异步上传  
                showUpload: true, //是否显示上传按钮  
                showRemove : true, //显示移除按钮  
                showPreview : false, //是否显示预览  
                showCaption: false,//是否显示标题  
                browseClass: "btn btn-primary", //按钮样式  
                dropZoneEnabled: true,//是否显示拖拽区域  
                //minImageWidth: 50, //图片的最小宽度  
                //minImageHeight: 50,//图片的最小高度  
                //maxImageWidth: 300,//图片的最大宽度  
                //maxImageHeight: 200,//图片的最大高度  
                maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小  
                //minFileCount: 0,  
                //maxFileCount: 10, //表示允许同时上传的最大文件个数  
                enctype: 'multipart/form-data',  
                validateInitialCount:true,  
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",  
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",  
  
            }).on('filepreupload', function(event, data, previewId, index) {     //上传中  
                var form = data.form, files = data.files, extra = data.extra,  
                response = data.response, reader = data.reader;  
                console.log('文件正在上传');  
            }).on("fileuploaded", function (event, data, previewId, index) {    //一个文件上传成功  
                console.log('文件上传成功！'+data.id);  
  
            }).on('fileerror', function(event, data, msg) {  //一个文件上传失败  
                console.log('文件上传失败！'+data.id);  
            })  
            }  
 </script>  
</body>  
</html>  