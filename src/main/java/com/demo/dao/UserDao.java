package com.demo.dao;

import com.demo.base.BaseDao;
import com.demo.dao.entity.UserEntity;

/**
 * 用户Dao类
 *
 * @author Wwwwei
 */
public interface UserDao extends BaseDao<UserEntity> {
    UserEntity selectByUsername(String username);

    UserEntity selectByUP(String username,String password);
}
