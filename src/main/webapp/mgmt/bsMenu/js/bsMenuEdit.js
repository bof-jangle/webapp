/*!
 * 菜单表 专用JS
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
		menuName : {
			validators : {
				notEmpty : {
					message : "请输入菜单名称"
				}
			}
		},
		menuParentName : {
			validators : {
				notEmpty : {
					message : "请输入上级菜单名称"
				}
			}
		},
		menuUrl : {
			validators : {
				notEmpty : {
					message : "请输入菜单链接"
				}
			}
		}
	}
});
