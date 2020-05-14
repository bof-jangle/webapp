package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsExcuteHistory;
import xyz.jangle.demoname.service.BsExcuteHistoryService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 执行记录表 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsExcuteHistoryCtrl")
public class BsExcuteHistoryCtrl {

	@Autowired
	private BsExcuteHistoryService bsExcuteHistoryService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsExcuteHistory> insert(BsExcuteHistory record) {
		bsExcuteHistoryService.insertOrUpdate(record);
		return new ResultModel<>(CME.SUCCESS);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsExcuteHistory> deleteByPrimaryKey(BsExcuteHistory record) {
		return bsExcuteHistoryService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsExcuteHistory> updateByPrimaryKey(BsExcuteHistory record) {
		return bsExcuteHistoryService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsExcuteHistory> selectByPrimaryKey(BsExcuteHistory record) {
		return bsExcuteHistoryService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsExcuteHistory> selectPage(BsExcuteHistory record) {
		return bsExcuteHistoryService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsExcuteHistory> selectAll() {
		return bsExcuteHistoryService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsExcuteHistory> batchDeleteByPrimaryKey(BsExcuteHistory record) {
		return bsExcuteHistoryService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsExcuteHistory> batchDeleteByPrimaryKeyActually(BsExcuteHistory record) {
		return bsExcuteHistoryService.batchDeleteByPrimaryKeyActually(record);
	}

}
