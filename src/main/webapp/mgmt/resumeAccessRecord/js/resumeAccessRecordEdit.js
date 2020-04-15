/*!
 * 简历访问记录 专用JS
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
					message : "请输入ip"
				}
			}
		},
		dmDesc2 : {
			validators : {
				notEmpty : {
					message : "请输入城市"
				}
			}
		},
		resumeUri : {
			validators : {
				notEmpty : {
					message : "请输入简历URI"
				}
			}
		}
	}
});
