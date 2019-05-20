package xyz.jangle.demoname.service;

import xyz.jangle.demoname.model.BsDemo;
import xyz.jangle.utils.ResultModel;

/**
 * 基础Demo业务层接口
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月15日 下午5:09:20 类说明
 */
public interface BsDemoService extends BaseService<BsDemo> {
	/**
	 * 通过主键查询记录（注解方式）
	 * @return
	 */
	ResultModel<BsDemo> selectByPrimaryKeyForAnnotation(BsDemo record);
	/**
	 * 批量删除记录
	 * @param record
	 * @return
	 */
	ResultModel<BsDemo> batchDeleteByPrimaryKey(BsDemo record);

}
