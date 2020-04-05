package xyz.jangle.demoname.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import xyz.jangle.demoname.model.BsAttachment;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
import xyz.jangle.utils.ResultModelMap;

/**
 * 附件上传存放管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsAttachmentService {
	/**
	 * 	增
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsAttachment> insertOrUpdate(BsAttachment record);

	/**
	 * 	删
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsAttachment> deleteByPrimaryKey(BsAttachment record);

	/**
	 *	改
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsAttachment> updateByPrimaryKey(BsAttachment record);

	/**
	 * 	单查
	 *
	 * @param record
	 * @return
	 */
	ResultModel<BsAttachment> selectByPrimaryKey(BsAttachment record);

	/**
	 * 	参查
	 *
	 * @param param
	 * @return
	 */
	ResultModelList<BsAttachment> selectByParam(Map<String, Object> param);

	/**
	 * 	分查
	 *
	 * @param record
	 * @return
	 */
	ResultModelList<BsAttachment> selectPage(BsAttachment record);

	/**
	 * 	全询
	 *
	 * @return
	 */
	ResultModelList<BsAttachment> selectAll();

	/**
	 * 	批删
	 * @param record
	 * @return
	 */
	ResultModel<BsAttachment> batchDeleteByPrimaryKey(BsAttachment record);

	/**
	 * 	批删Actually
	 * @param record
	 * @return
	 */
	ResultModel<BsAttachment> batchDeleteByPrimaryKeyActually(BsAttachment record);

	/**
	 * 	注解查（注解方式）
	 * @return
	 */
	ResultModel<BsAttachment> selectByPrimaryKeyForAnnotation(BsAttachment record);
	
	/**
	 * 上传附件
	 * 
	 * @param files
	 * @param record
	 * @return
	 */
	ResultModelMap<BsAttachment> uploadBatch(MultipartFile[] files, BsAttachment record);

	/**
	 * 下载附件
	 * 
	 * @param record
	 * @return
	 */
	ResultModelMap<BsAttachment> downLoadById(BsAttachment record, HttpServletResponse response);

}
