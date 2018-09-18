package xyz.jangle.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;
import xyz.jangle.service.DUserService;
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

}
