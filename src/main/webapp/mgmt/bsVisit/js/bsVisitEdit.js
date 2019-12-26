/*!
 * 访问记录表 专用JS
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
		dmDesc : {
			validators : {
				notEmpty : {
					message : "请输入描述"
				}
			}
		},
		dmDesc2 : {
			validators : {
				notEmpty : {
					message : "请输入描述2"
				}
			}
		}
	}
});
