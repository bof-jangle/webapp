package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.MyFiles;
import xyz.jangle.demoname.service.MyFilesService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 文件、资料 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/myFilesCtrl")
public class MyFilesCtrl {

	@Autowired
	private MyFilesService myFilesService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<MyFiles> insert(MyFiles record) {
		return myFilesService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<MyFiles> deleteByPrimaryKey(MyFiles record) {
		return myFilesService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<MyFiles> updateByPrimaryKey(MyFiles record) {
		return myFilesService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<MyFiles> selectByPrimaryKey(MyFiles record) {
		return myFilesService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<MyFiles> selectPage(MyFiles record) {
		return myFilesService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<MyFiles> selectAll() {
		return myFilesService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<MyFiles> batchDeleteByPrimaryKey(MyFiles record) {
		return myFilesService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<MyFiles> batchDeleteByPrimaryKeyActually(MyFiles record) {
		return myFilesService.batchDeleteByPrimaryKeyActually(record);
	}

}
