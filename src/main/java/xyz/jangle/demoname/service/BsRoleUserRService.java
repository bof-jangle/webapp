package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsRoleUserR;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 *  业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsRoleUserRService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsRoleUserR> insertOrUpdate(BsRoleUserR record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsRoleUserR> deleteByPrimaryKey(BsRoleUserR record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsRoleUserR> updateByPrimaryKey(BsRoleUserR record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsRoleUserR> selectByPrimaryKey(BsRoleUserR record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsRoleUserR> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsRoleUserR> selectPage(BsRoleUserR record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsRoleUserR> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsRoleUserR> batchDeleteByPrimaryKey(BsRoleUserR record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsRoleUserR> batchDeleteByPrimaryKeyActually(BsRoleUserR record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsRoleUserR> selectByPrimaryKeyForAnnotation(BsRoleUserR record);

}
