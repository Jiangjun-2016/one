package testcode;

import codespring.service.WebServerService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 * cxf webservice测试
 *
 * @author fxf
 * @create 2017-11-02 13:18
 **/

public class TestWebService {

	public static final int CXF_CLIENT_CONNECT_TIMEOUT = 50 * 1000;
	public static final int CXF_CLIENT_RECEIVE_TIMEOUT = 100 * 1000;

	public static void configTimeout(Object service) {
		Client proxy = ClientProxy.getClient(service);
		HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
		HTTPClientPolicy policy = new HTTPClientPolicy();
		policy.setConnectionTimeout(CXF_CLIENT_CONNECT_TIMEOUT);
		policy.setReceiveTimeout(CXF_CLIENT_RECEIVE_TIMEOUT);
		conduit.setClient(policy);
	}


	public static void main(String[] args) {

		JaxWsProxyFactoryBean webService = new JaxWsProxyFactoryBean();
		webService.setServiceClass(WebServerService.class);
		webService.setAddress("http://localhost:8088/one/services/oneWebServer");
		WebServerService webServerService = (WebServerService) webService
				.create();
		configTimeout(webServerService);
		String info = webServerService.getUsers("1");
		System.out.println(info);

	}
}