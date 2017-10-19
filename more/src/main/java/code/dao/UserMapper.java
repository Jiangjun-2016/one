package code.dao;

import code.model.UserEntity;

public interface UserMapper {

	UserEntity selectByPrimaryKey(String id);

}
