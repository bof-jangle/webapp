package xyz.jangle.demoname.service;

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
	 * 根据主键删除记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<T> deleteByPrimaryKey(T record);

	/**
	 * 新增记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<T> insert(T record);

	/**
	 * 根据主键查询记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<T> selectByPrimaryKey(T record);

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	ResultModelList<T> selectAll();

	/**
	 * 根据主键更新记录
	 * 
	 * @param record
	 * @return
	 */
	ResultModel<T> updateByPrimaryKey(T record);

	/**
	 * 分页查询
	 * 
	 * @param record
	 * @return
	 */
	ResultModelList<T> selectPage(T record);

}
