package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.ResumeAccessRecord;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 简历访问记录 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface ResumeAccessRecordService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<ResumeAccessRecord> insertOrUpdate(ResumeAccessRecord record);
	void doInsertRecordByQueue();

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<ResumeAccessRecord> deleteByPrimaryKey(ResumeAccessRecord record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<ResumeAccessRecord> updateByPrimaryKey(ResumeAccessRecord record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<ResumeAccessRecord> selectByPrimaryKey(ResumeAccessRecord record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<ResumeAccessRecord> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<ResumeAccessRecord> selectPage(ResumeAccessRecord record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<ResumeAccessRecord> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<ResumeAccessRecord> batchDeleteByPrimaryKey(ResumeAccessRecord record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<ResumeAccessRecord> batchDeleteByPrimaryKeyActually(ResumeAccessRecord record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<ResumeAccessRecord> selectByPrimaryKeyForAnnotation(ResumeAccessRecord record);

}
