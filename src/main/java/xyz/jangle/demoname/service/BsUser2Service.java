package xyz.jangle.demoname.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 用户表V2 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsUser2Service {
	/**
	 * 	增
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsUser2> insertOrUpdate(BsUser2 record);

	/**
	 * 	删
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsUser2> deleteByPrimaryKey(BsUser2 record);

	/**
	 *	改
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsUser2> updateByPrimaryKey(BsUser2 record);

	/**
	 * 	单查
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsUser2> selectByPrimaryKey(BsUser2 record);

	/**
	 * 	参查
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<BsUser2> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<BsUser2> selectPage(BsUser2 record);

	/**
	 * 	全询
	 * 
	 * @return
	 */
	ResultModelList<BsUser2> selectAll();
	
	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsUser2> batchDeleteByPrimaryKey(BsUser2 record);
	
	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsUser2> selectByPrimaryKeyForAnnotation(BsUser2 record);
	
	/**
	 * 获取当前登陆者信息
	 * @return
	 */
	ResultModel<BsUser2> currentLoggedIn();
	
	/**
	 * 执行登录
	 * @param code
	 * @param password
	 * @param timeStamp
	 * @return
	 */
	ResultModel<BsUser2> login(String code, String password, String timeStamp);
	
	/**
	 * 注销登录
	 * @param httpSession
	 * @return
	 */
	ResultModel<BsUser2> logout();
	
	/**
	 * 审批通过
	 * @param bsUser
	 * @return
	 */
	ResultModel<BsUser2> passApply(BsUser2 bsUser2);
	
	/**
	 * 审批不通过
	 * @param bsUser
	 * @return
	 */
	ResultModel<BsUser2> noPassApply(BsUser2 bsUser2);
	
	/**
	 * 根据jgCode查询用户
	 * @param bsUser2
	 * @return
	 */
	ResultModel<BsUser2> selectByCode(BsUser2 bsUser2);

}
