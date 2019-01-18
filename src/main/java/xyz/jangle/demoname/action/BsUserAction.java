package xyz.jangle.demoname.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.demoname.service.BsUserService;
import xyz.jangle.utils.ResultModel;

@Controller
@RequestMapping("/bsUserAction")
public class BsUserAction {
	// 养成一种习惯，将项目的控制层对象，对应的视图，视图所用的js文件，三个名称进行统一。用Ctrl+R查找时可以很方便地找到他们
	@Autowired
	private BsUserService bsUserService;

	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam(value = "id", required = false) Integer id) {
//		List<DemoModel> users = bsUserService
		ModelAndView mav = new ModelAndView("hello"); // 参数为试图名称 viewName
//		mav.addObject("users", users); // 添加model用于EL表达式输出值
		return mav;
	}

	/**
	 * 新增记录
	 * 
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public ResultModel<BsUser> insert(BsUser bsUser) {
		return bsUserService.insert(bsUser);
	}

	/**
	 * 删除记录
	 * 
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/deleteByPrimaryKey")
	@ResponseBody
	public ResultModel<BsUser> deleteByPrimaryKey(BsUser bsUser) {
		return bsUserService.deleteByPrimaryKey(bsUser);

	}

	/**
	 * 更新记录
	 * 
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/updateByPrimaryKey")
	@ResponseBody
	public ResultModel<BsUser> updateByPrimaryKey(BsUser bsUser) {
		return bsUserService.updateByPrimaryKey(bsUser);
	}

	/**
	 * 查询记录
	 * 
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/selectByPrimaryKey")
	@ResponseBody
	public ResultModel<BsUser> selectByPrimaryKey(BsUser bsUser) {
		return bsUserService.selectByPrimaryKey(bsUser);
	}

}
