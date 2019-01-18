package xyz.jangle.demoname.dao;

import java.util.List;

/**
 * DAO层基础接口
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月18日 下午3:01:02 类说明
 */
public interface BaseDaoMapper<T> {
	/**
	 * 根据主键ID删除记录
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 插入记录
	 * 
	 * @param record
	 * @return
	 */
	int insert(T record);

	/**
	 * 根据主键查询记录
	 * 
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(Long id);

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	List<T> selectAll();

	/**
	 * 根据主键更新记录
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(T record);

	/**
	 * 分页查询
	 * 
	 * @param record
	 * @return
	 */
	List<T> selectPage(T record);

	/**
	 * 数量统计
	 * 
	 * @param record
	 * @return
	 */
	Long selectPageCount(T record);

}
