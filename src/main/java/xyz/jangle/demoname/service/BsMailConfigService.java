package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsMailConfig;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 邮件配置表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsMailConfigService {
	/**
	 * 	增
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsMailConfig> insertOrUpdate(BsMailConfig record);

	/**
	 * 	删
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsMailConfig> deleteByPrimaryKey(BsMailConfig record);

	/**
	 *	改
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsMailConfig> updateByPrimaryKey(BsMailConfig record);

	/**
	 * 	单查
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsMailConfig> selectByPrimaryKey(BsMailConfig record);

	/**
	 * 	参查
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<BsMailConfig> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<BsMailConfig> selectPage(BsMailConfig record);

	/**
	 * 	全询
	 * 
	 * @return
	 */
	ResultModelList<BsMailConfig> selectAll();
	
	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsMailConfig> batchDeleteByPrimaryKey(BsMailConfig record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsMailConfig> batchDeleteByPrimaryKeyActually(BsMailConfig record);
	
	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsMailConfig> selectByPrimaryKeyForAnnotation(BsMailConfig record);

}
