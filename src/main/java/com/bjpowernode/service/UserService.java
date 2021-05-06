package com.bjpowernode.service;

import com.bjpowernode.pojo.User;

public interface UserService {
    void registerUser(User user);
    User loginUser(User user);
    boolean existUser(String username);
}
