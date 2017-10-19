package code.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import code.model.UserEntity;
import code.service.UserService;

@Controller
@RequestMapping("doUserService")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@RequestMapping("getUser")
	public @ResponseBody UserEntity getUser(HttpServletRequest request) {
		String id = request.getParameter("ID"); // userid
		UserEntity user = userService.getUser(id);
		return user;
	}

	@RequestMapping("hello")
	public String helloWorld(HttpServletRequest request) {
		return "Yes！！！";
	}

	/**
	 * 非空验证方法
	 */
	private boolean validateParam(String... param) {
		if (param == null || param.length == 0) {
			return false;
		}
		for (int i = 0; i < param.length; i++) {
			if (StringUtils.isEmpty(param[i])) {
				return false;
			}
		}
		return true;
	}

}
