package xyz.jangle.demoname.service.impl;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import xyz.jangle.demoname.dao.BsAttachmentMapper;
import xyz.jangle.demoname.model.BsAttachment;
import xyz.jangle.demoname.model.BsFileBit;
import xyz.jangle.demoname.service.BsAttachmentService;
import xyz.jangle.demoname.service.BsFileBitService;
import xyz.jangle.demoname.service.BsMailService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
import xyz.jangle.utils.ResultModelMap;

/**
 * 附件上传存放管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsAttachmentServiceImpl extends BaseServiceImpl implements BsAttachmentService {

	@Autowired
	private BsAttachmentMapper bsAttachmentMapper;
	@Autowired
	private BsFileBitService bsFileBitService;
	@Autowired
	private BsMailService bsMailService;
	@Autowired
	private HttpSession httpSession;
	
	
	
	
	@Override
	public ResultModel<BsAttachment> insertOrUpdate(BsAttachment record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsAttachmentMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsAttachmentMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsAttachment>(record);
		}
		return new ResultModel<BsAttachment>(CME.error);
	}

	@Override
	public ResultModel<BsAttachment> deleteByPrimaryKey(BsAttachment record) {
		int i = bsAttachmentMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsAttachment>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsAttachment>(CME.error);
	}
	
	@Override
	public ResultModel<BsAttachment> updateByPrimaryKey(BsAttachment record) {
		int i = bsAttachmentMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsAttachment>(CME.success);
		}
		return new ResultModel<BsAttachment>(CME.error);
	}
	
	@Override
	public ResultModel<BsAttachment> selectByPrimaryKey(BsAttachment record) {
		return new ResultModel<BsAttachment>(bsAttachmentMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsAttachment> selectByParam(Map<String, Object> param) {
		List<BsAttachment> list = bsAttachmentMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsAttachment> selectAll() {
		List<BsAttachment> list = bsAttachmentMapper.selectAll();
		return new ResultModelList<BsAttachment>(list);
	}

	

	@Override
	public ResultModelList<BsAttachment> selectPage(BsAttachment record) {
		ResultModelList<BsAttachment> resultModelList = new ResultModelList<BsAttachment>(bsAttachmentMapper.selectPage(record));
		resultModelList.setCount(bsAttachmentMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsAttachment> batchDeleteByPrimaryKey(BsAttachment record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsAttachment>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsAttachmentMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsAttachment>(CME.success);
	}

	@Override
	public ResultModel<BsAttachment> batchDeleteByPrimaryKeyActually(BsAttachment record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsAttachment>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsAttachmentMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsAttachment>(CME.success);
	}

	@Override
	public ResultModel<BsAttachment> selectByPrimaryKeyForAnnotation(BsAttachment record) {
		return new ResultModel<BsAttachment>(bsAttachmentMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}
	
	@Override
	public ResultModelMap<BsAttachment> uploadBatch(MultipartFile[] files, BsAttachment record) {
		Map<String, Object> map = Jutils.getHashMapSO();
		if (files == null) {
			logger.error("未获取到附件");
			return new ResultModelMap<>(CME.bsAttachmentFileNotFound);
		}
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isEmpty()) {
				String originalname = files[i].getOriginalFilename();
				System.out.println(originalname);
				try {
					//					writeToLocal(files[i]); // TODO 将文件写入，可改为写入数据库，或文件服务器。
					BsFileBit bsFileBit = new BsFileBit();
					bsFileBit.setBitContent(files[i].getBytes());
					ResultModel<BsFileBit> bitResult = bsFileBitService.insertOrUpdate(bsFileBit);
					record.setAttId(bitResult.getModel().getId());
					bsAttachmentMapper.insert(record);
				} catch (IOException e) {
					logger.error("文件写入时异常", e);
					// 做相应的异常信息返回
				}
			} else {
				logger.info("files is empty");
			}
		}
		return new ResultModelMap<BsAttachment>(map);
	}

	@Override
	public ResultModelMap<BsAttachment> downLoadById(BsAttachment record, HttpServletResponse response) {
		BsAttachment attachment = bsAttachmentMapper.selectByPrimaryKey(record.getId());
		BsFileBit fileBit = new BsFileBit();
		fileBit.setId(attachment.getAttId());
		ResultModel<BsFileBit> resFile = bsFileBitService.selectByPrimaryKey(fileBit);
		if(resFile.getModel() == null) {
			logger.error("下载时未找到文件实体");
			return null;
		}
		byte[] bitContent = resFile.getModel().getBitContent();
		response.setCharacterEncoding(JConstant.UTF8);
		response.setContentType(JConstant.multipart_form_data);
		String fileName = attachment.getAttName();
		try {
			fileName = java.net.URLEncoder.encode(attachment.getAttName(),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			logger.error("附件文件名转换时异常",e1);
		}
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		try {
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
			bufferedOutputStream.write(bitContent);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		} catch (IOException e) {
			logger.error("文件下载时异常", e);
		}
		attachment.setDmDesc((String) httpSession.getAttribute(JConstant.ip));
		attachment.setAttExtends2((String) httpSession.getAttribute(JConstant.city));
		bsMailService.insertOrUpdate(attachment);
		return null;
	}

}
