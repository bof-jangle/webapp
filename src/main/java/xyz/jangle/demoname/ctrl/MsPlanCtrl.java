package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.MsPlan;
import xyz.jangle.demoname.service.MsPlanService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 面试安排 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.12020-06-08 11:34:37
 */
@Controller
@RequestMapping("/msPlanCtrl")
public class MsPlanCtrl {

	@Autowired
	private MsPlanService msPlanService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<MsPlan> insert(MsPlan record) {
		return msPlanService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<MsPlan> deleteByPrimaryKey(MsPlan record) {
		return msPlanService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<MsPlan> updateByPrimaryKey(MsPlan record) {
		return msPlanService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<MsPlan> selectByPrimaryKey(MsPlan record) {
		return msPlanService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<MsPlan> selectPage(MsPlan record) {
		return msPlanService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<MsPlan> selectAll() {
		return msPlanService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<MsPlan> batchDeleteByPrimaryKey(MsPlan record) {
		return msPlanService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<MsPlan> batchDeleteByPrimaryKeyActually(MsPlan record) {
		return msPlanService.batchDeleteByPrimaryKeyActually(record);
	}

}
