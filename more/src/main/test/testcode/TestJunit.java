package testcode;

import codespring.controller.UploadController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml"})
public class TestJunit {

	// 模拟request,response
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	// 注入Controller
	@Autowired
	private UploadController uploadController;

	// 执行测试方法之前初始化模拟request,response
	@org.junit.Before
	public void setUp() {
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
	}

	/**
	 * 测试ftpDownloadFile
	 */
	@Test
	public void ftpDownloadFileTest() {
		try {
			request.setParameter("eventId", "1");
			request.setParameter("documetID", "1708090019001001");
			uploadController.ftpDownloadFile(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
