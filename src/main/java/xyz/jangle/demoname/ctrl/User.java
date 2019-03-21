package xyz.jangle.demoname.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.demoname.model.BsUserExample;
import xyz.jangle.demoname.service.BsUserService;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

@Controller
@RequestMapping("/**/user")
public class User {

	@Autowired
	private BsUserService bsUserService;

	@RequestMapping("/selectUsers")
	@ResponseBody
	public ResultModelList<BsUser> selectByExample(@RequestParam(value = "usrName", required = false) String usrName,
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize
			) {
		BsUserExample bsUserExample = new BsUserExample();
//		bsUserExample.createCriteria().andUsrNameLike(usrName);
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
