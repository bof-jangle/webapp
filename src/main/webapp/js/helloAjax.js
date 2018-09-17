$(function() {
	$.ajax({
		url : '/hello/helloData',
		type : "post",
		dataType : "json",
		success : function(data) {
			$.each(data.users, function(index, item) {
				$("table").append(
						"<tr>" + "<td>" + index + "</td>" + "<td>"
								+ item.userName + "</td>" + "<td>"
								+ item.userId + "</td>" + "</tr>");
			});
		},
		error : function(data) {
			alert("失败！");
		}
	});
});