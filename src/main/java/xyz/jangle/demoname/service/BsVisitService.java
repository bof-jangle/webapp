package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsVisit;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 访问记录表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsVisitService {
	/**
	 * 	增
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsVisit> insertOrUpdate(BsVisit record);

	/**
	 * 	删
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsVisit> deleteByPrimaryKey(BsVisit record);

	/**
	 *	改
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsVisit> updateByPrimaryKey(BsVisit record);

	/**
	 * 	单查
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsVisit> selectByPrimaryKey(BsVisit record);

	/**
	 * 	参查
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<BsVisit> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<BsVisit> selectPage(BsVisit record);

	/**
	 * 	全询
	 * 
	 * @return
	 */
	ResultModelList<BsVisit> selectAll();
	
	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsVisit> batchDeleteByPrimaryKey(BsVisit record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsVisit> batchDeleteByPrimaryKeyActually(BsVisit record);
	
	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsVisit> selectByPrimaryKeyForAnnotation(BsVisit record);

	/**
	 * 	统计
	 * @return
	 */
	ResultModel<BsVisit> count();

}
