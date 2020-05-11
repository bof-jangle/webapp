package xyz.jangle.demoname.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.BsMenu;
/**
 * 菜单表 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsMenuMapper extends BaseDaoMapper<BsMenu> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from bs_menu where id = #{id}")
	BsMenu selectByPrimaryKeyForAnnotation(Long id);
	
	@Select("select * from bs_menu where menu_parent_id = 0")
	List<BsMenu> selectAllRootMenu();

}