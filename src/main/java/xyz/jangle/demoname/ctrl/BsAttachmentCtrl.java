package xyz.jangle.demoname.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import xyz.jangle.demoname.model.BsAttachment;
import xyz.jangle.demoname.model.BsFileBit;
import xyz.jangle.demoname.service.BsAttachmentService;
import xyz.jangle.demoname.service.BsFileBitService;
import xyz.jangle.demoname.service.BsUser2Service;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
/**
 * 附件上传存放管理 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsAttachmentCtrl")
public class BsAttachmentCtrl {

	@Autowired
	private BsAttachmentService bsAttachmentService;
	@Autowired
	private BsFileBitService bsFileBitService;
	@Autowired
	private BsUser2Service bsUser2Service;
	
	protected Logger logger = Logger.getLogger(getClass());

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> insert(BsAttachment record) {
		return bsAttachmentService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> deleteByPrimaryKey(BsAttachment record) {
		return bsAttachmentService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> updateByPrimaryKey(BsAttachment record) {
		return bsAttachmentService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> selectByPrimaryKey(BsAttachment record) {
		return bsAttachmentService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsAttachment> selectPage(BsAttachment record) {
		return bsAttachmentService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsAttachment> selectAll() {
		return bsAttachmentService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> batchDeleteByPrimaryKey(BsAttachment record) {
		return bsAttachmentService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> batchDeleteByPrimaryKeyActually(BsAttachment record) {
		return bsAttachmentService.batchDeleteByPrimaryKeyActually(record);
	}
	
	@RequestMapping(value = "/uploadFile.ctrl", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void uploadExcel(@RequestParam("file") MultipartFile[] files) throws Exception {
		if (files == null) {
			System.out.println("未获取到附件");
			return;
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println("获取到了附件：" + files[i].getOriginalFilename());
		}
		System.out.println("files.length:" + files.length);
	}

	// 批量上传文件
	@RequestMapping(value = "/uploadBatch", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> uploadBatch(HttpServletRequest request,
			@RequestParam("file") MultipartFile[] files, BsAttachment record) {
		if (files == null) {
			logger.error("未获取到附件");
		}
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isEmpty()) {
				String originalname = files[i].getOriginalFilename();
				System.out.println(originalname);
				record.setAttName(originalname);	//设置文件名
				// TODO 添加扩展名和文件大小的逻辑
				try {
//					writeToLocal(files[i]); // TODO 将文件写入，可改为写入数据库，或文件服务器。
					BsFileBit bsFileBit = new BsFileBit();
					bsFileBit.setBitContent(files[i].getBytes());
					ResultModel<BsFileBit> fileBitRes = bsFileBitService.insertOrUpdate(bsFileBit);
					record.setAttId(fileBitRes.getModel().getId());
				} catch (IOException e) {
					logger.error("文件写入时异常", e);
					// 做相应的异常信息返回
				}
			} else {
				logger.info("files is empty");
			}
			record.setStatus(JConstant.status_1);
			bsAttachmentService.insertOrUpdate(record);
		}
		return new HashMap<String, Object>();
	}

	// 批量上传war
	@RequestMapping(value = "/uploadROOT", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> uploadROOT(HttpServletRequest request,
			@RequestParam("file") MultipartFile[] files, BsAttachment record) {
		if (files == null) {
			logger.error("未获取到附件");
		}
		if (!bsUser2Service.currentLoggedIn().getModel().getJgCode().equals("jangle")) {
			logger.error("非管理员进行了应用的发布:" + bsUser2Service.currentLoggedIn().getModel().getJgName());
			return new HashMap<String, Object>();
		}
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isEmpty()) {
				try {
					writeToWebapps(files[i]);
				} catch (IOException e) {
					logger.error("war文件写入时异常", e);
					// 做相应的异常信息返回
				}
			} else {
				logger.info("files is empty");
			}
		}
		return new HashMap<String, Object>();
	}
	
	@RequestMapping("/downLoadById.ctrl")
	@ResponseBody
	void downLoadById(BsAttachment record,HttpServletResponse response) {
		bsAttachmentService.downLoadById(record,response);
	}

	/**
	 * 将文件写入本地磁盘
	 * 
	 * @param file
	 * @throws IOException
	 */
    @SuppressWarnings("unused")
	private void writeToLocal(MultipartFile file) throws IOException {
		File f = new File("D:/d/j/" + file.getOriginalFilename());
		OutputStream out = new FileOutputStream(f);
		out.write(file.getBytes());
		out.flush();
		out.close();
	}

	private void writeToWebapps(MultipartFile file) throws IOException {
		File f = new File("/opt/apache-tomcat-7.0.90/webapps/" + file.getOriginalFilename());
		OutputStream out = new FileOutputStream(f);
		out.write(file.getBytes());
		out.flush();
		out.close();
	}

}
