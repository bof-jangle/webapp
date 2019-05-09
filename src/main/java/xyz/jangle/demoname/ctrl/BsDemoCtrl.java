package xyz.jangle.demoname.ctrl;

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
@RequestMapping("/bsDemoCtrl")
public class BsDemoCtrl {

	@Autowired
	private BsDemoService bsDemoService;

	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsDemo> deleteByPrimaryKey(BsDemo record) {
		return bsDemoService.deleteByPrimaryKey(record);
	}

	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsDemo> insert(BsDemo record) {
		return bsDemoService.insertOrUpdate(record);
	}

	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsDemo> selectByPrimaryKey(BsDemo record) {
		return bsDemoService.selectByPrimaryKey(record);
	}

	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsDemo> selectAll() {
		return bsDemoService.selectAll();
	}

	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsDemo> selectPage(BsDemo record) {
		return bsDemoService.selectPage(record);
	}

	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsDemo> updateByPrimaryKey(BsDemo record) {
		return bsDemoService.updateByPrimaryKey(record);
	}

}
