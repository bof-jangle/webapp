/*!
 * 战队留言板 专用JS
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
		zdContent : {
			validators : {
				notEmpty : {
					message : "请输入留言正文"
				}
			}
		}
	}
});
