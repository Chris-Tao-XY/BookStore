package com.bjpowernode.dao;


import com.bjpowernode.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User queryUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    int saveUser(User user);

    User queryUserById(Integer id);
}
