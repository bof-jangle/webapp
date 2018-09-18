package xyz.jangle.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.jangle.model.User;
import xyz.jangle.service.UserService;
import xyz.jangle.utils.ResultModelList;

/**
 * @author huhj
 * @email jangle@jangle.xyz
 * @time 2018年7月6日 上午10:27:20
 */
@Controller
@RequestMapping("/hello")
public class HelloAjax {

	@Autowired
	private UserService userService;

	@RequestMapping("/helloAjax")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("helloAjax"); // 参数为试图名称 viewName
		return mav;
	}

	@RequestMapping("/helloData")
	@ResponseBody
	public ResultModelList<User> helloData() {
		ResultModelList<User> res = userService.getAllUser();
		return res;
	}

}
