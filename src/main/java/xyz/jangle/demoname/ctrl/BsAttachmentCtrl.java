package xyz.jangle.demoname.ctrl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import xyz.jangle.demoname.model.BsAttachment;
import xyz.jangle.demoname.service.BsAttachmentService;
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

	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> deleteByPrimaryKey(BsAttachment record) {
		return bsAttachmentService.deleteByPrimaryKey(record);
	}
	
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> batchDeleteByPrimaryKey(BsAttachment record) {
		return bsAttachmentService.batchDeleteByPrimaryKey(record);
	}

	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> insert(BsAttachment record) {
		return bsAttachmentService.insertOrUpdate(record);
	}
	
		

	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> selectByPrimaryKey(BsAttachment record) {
		return bsAttachmentService.selectByPrimaryKey(record);
	}

	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsAttachment> selectAll() {
		return bsAttachmentService.selectAll();
	}

	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsAttachment> selectPage(BsAttachment record) {
		return bsAttachmentService.selectPage(record);
	}

	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsAttachment> updateByPrimaryKey(BsAttachment record) {
		return bsAttachmentService.updateByPrimaryKey(record);
	}
	
//	@RequestMapping("/uploadFile.ctrl")
//	@ResponseBody
//	ResultModel<BsAttachment> uploadFile(BsAttachment record,@RequestParam String filename) {
//		System.out.println(filename);
//		return null;
//	}
	
	@RequestMapping("/uploadFile.ctrl")
	public void uploadExcel(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) throws Exception {
		if(file == null) {
			System.out.println("未获取到附件");
			return ;
		}
		System.out.println(file.getOriginalFilename());
	}

}
