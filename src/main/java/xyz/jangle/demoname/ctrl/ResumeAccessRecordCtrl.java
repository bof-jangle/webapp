package xyz.jangle.demoname.ctrl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.ResumeAccessRecord;
import xyz.jangle.demoname.service.ResumeAccessRecordService;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.JResumeAccessQueue;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 简历访问记录 控制层
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/resumeAccessRecordCtrl")
public class ResumeAccessRecordCtrl {

	@Autowired
	private ResumeAccessRecordService resumeAccessRecordService;

	// 增
	@RequestMapping("/add")
	@ResponseBody
	void add(ResumeAccessRecord record) {
		record.setStatus(JConstant.status_1);
		record.setCreateTime(new Date());
		JResumeAccessQueue.add(record);
	}

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<ResumeAccessRecord> insert(ResumeAccessRecord record) {
		return resumeAccessRecordService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ResumeAccessRecord> deleteByPrimaryKey(ResumeAccessRecord record) {
		return resumeAccessRecordService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ResumeAccessRecord> updateByPrimaryKey(ResumeAccessRecord record) {
		return resumeAccessRecordService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ResumeAccessRecord> selectByPrimaryKey(ResumeAccessRecord record) {
		return resumeAccessRecordService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<ResumeAccessRecord> selectPage(ResumeAccessRecord record) {
		return resumeAccessRecordService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<ResumeAccessRecord> selectAll() {
		return resumeAccessRecordService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ResumeAccessRecord> batchDeleteByPrimaryKey(ResumeAccessRecord record) {
		return resumeAccessRecordService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<ResumeAccessRecord> batchDeleteByPrimaryKeyActually(ResumeAccessRecord record) {
		return resumeAccessRecordService.batchDeleteByPrimaryKeyActually(record);
	}

}
