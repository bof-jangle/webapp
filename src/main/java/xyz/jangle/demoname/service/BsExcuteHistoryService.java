package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsExcuteHistory;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 执行记录表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsExcuteHistoryService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	void insertOrUpdate(BsExcuteHistory record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsExcuteHistory> deleteByPrimaryKey(BsExcuteHistory record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsExcuteHistory> updateByPrimaryKey(BsExcuteHistory record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsExcuteHistory> selectByPrimaryKey(BsExcuteHistory record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsExcuteHistory> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsExcuteHistory> selectPage(BsExcuteHistory record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsExcuteHistory> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsExcuteHistory> batchDeleteByPrimaryKey(BsExcuteHistory record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsExcuteHistory> batchDeleteByPrimaryKeyActually(BsExcuteHistory record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsExcuteHistory> selectByPrimaryKeyForAnnotation(BsExcuteHistory record);

}
