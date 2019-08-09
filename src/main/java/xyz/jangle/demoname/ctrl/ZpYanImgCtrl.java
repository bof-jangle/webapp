package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.ZpYanImg;
import xyz.jangle.demoname.service.ZpYanImgService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * yan的作品 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/zpYanImgCtrl")
public class ZpYanImgCtrl {

	@Autowired
	private ZpYanImgService zpYanImgService;

	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZpYanImg> deleteByPrimaryKey(ZpYanImg record) {
		return zpYanImgService.deleteByPrimaryKey(record);
	}
	
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZpYanImg> batchDeleteByPrimaryKey(ZpYanImg record) {
		return zpYanImgService.batchDeleteByPrimaryKey(record);
	}

	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<ZpYanImg> insert(ZpYanImg record) {
		return zpYanImgService.insertOrUpdate(record);
	}

	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZpYanImg> selectByPrimaryKey(ZpYanImg record) {
		return zpYanImgService.selectByPrimaryKey(record);
	}

	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<ZpYanImg> selectAll() {
		return zpYanImgService.selectAll();
	}

	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<ZpYanImg> selectPage(ZpYanImg record) {
		return zpYanImgService.selectPage(record);
	}

	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<ZpYanImg> updateByPrimaryKey(ZpYanImg record) {
		return zpYanImgService.updateByPrimaryKey(record);
	}

}
