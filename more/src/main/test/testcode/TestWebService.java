package testcode;

import codespring.service.WebServerService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * cxf webservice测试
 *
 * @author fxf
 * @create 2017-11-02 13:18
 **/

public class TestWebService {

	public static void main(String[] args) {

		JaxWsProxyFactoryBean webService = new JaxWsProxyFactoryBean();
		webService.setServiceClass(WebServerService.class);
		webService.setAddress("http://localhost:8088/one/services/oneWebServer");
		WebServerService webServerService = (WebServerService) webService
				.create();
		String info = webServerService.getUsers("1");
		System.out.println(info);

	}
}