package code.controller;

import code.util.FTPService;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("doUserService")
public class UploadController {

	private Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource
	private FTPService ftpService;

	/**
	 * 上传ftp服务
	 */
	@RequestMapping(value = "upload/uploadfile", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
						 ModelMap model, HttpServletResponse res) throws IOException {
		InputStream is = null;
		String url = null;
		String fileName = file.getOriginalFilename();//上传文件名称
		String subPath = request.getParameter("uploadFileUrl");//文件在ftp上保存目录
		// 需要上传空间地址参数,&&后跟其余要是用的参数变量
		String[] rSubPathArr = subPath.split("&&");
		String rSubPath = rSubPathArr[0];
		try {
			is = file.getInputStream();
			byte[] buffer = IOUtils.toByteArray(is);
			url = ftpService.ftpUpLoad(rSubPath, fileName, buffer);
			System.out.println(url + "======" + buffer.length);
			url = url.substring(1, url.length());
			if (url != null) {
				JSONObject paramJSON = new JSONObject();
				paramJSON.put("results", url);
				res.getWriter().write(paramJSON.toString());
				res.getWriter().flush();
				res.getWriter().close();
			}
		} catch (Exception e) {
			logger.error("error",e);
			e.printStackTrace();
		}
		return null;
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
