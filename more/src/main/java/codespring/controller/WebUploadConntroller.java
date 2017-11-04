package codespring.controller;

import codespring.util.RequestParamsUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fxf
 * @create 2017-11-02 13:25
 **/
@Controller
@RequestMapping("doWebUploadService")
public class WebUploadConntroller {

	private Logger logger = LoggerFactory.getLogger(WebUploadConntroller.class);

	/**
	 * webupload上传
	 */
	@RequestMapping(value = "webUploadFile", method = RequestMethod.POST)
	public String webUploadFile(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
								ModelMap model, HttpServletResponse res) throws IOException {
		JSONObject jsonObject = RequestParamsUtil.getSpringMultipartFormParameter(request);
		String fileName = file.getOriginalFilename();//上传文件名称
		try {
			System.out.printf(fileName);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
		}
		return null;
	}
}