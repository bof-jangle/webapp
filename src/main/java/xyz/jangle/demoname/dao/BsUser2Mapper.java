package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xyz.jangle.demoname.model.BsUser2;
/**
 * 用户表V2 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsUser2Mapper extends BaseDaoMapper<BsUser2> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from bs_user2 where id = #{id}")
	BsUser2 selectByPrimaryKeyForAnnotation(Long id);

//	@Select("select id,jg_name as jgName,jg_code as jgCode,jg_password as jgPassword from bs_user2 where jg_code = #{jgCode}")
	BsUser2 selectByCode(BsUser2 record);

	@Update("update bs_user2 set status = #{status},jg_apply_ip = CONCAT(jg_apply_ip,'Q',id) where id = #{id}")
	int updateStatusById(BsUser2 bsUser2);
	
	/**
	 * 查询是否有重复的code
	 * @param bsUser2
	 * @return
	 */
	@Select("select count(1) from bs_user2 where jg_code = #{jgCode} and status = 1")
	int countByJgCode(BsUser2 bsUser2);
}