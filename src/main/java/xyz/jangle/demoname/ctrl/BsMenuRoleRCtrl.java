package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsMenuRoleR;
import xyz.jangle.demoname.service.BsMenuRoleRService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 基础框架的基础Demo 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsMenuRoleRCtrl")
public class BsMenuRoleRCtrl {

	@Autowired
	private BsMenuRoleRService bsMenuRoleRService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsMenuRoleR> insert(BsMenuRoleR record) {
		return bsMenuRoleRService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMenuRoleR> deleteByPrimaryKey(BsMenuRoleR record) {
		return bsMenuRoleRService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMenuRoleR> updateByPrimaryKey(BsMenuRoleR record) {
		return bsMenuRoleRService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMenuRoleR> selectByPrimaryKey(BsMenuRoleR record) {
		return bsMenuRoleRService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsMenuRoleR> selectPage(BsMenuRoleR record) {
		return bsMenuRoleRService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsMenuRoleR> selectAll() {
		return bsMenuRoleRService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMenuRoleR> batchDeleteByPrimaryKey(BsMenuRoleR record) {
		return bsMenuRoleRService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsMenuRoleR> batchDeleteByPrimaryKeyActually(BsMenuRoleR record) {
		return bsMenuRoleRService.batchDeleteByPrimaryKeyActually(record);
	}

}
