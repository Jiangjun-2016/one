package codespring.service.impl;

import codespring.dao.UserMapper;
import codespring.model.UserEntity;
import codespring.service.WebServerService;

import javax.annotation.Resource;
import javax.jws.WebService;

/**
 * @author fxf
 * @create 2017-11-01 14:33
 **/
@WebService(endpointInterface = "codespring.service.WebServerService")
public class WebServerServiceImpl implements WebServerService {

	@Resource
	private UserMapper userMapper;

	public String getUsers(String uid) {
		UserEntity userEntity = userMapper.selectByPrimaryKey(uid);
		return userEntity.getUserName();
	}
}