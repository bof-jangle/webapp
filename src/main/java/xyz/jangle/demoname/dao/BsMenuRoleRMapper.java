package xyz.jangle.demoname.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.BsMenuRoleR;
import xyz.jangle.demoname.vo.BsMenuRoleRVo;
/**
 * 基础框架的基础Demo 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsMenuRoleRMapper extends BaseDaoMapper<BsMenuRoleR> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from bs_menu_role_r where id = #{id}")
	BsMenuRoleR selectByPrimaryKeyForAnnotation(Long id);
	
	@Select("select menu_id,dm_desc from bs_menu_role_r where role_id = #{roleId}")
	List<BsMenuRoleRVo> selectByRoleId(Long roleId);
	
}