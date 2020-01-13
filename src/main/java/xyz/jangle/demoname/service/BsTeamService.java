package xyz.jangle.demoname.service;

import java.util.Map;

import xyz.jangle.demoname.model.BsTeam;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 队伍管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsTeamService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsTeam> insertOrUpdate(BsTeam record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsTeam> deleteByPrimaryKey(BsTeam record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsTeam> updateByPrimaryKey(BsTeam record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsTeam> selectByPrimaryKey(BsTeam record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsTeam> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsTeam> selectPage(BsTeam record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsTeam> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsTeam> batchDeleteByPrimaryKey(BsTeam record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsTeam> batchDeleteByPrimaryKeyActually(BsTeam record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsTeam> selectByPrimaryKeyForAnnotation(BsTeam record);

}
