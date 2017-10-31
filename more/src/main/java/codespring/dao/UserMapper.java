package codespring.dao;

import codespring.model.UserEntity;

public interface UserMapper {

	UserEntity selectByPrimaryKey(String id);

}
