package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsFileBit;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 文件存储表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsFileBitService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsFileBit> insertOrUpdate(BsFileBit record);
	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsFileBit> selectByPrimaryKey(BsFileBit record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsFileBit> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsFileBit> selectPage(BsFileBit record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsFileBit> selectAll();


	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsFileBit> batchDeleteByPrimaryKeyActually(BsFileBit record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsFileBit> selectByPrimaryKeyForAnnotation(BsFileBit record);

}
