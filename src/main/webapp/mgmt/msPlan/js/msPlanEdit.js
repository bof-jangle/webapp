/*!
 * 面试安排 专用JS
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
		company : {
			validators : {
				notEmpty : {
					message : "请输入公司"
				}
			}
		}
	}
});
