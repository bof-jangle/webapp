package xyz.jangle.demoname.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import xyz.jangle.demoname.model.BsAttachment;
import xyz.jangle.utils.ResultModelMap;

/**
 * 附件上传存放管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public interface BsAttachmentService extends BaseService<BsAttachment> {

	/**
	 * 	上传附件
	 * @param files
	 * @param record
	 * @return
	 */
	ResultModelMap<BsAttachment> uploadBatch(MultipartFile[] files, BsAttachment record);

	/**
	 * 	下载附件
	 * @param record
	 * @return
	 */
	ResultModelMap<BsAttachment> downLoadById(BsAttachment record, HttpServletResponse response);

}
