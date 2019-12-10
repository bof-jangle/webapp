package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsMailConfig;
import xyz.jangle.demoname.service.BsMailConfigService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 邮件配置表 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsMailConfigCtrl")
public class BsMailConfigCtrl {

	@Autowired
	private BsMailConfigService bsMailConfigService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsMailConfig> insert(BsMailConfig record) {
		return bsMailConfigService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMailConfig> deleteByPrimaryKey(BsMailConfig record) {
		return bsMailConfigService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMailConfig> updateByPrimaryKey(BsMailConfig record) {
		return bsMailConfigService.updateByPrimaryKey(record);
	}
	
	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMailConfig> selectByPrimaryKey(BsMailConfig record) {
		return bsMailConfigService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsMailConfig> selectPage(BsMailConfig record) {
		return bsMailConfigService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsMailConfig> selectAll() {
		return bsMailConfigService.selectAll();
	}
		
	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMailConfig> batchDeleteByPrimaryKey(BsMailConfig record) {
		return bsMailConfigService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsMailConfig> batchDeleteByPrimaryKeyActually(BsMailConfig record) {
		return bsMailConfigService.batchDeleteByPrimaryKeyActually(record);
	}

}
