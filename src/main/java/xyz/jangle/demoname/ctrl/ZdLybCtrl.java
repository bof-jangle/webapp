package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.ZdLyb;
import xyz.jangle.demoname.service.ZdLybService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 战队留言板 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/zdLybCtrl")
public class ZdLybCtrl {

	@Autowired
	private ZdLybService zdLybService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<ZdLyb> insert(ZdLyb record) {
		return zdLybService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZdLyb> deleteByPrimaryKey(ZdLyb record) {
		return zdLybService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZdLyb> updateByPrimaryKey(ZdLyb record) {
		return zdLybService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZdLyb> selectByPrimaryKey(ZdLyb record) {
		return zdLybService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<ZdLyb> selectPage(ZdLyb record) {
		return zdLybService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<ZdLyb> selectAll() {
		return zdLybService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZdLyb> batchDeleteByPrimaryKey(ZdLyb record) {
		return zdLybService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<ZdLyb> batchDeleteByPrimaryKeyActually(ZdLyb record) {
		return zdLybService.batchDeleteByPrimaryKeyActually(record);
	}

}
