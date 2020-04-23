package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsVisitCount;
import xyz.jangle.demoname.service.BsVisitCountService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 访客统计 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsVisitCountCtrl")
public class BsVisitCountCtrl {

	@Autowired
	private BsVisitCountService bsVisitCountService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsVisitCount> insert(BsVisitCount record) {
		return bsVisitCountService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsVisitCount> deleteByPrimaryKey(BsVisitCount record) {
		return bsVisitCountService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsVisitCount> updateByPrimaryKey(BsVisitCount record) {
		return bsVisitCountService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsVisitCount> selectByPrimaryKey(BsVisitCount record) {
		return bsVisitCountService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsVisitCount> selectPage(BsVisitCount record) {
		return bsVisitCountService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsVisitCount> selectAll() {
		return bsVisitCountService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsVisitCount> batchDeleteByPrimaryKey(BsVisitCount record) {
		return bsVisitCountService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsVisitCount> batchDeleteByPrimaryKeyActually(BsVisitCount record) {
		return bsVisitCountService.batchDeleteByPrimaryKeyActually(record);
	}

}
