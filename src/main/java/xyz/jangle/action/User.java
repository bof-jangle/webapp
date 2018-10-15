package xyz.jangle.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.model.BsUser;
import xyz.jangle.model.BsUserExample;
import xyz.jangle.service.BsUserService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

@Controller
@RequestMapping("/**/user")
public class User {

	@Autowired
	private BsUserService bsUserService;

	@RequestMapping("/selectUsers")
	@ResponseBody
	public ResultModelList<BsUser> selectByExample() {
		BsUserExample bsUserExample = new BsUserExample();
		ResultModelList<BsUser> res = bsUserService.selectByExample(bsUserExample);
		return res;
	}

	@RequestMapping("/loginStatus")
	@ResponseBody
	public ResultModel<BsUser> loginStatus() {
		return bsUserService.currentLoggedIn();
	}

	@RequestMapping("/login")
	@ResponseBody
	public ResultModel<BsUser> login(@RequestParam(required = false) String code,
			@RequestParam(required = false) String ip, @RequestParam(required = false) String city,
			@RequestParam(required = false) String password, HttpSession httpSession) {
		return bsUserService.login(code, password, httpSession);
	}

	@RequestMapping("/logout")
	@ResponseBody
	public ResultModel<BsUser> logout(HttpSession httpSession) {
		httpSession.removeAttribute("userName");
		httpSession.removeAttribute("userId");
		ResultModel<BsUser> resultModel = new ResultModel<BsUser>();
		resultModel.setMessage("注销成功");
		return resultModel;
	}

}
