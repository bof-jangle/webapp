package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.ZdLyb;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 战队留言板 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface ZdLybService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<ZdLyb> insertOrUpdate(ZdLyb record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<ZdLyb> deleteByPrimaryKey(ZdLyb record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<ZdLyb> updateByPrimaryKey(ZdLyb record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<ZdLyb> selectByPrimaryKey(ZdLyb record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<ZdLyb> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<ZdLyb> selectPage(ZdLyb record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<ZdLyb> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<ZdLyb> batchDeleteByPrimaryKey(ZdLyb record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<ZdLyb> batchDeleteByPrimaryKeyActually(ZdLyb record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<ZdLyb> selectByPrimaryKeyForAnnotation(ZdLyb record);

}
