package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.BsExcuteHistory;
/**
 * 执行记录表 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsExcuteHistoryMapper extends BaseDaoMapper<BsExcuteHistory> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from bs_excute_history where id = #{id}")
	BsExcuteHistory selectByPrimaryKeyForAnnotation(Long id);

}