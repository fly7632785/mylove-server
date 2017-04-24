package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.dao.entity.UserEntity;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @author Wwwwei
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public Integer createUser(UserEntity userEntity) {
        return userDao.insert(userEntity);
    }

    public Integer updateUser(UserEntity userEntity) {
        return userDao.update(userEntity);
    }

    public Integer deleteUser(Integer id) {
        return userDao.delete(id);
    }

    public UserEntity getUserById(Integer id) {
        return userDao.selectById(id);
    }

    public UserEntity getUserByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    public UserEntity getUserByUP(String username, String password) {
        return userDao.selectByUP(username,password);
    }
}
