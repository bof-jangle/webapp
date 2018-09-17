<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../../js/jquery-3.3.1.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>啦啦啦啦啦</title>
<script type="text/javascript" src="../../js/hello.js"></script>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>序列</th>
			<th>名称</th>
			<th>id</th>
		</tr>
	</thead>
 <%-- hello,I'm helloJsp2. ${users[4].userName} --%>
<s:forEach items="${users}" var="item" varStatus="status">
	  <tr >
	    <td>${status.count}</td>
	    <td class="center"><span class="center">${item.userName}</span></td>
	    <td><dfn>￥</dfn>${item.userId}</td>
	  </tr>
</s:forEach>
</table>
<p >再见.</p>
 <% %>
</body>
</html>