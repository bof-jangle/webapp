/*!
 * 资产管理 专用JS
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
		jgAssetsName : {
			validators : {
				notEmpty : {
					message : "请输入资产名称"
				}
			}
		},
		jgAssetsPosition : {
			validators : {
				notEmpty : {
					message : "请输入存放位置"
				}
			}
		},
		jgAssetsCost : {
			validators : {
				notEmpty : {
					message : "请输入价值"
				}
			}
		},
		jgAssetsSource : {
			validators : {
				notEmpty : {
					message : "请输入来源"
				}
			}
		},
		jgAssetsGetTime : {
			validators : {
				notEmpty : {
					message : "请输入获取时间"
				}
			}
		}
	}
});
