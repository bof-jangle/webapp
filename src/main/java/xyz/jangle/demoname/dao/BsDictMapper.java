package xyz.jangle.demoname.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.BsDict;
/**
 * 字典表 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsDictMapper extends BaseDaoMapper<BsDict> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from bs_dict where id = #{id}")
	BsDict selectByPrimaryKeyForAnnotation(Long id);
	
	@Select("select dvalue from bs_dict where dkey = #{key}")
	List<String> selectValueByKey(String key);

}