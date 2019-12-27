package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsFileBit;
import xyz.jangle.demoname.service.BsFileBitService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 文件存储表 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsFileBitCtrl")
public class BsFileBitCtrl {

	@Autowired
	private BsFileBitService bsFileBitService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsFileBit> insert(BsFileBit record) {
		return bsFileBitService.insertOrUpdate(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsFileBit> selectByPrimaryKey(BsFileBit record) {
		return bsFileBitService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsFileBit> selectPage(BsFileBit record) {
		return bsFileBitService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsFileBit> selectAll() {
		return bsFileBitService.selectAll();
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsFileBit> batchDeleteByPrimaryKeyActually(BsFileBit record) {
		return bsFileBitService.batchDeleteByPrimaryKeyActually(record);
	}

}
