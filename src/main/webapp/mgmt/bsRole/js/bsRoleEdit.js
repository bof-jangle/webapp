/*!
 * 角色管理 专用JS
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
		rolName : {
			validators : {
				notEmpty : {
					message : "请输入角色名称"
				}
			}
		},
		rolCode : {
			validators : {
				notEmpty : {
					message : "请输入角色编码"
				}
			}
		},
		dmDesc : {
			validators : {
				notEmpty : {
					message : "请输入拓展字段1"
				}
			}
		},
		dmDesc2 : {
			validators : {
				notEmpty : {
					message : "请输入拓展字段2"
				}
			}
		}
	}
});
