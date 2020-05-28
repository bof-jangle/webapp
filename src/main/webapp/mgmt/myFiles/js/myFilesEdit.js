/*!
 * 文件、资料 专用JS
 * 
 */

// 校验的渲染
$("#jangleEditForm").bootstrapValidator({
	message : 'This value is not valid',
	feedbackIcons : {
		valid : 'glyphicon glyphicon-ok',
		invalid : 'glyphicon glyphicon-remove',
		validating : 'glyphicon glyphicon-refresh'
	},
	fields : {
		fileName : {
			validators : {
				notEmpty : {
					message : "请输入文件名称"
				}
			}
		}
	}
});
