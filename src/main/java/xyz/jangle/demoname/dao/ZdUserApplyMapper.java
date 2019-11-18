package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xyz.jangle.demoname.model.ZdUserApply;
/**
 * 用户申请 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface ZdUserApplyMapper extends BaseDaoMapper<ZdUserApply> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from zd_user_apply where id = #{id}")
	ZdUserApply selectByPrimaryKeyForAnnotation(Long id);
	
	@Select("select count(1) from zd_user_apply where zd_user_apply_ip = #{zdUserApplyIp} and status = 1")
	int countByApplyIp(ZdUserApply zdUserApply);
	
	@Update("update zd_user_apply set update_time = now(),status = 6,zd_user_apply_ip =  CONCAT(zd_user_apply_ip,'Q',id) where id = #{id}")
	int pass(ZdUserApply zdUserApply);

	@Update("update zd_user_apply set update_time = now(),status = 5,zd_user_apply_ip =  CONCAT(zd_user_apply_ip,'Q',id)  where id = #{id}")
	int unPass(ZdUserApply zdUserApply);

}