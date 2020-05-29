package xyz.jangle.demoname.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.BsRoleUserR;
import xyz.jangle.demoname.vo.BsRoleUserRVo;
/**
 *  数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsRoleUserRMapper extends BaseDaoMapper<BsRoleUserR> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from bs_role_user_r where id = #{id}")
	BsRoleUserR selectByPrimaryKeyForAnnotation(Long id);
	
	@Select("select bs_user_uuid,dm_desc from bs_role_user_r where bs_role_id = #{roleId}")
	List<BsRoleUserRVo> selectByRoleId(Long roleId);

}