package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsTeam;
import xyz.jangle.demoname.service.BsTeamService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 队伍管理 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsTeamCtrl")
public class BsTeamCtrl {

	@Autowired
	private BsTeamService bsTeamService;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsTeam> insert(BsTeam record) {
		return bsTeamService.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsTeam> deleteByPrimaryKey(BsTeam record) {
		return bsTeamService.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsTeam> updateByPrimaryKey(BsTeam record) {
		return bsTeamService.updateByPrimaryKey(record);
	}

	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsTeam> selectByPrimaryKey(BsTeam record) {
		return bsTeamService.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsTeam> selectPage(BsTeam record) {
		return bsTeamService.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsTeam> selectAll() {
		return bsTeamService.selectAll();
	}

	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsTeam> batchDeleteByPrimaryKey(BsTeam record) {
		return bsTeamService.batchDeleteByPrimaryKey(record);
	}

	// 批删Actually
	@RequestMapping("/batchDeleteByPrimaryKeyActually.ctrl")
	@ResponseBody
	ResultModel<BsTeam> batchDeleteByPrimaryKeyActually(BsTeam record) {
		return bsTeamService.batchDeleteByPrimaryKeyActually(record);
	}

}
