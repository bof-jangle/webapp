package xyz.jangle.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xyz.jangle.model.User;
import xyz.jangle.service.A;
import xyz.jangle.service.UserService;

@Controller
@RequestMapping("/mvc")
public class Hello {
	// 养成一种习惯，将项目的控制层对象，对应的视图，视图所用的js文件，三个名称进行统一。用Ctrl+R查找时可以很方便地找到他们
	@Autowired
	private UserService userService;
	@Autowired
	private A a;

	@RequestMapping("/hello")
	public ModelAndView hello(
			@RequestParam(value = "id", required = false) Integer id) {
		System.out.println("全都一起上吧，我根本没在怕，啦蜡辣拉拉");
		List<User> users = userService.getAllUser().getList();
		System.out.println("测试被切面干预的方法结果是否还可用 "+users.get(0).getUserName());
		System.out.println("这是return位置 " +userService.getAllUser());
		ModelAndView mav = new ModelAndView("hello"); // 参数为试图名称 viewName
		mav.addObject("users", users); // 添加model用于EL表达式输出值
		return mav;
	}
	
	@RequestMapping("/testAb")
	public ModelAndView testAB() {
		a.testA();
		return new ModelAndView("hello");
	}

}
