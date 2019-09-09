package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsDemo;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 基础Demo业务层接口
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月15日 下午5:09:20 类说明
 */
public interface BsDemoService {
	/**
	 * 新增记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsDemo> insertOrUpdate(BsDemo record);

	/**
	 * 根据主键删除记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsDemo> deleteByPrimaryKey(BsDemo record);

	/**
	 * 根据主键更新记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsDemo> updateByPrimaryKey(BsDemo record);

	/**
	 * 根据主键查询记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<BsDemo> selectByPrimaryKey(BsDemo record);

	/**
	 * 根据参数查询列表
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<BsDemo> selectByParam(Map<String, Object> param);

	/**
	 * 分页查询
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<BsDemo> selectPage(BsDemo record);

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	ResultModelList<BsDemo> selectAll();
	/**
	 * 批量删除记录
	 * @param record
	 * @return
	 */
	ResultModel<BsDemo> batchDeleteByPrimaryKey(BsDemo record);
	
	/**
	 * 通过主键查询记录（注解方式）
	 * @return
	 */
	ResultModel<BsDemo> selectByPrimaryKeyForAnnotation(BsDemo record);

}
