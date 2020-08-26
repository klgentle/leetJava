package com.klgentle.mapper;

import com.klgentle.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();

    // 添加用户
    int addUser(User user);

    // 删除用户
    int deleteUser(int id);
}
