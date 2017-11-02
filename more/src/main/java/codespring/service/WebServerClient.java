package codespring.service;

import javax.jws.WebService;

/**
 * @author fxf
 * @create 2017-11-02 11:15
 **/
@WebService
public interface WebServerClient {
	String addByFtpJson(String fileInfo);
}