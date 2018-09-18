$(function() {
	$.ajax({
		url : '/hello/helloData',
		type : "post",
		dataType : "json",
		success : function(data) {
			console.log(data);
			if(data.code!="10001"){
				alert(data.message);
				return;
			}
			$.each(data.list, function(index, item) {
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