package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.ZdLyb;
/**
 * 战队留言板 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface ZdLybMapper extends BaseDaoMapper<ZdLyb> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from zd_lyb where id = #{id}")
	ZdLyb selectByPrimaryKeyForAnnotation(Long id);

}