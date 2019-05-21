/*!
 * 用户管理 专用JS
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
		usrName : {
			validators : {
				notEmpty : {
					message : "请输入名称"
				}
			}
		},
		usrCode : {
			validators : {
				notEmpty : {
					message : "请输入用户名"
				}
			}
		},
		usrPassword : {
			validators : {
				notEmpty : {
					message : "请输入密码"
				}
			}
		}
	}
});
