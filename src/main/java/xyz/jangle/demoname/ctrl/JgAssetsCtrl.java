package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.JgAssets;
import xyz.jangle.demoname.service.JgAssetsService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 资产管理 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/jgAssetsCtrl")
public class JgAssetsCtrl {

	@Autowired
	private JgAssetsService jgAssetsService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<JgAssets> insert(JgAssets record) {
		return jgAssetsService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<JgAssets> deleteByPrimaryKey(JgAssets record) {
		return jgAssetsService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<JgAssets> updateByPrimaryKey(JgAssets record) {
		return jgAssetsService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<JgAssets> selectByPrimaryKey(JgAssets record) {
		return jgAssetsService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<JgAssets> selectPage(JgAssets record) {
		return jgAssetsService.selectPage(record);
	}
	
	// 条件查
	@RequestMapping("/selectPageForQuery.ctrl")
	@ResponseBody
	ResultModelList<JgAssets> selectPageForQuery(JgAssets record) {
		return jgAssetsService.selectPageForQuery(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<JgAssets> selectAll() {
		return jgAssetsService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<JgAssets> batchDeleteByPrimaryKey(JgAssets record) {
		return jgAssetsService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<JgAssets> batchDeleteByPrimaryKeyActually(JgAssets record) {
		return jgAssetsService.batchDeleteByPrimaryKeyActually(record);
	}

}
