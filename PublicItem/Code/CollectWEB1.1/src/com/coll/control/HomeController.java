package com.coll.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping(value = "resetpwd", method = RequestMethod.GET)
	public String resetpwd(ModelMap model) {
		System.out.println("=============================index===============================");
		//File fi = new File(PathsysConfig.importFile);
		//urlContentServiceImpl.importMenu(fi, "2768559446@qq.com");
		return "resetpwd";
	}
}
