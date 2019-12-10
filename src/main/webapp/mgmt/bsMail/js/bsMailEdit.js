/*!
 * 邮件发送记录表 专用JS
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
		toEmail : {
			validators : {
				notEmpty : {
					message : "请输入邮箱收件人"
				}
			}
		},
		mailSubject : {
			validators : {
				notEmpty : {
					message : "请输入邮件标题"
				}
			}
		},
		mailContent : {
			validators : {
				notEmpty : {
					message : "请输入邮件内容"
				}
			}
		},
		mailType : {
			validators : {
				notEmpty : {
					message : "请输入邮件类型：1、密码邮件 2、手动录入"
				}
			}
		},
		mailResult : {
			validators : {
				notEmpty : {
					message : "请输入发送结果（失败原因）"
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
