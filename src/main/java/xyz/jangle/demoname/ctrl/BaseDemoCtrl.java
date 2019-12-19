package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BaseDemo;
import xyz.jangle.demoname.service.BaseDemoService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 基础框架的基础Demo 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/baseDemoCtrl")
public class BaseDemoCtrl {

	@Autowired
	private BaseDemoService baseDemoService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BaseDemo> insert(BaseDemo record) {
		return baseDemoService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BaseDemo> deleteByPrimaryKey(BaseDemo record) {
		return baseDemoService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BaseDemo> updateByPrimaryKey(BaseDemo record) {
		return baseDemoService.updateByPrimaryKey(record);
	}
	
	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BaseDemo> selectByPrimaryKey(BaseDemo record) {
		return baseDemoService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BaseDemo> selectPage(BaseDemo record) {
		return baseDemoService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BaseDemo> selectAll() {
		return baseDemoService.selectAll();
	}
		
	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BaseDemo> batchDeleteByPrimaryKey(BaseDemo record) {
		return baseDemoService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BaseDemo> batchDeleteByPrimaryKeyActually(BaseDemo record) {
		return baseDemoService.batchDeleteByPrimaryKeyActually(record);
	}

}
