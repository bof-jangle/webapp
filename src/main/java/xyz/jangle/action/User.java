package xyz.jangle.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;
import xyz.jangle.service.DUserService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

@Controller
@RequestMapping("/**/user")
public class User {

	@Autowired
	private DUserService dUserService;

	@RequestMapping("/selectUsers")
	@ResponseBody
	public ResultModelList<DUser> selectByExample() {
		DUserExample dUserExample = new DUserExample();
		ResultModelList<DUser> res = dUserService.selectByExample(dUserExample);
		return res;
	}

	@RequestMapping("/loginStatus")
	@ResponseBody
	public ResultModel<DUser> loginStatus() {
		return dUserService.currentLoggedIn();
	}

	@RequestMapping("/login")
	@ResponseBody
	public ResultModel<DUser> login(@RequestParam(required = false) String code,
			@RequestParam(required = false) String ip, @RequestParam(required = false) String city,
			@RequestParam(required = false) String password, HttpSession httpSession) {
		return dUserService.login(code, password, httpSession);
	}

	@RequestMapping("/logout")
	@ResponseBody
	public ResultModel<DUser> logout(HttpSession httpSession) {
		httpSession.removeAttribute("userName");
		httpSession.removeAttribute("userId");
		ResultModel<DUser> resultModel = new ResultModel<DUser>();
		resultModel.setMessage("注销成功");
		return resultModel;
	}

}
