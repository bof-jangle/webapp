package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.JgAssets;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 资产管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface JgAssetsService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<JgAssets> insertOrUpdate(JgAssets record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<JgAssets> deleteByPrimaryKey(JgAssets record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<JgAssets> updateByPrimaryKey(JgAssets record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<JgAssets> selectByPrimaryKey(JgAssets record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<JgAssets> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<JgAssets> selectPage(JgAssets record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<JgAssets> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<JgAssets> batchDeleteByPrimaryKey(JgAssets record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<JgAssets> batchDeleteByPrimaryKeyActually(JgAssets record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<JgAssets> selectByPrimaryKeyForAnnotation(JgAssets record);

}
