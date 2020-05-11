package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsMenu;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 菜单表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsMenuService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsMenu> insertOrUpdate(BsMenu record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsMenu> deleteByPrimaryKey(BsMenu record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsMenu> updateByPrimaryKey(BsMenu record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsMenu> selectByPrimaryKey(BsMenu record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsMenu> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsMenu> selectPage(BsMenu record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsMenu> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsMenu> batchDeleteByPrimaryKey(BsMenu record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsMenu> batchDeleteByPrimaryKeyActually(BsMenu record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsMenu> selectByPrimaryKeyForAnnotation(BsMenu record);

	/**
	 * 查询所有顶级菜单
	 * @return
	 */
	ResultModelList<BsMenu> selectAllRootMenu();

}
