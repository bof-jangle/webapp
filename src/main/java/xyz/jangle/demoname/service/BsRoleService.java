package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsRole;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
import xyz.jangle.utils.ResultModelMap;

/**
 * 角色管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsRoleService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsRole> insertOrUpdate(BsRole record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsRole> deleteByPrimaryKey(BsRole record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsRole> updateByPrimaryKey(BsRole record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModelMap<BsRole> selectByPrimaryKey(BsRole record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsRole> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsRole> selectPage(BsRole record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsRole> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsRole> batchDeleteByPrimaryKey(BsRole record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsRole> batchDeleteByPrimaryKeyActually(BsRole record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsRole> selectByPrimaryKeyForAnnotation(BsRole record);

}
