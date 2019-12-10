package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsMail;
import xyz.jangle.demoname.service.BsMailService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 邮件发送记录表 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsMailCtrl")
public class BsMailCtrl {

	@Autowired
	private BsMailService bsMailService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsMail> insert(BsMail record) {
		return bsMailService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMail> deleteByPrimaryKey(BsMail record) {
		return bsMailService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMail> updateByPrimaryKey(BsMail record) {
		return bsMailService.updateByPrimaryKey(record);
	}
	
	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMail> selectByPrimaryKey(BsMail record) {
		return bsMailService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsMail> selectPage(BsMail record) {
		return bsMailService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsMail> selectAll() {
		return bsMailService.selectAll();
	}
		
	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMail> batchDeleteByPrimaryKey(BsMail record) {
		return bsMailService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsMail> batchDeleteByPrimaryKeyActually(BsMail record) {
		return bsMailService.batchDeleteByPrimaryKeyActually(record);
	}

}
