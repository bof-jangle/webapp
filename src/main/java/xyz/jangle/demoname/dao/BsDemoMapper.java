package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.BsDemo;

public interface BsDemoMapper extends BaseDaoMapper<BsDemo> {
	
	@Select("select * from bs_demo where id = #{id}")
	BsDemo selectByPrimaryKeyForAnnotation(Long id);

}