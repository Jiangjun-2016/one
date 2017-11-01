package codespring.service;

import javax.jws.WebService;

/**
 * @author fxf
 * @create 2017-11-01 14:29
 **/
@WebService
public interface WebServerService {

	String getUsers(String uid);

}