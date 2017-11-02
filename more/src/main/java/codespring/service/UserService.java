package codespring.service;

import codespring.dao.UserMapper;
import codespring.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Resource
	private UserMapper userMapper;

	@Resource
	private WebServerClient webServerClient;

	public UserEntity getUser(String id) {

		webServerClient.addByFtpJson("solr");
		logger.info(id);
		UserEntity user = userMapper.selectByPrimaryKey(id);
		return user;
	}

}
