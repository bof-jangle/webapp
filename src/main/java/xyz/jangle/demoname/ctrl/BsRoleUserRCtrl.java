package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsRoleUserR;
import xyz.jangle.demoname.service.BsRoleUserRService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 *  控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsRoleUserRCtrl")
public class BsRoleUserRCtrl {

	@Autowired
	private BsRoleUserRService bsRoleUserRService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsRoleUserR> insert(BsRoleUserR record) {
		return bsRoleUserRService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsRoleUserR> deleteByPrimaryKey(BsRoleUserR record) {
		return bsRoleUserRService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsRoleUserR> updateByPrimaryKey(BsRoleUserR record) {
		return bsRoleUserRService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsRoleUserR> selectByPrimaryKey(BsRoleUserR record) {
		return bsRoleUserRService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsRoleUserR> selectPage(BsRoleUserR record) {
		return bsRoleUserRService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsRoleUserR> selectAll() {
		return bsRoleUserRService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsRoleUserR> batchDeleteByPrimaryKey(BsRoleUserR record) {
		return bsRoleUserRService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsRoleUserR> batchDeleteByPrimaryKeyActually(BsRoleUserR record) {
		return bsRoleUserRService.batchDeleteByPrimaryKeyActually(record);
	}

}
