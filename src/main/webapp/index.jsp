<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>阿景请求挑战</title>
</head>
<body onload='onloadMethod()'>
<!-- <h2>Hello World!!!!!!index.jsp</h2> -->

<h2>不服跟我来场5V5。给我留言：jangle@jangle.xyz</h2>

</body>
<script>
function toDouyu(){
	alert("去往直播平台");
	window.location.href="http://douyu.com/jangle"; 
}
function onloadMethod(){
	setTimeout("toDouyu()",3000);
}
</script>
</html>
