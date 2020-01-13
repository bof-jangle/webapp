package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.BsTeam;
/**
 * 队伍管理 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsTeamMapper extends BaseDaoMapper<BsTeam> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from bs_team where id = #{id}")
	BsTeam selectByPrimaryKeyForAnnotation(Long id);

}