/*!
 * 队伍管理 专用JS
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
		jgParentId : {
			validators : {
				notEmpty : {
					message : "请输入上级节点ID"
				}
			}
		},
		jgParentName : {
			validators : {
				notEmpty : {
					message : "请输入上级节点名称"
				}
			}
		},
		jgName : {
			validators : {
				notEmpty : {
					message : "请输入队伍名称"
				}
			}
		},
		jgTeamType : {
			validators : {
				notEmpty : {
					message : "请输入队伍类型"
				}
			}
		},
		jgOrder : {
			validators : {
				notEmpty : {
					message : "请输入排序"
				}
			}
		},
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
