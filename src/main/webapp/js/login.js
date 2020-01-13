var userName;
var userPassword;
$(function() {
	$("#ip").val(returnCitySN["cip"]);
	$("#city").val(returnCitySN["cname"]);
	$("#userLoginForm").submit(function() {
		// 重写form表单提交事件。
		loginForUser();
		return false;
	});
});

function login() {
	if (userName == "") {
		// alert("用户名不可为空");
		return;
	}
	if (userPassword == "") {
		// alert("密码不可为空");
		return;
	}
	$.ajax({
		type : "POST",
		url : "/user/login",
		dataType : "json",
		data : {
			"code" : userName,
			"password" : userPassword,
			"ip" : $("#ip").val(),
			"city" : $("#city").val()
		},
		success : function(res) {
			// console.log(res);
			if (res.code != "10001") {
				alert(res.message);
			} else {
				// alert("登陆成功");
				if (window.top == window.self) {
					location.href = "index.html";
				} else {
					parent.window.location.href = "index.html";
				}
			}
		},
		error : function(request, textStatus, errorThrown) {
			jangleShowAjaxError(request, textStatus, errorThrown);
		}
	});
}

function loginForUser() {
	userName = $("#userName").val();
	userPassword = $("#userPassword").val();
	login();
}

function loginForYk() {
	userName = "2";
	userPassword = "p;.";
	login();
}
function jangleShowAjaxError(request, textStatus, errorThrown) {
	if (textStatus == 'timeout') {
		alert('请求超时');
	} else if (request.status == 500 || request.status == 400
			|| request.status == 403 || request.status == 404) {
		alert(request.status);
		document.body.innerHTML = request.responseText;
	} else {
		alert("操作异常，请提供确认后的信息给系统管理员");
		document.body.innerHTML = request.responseText;
	}
}