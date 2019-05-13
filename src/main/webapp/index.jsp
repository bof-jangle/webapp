<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../images/douyin.png" type="image/x-icon" /><!-- 小图标 -->
<title>阿景请求挑战</title>
</head>
<body onload='onloadMethod()'>
<!-- <h2>Hello World!!!!!!index.jsp</h2> -->

<h2>不服跟我来场5V5。给我留言：jangle@jangle.xyz(邮箱) <a href="javascript:void(0);" onclick="toDouyu(1);">看我直播</a>（斗鱼）
<span style="margin-left:30px;"><a href="https://tieba.baidu.com/p/6115501649">看我个人信息</a></span></h2>
<div>
	<h3>招募：王者辅助1名（队内辅助家管严）</h3>
	<p>要求1：为人友善，性格开朗（学生或固定工作者佳，工作日晚上19:30-23:00，休息日放假，佳。）</p>
	<p>要求2：喜欢玩辅助，会游走。（能语音，佳）</p>
	<p>要求3：乐于沟通，游戏结束后喜欢探讨，总结经验，提出解决方案，针对措施，改进措施。</p>
	<p>加分项1：以全能辅助为目标，悉知所有英雄技能及特点。了解最佳搭档、最佳克制英雄</p>
	<p>加分项2：次选英雄为大肉上单。</p>
	<p>另：次选英雄为打野的，我们可以轮换打野和辅助，相互学习。</p>
</div>
<h3>有意者将个人信息（参考“<a href="https://tieba.baidu.com/p/6115501649">看我个人信息</a>”的内容）发送到我的邮箱jangle@jangle.xyz</h3>
<h2><a href="https://bbs.nga.cn/read.php?pid=337039243">我的团队信息</a></h2>
<img alt="抖音二维码" src="../images/douyin.png">
</body>
<jsp:include page="/js/includeJS.jsp">
		<jsp:param value="validator-out,utilJ" name="jses"/>
</jsp:include>
<script>
function toDouyu(look){
	if(look == '1'){
		window.location.href="http://douyu.com/jangle";
		return;
	}
	$.ajax({
		url : "/bsDemoCtrl/selectByPrimaryKey.ctrl",
		dataType : "json",
		cache : false,
		data : {
			"id" : 249
		},
		error : function(request, textStatus, errorThrown) {
			jangleShowAjaxError(request, textStatus, errorThrown);
		},
		success : function(data) {
			if (data != null && data.code == "10001"
					&& data.model != null) {
				if(data.model["dmDesc"] !=null && data.model["dmDesc"].trim() != "0"){
					if(data.model["dmDesc2"] !=null && data.model["dmDesc2"].trim() != "0"){
						window.location.href=data.model["dmDesc"]; 	//如果dmDesc2不为0，则为开播
					}
				}
			}
		}
	});
}
function onloadMethod(){
	setTimeout("toDouyu()",3000);
}
</script>
</html>
