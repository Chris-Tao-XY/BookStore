package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.eception.AlreadyExistUserException;
import com.bjpowernode.eception.NotRegisterException;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import com.bjpowernode.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void registerUser(User user) {
        if(!existUser(user.getUsername())){
            userDao.saveUser(user);
        }else {
            throw new AlreadyExistUserException();
        }
    }

    @Override
    public User loginUser(User user) {
        if(existUser(user.getUsername())){
            return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        }else {
            throw new NotRegisterException();
        }
    }

    @Override
    public boolean existUser(String username) {
        return userDao.queryUserByUsernameAndPassword(username, null)!=null;
    }
}
