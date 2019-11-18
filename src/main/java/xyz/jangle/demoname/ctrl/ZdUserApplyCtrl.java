package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.ZdUserApply;
import xyz.jangle.demoname.service.ZdUserApplyService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 用户申请 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/zdUserApplyCtrl")
public class ZdUserApplyCtrl {

	@Autowired
	private ZdUserApplyService zdUserApplyService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<ZdUserApply> insert(ZdUserApply record) {
		return zdUserApplyService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZdUserApply> deleteByPrimaryKey(ZdUserApply record) {
		return zdUserApplyService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZdUserApply> updateByPrimaryKey(ZdUserApply record) {
		return zdUserApplyService.updateByPrimaryKey(record);
	}
	
	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZdUserApply> selectByPrimaryKey(ZdUserApply record) {
		return zdUserApplyService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<ZdUserApply> selectPage(ZdUserApply record) {
		return zdUserApplyService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<ZdUserApply> selectAll() {
		return zdUserApplyService.selectAll();
	}
		
	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZdUserApply> batchDeleteByPrimaryKey(ZdUserApply record) {
		return zdUserApplyService.batchDeleteByPrimaryKey(record);
	}
	// 通过
	@RequestMapping("/pass.ctrl")
	@ResponseBody
	ResultModel<ZdUserApply> pass(ZdUserApply record) {
		return zdUserApplyService.pass(record);
	}
	// 不通过
	@RequestMapping("/unPass.ctrl")
	@ResponseBody
	ResultModel<ZdUserApply> unPass(ZdUserApply record) {
		return zdUserApplyService.unPass(record);
	}

}
