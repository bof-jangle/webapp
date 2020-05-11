package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsMenuRoleR;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 基础框架的基础Demo 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsMenuRoleRService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsMenuRoleR> insertOrUpdate(BsMenuRoleR record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsMenuRoleR> deleteByPrimaryKey(BsMenuRoleR record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsMenuRoleR> updateByPrimaryKey(BsMenuRoleR record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsMenuRoleR> selectByPrimaryKey(BsMenuRoleR record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsMenuRoleR> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsMenuRoleR> selectPage(BsMenuRoleR record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsMenuRoleR> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsMenuRoleR> batchDeleteByPrimaryKey(BsMenuRoleR record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsMenuRoleR> batchDeleteByPrimaryKeyActually(BsMenuRoleR record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsMenuRoleR> selectByPrimaryKeyForAnnotation(BsMenuRoleR record);

}
