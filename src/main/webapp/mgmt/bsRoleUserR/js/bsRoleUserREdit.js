/*!
 *  专用JS
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
		bsUserUuid : {
			validators : {
				notEmpty : {
					message : "请输入用户UUID"
				}
			}
		},
		bsRoleId : {
			validators : {
				notEmpty : {
					message : "请输入角色ID"
				}
			}
		},
		dmDesc : {
			validators : {
				notEmpty : {
					message : "请输入dm_desc"
				}
			}
		},
		dmDesc2 : {
			validators : {
				notEmpty : {
					message : "请输入dm_desc2"
				}
			}
		}
	}
});
