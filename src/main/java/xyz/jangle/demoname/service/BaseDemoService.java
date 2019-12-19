package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BaseDemo;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 基础框架的基础Demo 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BaseDemoService {
	/**
	 * 	增
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BaseDemo> insertOrUpdate(BaseDemo record);

	/**
	 * 	删
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BaseDemo> deleteByPrimaryKey(BaseDemo record);

	/**
	 *	改
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BaseDemo> updateByPrimaryKey(BaseDemo record);

	/**
	 * 	单查
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BaseDemo> selectByPrimaryKey(BaseDemo record);

	/**
	 * 	参查
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<BaseDemo> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<BaseDemo> selectPage(BaseDemo record);

	/**
	 * 	全询
	 * 
	 * @return
	 */
	ResultModelList<BaseDemo> selectAll();
	
	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BaseDemo> batchDeleteByPrimaryKey(BaseDemo record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BaseDemo> batchDeleteByPrimaryKeyActually(BaseDemo record);
	
	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BaseDemo> selectByPrimaryKeyForAnnotation(BaseDemo record);

}
