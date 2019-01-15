package xyz.jangle.demoname.service;


import xyz.jangle.demoname.model.BsDemo;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2019年1月15日 下午5:09:20 
* 类说明 
*/
public interface BsDemoService {
	
	ResultModel<BsDemo> deleteByPrimaryKey(BsDemo record);

	ResultModel<BsDemo> insert(BsDemo record);

	ResultModel<BsDemo> selectByPrimaryKey(BsDemo record);

	ResultModelList<BsDemo> selectAll();

    ResultModel<BsDemo> updateByPrimaryKey(BsDemo record);

}
