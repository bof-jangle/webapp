package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xyz.jangle.demoname.model.BsMail;
/**
 * 邮件发送记录表 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsMailMapper extends BaseDaoMapper<BsMail> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from bs_mail where id = #{id}")
	BsMail selectByPrimaryKeyForAnnotation(Long id);
	
	/**
	 * 根据主键更新发送结果
	 * @param record
	 * @return
	 */
	@Update("update bs_mail set mail_result = #{mailResult},status = #{status} where id = #{id}")
	int updateResultByPrimaryKey(BsMail record);

}