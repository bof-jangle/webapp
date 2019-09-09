package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsTest;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 测试表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsTestService {
	/**
	 * 	增
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsTest> insertOrUpdate(BsTest record);

	/**
	 * 	删
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsTest> deleteByPrimaryKey(BsTest record);

	/**
	 *	改
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsTest> updateByPrimaryKey(BsTest record);

	/**
	 * 	单查
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsTest> selectByPrimaryKey(BsTest record);

	/**
	 * 	参查
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<BsTest> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<BsTest> selectPage(BsTest record);

	/**
	 * 	全询
	 * 
	 * @return
	 */
	ResultModelList<BsTest> selectAll();
	
	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsTest> batchDeleteByPrimaryKey(BsTest record);
	
	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsTest> selectByPrimaryKeyForAnnotation(BsTest record);

}
