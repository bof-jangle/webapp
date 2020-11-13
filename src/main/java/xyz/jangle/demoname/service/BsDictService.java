package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsDict;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 字典表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsDictService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsDict> insertOrUpdate(BsDict record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsDict> deleteByPrimaryKey(BsDict record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsDict> updateByPrimaryKey(BsDict record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsDict> selectByPrimaryKey(BsDict record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsDict> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsDict> selectPage(BsDict record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsDict> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsDict> batchDeleteByPrimaryKey(BsDict record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsDict> batchDeleteByPrimaryKeyActually(BsDict record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsDict> selectByPrimaryKeyForAnnotation(BsDict record);

	boolean noRecordForMyIp(String keyIp);

}
