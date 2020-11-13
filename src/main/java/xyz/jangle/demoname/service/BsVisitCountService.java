package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsVisitCount;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 访客统计 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsVisitCountService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsVisitCount> insertOrUpdate(BsVisitCount record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsVisitCount> deleteByPrimaryKey(BsVisitCount record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsVisitCount> updateByPrimaryKey(BsVisitCount record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsVisitCount> selectByPrimaryKey(BsVisitCount record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsVisitCount> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @param timeEnd 
	 * @param timeStart 
	 * @return
	 */
	ResultModelList<BsVisitCount> selectPage(BsVisitCount record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsVisitCount> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsVisitCount> batchDeleteByPrimaryKey(BsVisitCount record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsVisitCount> batchDeleteByPrimaryKeyActually(BsVisitCount record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsVisitCount> selectByPrimaryKeyForAnnotation(BsVisitCount record);

}
