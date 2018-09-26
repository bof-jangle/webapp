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
import xyz.jangle.utils.CodeMessageEnum;
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

	@RequestMapping("/login")
	@ResponseBody
	public ResultModel<DUser> login(@RequestParam(required=false) String code, @RequestParam(required=false) String password, HttpSession httpSession) {
		System.out.println("userName:"+httpSession.getAttribute("userName"));
		System.out.println("userId:"+httpSession.getAttribute("userId"));
		System.out.println(code);
		System.out.println(password);

		DUser record = new DUser();
		record.setUsrCode(code);
		record.setUsrPassword(password);
		ResultModel<DUser> resultModel = dUserService.selectByCodeAndPassword(record);
		DUser model = resultModel.getModel();
		if (model == null) {
			return new ResultModel<DUser>(CodeMessageEnum.loginFailed);
		}
		// 执行登陆的操作 TODO
		httpSession.setAttribute("userName", model.getUsrName());
		httpSession.setAttribute("userId", model.getUsrId().intValue());
		return resultModel;
	}

}
