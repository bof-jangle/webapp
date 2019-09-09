/*!
 * 附件上传存放管理 专用JS
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
		attId : {
			validators : {
				notEmpty : {
					message : "请输入文件表id"
				}
			}
		},
		attCreateUuid : {
			validators : {
				notEmpty : {
					message : "请输入创建人的uuid"
				}
			}
		},
		attName : {
			validators : {
				notEmpty : {
					message : "请输入文件名"
				}
			}
		},
		attExt : {
			validators : {
				notEmpty : {
					message : "请输入文件类型，扩展名"
				}
			}
		},
		attPath : {
			validators : {
				notEmpty : {
					message : "请输入相对路径 年/月/ID/文件"
				}
			}
		},
		attAbspath : {
			validators : {
				notEmpty : {
					message : "请输入绝对路径"
				}
			}
		},
		attProtocol : {
			validators : {
				notEmpty : {
					message : "请输入协议"
				}
			}
		},
		attContext : {
			validators : {
				notEmpty : {
					message : "请输入内容，备用"
				}
			}
		},
		attSourceType : {
			validators : {
				notEmpty : {
					message : "请输入附件所属业务表名"
				}
			}
		},
		attSourceId : {
			validators : {
				notEmpty : {
					message : "请输入附件所属业务表主键id"
				}
			}
		},
		attSourceUuid : {
			validators : {
				notEmpty : {
					message : "请输入业务源的UUID"
				}
			}
		},
		attFileType : {
			validators : {
				notEmpty : {
					message : "请输入附件类型"
				}
			}
		},
		attExtends1 : {
			validators : {
				notEmpty : {
					message : "请输入扩展字段1"
				}
			}
		},
		attExtends2 : {
			validators : {
				notEmpty : {
					message : "请输入扩展字段2 "
				}
			}
		},
		attExtends3 : {
			validators : {
				notEmpty : {
					message : "请输入扩展字段3"
				}
			}
		},
		dmDesc : {
			validators : {
				notEmpty : {
					message : "请输入描述"
				}
			}
		}
	}
});
