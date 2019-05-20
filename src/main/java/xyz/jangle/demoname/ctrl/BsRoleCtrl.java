package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsRole;
import xyz.jangle.demoname.service.BsRoleService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 角色管理 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsRoleCtrl")
public class BsRoleCtrl {

	@Autowired
	private BsRoleService bsRoleService;

	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsRole> deleteByPrimaryKey(BsRole record) {
		return bsRoleService.deleteByPrimaryKey(record);
	}
	
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsRole> batchDeleteByPrimaryKey(BsRole record) {
		return bsRoleService.batchDeleteByPrimaryKey(record);
	}

	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsRole> insert(BsRole record) {
		return bsRoleService.insertOrUpdate(record);
	}

	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsRole> selectByPrimaryKey(BsRole record) {
		return bsRoleService.selectByPrimaryKey(record);
	}

	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsRole> selectAll() {
		return bsRoleService.selectAll();
	}

	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsRole> selectPage(BsRole record) {
		return bsRoleService.selectPage(record);
	}

	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsRole> updateByPrimaryKey(BsRole record) {
		return bsRoleService.updateByPrimaryKey(record);
	}

}
