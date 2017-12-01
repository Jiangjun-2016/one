package codespring.controller;

import codespring.util.ValidateCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("doValidateService")
public class ValidateCodeController {

	private Logger logger = LoggerFactory.getLogger(ValidateCodeController.class);

	/**
	 * 随机生成图片验证码
	 *
	 * @param request
	 * @param response
	 * @param session
	 */
	@RequestMapping("getValidateCode")
	public void getValidateCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/png");
		//设置response头信息 禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		ValidateCode validateCode = new ValidateCode();//生成验证码
		String strCode = validateCode.getCode();
		//将字符保存到session中用于前端的验证
		session.setAttribute("authCode", strCode.toLowerCase());
		try {
			validateCode.write(response.getOutputStream());
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
