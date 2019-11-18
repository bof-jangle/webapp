/*!
 * 用户申请 专用JS
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
		zdUserName : {
			validators : {
				notEmpty : {
					message : "请输入昵称"
				}
			}
		},
		zdUserCode : {
			validators : {
				notEmpty : {
					message : "请输入用户名"
				}
			}
		},
		zdUserApplyReason : {
			validators : {
				notEmpty : {
					message : "请输入申请理由"
				}
			}
		}
	}
});
