/*!
 * 文件存储表 专用JS
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
		bitContent : {
			validators : {
				notEmpty : {
					message : "请输入二进制大数据对象"
				}
			}
		}
	}
});
