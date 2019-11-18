package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.ZdUserApply;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 用户申请 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface ZdUserApplyService {
	/**
	 * 	增
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<ZdUserApply> insertOrUpdate(ZdUserApply record);

	/**
	 * 	删
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<ZdUserApply> deleteByPrimaryKey(ZdUserApply record);

	/**
	 *	改
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<ZdUserApply> updateByPrimaryKey(ZdUserApply record);

	/**
	 * 	单查
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<ZdUserApply> selectByPrimaryKey(ZdUserApply record);

	/**
	 * 	参查
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<ZdUserApply> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<ZdUserApply> selectPage(ZdUserApply record);

	/**
	 * 	全询
	 * 
	 * @return
	 */
	ResultModelList<ZdUserApply> selectAll();
	
	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<ZdUserApply> batchDeleteByPrimaryKey(ZdUserApply record);
	
	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<ZdUserApply> selectByPrimaryKeyForAnnotation(ZdUserApply record);
	/**
	 * 通过
	 * @param record
	 * @return
	 */
	ResultModel<ZdUserApply> pass(ZdUserApply record);
	/**
	 * 不通过
	 * @param record
	 * @return
	 */
	ResultModel<ZdUserApply> unPass(ZdUserApply record);
	
	

}
