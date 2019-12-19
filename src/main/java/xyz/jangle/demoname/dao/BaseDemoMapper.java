package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.BaseDemo;
/**
 * 基础框架的基础Demo 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BaseDemoMapper extends BaseDaoMapper<BaseDemo> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from base_demo where id = #{id}")
	BaseDemo selectByPrimaryKeyForAnnotation(Long id);

}