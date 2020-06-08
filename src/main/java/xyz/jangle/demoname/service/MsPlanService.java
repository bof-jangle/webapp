package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.MsPlan;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 面试安排 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.12020-06-08 11:34:37
 */
public interface MsPlanService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<MsPlan> insertOrUpdate(MsPlan record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<MsPlan> deleteByPrimaryKey(MsPlan record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<MsPlan> updateByPrimaryKey(MsPlan record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<MsPlan> selectByPrimaryKey(MsPlan record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<MsPlan> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<MsPlan> selectPage(MsPlan record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<MsPlan> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<MsPlan> batchDeleteByPrimaryKey(MsPlan record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<MsPlan> batchDeleteByPrimaryKeyActually(MsPlan record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<MsPlan> selectByPrimaryKeyForAnnotation(MsPlan record);

}
