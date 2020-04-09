package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.JgAssets;
/**
 * 资产管理 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface JgAssetsMapper extends BaseDaoMapper<JgAssets> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from jg_assets where id = #{id}")
	JgAssets selectByPrimaryKeyForAnnotation(Long id);
	
	Float countCost(JgAssets record);

}