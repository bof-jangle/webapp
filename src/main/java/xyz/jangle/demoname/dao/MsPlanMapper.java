package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.MsPlan;
/**
 * 面试安排 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.12020-06-08 11:34:37
 */
public interface MsPlanMapper extends BaseDaoMapper<MsPlan> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from ms_plan where id = #{id}")
	MsPlan selectByPrimaryKeyForAnnotation(Long id);

}