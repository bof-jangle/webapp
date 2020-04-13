package xyz.jangle.demoname.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsVisit;
import xyz.jangle.demoname.service.BsVisitService;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 访问记录表 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/visitCtrl")
public class BsVisitCtrl {

	@Autowired
	private BsVisitService bsVisitService;
	

	// 增
	@RequestMapping("/insert")
	@ResponseBody
	ResultModel<BsVisit> insert(BsVisit record,HttpSession httpSession) {
		httpSession.setAttribute(JConstant.ip, record.getDmDesc());
		httpSession.setAttribute(JConstant.city, record.getDmDesc2());
		return bsVisitService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsVisit> deleteByPrimaryKey(BsVisit record) {
		return bsVisitService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsVisit> updateByPrimaryKey(BsVisit record) {
		return bsVisitService.updateByPrimaryKey(record);
	}
	
	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsVisit> selectByPrimaryKey(BsVisit record) {
		return bsVisitService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsVisit> selectPage(BsVisit record) {
		return bsVisitService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsVisit> selectAll() {
		return bsVisitService.selectAll();
	}
		
	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsVisit> batchDeleteByPrimaryKey(BsVisit record) {
		return bsVisitService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsVisit> batchDeleteByPrimaryKeyActually(BsVisit record) {
		return bsVisitService.batchDeleteByPrimaryKeyActually(record);
	}
	
	@RequestMapping("/count")
	@ResponseBody
	ResultModel<BsVisit> count(){
		return bsVisitService.count();
	}

}
