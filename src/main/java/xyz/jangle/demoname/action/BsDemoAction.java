package xyz.jangle.demoname.action;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsDemo;
import xyz.jangle.demoname.service.BsDemoService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月15日 下午5:23:31 类说明
 */
@Controller
@RequestMapping("/bsDemoAction")
public class BsDemoAction {

	@Autowired
	private BsDemoService bsDemoService;

	@RequestMapping("/deleteByPrimaryKey.action")
	@ResponseBody
	ResultModel<BsDemo> deleteByPrimaryKey(BsDemo record) {
		return bsDemoService.deleteByPrimaryKey(record);
	}

	@RequestMapping("/insert.action")
	@ResponseBody
	ResultModel<BsDemo> insert(BsDemo record) {
		return bsDemoService.insert(record);
	}

	@RequestMapping("/selectByPrimaryKey.action")
	@ResponseBody
	ResultModel<BsDemo> selectByPrimaryKey(BsDemo record) {
		return bsDemoService.selectByPrimaryKey(record);
	}

	@RequestMapping("/selectAll.action")
	@ResponseBody
	ResultModelList<BsDemo> selectAll() {
		return bsDemoService.selectAll();
	}

	@RequestMapping("/selectPage.action")
	@ResponseBody
	ResultModelList<BsDemo> selectPage(BsDemo record) {
		return bsDemoService.selectPage(record);
	}

	@RequestMapping("/updateByPrimaryKey.action")
	@ResponseBody
	ResultModel<BsDemo> updateByPrimaryKey(BsDemo record) {
		return bsDemoService.updateByPrimaryKey(record);
	}

}
