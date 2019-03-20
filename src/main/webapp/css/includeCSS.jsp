<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();//获取容器路径，即项目名称
%>
<!-- 引入基础背景css -->
<link rel="stylesheet" type="text/css" href="/css/backSystem.css" />
<!-- 引入bootstrap样式 -->
<link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css"  />
<%
    String csses = request.getParameter("csses");
    if(csses != null){
		String[] cssArr = csses.split(",");
		String[] innerLink;
		String[] outerLink;
		String[] commentArr;
		for(int i = 0;i < cssArr.length;i++){
			innerLink = new String[]{};
			outerLink = new String[]{};
			commentArr = new String[]{};
			if("table-out".equals(cssArr[i])){
				commentArr = new String[]{"bootstrap-table的样式"};
				outerLink = new String[]{"https://cdn.bootcss.com/bootstrap-table/1.8.1/bootstrap-table.min.css"};
			}else if("table".equals(cssArr[i])){
				commentArr = new String[]{"bootstrap-table的样式"};
				innerLink = new String[]{"bootstrap/bootstrap-table/1.8.1/bootstrap-table.min.css"};
			}else if("formJ".equals(cssArr[i])){
				commentArr = new String[]{"Jangle的form表单样式"};
				innerLink = new String[]{"/css/formJ.css"};
			}else if("validator-out".equals(cssArr[i])){
				commentArr = new String[]{"bootstrap-Validator的样式"};
				outerLink = new String[]{"https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css"};
			}else{
				out.println("<!-- 无匹配的css样式参数:"+cssArr[i]+". -->");
			}
			if(innerLink.length > 0){
				for(int j = 0;j < innerLink.length;j++){
					if(j < commentArr.length){
						out.println("<!-- "+commentArr[j]+" -->");
					}
					out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\""+contextPath+innerLink[j]+"\" />");
				}
			}
			if(outerLink.length > 0){
				for(int j = 0;j < outerLink.length;j++){
					if(j < commentArr.length){
						out.println("<!-- "+commentArr[j]+" -->");
					}
					out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\""+outerLink[j]+"\"  />");
				}
			}
		}
    }
%>
