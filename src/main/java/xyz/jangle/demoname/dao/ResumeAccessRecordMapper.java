package xyz.jangle.demoname.dao;

import org.apache.ibatis.annotations.Select;

import xyz.jangle.demoname.model.ResumeAccessRecord;
/**
 * 简历访问记录 数据链路层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface ResumeAccessRecordMapper extends BaseDaoMapper<ResumeAccessRecord> {
	
	@Select("select id,uuid,create_time as createTime,update_time as updateTime,status,dm_desc as dmDesc,dm_desc2 as dmDesc2 from resume_access_record where id = #{id}")
	ResumeAccessRecord selectByPrimaryKeyForAnnotation(Long id);

}