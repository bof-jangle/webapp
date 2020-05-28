package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.MyFiles;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 文件、资料 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface MyFilesService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<MyFiles> insertOrUpdate(MyFiles record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<MyFiles> deleteByPrimaryKey(MyFiles record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<MyFiles> updateByPrimaryKey(MyFiles record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<MyFiles> selectByPrimaryKey(MyFiles record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<MyFiles> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<MyFiles> selectPage(MyFiles record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<MyFiles> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<MyFiles> batchDeleteByPrimaryKey(MyFiles record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<MyFiles> batchDeleteByPrimaryKeyActually(MyFiles record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<MyFiles> selectByPrimaryKeyForAnnotation(MyFiles record);

}
