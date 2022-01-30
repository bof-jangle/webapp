<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();//获取容器路径，即项目名称
%>
<!-- 基础的Jquery -->
<script type="text/javascript" src="/cdn.bootcss.com/jquery/3.3.1/jquery.min.js" ></script>
<!-- 基础的bootstrap -->
<script type="text/javascript" src="/cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js" ></script>
<%
    String jses = request.getParameter("jses");
    if(jses != null){
		String[] jsArr = jses.split(",");
		String[] innerScript;
		String[] outerScript;
		String[] commentArr;
		for(int i = 0;i < jsArr.length;i++){
			innerScript = new String[]{};
			outerScript = new String[]{};
			commentArr = new String[]{};
			if("table-out".equals(jsArr[i])){
				commentArr = new String[]{"bootstrap-table的js文件","bootstrap-table的中文语言包"};
				outerScript = new String[]{"https://cdn.bootcss.com/bootstrap-table/1.8.1/bootstrap-table.min.js","https://cdn.bootcss.com/bootstrap-table/1.8.1/locale/bootstrap-table-zh-CN.min.js"};
			}else if("fileinput".equals(jsArr[i])){
				commentArr = new String[]{"bootstrap-fileinput的js文件","bootstrap-fileinput的中文语言包","jangle的附件上传工具JS"};
				outerScript = new String[]{"/fileUpload/js/fileinput.min.js","/fileUpload/js/zh.js","/fileUpload/js/jangle.fileinput.utils.js"};
			}else if("fileinput-out".equals(jsArr[i])){
				commentArr = new String[]{"bootstrap-fileinput的js文件","bootstrap-fileinput的中文语言包"};
				outerScript = new String[]{"https://cdn.bootcss.com/bootstrap-fileinput/4.2.3/js/fileinput.min.js","https://cdn.bootcss.com/bootstrap-fileinput/4.2.3/js/fileinput_locale_zh.min.js"};
			}else if("utilJ".equals(jsArr[i])){
				commentArr = new String[]{"jangle的工具JS"};
				innerScript = new String[]{"/js/jangle.util.js"};
			}else if("listJ".equals(jsArr[i])){
				commentArr = new String[]{"jangle的工具JS","jangle的list页面JS"};
				innerScript = new String[]{"/js/jangle.util.js","/js/bootstrap.table.ajax.js"};
			}else if("datetime".equals(jsArr[i])){
				commentArr = new String[]{"bootstrap-datetimepicker","bootstrap-datetimepicker的中文语言包"};
				innerScript = new String[]{"/jPlugs/datatimepicker/bootstrap-datetimepicker.js","/jPlugs/datatimepicker/bootstrap-datetimepicker.zh-CN.js"};
			}else if("validator-out".equals(jsArr[i])){
				commentArr = new String[]{"bootstrap-validator的js文件","bootstrap-validator的中文语言包"};
				outerScript = new String[]{"https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js","https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/language/zh_CN.min.js"};
			}else{
				out.println("<!-- 无匹配的js文件参数:"+jsArr[i]+". -->");
			}
			if(innerScript.length > 0){
				for(int j = 0;j < innerScript.length;j++){
					if(j < commentArr.length){
						out.println("<!-- "+commentArr[j]+" -->");
					}
					out.println("<script type=\"text/javascript\" src=\""+contextPath+innerScript[j]+"?v=202004211053"+"\" charset=\"UTF-8\" ></script>");
				}
			}
			if(outerScript.length > 0){
				for(int j = 0;j < outerScript.length;j++){
					if(j < commentArr.length){
						out.println("<!-- "+commentArr[j]+" -->");
					}
					out.println("<script type=\"text/javascript\" src=\""+outerScript[j]+"\" charset=\"UTF-8\" ></script>");
				}
			}
		}
    }
%>
