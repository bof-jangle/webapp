/*!
 * 用户表V2 专用JS
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
//		dmDesc : {
//			validators : {
//				notEmpty : {
//					message : "请输入描述"
//				}
//			}
//		},
//		dmDesc2 : {
//			validators : {
//				notEmpty : {
//					message : "请输入描述2"
//				}
//			}
//		},
		jgName : {
			validators : {
				notEmpty : {
					message : "请输入用户中文名称"
				}
			}
		},
		jgCode : {
			validators : {
				notEmpty : {
					message : "请输入英文账号"
				},
				remote: {//将内容发送至指定地址验证，返回验证结果，查询用户名是否存在
					delay:1000, //延迟1秒验证
					url: '/bsUser2Ctrl/hasCode.ctrl?id='+id, //验证地址。该验证通过 json串的valid:true 来判断是否验证通过  valid:false 则为不通过 后端用map转json的方式的话，就用"valid"的key。
										//该验证会把testName传给后端，如果要增加传参，直接在url后面增加参数即可，如："xxx.action?a=1&b=test",
					message: '用户名已经存在'
				}
			}
		},
		jgPassword : {
			validators : {
				notEmpty : {
					message : "请输入密码"
				}
			}
		}
//		,jgApplyIp : {
//			validators : {
//				notEmpty : {
//					message : "请输入申请人IP"
//				}
//			}
//		},
//		jgApplyReason : {
//			validators : {
//				notEmpty : {
//					message : "请输入申请理由"
//				}
//			}
//		}
	}
});
