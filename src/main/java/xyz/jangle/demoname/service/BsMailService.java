package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsMail;
import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.model.BsVisit;
import xyz.jangle.demoname.model.ZdUserApply;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 邮件发送记录表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsMailService {
	/**
	 * 	增
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsMail> insertOrUpdate(BsMail record);

	/**
	 * 	删
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsMail> deleteByPrimaryKey(BsMail record);

	/**
	 *	改
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsMail> updateByPrimaryKey(BsMail record);

	/**
	 * 	单查
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsMail> selectByPrimaryKey(BsMail record);

	/**
	 * 	参查
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<BsMail> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<BsMail> selectPage(BsMail record);

	/**
	 * 	全询
	 * 
	 * @return
	 */
	ResultModelList<BsMail> selectAll();
	
	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsMail> batchDeleteByPrimaryKey(BsMail record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsMail> batchDeleteByPrimaryKeyActually(BsMail record);
	
	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsMail> selectByPrimaryKeyForAnnotation(BsMail record);
	
	/**
	 * 定时发送邮件
	 */
	void doSendEmail();
	
	/**
	 * 用户申请消息（有用户申请账户时，提醒管理员审批）
	 * @param bsUser2
	 */
	void userApplyMsg(ZdUserApply zdUserApply);

	/**
	 * 用户申请通过邮件提醒
	 * @param bsUser2
	 */
	void userApplySuccess(BsUser2 bsUser2);
	
	/**
	 * 访问记录提醒
	 * @param bsVisit 
	 */
	void hAccessMsg(BsVisit bsVisit);

}
