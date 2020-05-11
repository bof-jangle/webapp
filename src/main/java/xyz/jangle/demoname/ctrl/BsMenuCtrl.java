package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsMenu;
import xyz.jangle.demoname.service.BsMenuService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 菜单表 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsMenuCtrl")
public class BsMenuCtrl {

	@Autowired
	private BsMenuService bsMenuService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsMenu> insert(BsMenu record) {
		return bsMenuService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMenu> deleteByPrimaryKey(BsMenu record) {
		return bsMenuService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMenu> updateByPrimaryKey(BsMenu record) {
		return bsMenuService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMenu> selectByPrimaryKey(BsMenu record) {
		return bsMenuService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsMenu> selectPage(BsMenu record) {
		return bsMenuService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsMenu> selectAll() {
		return bsMenuService.selectAll();
	}
	
	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsMenu> batchDeleteByPrimaryKey(BsMenu record) {
		return bsMenuService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsMenu> batchDeleteByPrimaryKeyActually(BsMenu record) {
		return bsMenuService.batchDeleteByPrimaryKeyActually(record);
	}
	
	// 查询全部顶级菜单
	@RequestMapping("/selectAllRootMenu.ctrl")
	@ResponseBody
	ResultModelList<BsMenu> selectAllRootMenu() {
		return bsMenuService.selectAllRootMenu();
	}

}
