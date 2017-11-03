package codespring.util;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RequestParamsUtil {

	/**
	 * spring 部件上传
	 *
	 * @param request
	 * @return
	 */
	public static JSONObject getSpringMultipartFormParameter(HttpServletRequest request) {
		JSONObject jsonObject = null;
		DefaultMultipartHttpServletRequest multiRequest = (DefaultMultipartHttpServletRequest) (request);
		String[] parameterValues = multiRequest.getParameterValues("formData");
		if (parameterValues != null) {
			jsonObject = JSONObject.fromObject(parameterValues[0]);
		}
		return jsonObject;
	}

	/**
	 * commos fileupload 上传
	 *
	 * @param request
	 * @return
	 */
	public static JSONObject getFileUploadFormParameter(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(
					diskFileItemFactory);
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					// 此处为表单参数，表单参数名称：fileItem.getFieldName()，表单参数值：fileItem.getString("UTF-8")。
					if (fileItem.getFieldName().equals("formData")) {
						jsonObject = JSONObject.fromObject(fileItem
								.getString("UTF-8"));
					}
				} else {
					// 此处为非表单参数即文档参数
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
