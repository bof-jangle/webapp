package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 服务接口层基类，用于定义基础服务方法
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月18日 下午3:15:45 类说明
 */
public interface BaseService<T> {
	/**
	 * 新增记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<T> insertOrUpdate(T record);

	/**
	 * 根据主键删除记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<T> deleteByPrimaryKey(T record);

	/**
	 * 根据主键更新记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<T> updateByPrimaryKey(T record);

	/**
	 * 根据主键查询记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<T> selectByPrimaryKey(T record);

	/**
	 * 根据参数查询列表
	 * 
	 * @param param
	 * @return
	 */
	ResultModelList<T> selectByParam(Map<String, Object> param);

	/**
	 * 分页查询
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<T> selectPage(T record);

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	ResultModelList<T> selectAll();
	/**
	 * 批量删除记录
	 * @param record
	 * @return
	 */
	ResultModel<T> batchDeleteByPrimaryKey(T record);

}
