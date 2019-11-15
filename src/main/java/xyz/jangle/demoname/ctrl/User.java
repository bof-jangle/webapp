package xyz.jangle.demoname.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.service.BsUser2Service;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.ResultModel;

@Controller
@RequestMapping("/**/user")
public class User {

//	@Autowired
//	private BsUserService bsUserService;
	@Autowired
	private BsUser2Service bsUser2Service;

//	@RequestMapping("/selectUsers")
//	@ResponseBody
//	public ResultModelList<BsUser> selectByExample(@RequestParam(value = "usrName", required = false) String usrName,
//			@RequestParam(value = "pageNum", required = false) Integer pageNum,
//			@RequestParam(value = "pageSize", required = false) Integer pageSize
//			) {
//		BsUserExample bsUserExample = new BsUserExample();
////		bsUserExample.createCriteria().andUsrNameLike(usrName);
//		ResultModelList<BsUser> res = bsUserService.selectByExample(bsUserExample);
//		return res;
//	}

	@RequestMapping("/loginStatus")
	@ResponseBody
	public ResultModel<BsUser2> loginStatus() {
		return bsUser2Service.currentLoggedIn();
	}

	@RequestMapping("/login")
	@ResponseBody
	public ResultModel<BsUser2> login(@RequestParam(required = false) String code,
			@RequestParam(required = false) String ip, @RequestParam(required = false) String city,
			@RequestParam(required = false) String password, HttpSession httpSession) {
		httpSession.setAttribute(JConstant.ip, ip);
		httpSession.setAttribute(JConstant.city, city);
//		return bsUserService.login(code, password, httpSession);
		String timeStamp = "";
		return bsUser2Service.login(code, password, timeStamp);
	}

	@RequestMapping("/logout")
	@ResponseBody
	public ResultModel<BsUser2> logout(HttpSession httpSession) {
//		httpSession.removeAttribute("userName");
//		httpSession.removeAttribute("userId");
//		ResultModel<BsUser> resultModel = new ResultModel<BsUser>();
//		resultModel.setMessage("注销成功");
//		return resultModel;
		return bsUser2Service.logout();
	}

}
